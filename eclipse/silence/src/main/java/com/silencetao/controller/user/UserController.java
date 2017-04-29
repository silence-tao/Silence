package com.silencetao.controller.user;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.jdbc.Null;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.silencetao.dao.user.UserDao;
import com.silencetao.entity.User;
import com.silencetao.exception.DatabaseException;
import com.silencetao.exception.MessageExcetion;
import com.silencetao.service.user.UserService;
import com.silencetao.utils.CookiesUtil;
import com.silencetao.utils.StringUtil;
import com.silencetao.view.SilenceResult;

/**
 * User Controller层
 * @author Silence
 *
 */
@RequestMapping(value = "user")
@Controller
public class UserController {
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserService userService;
	
	/**
	 * 用户注册
	 * @param user
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "userRegister")
	@ResponseBody
	public SilenceResult<Null> register(User user, HttpServletRequest request, HttpSession session) {
		if(userService.getCountByNikename(user.getNikename()) > 0) {
			log.warn("昵称已存在");
			return new SilenceResult<Null>(false, "昵称已存在");
		}
		if(userService.getCountByUsername(user.getUsername()) > 0) {
			log.warn("邮箱已被注册");
			return new SilenceResult<Null>(false, "邮箱已被注册");
		}
		user.setRegisterIp(request.getRemoteAddr());
		user.setUserSign(StringUtil.getMd5(user.getUsername() + user.getNikename(), "silenceUser"));
		user.setPassword(StringUtil.getMd5(user.getPassword(), "silencePassword"));
		try {
			userService.register(user);
			user = userService.login(user);
			session.setAttribute("userInfo", user);
			return new SilenceResult<Null>(true, "注册成功");
		} catch (DatabaseException e) {
			log.error(e.getMessage(), e);
			return new SilenceResult<Null>(false, "注册失败");
		} catch (Exception e) {
			log.warn("注册失败");
			log.error(e.getMessage(), e);
			return new SilenceResult<Null>(false, "注册失败");
		}
	}
	
	/**
	 * 用户登录
	 * @param userSign
	 * @param u
	 * @param remember
	 * @param session
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "userLogin")
	@ResponseBody
	public SilenceResult<Null> login(@CookieValue(value = "userSign", required = false) String userSign,
			User u, String remember, HttpSession session, HttpServletResponse response) {
		User user = null;
		if(userSign != null) {//判断是否记住了密码
			if(!"silencetao".equals(u.getPassword())) {//避免出现用户修改了密码,还登录成功
				CookiesUtil.clearCookie(response, "userSign");
				return new SilenceResult<Null>(false, "用户名或密码错误");
			}
			user = userService.getUserBySign(userSign);
			if(!user.getUsername().equals(u.getUsername())) {//避免出现用户修改了用户名,还登录成功
				CookiesUtil.clearCookie(response, "userSign");
				return new SilenceResult<Null>(false, "用户名或密码错误");
			}
		} else {
			u.setPassword(StringUtil.getMd5(u.getPassword(), "silencePassword"));
			user = userService.login(u);
		}
		if(user != null) {//如果user不为空,表示等成功
			session.setAttribute("userInfo", user);
			if("checked".equals(remember)) {//是否需要记住密码
				Cookie cookie = new Cookie("userSign", user.getUserSign());
				cookie.setMaxAge(3600 * 24 * 30);
				response.addCookie(cookie);
			} else {
				CookiesUtil.clearCookie(response, "userSign");
			}
			return new SilenceResult<Null>(true, "登录成功");
		} else {
			CookiesUtil.clearCookie(response, "userSign");
			return new SilenceResult<Null>(false, "用户名或密码错误");
		}
	}
	
	/**
	 * 获取用户名和密码,用于记住密码时,显示在页面上
	 * @param userSign
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "getUserSign")
	@ResponseBody
	public SilenceResult<User> getUserSign(@CookieValue(value = "userSign", required = false) String userSign,
			HttpServletResponse response) {
		if(userSign != null) {
			User user = userService.getUserBySign(userSign);
			if(user != null) {
				user.setPassword("silencetao");
				user.setUserId(0);
				user.setNikename("");
				return new SilenceResult<User>(true, user);
			} else {
				Cookie cookie = new Cookie("userSign", null);
				cookie.setMaxAge(0);
				response.addCookie(cookie);
				return new SilenceResult<User>(false, "记住密码已失效,请重新记住");
			}
		}
		return new SilenceResult<User>(false, "上次登录未记住密码");
	}
	
	/**
	 * 检测用户或昵称是否存在
	 * @param name
	 * @param action
	 * @return
	 */
	@RequestMapping(value = "checkName")
	@ResponseBody
	public SilenceResult<Null> checkName(String name, long action) {
		if("".equals(name)) {
			return new SilenceResult<Null>(false, 0);
		} else {
			if(action == 1) {
				if(userService.getCountByNikename(name) > 0) {
					return new SilenceResult<Null>(false, "昵称已存在");
				} else {
					return new SilenceResult<Null>(true, 1);
				}
			} else {
				if(userService.getCountByUsername(name) > 0) {
					return new SilenceResult<Null>(false, "邮箱已被注册");
				} else {
					return new SilenceResult<Null>(true, 1);
				}
			}
		}
	}
	
	/**
	 * 退出登录
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "loginOut")
	@ResponseBody
	public String loginOut(HttpSession session) {
		User user = (User) session.getAttribute("userInfo");
		if(user != null) {
			session.removeAttribute("userInfo");
		}
		return null;
	}
	
	/**
	 * 根据用户名或昵称获取用户的头像
	 * @param username
	 * @return
	 */
	@RequestMapping(value = "getHeader")
	@ResponseBody
	public SilenceResult<Null> getHeader(String username) {
		String header = userService.getHeader(username);
		if(!"".equals(header) && header != null) {
			return new SilenceResult<Null>(true, header);
		}
		return new SilenceResult<Null>(false, "用户名未注册");
	}
	
	/**
	 * 判断用户是否登录
	 * @param visitorSign
	 * @param session
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "isLogin")
	@ResponseBody
	public SilenceResult<Null> isLogin(@CookieValue(value = "visitorSign", required = false) String visitorSign,
			HttpSession session, HttpServletResponse response) {
		User user = (User) session.getAttribute("userInfo");
		if(user != null) {
			CookiesUtil.clearCookie(response, "visitorSign");
			return new SilenceResult<Null>(true, 1);
		} else if(visitorSign != null) {
			return new SilenceResult<Null>(true, 2);
		} else {
			return new SilenceResult<Null>(false, 0);
		}
	}
}
