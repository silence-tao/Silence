package com.silencetao.service.about.impl;

import com.silencetao.dao.about.HistoryDao;
import com.silencetao.entity.History;
import com.silencetao.service.about.HistoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("historyService")
public class HistoryServiceImpl implements HistoryService {

	@Autowired
	private HistoryDao historyDao;

	public List<History> getHistories(int offset, int limit, String order) {
		List<History> histories = null;
		if ("acs".equals(order)) {
			histories = this.historyDao.getHistories(offset, limit);
		} else if ("desc".equals(order)) {
			histories = this.historyDao.getHistoriesDesc(offset, limit);
		}
		return histories;
	}
}