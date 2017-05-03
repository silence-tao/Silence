package com.silencetao.service.technical.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.silencetao.dao.module.StatisticDao;
import com.silencetao.dao.technical.TechnicalDao;
import com.silencetao.entity.Statistic;
import com.silencetao.entity.Technical;
import com.silencetao.service.technical.TechnicalService;

/**
 * 技术分享Service层接口实现
 * @author Silence
 *
 */
@Service
public class TechnicalServiceImpl implements TechnicalService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private TechnicalDao technicalDao;
	
	@Autowired
	private StatisticDao statisticDao;

	@Transactional
	@Override
	public int insertTechnical(Technical technical) {
		int result = 0;
		try {
			result += technicalDao.insertTechnical(technical);
			Statistic statistic = new Statistic(technical.getTechnicalSign());
			result += statisticDao.insertStatistic(statistic);
		} catch (Exception e) {
			log.warn("保存技术分享失败");
			log.error(e.getMessage(), e);
		}
		return result;
	}

}
