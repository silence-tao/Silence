package com.silencetao.service.module.impl;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.silencetao.entity.Picture;
import com.silencetao.service.module.PictureService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"classpath:spring/spring-dao.xml",
	"classpath:spring/spring-service.xml"
})
public class PictureServiceImplTest {
	@Autowired
	private PictureService pictureService;

	@Test
	public void testInsertPictures() {
		Picture picture = new Picture("JOIFJIOJFJLKJF4234", "fsdewf.jpg");
		int result = pictureService.insertPictures(picture);
		System.out.println(result);
	}

	@Test
	public void testGetPicture() {
		Picture picture = pictureService.getPicture(25);
		System.out.println(picture);
	}

	@Test
	public void testGetOnePictures() {
		List<Picture> pictures = pictureService.getOnePictures("JOIFJIOJFJLKJF4234");
		for(Picture picture : pictures) {
			System.out.println(picture);
		}
	}

}
