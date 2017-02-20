package com.silencetao.entity;

import java.io.Serializable;
import java.util.Date;

public class History implements Serializable {
	private static final long serialVersionUID = 5547123417053375305L;
	private long historyId;
	private String content;
	private String picturePath;
	private Date recordTime;

	public History() {
	}

	public History(String content, String picturePath) {
		this.content = content;
		this.picturePath = picturePath;
	}

	public long getHistoryId() {
		return this.historyId;
	}

	public void setHistoryId(long historyId) {
		this.historyId = historyId;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPicturePath() {
		return this.picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}

	public Date getRecordTime() {
		return this.recordTime;
	}

	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}

	public String toString() {
		return "History [historyId=" + this.historyId + ", content="
				+ this.content + ", picturePath=" + this.picturePath
				+ ", recordTime=" + this.recordTime + "]";
	}
}