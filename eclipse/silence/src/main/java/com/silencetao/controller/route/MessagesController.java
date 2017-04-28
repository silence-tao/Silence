package com.silencetao.controller.route;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 留言板模块页面跳转代理
 * @author Silence
 *
 */
@Controller
public class MessagesController {

	@RequestMapping(value = "message", method = RequestMethod.GET)
	public String to() {
		return "message/message";
	}
	
	@RequestMapping(value = "message/{action}", method = RequestMethod.GET)
	public String toPage(@PathVariable("action") String action) {
		return "message/" + action;
	}
}
