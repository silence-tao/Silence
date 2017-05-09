package com.silencetao.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Cookies工具类
 * @author Silence
 *
 */
public class CookiesUtil {
	
	/**
	 * 创建Cookie
	 * @param response
	 * @param cookieName
	 * @param cookieValue
	 */
	public static void createCookie(HttpServletResponse response, String cookieName, String cookieValue) {
		Cookie cookie = new Cookie(cookieName, cookieValue);
		cookie.setMaxAge(3600 * 24 * 30);
		response.addCookie(cookie);
	}
	
	/**
	 * 销毁Cookie
	 * @param response
	 */
	public static void clearCookie(HttpServletResponse response, String cookieName) {
		Cookie cookie = new Cookie(cookieName, null);
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	}
	
	public static String getCookie(HttpServletRequest request, String cookieName) {
		Cookie[] cookies = request.getCookies();
		if(cookies == null) {
			return null;
		}
		String cookieValue = null;
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals(cookieName)) {
				cookieValue = cookie.getValue();
			}
		}
		return cookieValue;
	}
}
