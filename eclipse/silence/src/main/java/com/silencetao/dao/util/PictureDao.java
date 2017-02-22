package com.silencetao.dao.util;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.silencetao.entity.Picture;

public interface PictureDao {

	/**
	 * 添加一条图片上传的记录
	 * @param picture
	 * @return 表示添加的记录的行数
	 */
	public int insertPicture(Picture picture);
	
	/**
	 * 删除一条图片上传记录
	 * @param id
	 * @return 表示删除的记录的行数
	 */
	public int deletePicture(long id);
	
	/**
	 * 修改某条图片上传记录
	 * @param picture
	 * @return 表示修改的记录的行数
	 */
	public int updatePicture(Picture picture);
	
	/**
	 * 按id查找一条图片上传记录
	 * @param id
	 * @return
	 */
	public Picture getPicture(long id);
	
	/**
	 * 根据给出区间按时间顺序查找图片上传记录
	 * @param offset
	 * @param limit
	 * @return 按时间顺序返回区间内的多条图片上传记录
	 */
	public List<Picture> getPictures(@Param("offset") int offset, @Param("limit") int limit);
	
	/**
	 * 根据给出区间按时间逆序查找图片上传记录
	 * @param offset
	 * @param limit
	 * @return 按时间逆序返回区间内的多条图片上传记录
	 */
	public List<Picture> getPicturesDesc(@Param("offset") int offset, @Param("limit") int limit);
	
	/**
	 * 根据所属查找所有的图片上传记录
	 * @param pertain
	 * @return 根据所属返回所有的图片上传记录
	 */
	public List<Picture> getOnePictures(String pertain);
}
