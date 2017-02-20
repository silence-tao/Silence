package com.silencetao.service.about;

import com.silencetao.entity.History;
import java.util.List;

public interface HistoryService {
	public List<History> getHistories(int offset, int limit,
			String order);
}