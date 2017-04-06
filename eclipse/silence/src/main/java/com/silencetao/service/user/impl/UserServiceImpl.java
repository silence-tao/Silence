package com.silencetao.service.user.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.silencetao.dao.user.UserDao;
import com.silencetao.entity.User;
import com.silencetao.exception.DatabaseException;
import com.silencetao.exception.SilenceException;
import com.silencetao.service.user.UserService;

/**
 * User Service实现层
 * @author Silence
 *
 */
@Service
public class UserServiceImpl implements UserService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserDao userDao;

	@Transactional
	@Override
	public void register(User user) {
		log.info("保存User信息");
		try {
			int insertCount =  userDao.insertUser(user);
			if(insertCount < 1) {
				throw new DatabaseException("保存失败");
			}
			log.info("保存User信息成功");
		} catch (DatabaseException e) {
			log.error(e.getMessage(), e);
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new SilenceException("系统错误,请重试");
		}
	}

	@Override
	public User login(User user) {
		return userDao.getUser(user);
	}

	@Override
	public int getCountByNikename(String nikename) {
		return userDao.getCountByNikename(nikename);
	}

	@Override
	public int getCountByUsername(String username) {
		return userDao.getCountByUsername(username);
	}

	@Override
	public User getUserBySign(String userSign) {
		return userDao.getUserBySign(userSign);
	}

}
