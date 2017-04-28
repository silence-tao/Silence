package com.silencetao.controller.route;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String toPage(@PathVariable("action") String action) {
		return "technical/" + action;
	}
}
