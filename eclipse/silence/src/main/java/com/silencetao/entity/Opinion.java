package com.silencetao.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Silence
 *
 */
public class Opinion implements Serializable {
	private static final long serialVersionUID = -7495991786758344141L;
	private long opinionId;//id
	private String title;//标题
	private String content;//内容
	private String publisher;//发布者
	private String opinionSign;//唯一标示
	private Date publishTime;//发布时间
	private String summary;//文章简介
	
	public Opinion() {
		
	}

	public Opinion(String title, String content, String publisher,
			String opinionSign) {
		this.title = title;
		this.content = content;
		this.publisher = publisher;
		this.opinionSign = opinionSign;
	}

	public long getOpinionId() {
		return opinionId;
	}

	public void setOpinionId(long opinionId) {
		this.opinionId = opinionId;
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

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getOpinionSign() {
		return opinionSign;
	}

	public void setOpinionSign(String opinionSign) {
		this.opinionSign = opinionSign;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	@Override
	public String toString() {
		return "Opinion [opinionId=" + opinionId + ", title=" + title + ", content=" + content + ", publisher="
				+ publisher + ", opinionSign=" + opinionSign + ", publishTime=" + publishTime + ", summary=" + summary
				+ "]";
	}
}
