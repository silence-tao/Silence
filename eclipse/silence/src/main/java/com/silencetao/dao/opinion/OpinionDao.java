package com.silencetao.dao.opinion;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.silencetao.entity.Opinion;
import com.silencetao.view.OpinionView;

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
	
	/**
	 * 获取分享生活
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<OpinionView> getOpinions(@Param("offset") long offset, @Param("limit") long limit);
	
	/**
	 * 获取分享生活数量
	 * @return
	 */
	public long getOpinionNum();
}
