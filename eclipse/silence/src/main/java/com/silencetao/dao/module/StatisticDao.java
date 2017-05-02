package com.silencetao.dao.module;

import com.silencetao.entity.Statistic;

/**
 * 数据统计Dao层接口
 * @author Silence
 *
 */
public interface StatisticDao {

	/**
	 * 插入一条数据统计
	 * @param statistic
	 * @return
	 */
	public int insertStatistic(Statistic statistic);
	
	/**
	 * 评论数加1
	 * @param pertain
	 * @return
	 */
	public int updateCommentNum(String pertain);
	
	/**
	 * 浏览量加1
	 * @param pertain
	 * @return
	 */
	public int updateVisitorNum(String pertain);
	
	/**
	 * 点赞数加1
	 * @param pertain
	 * @return
	 */
	public int updatePraiseNum(String pertain);
}
