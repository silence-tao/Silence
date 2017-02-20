package com.silencetao.service.about;

import com.silencetao.entity.History;
import java.util.List;

public interface HistoryService {
	
	/**
	 * 获取给出区间和查询顺序(顺序或逆序)查找进程记录
	 * @return
	 */
	public List<History> getHistories(int offset, int limit, String order);
}