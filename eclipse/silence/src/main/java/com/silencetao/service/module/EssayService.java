package com.silencetao.service.module;

import java.util.List;

import com.silencetao.view.EssayView;
import com.silencetao.view.Pages;

/**
 * 文章排行榜Service层接口
 * @author Silence
 *
 */
public interface EssayService {

	/**
	 * 获取最新的十篇文章
	 * @return
	 */
	public List<EssayView> getNewEssay();
	
	/**
	 * 获取点击量最高的十篇文章
	 * @return
	 */
	public List<EssayView> getHotEssay();
	
	/**
	 * 获取所有文章
	 * @return
	 */
	public List<EssayView> getEssays(Pages pages);
	
	/**
	 * 获取文章数量
	 * @return
	 */
	public long getEssayNum();
}
