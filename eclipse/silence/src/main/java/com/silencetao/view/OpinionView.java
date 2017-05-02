package com.silencetao.view;

import java.util.Date;

/**
 * 分享生活前端数据显示类
 * @author Silence
 *
 */
public class OpinionView {
	private long opinionId;//id
	private String title;//标题
	private String content;//内容
	private String nikename;//发布者
	private String opinionSign;//唯一标示
	private Date publishTime;//发布时间
	private String cover;//封面图片

	public OpinionView() {
		
	}

	public OpinionView(long opinionId, String title, String content,
			String nikename, String opinionSign, Date publishTime, String cover) {
		this.opinionId = opinionId;
		this.title = title;
		this.content = content;
		this.nikename = nikename;
		this.opinionSign = opinionSign;
		this.publishTime = publishTime;
		this.cover = cover;
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

	public String getNikename() {
		return nikename;
	}

	public void setNikename(String nikename) {
		this.nikename = nikename;
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

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	@Override
	public String toString() {
		return "OpinionView [opinionId=" + opinionId + ", title=" + title
				+ ", content=" + content + ", nikename=" + nikename
				+ ", opinionSign=" + opinionSign + ", publishTime="
				+ publishTime + ", cover=" + cover + "]";
	}
}
