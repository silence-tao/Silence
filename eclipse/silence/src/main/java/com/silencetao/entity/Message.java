package com.silencetao.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 留言板实体类
 * @author Administrator
 *
 */
public class Message implements Serializable {
	private static final long serialVersionUID = -2409732689025315856L;
	private long messageId;
	private String content;
	private String messageSign;
	private String userSign;
	private Date messageTime;
	private long state;
	private long fatherId;
	
	public Message() {
		
	}

	public Message(String content, String messageSign, String userSign,
			long state) {
		this.content = content;
		this.messageSign = messageSign;
		this.userSign = userSign;
		this.state = state;
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

	@Override
	public String toString() {
		return "Message [messageId=" + messageId + ", content=" + content + ", messageSign=" + messageSign
				+ ", userSign=" + userSign + ", messageTime=" + messageTime + ", state=" + state + ", fatherId="
				+ fatherId + "]";
	}
}
