package com.silencetao.view;

import java.util.Date;
import java.util.List;

/**
 * 留言前端显示类
 * @author Silence
 *
 */
public class MessageView {
	private long messageId;
	private String content;
	private String messageSign;
	private String userSign;
	private Date messageTime;
	private long state;
	private long fatherId;
	private long userId;
	private String username;
	private String nikename;
	private long userRank;
	private String header;
	private List<MessageView> replyList;
	private boolean permitReply;
	
	public MessageView() {
		
	}

	public MessageView(long messageId, String content, String messageSign, String userSign, Date messageTime,
			long state, long fatherId, long userId, String username, String nikename, long userRank, String header) {
		this.messageId = messageId;
		this.content = content;
		this.messageSign = messageSign;
		this.userSign = userSign;
		this.messageTime = messageTime;
		this.state = state;
		this.fatherId = fatherId;
		this.userId = userId;
		this.username = username;
		this.nikename = nikename;
		this.userRank = userRank;
		this.header = header;
	}

	public long getMessageId() {
		return messageId;
	}

	public void setMessageId(long messageId) {
		this.messageId = messageId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMessageSign() {
		return messageSign;
	}

	public void setMessageSign(String messageSign) {
		this.messageSign = messageSign;
	}

	public String getUserSign() {
		return userSign;
	}

	public void setUserSign(String userSign) {
		this.userSign = userSign;
	}

	public Date getMessageTime() {
		return messageTime;
	}

	public void setMessageTime(Date messageTime) {
		this.messageTime = messageTime;
	}

	public long getState() {
		return state;
	}

	public void setState(long state) {
		this.state = state;
	}

	public long getFatherId() {
		return fatherId;
	}

	public void setFatherId(long fatherId) {
		this.fatherId = fatherId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNikename() {
		return nikename;
	}

	public void setNikename(String nikename) {
		this.nikename = nikename;
	}

	public long getUserRank() {
		return userRank;
	}

	public void setUserRank(long userRank) {
		this.userRank = userRank;
	}

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public List<MessageView> getReplyList() {
		return replyList;
	}

	public void setReplyList(List<MessageView> replyList) {
		this.replyList = replyList;
	}

	public boolean isPermitReply() {
		return permitReply;
	}

	public void setPermitReply(boolean permitReply) {
		this.permitReply = permitReply;
	}

	@Override
	public String toString() {
		return "MessageView [messageId=" + messageId + ", content=" + content + ", messageSign=" + messageSign
				+ ", userSign=" + userSign + ", messageTime=" + messageTime + ", state=" + state + ", fatherId="
				+ fatherId + ", userId=" + userId + ", username=" + username + ", nikename=" + nikename + ", userRank="
				+ userRank + ", header=" + header + ", replyList=" + replyList + ", permitReply=" + permitReply + "]";
	}
}
