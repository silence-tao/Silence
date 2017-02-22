package com.silencetao.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Picture implements Serializable {
	private static final long serialVersionUID = -3381937488143456168L;
	private long pictureId;
	private String pertain;
	private String realPath;
	@DateTimeFormat(pattern="yyyy年MM月dd日 HH:mm:ss")  
	@JsonFormat(pattern="yyyy年MM月dd日 HH:mm:ss",timezone = "GMT+8")
	private Date uploadTime;
	
	public Picture() {
		
	}

	public Picture(String pertain, String realPath) {
		this.pertain = pertain;
		this.realPath = realPath;
	}

	public long getPictureId() {
		return pictureId;
	}

	public void setPictureId(long pictureId) {
		this.pictureId = pictureId;
	}

	public String getPertain() {
		return pertain;
	}

	public void setPertain(String pertain) {
		this.pertain = pertain;
	}

	public String getRealPath() {
		return realPath;
	}

	public void setRealPath(String realPath) {
		this.realPath = realPath;
	}

	public Date getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}

	@Override
	public String toString() {
		return "Pictures [pictureId=" + pictureId + ", pertain=" + pertain
				+ ", realPath=" + realPath + ", uploadTime=" + uploadTime + "]";
	}
}
