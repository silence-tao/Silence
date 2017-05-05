package com.silencetao.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.silencetao.entity.User;
import com.silencetao.view.UserView;

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
	
	/**
	 * 根据用户名或昵称获取用户的头像
	 * @param username
	 * @return
	 */
	public String getHeader(String username);
	
	/**
	 * 根据用户唯一标示获取用户头像
	 * @param userSing
	 * @return
	 */
	public String getHeaderBySign(String userSign);
	
	/**
	 * 获取所有用户信息
	 * @return
	 */
	public List<UserView> getAllUser(@Param("offset") long offset, @Param("limit") long limit);
	
	/**
	 * 获取用户数量
	 * @return
	 */
	public long getUserNum();
}
