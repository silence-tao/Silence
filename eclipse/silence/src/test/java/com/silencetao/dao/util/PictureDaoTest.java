package com.silencetao.dao.util;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.silencetao.dao.module.PictureDao;
import com.silencetao.entity.Picture;

@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件的位置
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class PictureDaoTest {
	@Autowired
	private PictureDao pictureDao;

	@Test
	public void testInsertPicture() {
		Picture picture = new Picture("JFJOIJFEPOEMAFS8903448274", "/fsdefsdfsdwfs.jpg");
		int result = pictureDao.insertPicture(picture);
		System.out.println(result);
	}

	@Test
	public void testDeletePicture() {
		long id = 24L;
		int result = pictureDao.deletePicture(id);
		System.out.println(result);
	}

	@Test
	public void testUpdatePicture() {
		Picture picture = pictureDao.getPicture(25);
		System.out.println(picture);
		picture.setRealPath("fsjdfjisoj");
		int result = pictureDao.updatePicture(picture);
		System.out.println(result);
	}
	
	@Test
	public void testGetPictures() {
		List<Picture> pictures = pictureDao.getPictures(0, 3);
		for(Picture picture : pictures) {
			System.out.println(picture);
		}
	}
	
	@Test
	public void testGetPicturesDesc() {
		List<Picture> pictures = pictureDao.getPicturesDesc(0, 3);
		for(Picture picture : pictures) {
			System.out.println(picture);
		}
	}
	
	@Test
	public void testGetOnePictures() {
		List<Picture> pictures = pictureDao.getOnePictures("JFJOIJFEPOEMAFS8903448274");
		for(Picture picture : pictures) {
			System.out.println(picture);
		}
	}
}
