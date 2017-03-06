package com.silencetao.view;

import java.util.Date;
import java.util.List;

public class HistoryView {
	private String title;
	private String content;
	private String historySign;
	private Date recordTime;
	private List<String> pictures;
	
	public HistoryView() {
		
	}

	public HistoryView(String title, String content, String historySign,
			Date recordTime) {
		this.title = title;
		this.content = content;
		this.historySign = historySign;
		this.recordTime = recordTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
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
		return recordTime;
	}

	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}

	public List<String> getPictures() {
		return pictures;
	}

	public void setPictures(List<String> pictures) {
		this.pictures = pictures;
	}

	@Override
	public String toString() {
		return "HistoryView [title=" + title + ", content=" + content
				+ ", historySign=" + historySign + ", recordTime=" + recordTime
				+ ", pictures=" + pictures + "]";
	}
}
