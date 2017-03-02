package com.silencetao.service.module.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.silencetao.dao.module.PictureDao;
import com.silencetao.entity.Picture;
import com.silencetao.service.module.PictureService;

@Service
public class PictureServiceImpl implements PictureService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private PictureDao pictureDao;

	@Transactional
	@Override
	public int insertPicture(Picture picture) {
		log.info("开始保存图片信息");
		int result = 0;
		try {
			result = pictureDao.insertPicture(picture);
			log.info("保存图片信息成功");
		} catch (Exception e) {
			log.warn("保存图片信息失败");
			log.error(e.getMessage(), e);
		}
		return result;
	}

	@Override
	public Picture getPicture(long id) {
		log.info("查询id为" + id + "的图片信息");
		return pictureDao.getPicture(id);
	}

	@Override
	public List<Picture> getOnePictures(String pertain) {
		log.info("查询pertain为" + pertain + "的图片信息");
		return pictureDao.getOnePictures(pertain);
	}
}
