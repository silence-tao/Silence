package com.silencetao.entity;

import java.io.Serializable;

/**
 * 评论表
 * @author Silence
 *
 */
public class Comment implements Serializable {
	private static final long serialVersionUID = -6027723579948018524L;
	private long commentId;//id
	private String content;//内容
	private long fatherId;//如果是二级评论,fatherId为一级评论的id,否则为0
	private String userSign;//评论者
	private String ownerSign;//评论了什么
	private String commentTime;//评论时间
	private long state;//查看状态,0为未查看,1为已查看
	private String toSign;//给谁评论或回复谁
	
	public Comment() {
		
	}

	public Comment(String content, long fatherId, String userSign,
			String ownerSign, long state) {
		this.content = content;
		this.fatherId = fatherId;
		this.userSign = userSign;
		this.ownerSign = ownerSign;
		this.state = state;
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

	public long getFatherId() {
		return fatherId;
	}

	public void setFatherId(long fatherId) {
		this.fatherId = fatherId;
	}

	public String getUserSign() {
		return userSign;
	}

	public void setUserSign(String userSign) {
		this.userSign = userSign;
	}

	public String getOwnerSign() {
		return ownerSign;
	}

	public void setOwnerSign(String ownerSign) {
		this.ownerSign = ownerSign;
	}

	public String getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}

	public long getState() {
		return state;
	}

	public void setState(long state) {
		this.state = state;
	}

	public String getToSign() {
		return toSign;
	}

	public void setToSign(String toSign) {
		this.toSign = toSign;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", content=" + content + ", fatherId=" + fatherId + ", userSign="
				+ userSign + ", ownerSign=" + ownerSign + ", commentTime=" + commentTime + ", state=" + state
				+ ", toSign=" + toSign + "]";
	}
}
