package com.silencetao.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.jdbc.Null;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.silencetao.utils.SessionUtil;
import com.silencetao.utils.StringUtil;
import com.silencetao.view.SilenceResult;

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
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String url = request.getRequestURI();
		int login = SessionUtil.isLogin(request.getSession(), request);
		if((
		"/history/savehistory".equals(url) ||
		"/history/editTechnical".equals(url) ||
		"/history/isHomeShow".equals(url) || 
		"/message/isHomeShow".equals(url) || 
		"/classify/saveClassify".equals(url) || 
		"/opinion/saveOpinion".equals(url) || 
		"/opinion/isHomeShow".equals(url) || 
		"/technical/saveTechnical".equals(url) || 
		"/technical/isHomeShow".equals(url) || 
		"/technical/getAllTechnical".equals(url) || 
		"/user/loginOut".equals(url) || 
		"/user/saveInformation".equals(url) || 
		"/user/saveHeader".equals(url) || 
		"/user/savePassword".equals(url) || 
		"/user/getAllUser".equals(url) ||
		url.contains("deleteById") ||
		url.contains("findTechnicalById")) && login != 2) {
			PrintWriter out = response.getWriter();
			SilenceResult<Null> result = new SilenceResult<Null>(false, -2, "未登录");
			out.print(StringUtil.toJson(result));
			out.flush();
			return false;
		} else if(("/comment/saveComment".equals(url) || 
		"/message/saveMessage".equals(url) || 
		"/user/getHeaderBySign".equals(url)) && login == -1) {
			PrintWriter out = response.getWriter();
			SilenceResult<Null> result = new SilenceResult<Null>(false, -1, "未登录");
			out.print(StringUtil.toJson(result));
			out.flush();
			return false;
		} else if((
		"/essay/getAllEssay".equals(url) || 
		"/essay/manage".equals(url) || 
		"/essay/history".equals(url) || 
		"/essay/message".equals(url) || 
		"/essay/opinion".equals(url) || 
		"/essay/technical".equals(url) || 
		"/opinion/newopinion".equals(url) || 
		"/technical/newtechnical".equals(url) || 
		"/user/manage".equals(url) || 
		"/user/message".equals(url) || 
		"/user/info".equals(url) || 
		"/user/password".equals(url) ||
		url.contains("technical/edit") ||
		url.contains("technical/audit")) && login != 2) {
			request.getRequestDispatcher("/user/login").forward(request, response);
			return false;
		}
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
