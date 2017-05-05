package com.silencetao.view;

import java.util.Date;

/**
 * 用户信息前端显示类
 * @author Silence
 *
 */
public class UserView {
	private long userId;
	private String username;
	private String nikename;
	private String registerIp;
	private Date registerTime;
	private long userRank;
	private String userSign;
	private String header;
	private String name;//真实姓名
	private long sex;//性别
	private Date birthday;//生日
	private String virtue;//擅长技能
	private String proverbs;//个性签名
	private long age;//年龄
	
	public UserView() {
		
	}

	public UserView(long userId, String username, String nikename,
			String registerIp, Date registerTime, long userRank,
			String userSign, String header, String name, long sex,
			Date birthday, String virtue, String proverbs, long age) {
		this.userId = userId;
		this.username = username;
		this.nikename = nikename;
		this.registerIp = registerIp;
		this.registerTime = registerTime;
		this.userRank = userRank;
		this.userSign = userSign;
		this.header = header;
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.virtue = virtue;
		this.proverbs = proverbs;
		this.age = age;
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

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getSex() {
		return sex;
	}

	public void setSex(long sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getVirtue() {
		return virtue;
	}

	public void setVirtue(String virtue) {
		this.virtue = virtue;
	}

	public String getProverbs() {
		return proverbs;
	}

	public void setProverbs(String proverbs) {
		this.proverbs = proverbs;
	}

	public long getAge() {
		return age;
	}

	public void setAge(long age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "UserView [userId=" + userId + ", username=" + username
				+ ", nikename=" + nikename + ", registerIp=" + registerIp
				+ ", registerTime=" + registerTime + ", userRank=" + userRank
				+ ", userSign=" + userSign + ", header=" + header + ", name="
				+ name + ", sex=" + sex + ", birthday=" + birthday
				+ ", virtue=" + virtue + ", proverbs=" + proverbs + ", age="
				+ age + "]";
	}
}
