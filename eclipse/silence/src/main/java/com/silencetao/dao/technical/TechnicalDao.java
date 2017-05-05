package com.silencetao.dao.technical;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.silencetao.entity.Technical;
import com.silencetao.view.EssayView;

/**
 * 技术分享Dao接口
 * @author Silence
 *
 */
public interface TechnicalDao {

	/**
	 * 添加一条技术分享
	 * @param technical
	 * @return
	 */
	public int insertTechnical(Technical technical);
	
	/**
	 * 获取技术分享
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<EssayView> getTechnicals(@Param("offset") long offset, @Param("limit") long limit);
	
	/**
	 * 获取技术分享数量
	 * @return
	 */
	public long getTechnicalNum();
	
	/**
	 * 根据Id获取技术分享
	 * @param technicalId
	 * @return
	 */
	public EssayView getTechnicalById(long technicalId);
	
	/**
	 * 获得前面一条技术分享
	 * @param opinionId
	 * @return
	 */
	public EssayView getOpinionFront(long technicalId);
	
	/**
	 * 获得后面一条技术分享
	 * @param opinionId
	 * @return
	 */
	public EssayView getOpinionAfter(long technicalId);
	
	/**
	 * 获取技术分享主页数据
	 * @return
	 */
	public List<EssayView> getTechnicalHome();
	
	/**
	 * 设置是否在首页显示
	 * @param technical
	 * @return
	 */
	public int updateHomeShow(Technical technical);
}