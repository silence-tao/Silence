package com.silencetao.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 心路历程实体类
 * @author Silence
 *
 */
public class History implements Serializable {
	private static final long serialVersionUID = 5547123417053375305L;
	private long historyId;
	private String title;
	private String content;
	private String historySign;
	private Date recordTime;
	private long visitorNum;
	private long commentNum;
	private long praiseNum;
	private long homeShow;//是否在首页显示

	public History() {
		
	}

	public History(String content, String historySign) {
		this.content = content;
		this.historySign = historySign;
	}

	public History(String title, String content, String historySign) {
		this.title = title;
		this.content = content;
		this.historySign = historySign;
	}

	public long getHistoryId() {
		return this.historyId;
	}

	public void setHistoryId(long historyId) {
		this.historyId = historyId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getHistorySign() {
		return historySign;
	}

	public void setHistorySign(String historySign) {
		this.historySign = historySign;
	}

	public Date getRecordTime() {
		return this.recordTime;
	}

	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}

	public long getVisitorNum() {
		return visitorNum;
	}

	public void setVisitorNum(long visitorNum) {
		this.visitorNum = visitorNum;
	}

	public long getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(long commentNum) {
		this.commentNum = commentNum;
	}

	public long getPraiseNum() {
		return praiseNum;
	}

	public void setPraiseNum(long praiseNum) {
		this.praiseNum = praiseNum;
	}

	public long getHomeShow() {
		return homeShow;
	}

	public void setHomeShow(long homeShow) {
		this.homeShow = homeShow;
	}

	@Override
	public String toString() {
		return "History [historyId=" + historyId + ", title=" + title
				+ ", content=" + content + ", historySign=" + historySign
				+ ", recordTime=" + recordTime + ", visitorNum=" + visitorNum
				+ ", commentNum=" + commentNum + ", praiseNum=" + praiseNum
				+ "]";
	}
}