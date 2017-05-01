package com.silencetao.service.opinion;

import com.silencetao.entity.Opinion;

/**
 * 分享生活Service层接口
 * @author 陈小轩
 *
 */
public interface OpinionService {

	/**
	 * 添加一条分享生活
	 * @param opinion
	 * @return
	 */
	public int insertOpinion(Opinion opinion);
}
