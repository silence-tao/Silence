package com.silencetao.service.about.impl;

import com.silencetao.dao.about.HistoryDao;
import com.silencetao.dao.module.PictureDao;
import com.silencetao.entity.History;
import com.silencetao.entity.Picture;
import com.silencetao.exception.DatabaseException;
import com.silencetao.exception.SilenceException;
import com.silencetao.service.about.HistoryService;
import com.silencetao.view.HistoryView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HistoryServiceImpl implements HistoryService {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private HistoryDao historyDao;
	
	@Autowired
	private PictureDao pictureDao;

	@Transactional
	@Override
	public int insertHistory(History history) {
		log.info("开始保存进程信息");
		int result = 0;
		try {
			result = historyDao.insertHistory(history);
			log.warn("保存进程信息成功");
		} catch (Exception e) {
			log.warn("保存进程信息失败");
			log.error(e.getMessage(), e);
		}
		return result;
	}

	public List<History> getHistories(int offset, int limit, String order) {
		List<History> histories = null;
		if ("acs".equals(order)) {
			log.info("根据时间顺序获取" + limit + "个History对象");
			histories = this.historyDao.getHistories(offset, limit);
		} else if ("desc".equals(order)) {
			log.info("根据时间逆序获取" + limit + "个History对象");
			histories = this.historyDao.getHistoriesDesc(offset, limit);
		}
		return histories;
	}

	@Override
	public List<HistoryView> getHistoryViews(int offset, int limit) throws Exception {
		log.info("根据时间逆序序获取" + limit + "个History对象");
		List<History> histories = null;
		histories = historyDao.getHistoriesDesc(offset, limit);
		List<HistoryView> historyViews = new ArrayList<HistoryView>();
		log.info("查找History对象所包含的图片并封装为HistoryView对象");
		for(History history : histories) {
			HistoryView historyView = new HistoryView(history.getTitle(), history.getContent(), history.getHistorySign(), history.getRecordTime());
			List<Picture> pictureList = pictureDao.getOnePictures(history.getHistorySign());
			List<String> pictures = new ArrayList<String>();
			for(Picture picture : pictureList) {
				pictures.add(picture.getRealPath());
			}
			historyView.setPictures(pictures);
			historyViews.add(historyView);
		}
		return historyViews;
	}

	@Transactional
	@Override
	public List<HistoryView> saveHistory(History history, List<Picture> pictures) {
		try {
			int historyCount = historyDao.insertHistory(history);
			if(historyCount > 0) {
				int pictureCount = 0;
				for(Picture picture : pictures) {
					pictureCount += pictureDao.insertPicture(picture);
				}
				if(pictureCount < pictures.size()) {
					throw new DatabaseException("保存图片信息失败");
				} else {
					return getHistoryViews(0, 10);
				}
			} else {
				throw new DatabaseException("保存History信息失败");
			}
		} catch (DatabaseException e) {
			log.error(e.getMessage());
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new SilenceException("系统错误,请重试");
		}
	}
}