package com.silencetao.service.opinion;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.silencetao.entity.Opinion;
import com.silencetao.view.EssayView;
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
	public List<EssayView> getOpinions(Pages pages);
	
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
	 * 获取相邻的分享生活
	 * @param opinionId
	 * @return
	 */
	public Map<String, EssayView> getOpinionBorder(long opinionId);
	
	/**
	 * 获取分享生活主页数据
	 * @return
	 */
	public List<EssayView> getOpinionHome();
	
	/**
	 * 设置是否在首页显示
	 * @param opinion
	 * @return
	 */
	public int updateHomeShow(Opinion opinion);
	
	/**
	 * 获取所有的分享生活,除了删除的
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<EssayView> getAllOpinion(Pages pages);
	
	/**
	 * 获取所有的分享生活数量,除了删除的
	 * @return
	 */
	public long getAllOpinionNum();
	
	/**
	 * 获取一条opinion对象信息
	 * @return
	 */
	public Opinion findOpinionById(long opinionId);
	
	/**
	 * 编辑分享生活
	 * @param opinion
	 * @return
	 */
	public int editOpinion(Opinion opinion);
	
	/**
	 * 删除一条分享生活,逻辑删除
	 * @param opinionId
	 * @return
	 */
	public int deleteById(long opinionId);
}
