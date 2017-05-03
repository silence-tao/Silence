package com.silencetao.service.technical;

import com.silencetao.entity.Technical;

/**
 * 技术分享Service层接口
 * @author Silence
 *
 */
public interface TechnicalService {

	/**
	 * 添加一条技术分享
	 * @param technical
	 * @return
	 */
	public int insertTechnical(Technical technical);
}
