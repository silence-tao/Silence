package com.silencetao.dao.user;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.silencetao.entity.User;
/**
 * UserDao Junit测试类
 * @author Silence
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml" })
public class UserDaoTest {
	
	@Resource
	private UserDao userDao;

	@Test
	public void testInsertUser() throws Exception {
		User user = new User("jfdlksaj", "fjdsa", "jfa", "fjls", "jfla");
		int insertCount = userDao.insertUser(user);
		System.out.println(insertCount);
	}
	
	@Test
	public void testDeleteUser() throws Exception {
		long id = 24;
		int deleteCount = userDao.deleteUser(id);
		System.out.println(deleteCount);
	}
	
	@Test
	public void testUpdateUser() throws Exception {
		User u = new User();
		u.setUsername("fsdfs");
		u.setNikename("fjdsa");
		u.setPassword("jfa");
		User user = userDao.getUser(u);
		System.out.println(user);
		user.setPassword("123456");
		int updateCount = userDao.updateUser(user);
		System.out.println(updateCount);
	}
}
