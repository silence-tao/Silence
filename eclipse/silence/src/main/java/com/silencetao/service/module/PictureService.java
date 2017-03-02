package com.silencetao.service.module;

import java.util.List;

import com.silencetao.entity.Picture;

public interface PictureService {
 
	/**
	 * 插入一条图片上传记录
	 * @param pictures
	 * @return 返回插入的条数
	 */
	public int insertPicture(Picture picture);
	
	/**
	 * 根据id查询一条图片上传记录
	 * @param id
	 * @return 返回给出id的图片上传记录
	 */
	public Picture getPicture(long id);
	
	/**
	 * 根据所属查询该所属所有的图片上传记录
	 * @param pertain
	 * @return 返回该所属所有的图片上传记录
	 */
	public List<Picture> getOnePictures(String pertain);
}
