package com.silencetao.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 系统拦截器
 * @author Silence
 *
 */
public class SilenceInterceptor implements HandlerInterceptor {

	/**
	 * 返回值:表示我们是否需要将当前的请求拦截下来
	 * 	如果返回false,请求将被终止
	 * 	如果返回true,请求会被继续运行
	 * Object handler表示的是被拦截的请求的目标对象
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String url = request.getRequestURI();
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//可以通过ModelAndView参数来改变显示的视图,或修改发往视图的方法
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		
	}
}
