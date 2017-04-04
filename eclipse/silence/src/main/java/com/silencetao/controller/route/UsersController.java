package com.silencetao.controller.route;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 用户模块页面跳转代理
 * @author Silence
 *
 */
@Controller
@RequestMapping(value = "user")
public class UsersController {

	@RequestMapping(value = "{action}", method = RequestMethod.GET)
	public String to(@PathVariable("action") String action) {
		return "user/" + action;
	}
}
