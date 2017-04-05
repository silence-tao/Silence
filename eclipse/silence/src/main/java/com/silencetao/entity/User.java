package com.silencetao.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息实体类
 * @author Silence
 *
 */
public class User implements Serializable {
	private static final long serialVersionUID = -1288875721589701874L;
	private long userId;
	private String username;
	private String nikename;
	private String password;
	private String registerIp;
	private Date registerTime;
	private long userRank;
	private String userSign;
	
	public User() {
		
	}

	public User(String username, String nikename, String registerIp, String userSign) {
		this.username = username;
		this.nikename = nikename;
		this.registerIp = registerIp;
		this.userSign = userSign;
	}

	public User(String username, String nikename, String password, String registerIp,
			String userSign) {
		this.username = username;
		this.nikename = nikename;
		this.password = password;
		this.registerIp = registerIp;
		this.userSign = userSign;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNikename() {
		return nikename;
	}

	public void setNikename(String nikename) {
		this.nikename = nikename;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRegisterIp() {
		return registerIp;
	}

	public void setRegisterIp(String registerIp) {
		this.registerIp = registerIp;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public long getUserRank() {
		return userRank;
	}

	public void setUserRank(long userRank) {
		this.userRank = userRank;
	}

	public String getUserSign() {
		return userSign;
	}

	public void setUserSign(String userSign) {
		this.userSign = userSign;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username
				+ ", nikename=" + nikename + ", password=" + password
				+ ", registerIp=" + registerIp + ", registerTime="
				+ registerTime + ", userRank=" + userRank + ", userSign="
				+ userSign + "]";
	}
}
