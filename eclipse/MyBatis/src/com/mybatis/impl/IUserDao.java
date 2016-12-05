package com.mybatis.impl;

import java.util.List;

import com.mybatis.model.Article;
import com.mybatis.model.User;

public interface IUserDao {
	public User selectUserById(int id);
	public List<User> selectUsers();
	public void addUser(User user);
	public void updateUser(User user);
	public void deleteUser(int id);
	public List<Article> getArticles(int id);
}
