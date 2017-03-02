package com.silencetao.service.about;

import com.silencetao.entity.History;
import java.util.List;

public interface HistoryService {
	
	/**
	 * 插入一条进程记录
	 * @param history
	 * @return 插入的条数
	 */
	public int insertHistory(History history);
	
	/**
	 * 获取给出区间和查询顺序(顺序或逆序)查找进程记录
	 * @return 返回要查询的进程记录
	 */
	public List<History> getHistories(int offset, int limit, String order);
}