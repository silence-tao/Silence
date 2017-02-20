package com.silencetao.service.about;

import com.silencetao.entity.History;
import java.util.List;

public abstract interface HistoryService {
	public abstract List<History> getHistories(int paramInt1, int paramInt2,
			String paramString);
}