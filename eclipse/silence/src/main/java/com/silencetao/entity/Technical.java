package com.silencetao.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 技术文章分享实体类
 * @author Silence
 *
 */
public class Technical implements Serializable {
	private static final long serialVersionUID = 7350304377897979464L;
	private long technicalId;//id
	private String title;//标题
	private String content;//内容
	private String publisher;//发布者
	private String technicalSign;//唯一表示
	private Date publishTime;//发布时间
	private long auditStatus;//审核状态
	private long homeShow;//是否在首页显示
	private String classify;//类别
	private String summary;//文章简介
	
	public Technical() {
		
	}

	public Technical(String title, String content, String publisher, String technicalSign) {
		this.title = title;
		this.content = content;
		this.publisher = publisher;
		this.technicalSign = technicalSign;
	}

	public long getTechnicalId() {
		return technicalId;
	}

	public void setTechnicalId(long technicalId) {
		this.technicalId = technicalId;
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

	public String getTechnicalSign() {
		return technicalSign;
	}

	public void setTechnicalSign(String technicalSign) {
		this.technicalSign = technicalSign;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public long getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(long auditStatus) {
		this.auditStatus = auditStatus;
	}

	public long getHomeShow() {
		return homeShow;
	}

	public void setHomeShow(long homeShow) {
		this.homeShow = homeShow;
	}

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	@Override
	public String toString() {
		return "Technical [technicalId=" + technicalId + ", title=" + title
				+ ", content=" + content + ", publisher=" + publisher
				+ ", technicalSign=" + technicalSign + ", publishTime="
				+ publishTime + ", auditStatus=" + auditStatus + ", homeShow="
				+ homeShow + ", classify=" + classify + ", summary=" + summary
				+ "]";
	}
}
