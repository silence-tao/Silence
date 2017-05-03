package com.silencetao.entity;

import java.io.Serializable;

/**
 * 技术分享文章类别
 * @author Silence
 *
 */
public class Classify implements Serializable {
	private static final long serialVersionUID = -2235645659881031145L;
	private long classifyId;
	private String classifyName;
	
	public Classify() {
		
	}

	public Classify(long classifyId, String classifyName) {
		this.classifyId = classifyId;
		this.classifyName = classifyName;
	}

	public long getClassifyId() {
		return classifyId;
	}

	public void setClassifyId(long classifyId) {
		this.classifyId = classifyId;
	}

	public String getClassifyName() {
		return classifyName;
	}

	public void setClassifyName(String classifyName) {
		this.classifyName = classifyName;
	}

	@Override
	public String toString() {
		return "Classify [classifyId=" + classifyId + ", classifyName=" + classifyName + "]";
	}
}
