package com.silencetao.service.about;

import com.silencetao.entity.History;
import com.silencetao.entity.Picture;
import com.silencetao.view.HistoryView;

import java.util.Date;
import java.util.List;

/**
 * 心路历程Service层
 * @author Silence
 *
 */
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
	
	/**
	 * 获取给出区间和查询顺序(顺序或逆序)查找进程记录(包括图片)
	 * @param offset
	 * @param limit
	 * @param order
	 * @return 返回要查询的进程记录
	 */
	public List<HistoryView> getHistoryViews(int offset, int limit) throws Exception;
	
	/**
	 * 保存一条心路历程信息,包括图片信息
	 * @param history
	 * @param pictures
	 * @return
	 */
	public List<HistoryView> saveHistory(History history, List<Picture> pictures);
}