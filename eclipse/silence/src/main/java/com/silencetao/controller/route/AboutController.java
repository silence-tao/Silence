package com.silencetao.controller.route;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("about")
public class AboutController {
	
	@RequestMapping(value = "{action}", method = RequestMethod.GET)
	public String toHistory(@PathVariable("action") String action) {
		return "about/" + action;
	}
}