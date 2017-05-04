package com.silencetao.dao.user;

import com.silencetao.entity.Information;

/**
 * 用户信息Dao层接口
 * @author Silence
 *
 */
public interface InformationDao {

	/**
	 * 添加一条用户信息
	 * @param information
	 * @return
	 */
	public int insertInformation(Information information);
	
	/**
	 * 
	 * @param pertain
	 * @return
	 */
	public Information getInformationByPertain(String pertain);
	
	/**
	 * 修改用户信息
	 * @param information
	 * @return
	 */
	public int updateInformation(Information information);
}
