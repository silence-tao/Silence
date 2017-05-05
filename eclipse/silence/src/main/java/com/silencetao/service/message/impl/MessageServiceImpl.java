package com.silencetao.service.message.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.silencetao.dao.message.MessageDao;
import com.silencetao.entity.Message;
import com.silencetao.service.message.MessageService;
import com.silencetao.view.MessageView;

/**
 * 留言模块Service接口实现
 * @author Silence
 *
 */
@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageDao messageDao;
	
	@Transactional
	@Override
	public int insertMessage(Message message) {
		return messageDao.insertMessage(message);
	}

	@Override
	public List<MessageView> getMessages(long offset, long limit) {
		return messageDao.getMessages(offset, limit);
	}

	@Override
	public long getMessageNum() {
		return messageDao.getMessageNum();
	}

	@Override
	public List<MessageView> getReplies(long fatherId) {
		return messageDao.getReplies(fatherId);
	}

	@Override
	public List<MessageView> getMessageHome() {
		return messageDao.getMessageHome();
	}

	@Transactional
	@Override
	public int updateHomeShow(Message message) {
		return messageDao.updateHomeShow(message);
	}

}
