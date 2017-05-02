package com.silencetao.service.module.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.silencetao.dao.module.CommentDao;
import com.silencetao.dao.module.StatisticDao;
import com.silencetao.entity.Comment;
import com.silencetao.exception.SilenceException;
import com.silencetao.service.module.CommentService;
import com.silencetao.view.CommentView;
import com.silencetao.view.Pages;

/**
 * 评论Service层接口实现
 * @author Silence
 *
 */
@Service
public class CommentServiceImpl implements CommentService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private CommentDao commentDao;
	
	@Autowired
	private StatisticDao statisticDao;

	@Transactional
	@Override
	public int saveComment(Comment comment) {
		int result = 0;
		try {
			result += commentDao.insertComment(comment);
			result += statisticDao.updateCommentNum(comment.getOwnerSign());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new SilenceException("系统错误,请重试");
		}
		return result;
	}

	@Override
	public List<CommentView> getComments(String ownerSign, Pages pages) {
		List<CommentView> commentViews = commentDao.getComments(ownerSign, (pages.getCurrentPage() - 1) * pages.getPageSize(), pages.getPageSize());
		for(int i = 0; i < commentViews.size(); i++) {
			commentViews.get(i).setReplyList(commentDao.getReplies(commentViews.get(i).getCommentId()));
		}
		return commentViews;
	}

	@Override
	public long getCommentNum(String ownerSign) {
		return commentDao.getCommentNum(ownerSign);
	}
}
