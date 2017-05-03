package com.silencetao.service.technical.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.silencetao.view.EssayView;
import com.silencetao.view.Pages;

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

	@Override
	public List<EssayView> getTechnicals(Pages pages) {
		return technicalDao.getTechnicals((pages.getCurrentPage() - 1) * pages.getPageSize(), pages.getPageSize());
	}

	@Override
	public long getTechnicalNum() {
		return technicalDao.getTechnicalNum();
	}

	@Transactional
	@Override
	public EssayView getTechnicalById(long technicalId) {
		EssayView essayView = technicalDao.getTechnicalById(technicalId);
		if(essayView != null) {
			statisticDao.updateVisitorNum(essayView.getEssaySign());
			return essayView;
		}
		return null;
	}

	@Override
	public Map<String, EssayView> getTechnicalBorder(long technicalId) {
		Map<String, EssayView> map = new HashMap<String, EssayView>();
		map.put("front", technicalDao.getOpinionFront(technicalId));
		map.put("after", technicalDao.getOpinionAfter(technicalId));
		return map;
	}

}
