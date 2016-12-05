package com.mybatis.test;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis.impl.IArticleDao;
import com.mybatis.impl.IUserDao;
import com.mybatis.model.Article;
import com.mybatis.model.User;

public class Test {
	private static SqlSessionFactory sessionFactory;
	private static Reader reader;
	
	static {
		try {
			reader = Resources.getResourceAsReader("config/Configuration.xml");
			sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static void main(String[] args) {
//		根据id获取一个User
//		getUser(1);
		
//		添加一个User
//		User user = new User("陈小轩", "22", "赣州崇义");
//		addUser(user);
		
//		更新一个User的信息
//		User user = getUser(1);
//		user.setUserAddress("江西赣州");
//		updateUser(user);
		
//		根据id删除一个User
//		deleteUser(1);
		
//		查询所有的User
//		getUserList();
		
//		根据User的id获取所有article
		getUserArticles(3);
	}
	
	public static User getUser(int id) {
		SqlSession session = sessionFactory.openSession();
		User user = null;
		try {
//			不用接口
//			user = (User) session.selectOne("model.User.selectUserById", id);
//			使用接口
			IUserDao userDao = session.getMapper(IUserDao.class);
			user = userDao.selectUserById(id);
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return user;
	}
	
	public static void getUserList() {
		SqlSession session = sessionFactory.openSession();
		try {
			IUserDao userDao = session.getMapper(IUserDao.class);
			List<User> users = userDao.selectUsers();
			System.out.println(users);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public static void addUser(User user) {
		SqlSession session = sessionFactory.openSession();
		try {
			IUserDao userDao = session.getMapper(IUserDao.class);
			userDao.addUser(user);
			session.commit();
			System.out.println(user.getId());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public static void updateUser(User user) {
		SqlSession session = sessionFactory.openSession();
		try {
			IUserDao userDao = session.getMapper(IUserDao.class);
			userDao.updateUser(user);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public static void deleteUser(int id) {
		SqlSession session = sessionFactory.openSession();
		try {
			IUserDao userDao = session.getMapper(IUserDao.class);
			userDao.deleteUser(id);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
		}
	}
	
	public static void getArticles(int id) {
		SqlSession session = sessionFactory.openSession();
		try {
			IUserDao userDao = session.getMapper(IUserDao.class);
			List<Article> articles = userDao.getArticles(id);
			System.out.println(articles);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
		}
	}
	
	public static void getUserArticles(int id) {
		SqlSession session = sessionFactory.openSession();
		try {
			IArticleDao articleDao = session.getMapper(IArticleDao.class);
			List<Article> articles = articleDao.getUserArticles(id);
			System.out.println(articles);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
		}
	}
}
