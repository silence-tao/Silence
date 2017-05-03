package com.silencetao.controller.module;

import java.util.List;

import org.apache.ibatis.jdbc.Null;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.silencetao.entity.Classify;
import com.silencetao.service.module.ClassifyService;
import com.silencetao.view.SilenceResult;

/**
 * 技术分享文章类别Controller层实现
 * @author Silence
 *
 */
@RequestMapping(value = "classify")
@Controller
public class ClassifyController {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private ClassifyService classifyService;
	
	/**
	 * 添加一个类别
	 * @param classify
	 * @return
	 */
	@RequestMapping(value = "saveClassify")
	@ResponseBody
	public SilenceResult<Null> saveClassify(Classify classify) {
		try {
			int result = classifyService.insertClassify(classify);
			if(result > 0) {
				return new SilenceResult<Null>(true, "保存成功");
			} else {
				return new SilenceResult<Null>(false, "保存失败");
			}
		} catch (Exception e) {
			log.warn("评论失败");
			log.error(e.getMessage(), e);
		}
		return new SilenceResult<Null>(false, "系统错误");
	}
	
	/**
	 * 获取所有类别
	 * @return
	 */
	@RequestMapping(value = "getClassifies")
	@ResponseBody
	public SilenceResult<List<Classify>> getClassifies() {
		return new SilenceResult<List<Classify>>(true, classifyService.getClassifies());
	}
}
