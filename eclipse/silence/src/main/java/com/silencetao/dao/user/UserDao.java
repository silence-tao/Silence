package com.silencetao.dao.user;

import com.silencetao.entity.User;

/**
 * User Dao层实现
 * @author Silence
 *
 */
public interface UserDao {

	/**
	 * 添加一条用户信息
	 * @param user
	 * @return 返回添加记录的条数
	 */
	public int insertUser(User user);
	
	/**
	 * 删除一条用户信息
	 * @param id
	 * @return 返回删除记录的条数
	 */
	public int deleteUser(long id);
	
	/**
	 * 更新一条用户信息
	 * @param user
	 * @return 返回更新记录的条数
	 */
	public int updateUser(User user);
	
	/**
	 * 根据用户名或者昵称查找一个用户,用在登录
	 * @param user
	 * @return 如果存在,返回一个User对象,否则返回空
	 */
	public User getUser(User user);
	
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
