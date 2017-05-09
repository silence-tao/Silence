package com.silencetao.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.silencetao.entity.User;

/**
 * 登录检测工具类
 * @author Silence
 *
 */
public class SessionUtil {
	
	public static int isLogin(HttpSession session, HttpServletRequest request) {
		String visitorSign = CookiesUtil.getCookie(request, "visitorSign");
		User user = (User) session.getAttribute("userInfo");
		if(visitorSign != null) {
			return 1;
		} else if(user != null) {
			return 2;
		} else {
			return 0;
		}
	}
}
