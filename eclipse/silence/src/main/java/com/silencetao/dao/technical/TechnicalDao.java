package com.silencetao.dao.technical;

import com.silencetao.entity.Technical;

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
}
