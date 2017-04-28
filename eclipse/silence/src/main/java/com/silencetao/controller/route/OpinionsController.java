package com.silencetao.controller.route;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String toPage(@PathVariable("action") String action) {
		return "opinion/" + action;
	}
}
