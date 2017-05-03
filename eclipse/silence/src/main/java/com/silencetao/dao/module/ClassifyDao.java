package com.silencetao.dao.module;

import java.util.List;

import com.silencetao.entity.Classify;

/**
 * 技术分享文章类别Dao层接口
 * @author Silence
 *
 */
public interface ClassifyDao {

	/**
	 * 添加一个类别
	 * @param classify
	 * @return
	 */
	public int insertClassify(Classify classify);
	
	/**
	 * 获取所有类别
	 * @return
	 */
	public List<Classify> getClassifies();
}
