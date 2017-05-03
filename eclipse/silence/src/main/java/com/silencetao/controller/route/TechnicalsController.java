package com.silencetao.controller.route;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.silencetao.utils.StringUtil;

/**
 * 技术分享模块页面跳转代理
 * @author Silence
 *
 */
@Controller
public class TechnicalsController {

	@RequestMapping(value = "technical", method = RequestMethod.GET)
	public String to() {
		return "technical/technical";
	}
	
	@RequestMapping(value = "technical/{action}", method = RequestMethod.GET)
	public String toPage(@PathVariable("action") String action, HttpSession session) {
		if("newtechnical".equals(action)) {
			String opinionSign = StringUtil.getMd5(System.currentTimeMillis() + StringUtil.getRandom(10), "silenceTechnical");
			session.setAttribute("technicalSign", opinionSign);
		}
		return "technical/" + action;
	}
}
