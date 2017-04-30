package com.silencetao.dao.module;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.silencetao.entity.Comment;
import com.silencetao.view.CommentView;

/**
 * 评论模块Dao层接口
 * @author Silence
 *
 */
public interface CommentDao {

	/**
	 * 添加一条评论信息
	 * @param comment
	 * @return 返回添加评论的数量
	 */
	public int insertComment(Comment comment);
	
	/**
	 * 获取相应的评论
	 * @param ownerSign
	 * @return
	 */
	public List<CommentView> getComments(@Param("ownerSign") String ownerSign, @Param("offset") long offset, @Param("limit") long limit);
	
	/**
	 * 获取评论相应的回复
	 * @param fatherId
	 * @return
	 */
	public List<CommentView> getReplies(long fatherId);
	
	/**
	 * 获取评论条数
	 * @param ownerSign
	 * @return
	 */
	public long getCommentNum(String ownerSign);
}
