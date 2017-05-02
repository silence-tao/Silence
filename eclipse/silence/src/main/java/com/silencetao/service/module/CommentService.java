package com.silencetao.service.module;

import java.util.List;

import com.silencetao.entity.Comment;
import com.silencetao.view.CommentView;
import com.silencetao.view.Pages;

/**
 * 评论Service层接口
 * @author Silence
 *
 */
public interface CommentService {
	
	/**
	 * 保存一条评论
	 * @param comment
	 * @param historyId
	 * @return
	 */
	public int saveComment(Comment comment);
	
	/**
	 * 获取评论
	 * @param ownerSign
	 * @return
	 */
	public List<CommentView> getComments(String ownerSign, Pages pages);
	
	/**
	 * 获取评论条数
	 * @param ownerSign
	 * @return
	 */
	public long getCommentNum(String ownerSign);
}
