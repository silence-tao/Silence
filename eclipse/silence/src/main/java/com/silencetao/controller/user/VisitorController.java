package com.silencetao.controller.user;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.jdbc.Null;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.silencetao.entity.User;
import com.silencetao.exception.DatabaseException;
import com.silencetao.service.user.UserService;
import com.silencetao.utils.StringUtil;
import com.silencetao.view.SilenceResult;

/**
 * 游客模式Controller
 * @author Silence
 *
 */
@Controller
public class VisitorController {
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserService userService;
	
	/**
	 * 游客录入基本信息
	 * @param user
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "visitorRegister")
	@ResponseBody
	public SilenceResult<Null> visitorRegister(User user, HttpServletRequest request, HttpServletResponse response) {
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
		try {
			userService.register(user);
			Cookie cookie = new Cookie("visitorSign", user.getUserSign());
			cookie.setMaxAge(3600 * 24 * 30);
			response.addCookie(cookie);
			return new SilenceResult<Null>(true, "录入成功");
		} catch (DatabaseException e) {
			log.error(e.getMessage(), e);
			return new SilenceResult<Null>(false, "录入失败");
		} catch (Exception e) {
			log.warn("录入失败");
			log.error(e.getMessage(), e);
			return new SilenceResult<Null>(false, "录入失败");
		}
	}
}
