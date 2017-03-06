package com.silencetao.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class History implements Serializable {
	private static final long serialVersionUID = 5547123417053375305L;
	private long historyId;
	private String title;
	private String content;
	private String historySign;
	private Date recordTime;

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

	public String toString() {
		return "History [title=" + this.title + ",historyId=" + this.historyId + ", content="
				+ this.content + ", historySign=" + this.historySign
				+ ", recordTime=" + this.recordTime + "]";
	}
}