package com.mybatis.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mybatis.impl.IUserDao;
import com.mybatis.model.Article;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	IUserDao userDao;
	
	@RequestMapping("/list")
	public ModelAndView getArticles(HttpServletRequest request, HttpServletResponse response) {
		List<Article> articles = userDao.getArticles(3);
		ModelAndView mav = new ModelAndView("list");
		mav.addObject("articles", articles);
		return mav;
	}
}
