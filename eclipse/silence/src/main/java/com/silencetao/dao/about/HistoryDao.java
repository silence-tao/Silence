package com.silencetao.dao.about;

import com.silencetao.entity.History;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface HistoryDao {
	
	/**
	 * 添加一条项目进程记录
	 * @param history
	 * @return 表示添加的记录的行数
	 */
	public int insertHistory(History history);
	
	/**
	 * 删除一条项目进程记录
	 * @param id
	 * @return 表示删除的记录的行数
	 */
	public int deleteHistory(long id);
	
	/**
	 * 修改某条进程记录
	 * @param history
	 * @return 表示修改的记录的行数
	 */
	public int updateHistory(History history);
	
	/**
	 * 按id查找一条进程记录
	 * @param id
	 * @return 返回一条进程记录
	 */
	public History getHistory(long id);
	
	/**
	 * 根据给出区间查找进程记录
	 * @param offset
	 * @param limit
	 * @return 返回区间内的多条进程记录
	 */
	public List<History> getHistories(@Param("offset") int offset, @Param("limit") int limit);
	
	/**
	 * 根据给出区间按时间逆序查找进程记录
	 * @param offset
	 * @param limit
	 * @return 按时间逆序返回区间内的多条进程记录
	 */
	public List<History> getHistoriesDesc(@Param("offset") int offset, @Param("limit") int limit);
	
	/**
	 * 获取10条最新的进程记录,并逆序返回
	 * @param currentDate
	 * @return 逆序返回10条最新的进程记录
	 */
	public List<History> getNewHistoryDesc(Date currentDate);
	
	/**
	 * 心路历程浏览量加1
	 * @param historyId
	 * @return
	 */
	public int updateVisitorNum(long historyId);
	
	/**
	 * 心路历程评论量加1
	 * @param histroyId
	 * @return
	 */
	public int updateCommentNum(long historyId);
}