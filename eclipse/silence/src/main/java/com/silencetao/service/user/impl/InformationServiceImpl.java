package com.silencetao.service.user.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.silencetao.dao.user.InformationDao;
import com.silencetao.entity.Information;
import com.silencetao.exception.SilenceException;
import com.silencetao.service.user.InformationService;

@Service
public class InformationServiceImpl implements InformationService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private InformationDao informationDao;

	@Transactional
	@Override
	public int insertInformation(Information information) {
		int result = 0;
		try {
			result = informationDao.insertInformation(information);
		} catch (Exception e) {
			log.warn("保存失败");
			log.error(e.getMessage(), e);
		}
		return result;
	}

	@Override
	public Information getInformationByPertain(String pertain) {
		return informationDao.getInformationByPertain(pertain);
	}

	@Transactional
	@Override
	public int updateInformation(Information information) {
		int result = 0;
		try {
			result = informationDao.updateInformation(information);
		} catch (Exception e) {
			log.warn("修改失败");
			log.error(e.getMessage(), e);
		}
		return result;
	}

}
