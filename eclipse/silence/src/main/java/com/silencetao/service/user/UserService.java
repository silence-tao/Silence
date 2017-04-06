package com.silencetao.service.user;

import com.silencetao.entity.User;

/**
 * User Service层
 * @author Silence
 *
 */
public interface UserService {
	
	/**
	 * 用户注册
	 * @param user
	 */
	public void register(User user);
	
	/**
	 * 用户登录
	 * @param user
	 * @return 成功返回user对象,否则返回null
	 */
	public User login(User user);
	
	/**
	 * 获取相同昵称的用户数量
	 * @param nikename
	 * @return 返回相同昵称的用户数量
	 */
	public int getCountByNikename(String nikename);
	
	/**
	 * 获取相同用户名的用户数量
	 * @param nikename
	 * @return 返回相同用户名的用户数量
	 */
	public int getCountByUsername(String username);
	
	/**
	 * 通过userSign或取user对象
	 * @param userSign
	 * @return 返回相应userSign的user对象
	 */
	public User getUserBySign(String userSign);
}
