package com.silencetao.dao.module;

import java.util.List;

import com.silencetao.view.EssayView;

/**
 * 文章排行榜Dao接口
 * @author Silence
 *
 */
public interface EssayDao {

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
}
