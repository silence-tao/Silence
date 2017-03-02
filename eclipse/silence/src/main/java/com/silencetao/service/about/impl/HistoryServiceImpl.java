package com.silencetao.service.about.impl;

import com.silencetao.dao.about.HistoryDao;
import com.silencetao.entity.History;
import com.silencetao.service.about.HistoryService;

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
}