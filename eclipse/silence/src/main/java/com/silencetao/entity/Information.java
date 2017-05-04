package com.silencetao.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户基本信息实体类
 * @author Silence
 *
 */
public class Information implements Serializable {
	private static final long serialVersionUID = 2358585265389168050L;
	private long informationId;//id
	private String pertain;//属于哪个用户,用户的sign
	private String name;//真实姓名
	private long sex;//性别
	private Date birthday;//生日
	private String virtue;//擅长技能
	private String proverbs;//个性签名
	private long age;//年龄
	
	public Information() {
		
	}

	public Information(String pertain) {
		this.pertain = pertain;
	}

	public Information(long informationId, String pertain, String name,
			long sex, Date birthday, String virtue, String proverbs) {
		this.informationId = informationId;
		this.pertain = pertain;
		this.name = name;
		this.sex = sex;
		this.birthday = birthday;
		this.virtue = virtue;
		this.proverbs = proverbs;
	}

	public long getInformationId() {
		return informationId;
	}

	public void setInformationId(long informationId) {
		this.informationId = informationId;
	}

	public String getPertain() {
		return pertain;
	}

	public void setPertain(String pertain) {
		this.pertain = pertain;
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
		return "Information [informationId=" + informationId + ", pertain="
				+ pertain + ", name=" + name + ", sex=" + sex + ", birthday="
				+ birthday + ", virtue=" + virtue + ", proverbs=" + proverbs
				+ "]";
	}
}
