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
		History history = new History("建立前端Web项目" ,"开始总是那么的艰难，尽管如此，还是要去做的。给自己无数的心里暗示，一定要把这件事情做好，是时候证明一下自己了。", "/14093320980.jpg");
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
		History history = new History("建立前端Web项目" ,"开始总是那么的艰难，尽管如此，还是要去做的。给自己无数的心里暗示，一定要把这件事情做好，是时候证明一下自己了。", "/140fdsa93320980.jpg");
		history.setHistoryId(24);
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