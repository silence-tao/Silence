package com.silencetao.service.opinion;

import java.util.List;
import java.util.Map;

import com.silencetao.entity.Opinion;
import com.silencetao.view.OpinionView;
import com.silencetao.view.Pages;

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
	
	/**
	 * 获取分享生活
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<OpinionView> getOpinions(Pages pages);
	
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
	public OpinionView getOpinionById(long opinionId);
	
	/**
	 * 获取相邻的分享生活
	 * @param opinionId
	 * @return
	 */
	public Map<String, OpinionView> getOpinionBorder(long opinionId);
}
