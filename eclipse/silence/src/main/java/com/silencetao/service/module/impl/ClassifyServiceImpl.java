package com.silencetao.service.module.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.silencetao.dao.module.ClassifyDao;
import com.silencetao.entity.Classify;
import com.silencetao.service.module.ClassifyService;

/**
 * 技术分享文章类别Service层接口实现
 * @author Silence
 *
 */
@Service
public class ClassifyServiceImpl implements ClassifyService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ClassifyDao classifyDao;

	@Transactional
	@Override
	public int insertClassify(Classify classify) {
		int result = 0;
		try {
			result = classifyDao.insertClassify(classify);
		} catch (Exception e) {
			log.warn("保存失败");
			log.error(e.getMessage(), e);
		}
		return result;
	}

	@Override
	public List<Classify> getClassifies() {
		return classifyDao.getClassifies();
	}

}
