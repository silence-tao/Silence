package com.silencetao.controller.route;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 页面跳转代理
 * @author Silence
 *
 */
@Controller
public class IndexController {
	
	@RequestMapping(value = "{action}.html", method = RequestMethod.GET)
	public String to(@PathVariable("action") String action) {
		return action;
	}
}
