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
	
	@RequestMapping(value = "userRegister")
	@ResponseBody
	public SilenceResult<Null> register(User user, HttpServletRequest request) {
		if(userService.getCountByNikename(user.getNikename()) > 0) {
			log.warn("昵称已存在");
			throw new MessageExcetion("昵称已存在");
		}
		if(userService.getCountByUsername(user.getUsername()) > 0) {
			log.warn("邮箱已被注册");
			throw new MessageExcetion("邮箱已被注册");
		}
		user.setRegisterIp(request.getRemoteAddr());
		user.setUserSign(StringUtil.getMd5(user.getUsername() + user.getNikename(), "silenceUser"));
		try {
			userService.register(user);
			return new SilenceResult<Null>(true, "注册成功");
		} catch (DatabaseException e) {
			log.error(e.getMessage(), e);
			throw new MessageExcetion("注册失败,请重试");
		} catch (Exception e) {
			log.warn("注册失败");
			log.error(e.getMessage(), e);
			throw new MessageExcetion("注册失败");
		}
	}
	
	@RequestMapping(value = "userLogin")
	@ResponseBody
	public SilenceResult<Null> login(@CookieValue(value = "userSign", required = false) String userSign,
			User u, String remember, HttpSession session, HttpServletResponse response) {
		User user = null;
		if(userSign != null) {
			user = userService.getUserBySign(userSign);
		} else {
			user = userService.login(u);
		}
		if(user != null) {
			session.setAttribute("userInfo", user);
			if("checked".equals(remember)) {
				Cookie cookie = new Cookie("userSign", user.getUserSign());
				cookie.setMaxAge(3600 * 24 * 30);
				response.addCookie(cookie);
			} else {
				Cookie cookie = new Cookie("userSign", null);
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
			return new SilenceResult<Null>(true, "登录成功");
		} else {
			Cookie cookie = new Cookie("userSign", null);
			cookie.setMaxAge(0);
			response.addCookie(cookie);
			return new SilenceResult<Null>(false, "用户名不存在或密码错误");
		}
	}
	
	@RequestMapping(value = "getUserSign")
	@ResponseBody
	public SilenceResult<User> getUserSign(@CookieValue(value = "userSign", required = false) String userSign,
			HttpServletResponse response) {
		if(userSign != null) {
			User user = userService.getUserBySign(userSign);
			if(user != null) {
				user.setPassword("silencetao");
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
}
