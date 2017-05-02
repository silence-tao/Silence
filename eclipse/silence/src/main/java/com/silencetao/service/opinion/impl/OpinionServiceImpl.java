package com.silencetao.service.opinion.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.silencetao.dao.opinion.OpinionDao;
import com.silencetao.entity.Opinion;
import com.silencetao.service.opinion.OpinionService;
import com.silencetao.view.OpinionView;
import com.silencetao.view.Pages;

/**
 * 分享生活Service层接口实现
 * @author Silence
 *
 */
@Service
public class OpinionServiceImpl implements OpinionService {
	
	@Autowired
	private OpinionDao opinionDao;

	@Transactional
	@Override
	public int insertOpinion(Opinion opinion) {
		return opinionDao.insertOpinion(opinion);
	}

	@Override
	public List<OpinionView> getOpinions(Pages pages) {
		return opinionDao.getOpinions((pages.getCurrentPage() - 1) * pages.getPageSize(), pages.getPageSize());
	}

	@Override
	public long getOpinionNum() {
		return opinionDao.getOpinionNum();
	}

}
