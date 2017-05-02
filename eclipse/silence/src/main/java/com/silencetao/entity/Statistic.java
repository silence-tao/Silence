package com.silencetao.entity;

/**
 * 数据统计实体类
 * @author Silence
 *
 */
public class Statistic {
	private long statisticId;//统计数据id
	private long commentNum;//评论数
	private long visitorNum;//浏览量
	private long praiseNum;//点赞数
	private String pertain;//所属
	
	public Statistic() {
		
	}

	public Statistic(String pertain) {
		this.pertain = pertain;
	}

	public Statistic(long statisticId, long commentNum, long visitorNum, long praiseNum, String pertain) {
		this.statisticId = statisticId;
		this.commentNum = commentNum;
		this.visitorNum = visitorNum;
		this.praiseNum = praiseNum;
		this.pertain = pertain;
	}

	public long getStatisticId() {
		return statisticId;
	}

	public void setStatisticId(long statisticId) {
		this.statisticId = statisticId;
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

	public String getPertain() {
		return pertain;
	}

	public void setPertain(String pertain) {
		this.pertain = pertain;
	}

	@Override
	public String toString() {
		return "Statistic [statisticId=" + statisticId + ", commentNum=" + commentNum + ", visitorNum=" + visitorNum
				+ ", praiseNum=" + praiseNum + ", pertain=" + pertain + "]";
	}
}
