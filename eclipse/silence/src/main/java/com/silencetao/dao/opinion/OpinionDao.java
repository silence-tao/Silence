package com.silencetao.dao.opinion;

import com.silencetao.entity.Opinion;

/**
 * 分享生活Dao层接口
 * @author Silence
 *
 */
public interface OpinionDao {

	/**
	 * 添加一条分享生活
	 * @param opinion
	 * @return
	 */
	public int insertOpinion(Opinion opinion);
}
