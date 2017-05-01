package com.silencetao.controller.route;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.silencetao.utils.StringUtil;

/**
 * 分享生活模块页面跳转代理
 * @author Silence
 *
 */
@Controller
public class OpinionsController {
	
	@RequestMapping(value = "opinion", method = RequestMethod.GET)
	public String to() {
		return "opinion/opinion";
	}
	
	@RequestMapping(value = "opinion/{action}", method = RequestMethod.GET)
	public String toPage(@PathVariable("action") String action, HttpSession session) {
		if("newopinion".equals(action)) {
			String opinionSign = StringUtil.getMd5(System.currentTimeMillis() + StringUtil.getRandom(10), "silenceOpinion");
			session.setAttribute("opinionSign", opinionSign);
		}
		return "opinion/" + action;
	}
}
