package com.silencetao.service.opinion.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.silencetao.dao.module.StatisticDao;
import com.silencetao.dao.opinion.OpinionDao;
import com.silencetao.entity.Opinion;
import com.silencetao.entity.Statistic;
import com.silencetao.service.opinion.OpinionService;
import com.silencetao.view.EssayView;
import com.silencetao.view.Pages;

/**
 * 分享生活Service层接口实现
 * @author Silence
 *
 */
@Service
public class OpinionServiceImpl implements OpinionService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private OpinionDao opinionDao;
	
	@Autowired
	private StatisticDao statisticDao;

	@Transactional
	@Override
	public int insertOpinion(Opinion opinion) {
		int result = 0;
		try {
			result += opinionDao.insertOpinion(opinion);
			Statistic statistic = new Statistic(opinion.getOpinionSign());
			result += statisticDao.insertStatistic(statistic);
		} catch (Exception e) {
			log.warn("保存分享生活失败");
			log.error(e.getMessage(), e);
		}
		return result;
	}

	@Override
	public List<EssayView> getOpinions(Pages pages) {
		return opinionDao.getOpinions((pages.getCurrentPage() - 1) * pages.getPageSize(), pages.getPageSize());
	}

	@Override
	public long getOpinionNum() {
		return opinionDao.getOpinionNum();
	}

	@Transactional
	@Override
	public EssayView getOpinionById(long opinionId) {
		EssayView opinionView = opinionDao.getOpinionById(opinionId);
		if(opinionView != null) {
			statisticDao.updateVisitorNum(opinionView.getEssaySign());
			return opinionView;
		}
		return null;
	}

	@Override
	public Map<String, EssayView> getOpinionBorder(long opinionId) {
		Map<String, EssayView> map = new HashMap<String, EssayView>();
		map.put("front", opinionDao.getOpinionFront(opinionId));
		map.put("after", opinionDao.getOpinionAfter(opinionId));
		return map;
	}

	@Override
	public List<EssayView> getOpinionHome() {
		return opinionDao.getOpinionHome();
	}

	@Transactional
	@Override
	public int updateHomeShow(Opinion opinion) {
		return opinionDao.updateHomeShow(opinion);
	}
}
