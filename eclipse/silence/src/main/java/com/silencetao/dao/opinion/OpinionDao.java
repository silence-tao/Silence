package com.silencetao.dao.opinion;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.silencetao.entity.Opinion;
import com.silencetao.view.EssayView;

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
	public List<EssayView> getOpinions(@Param("offset") long offset, @Param("limit") long limit);
	
	/**
	 * 获取分享生活数量
	 * @return
	 */
	public long getOpinionNum();
	
	/**
	 * 根据Id获取分享生活
	 * @param opinionId
	 * @return
	 */
	public EssayView getOpinionById(long opinionId);
	
	/**
	 * 获得前面一条分享生活
	 * @param opinionId
	 * @return
	 */
	public EssayView getOpinionFront(long opinionId);
	
	/**
	 * 获得后面一条分享生活
	 * @param opinionId
	 * @return
	 */
	public EssayView getOpinionAfter(long opinionId);
	
	/**
	 * 获取分享生活主页数据
	 * @return
	 */
	public List<EssayView> getOpinionHome();
}
