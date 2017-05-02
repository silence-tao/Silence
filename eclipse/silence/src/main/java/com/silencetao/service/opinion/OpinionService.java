package com.silencetao.service.opinion;

import java.util.List;

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
}
