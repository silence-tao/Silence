package com.silencetao.dao.about;

import com.silencetao.entity.History;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HistoryDao {
	public int insertHistory(History history);

	public int deleteHistory(long id);

	public int updateHistory(History history);

	public History getHistory(long id);

	public List<History> getHistories(@Param("offset") int offset,
			@Param("limit") int limit);

	public List<History> getHistoriesDesc(
			@Param("offset") int offset, @Param("limit") int limit);
}