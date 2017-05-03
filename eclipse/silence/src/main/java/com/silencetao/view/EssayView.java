package com.silencetao.view;

import java.util.Date;

/**
 * 分享生活前端数据显示类
 * @author Silence
 *
 */
public class EssayView {
	private long essayId;//id
	private String title;//标题
	private String content;//内容
	private String nikename;//发布者
	private String essaySign;//唯一标示
	private Date publishTime;//发布时间
	private String cover;//封面图片
	private long commentNum;//评论数
	private long visitorNum;//浏览量
	private long praiseNum;//点赞数
	private String summary;//文章简介
	private long auditStatus;//审核状态
	private long homeShow;//是否在首页显示
	private String classify;//类别
	private String header;//用户头像
	
	public EssayView() {
		
	}

	public EssayView(long essayId, String title, String content,
			String nikename, String essaySign, Date publishTime, String cover,
			long commentNum, long visitorNum, long praiseNum, String summary) {
		this.essayId = essayId;
		this.title = title;
		this.content = content;
		this.nikename = nikename;
		this.essaySign = essaySign;
		this.publishTime = publishTime;
		this.cover = cover;
		this.commentNum = commentNum;
		this.visitorNum = visitorNum;
		this.praiseNum = praiseNum;
		this.summary = summary;
	}

	public long getEssayId() {
		return essayId;
	}

	public void setEssayId(long essayId) {
		this.essayId = essayId;
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

	public String getNikename() {
		return nikename;
	}

	public void setNikename(String nikename) {
		this.nikename = nikename;
	}

	public String getEssaySign() {
		return essaySign;
	}

	public void setEssaySign(String essaySign) {
		this.essaySign = essaySign;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public long getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(long commentNum) {
		this.commentNum = commentNum;
	}

	public long getVisitorNum() {
		return visitorNum;
	}

	public void setVisitorNum(long visitorNum) {
		this.visitorNum = visitorNum;
	}

	public long getPraiseNum() {
		return praiseNum;
	}

	public void setPraiseNum(long praiseNum) {
		this.praiseNum = praiseNum;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
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

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	@Override
	public String toString() {
		return "EssayView [essayId=" + essayId + ", title=" + title
				+ ", content=" + content + ", nikename=" + nikename
				+ ", essaySign=" + essaySign + ", publishTime=" + publishTime
				+ ", cover=" + cover + ", commentNum=" + commentNum
				+ ", visitorNum=" + visitorNum + ", praiseNum=" + praiseNum
				+ ", summary=" + summary + ", auditStatus=" + auditStatus
				+ ", homeShow=" + homeShow + ", classify=" + classify + "]";
	}
}
