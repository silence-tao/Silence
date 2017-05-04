package com.silencetao.service.user;

import com.silencetao.entity.Information;

/**
 * 用户基本信息
 * @author Silence
 *
 */
public interface InformationService {

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
