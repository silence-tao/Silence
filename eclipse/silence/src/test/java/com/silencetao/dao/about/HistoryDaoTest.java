package com.silencetao.dao.about;

import com.silencetao.entity.History;
import java.io.PrintStream;
import java.util.List;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring/spring-dao.xml" })
public class HistoryDaoTest {

	@Resource
	private HistoryDao historyDao;

	@Test
	public void testInsertHistory() throws Exception {
		History history = new History("eheh", "1fdsa233123", "path/img/fdsajjj");
		int result = this.historyDao.insertHistory(history);
		System.out.println(result);
	}

	@Test
	public void testDeleteHistory() throws Exception {
		long id = 3L;
		int result = this.historyDao.deleteHistory(id);
		System.out.println(result);
	}

	@Test
	public void testUpdateHistory() throws Exception {
		History history = new History("lalala" ,"fdsailfj", "jijfdsjo");
		history.setHistoryId(2L);
		int result = this.historyDao.updateHistory(history);
		System.out.println(result);
	}

	@Test
	public void testGetHistory() throws Exception {
		long id = 5L;
		History history = this.historyDao.getHistory(id);
		System.out.println(history);
	}

	@Test
	public void testGetHistories() throws Exception {
		List<History> histories = this.historyDao.getHistories(0, 10);
		for (History history : histories)
			System.out.println(history);
	}

	@Test
	public void testGetHistoriesDesc() throws Exception {
		List<History> histories = this.historyDao.getHistoriesDesc(0, 10);
		for (History history : histories)
			System.out.println(history);
	}
}