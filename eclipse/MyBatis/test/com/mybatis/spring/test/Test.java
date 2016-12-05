package com.mybatis.spring.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mybatis.impl.IUserDao;
import com.mybatis.model.Article;
import com.mybatis.model.User;

public class Test {
	private static ApplicationContext context;
	
	static {
		context = new ClassPathXmlApplicationContext("config/applicationContext.xml");
	}

	public static void main(String[] args) {
		IUserDao userDao = (IUserDao) context.getBean("userMapper");
		User user = userDao.selectUserById(3);
		System.out.println(user);
		
		List<Article> articles = userDao.getArticles(3);
		for(Article article : articles) {
			System.out.println(article.getUser().getUserName() + ":" + article);
		}
	}

}
