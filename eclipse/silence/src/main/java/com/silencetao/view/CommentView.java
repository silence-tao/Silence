package com.silencetao.view;

import java.util.Date;
import java.util.List;

/**
 * 评论前端显示类
 * @author Silence
 *
 */
public class CommentView {
	private long commentId;//id
	private String content;//内容
	private Date commentTime;//评论时间
	private long fatherId;//如果是二级评论,fatherId为一级评论的id,否则为0
	private String nikename;//回复者或评论者昵称
	private String header;//回复者或评论者头像
	private String userSign;//回复者或评论者唯一标示
	private String name;//被回复者昵称
	private List<CommentView> replyList;
	
	public CommentView() {
		
	}

	public CommentView(long commentId, String content, Date commentTime, long fatherId, String nikename, String header,
			String userSign, String name, List<CommentView> replyList) {
		this.commentId = commentId;
		this.content = content;
		this.commentTime = commentTime;
		this.fatherId = fatherId;
		this.nikename = nikename;
		this.header = header;
		this.userSign = userSign;
		this.name = name;
		this.replyList = replyList;
	}



	public long getCommentId() {
		return commentId;
	}

	public void setCommentId(long commentId) {
		this.commentId = commentId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}

	public long getFatherId() {
		return fatherId;
	}

	public void setFatherId(long fatherId) {
		this.fatherId = fatherId;
	}

	public String getNikename() {
		return nikename;
	}

	public void setNikename(String nikename) {
		this.nikename = nikename;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getUserSign() {
		return userSign;
	}

	public void setUserSign(String userSign) {
		this.userSign = userSign;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CommentView> getReplyList() {
		return replyList;
	}

	public void setReplyList(List<CommentView> replyList) {
		this.replyList = replyList;
	}

	@Override
	public String toString() {
		return "CommentView [commentId=" + commentId + ", content=" + content + ", commentTime=" + commentTime
				+ ", fatherId=" + fatherId + ", nikename=" + nikename + ", header=" + header + ", userSign=" + userSign
				+ ", name=" + name + "]";
	}
}
