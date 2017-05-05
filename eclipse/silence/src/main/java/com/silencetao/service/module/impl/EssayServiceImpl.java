package com.silencetao.service.module.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silencetao.dao.module.EssayDao;
import com.silencetao.service.module.EssayService;
import com.silencetao.view.EssayView;
import com.silencetao.view.Pages;

/**
 * 文章排行榜Service层接口实现
 * @author 陈小轩
 *
 */
@Service
public class EssayServiceImpl implements EssayService {
	
	@Autowired
	private EssayDao essayDao;

	@Override
	public List<EssayView> getNewEssay() {
		return essayDao.getNewEssay();
	}

	@Override
	public List<EssayView> getHotEssay() {
		return essayDao.getHotEssay();
	}

	@Override
	public List<EssayView> getEssays(Pages pages) {
		return essayDao.getEssays((pages.getCurrentPage() - 1) * pages.getPageSize(), pages.getPageSize());
	}

	@Override
	public long getEssayNum() {
		return essayDao.getEssayNum();
	}

}
