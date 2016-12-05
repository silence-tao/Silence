package com.mybatis.impl;

import java.util.List;

import com.mybatis.model.Article;

public interface IArticleDao {
	public List<Article> getUserArticles(int id);
}
