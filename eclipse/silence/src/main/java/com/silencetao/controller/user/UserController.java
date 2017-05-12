package com.silencetao.controller.user;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.silencetao.dao.user.UserDao;
import com.silencetao.entity.Information;
import com.silencetao.entity.User;
import com.silencetao.exception.DatabaseException;
import com.silencetao.exception.MessageExcetion;
import com.silencetao.service.user.InformationService;
import com.silencetao.service.user.UserService;
import com.silencetao.utils.CookiesUtil;
import com.silencetao.utils.StringUtil;
import com.silencetao.utils.UploadUtil;
import com.silencetao.view.Pages;
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
	
	@Autowired
	private InformationService informationService;
	
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
		user.setUserSign(StringUtil.getMd5(user.getUsername() + user.getNikename() + System.currentTimeMillis(), "silenceUser"));
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
	public SilenceResult<Null> loginOut(HttpSession session) {
		User user = (User) session.getAttribute("userInfo");
		if(user != null) {
			session.removeAttribute("userInfo");
		}
		return new SilenceResult<Null>(false, -2, "未登录");
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
	
	/**
	 * 根据用户唯一标示获取用户头像
	 * @param visitorSign
	 * @param session
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "getHeaderBySign")
	@ResponseBody
	public SilenceResult<Null> getHeaderBySign(@CookieValue(value = "visitorSign", required = false) String visitorSign,
			HttpSession session, HttpServletResponse response) {
		User user = (User) session.getAttribute("userInfo");
		if(user != null) {
			CookiesUtil.clearCookie(response, "visitorSign");
			return new SilenceResult<Null>(true, 1, user.getHeader());
		} else if(visitorSign != null) {
			return new SilenceResult<Null>(true, 2, userService.getHeaderBySign(visitorSign));
		} else {
			return new SilenceResult<Null>(false, 0, "未登录");
		}
	}
	
	@RequestMapping(value = "info")
	public String getInformation(HttpServletRequest request, HttpSession session) {
		User user = (User) session.getAttribute("userInfo");
		Information information = informationService.getInformationByPertain(user.getUserSign());
		try {
			information.setAge(StringUtil.getAge(information.getBirthday()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("information", information);
		return "user/info";
	}
	
	/**
	 * 保存用户基本信息
	 * @param information
	 * @param session
	 * @param birth
	 * @return
	 */
	@RequestMapping(value = "saveInformation")
	@ResponseBody
	public SilenceResult<Null> saveInformation(Information information, HttpSession session,
			String birth) {
		User user = (User) session.getAttribute("userInfo");
		information.setPertain(user.getUserSign());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			information.setBirthday(sdf.parse(birth));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		SilenceResult<Null> silenceResult = null;
		try {
			int result = informationService.updateInformation(information);
			if(result > 0) {
				silenceResult = new SilenceResult<Null>(true, "保存成功");
			} else {
				silenceResult = new SilenceResult<Null>(false, "保存失败");
			}
		} catch (Exception e) {
			log.warn("保存失败");
			log.error(e.getMessage(), e);
			silenceResult = new SilenceResult<Null>(false, "系统错误");
		}
		return silenceResult;
	}
	
	/**
	 * 保存用户头像
	 * @param muliRequest
	 * @param header
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "saveHeader")
	@ResponseBody
	public SilenceResult<Null> saveHeader(MultipartHttpServletRequest muliRequest, String header,
			HttpSession session) {
		User user = (User) session.getAttribute("userInfo");
		Iterator<String> iterator = muliRequest.getFileNames();
		String path = null;
		while(iterator.hasNext()) {
			String fileName = iterator.next();
			MultipartFile file = muliRequest.getFile(fileName);
			path = UploadUtil.uploadFile(file, "img/header");
		}
		if(path != null) {
			user.setHeader(path);
		} else if(header != null) {
			user.setHeader(header);
		} else {
			return new SilenceResult<Null>(false, "上传的头像为空");
		}
		try {
			userService.updateUser(user);
			session.setAttribute("userInfo", user);
			return new SilenceResult<Null>(true, "上传成功");
		} catch (Exception e) {
			return new SilenceResult<Null>(false, "上传头像失败");
		}
	}
	
	/**
	 * 修改密码
	 * @param session
	 * @param oldPass
	 * @param newPass
	 * @return
	 */
	@RequestMapping(value = "savePassword")
	@ResponseBody
	public SilenceResult<Null> savePassword(HttpSession session, String oldPass,
			String newPass) {
		User user = (User) session.getAttribute("userInfo");
		if(oldPass != null) {
			user.setPassword(StringUtil.getMd5(oldPass, "silencePassword"));
			User u = userService.login(user);
			if(u != null) {
				user.setPassword(StringUtil.getMd5(newPass, "silencePassword"));
				userService.updateUser(user);
				session.removeAttribute("userInfo");
				return new SilenceResult<Null>(true, "修改成功");
			} else {
				return new SilenceResult<Null>(false, "原密码错误");
			}
		} else {
			return new SilenceResult<Null>(false, "原密码不能为空");
		}
	}
	
	/**
	 * 获取所有用户
	 * @param pages
	 * @return
	 */
	@RequestMapping(value = "getAllUser")
	@ResponseBody
	public SilenceResult<Map<String, Object>> getAllUser(Pages pages) {
		Map<String, Object> map = new HashMap<String, Object>();
		pages.setTotalCount(userService.getUserNum());
		pages.setTotalPage(pages.getTotalCount() % pages.getPageSize() == 0 ? pages.getTotalCount() / pages.getPageSize() : pages.getTotalCount() / pages.getPageSize() + 1);
		map.put("pages", pages);
		map.put("users", userService.getAllUser(pages));
		return new SilenceResult<Map<String,Object>>(true, map);
	}
}
