package com.silencetao.controller.technical;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.jdbc.Null;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.silencetao.entity.Technical;
import com.silencetao.entity.User;
import com.silencetao.service.technical.TechnicalService;
import com.silencetao.view.SilenceResult;

/**
 * 技术分享Controller层实现
 * @author Silence
 *
 */
@RequestMapping(value = "technical")
@Controller
public class TechnicalController {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private TechnicalService technicalService;
	
	@RequestMapping(value = "saveTechnical")
	@ResponseBody
	public SilenceResult<Null> saveTechnical(Technical technical, HttpSession session) {
		User user = (User) session.getAttribute("userInfo");
		if(user != null) {
			technical.setPublisher(user.getUserSign());
		} else {
			return new SilenceResult<Null>(false, 0, "未登录");
		}
		String technicalSign = (String) session.getAttribute("technicalSign");
		if(technicalSign != null) {
			technical.setTechnicalSign(technicalSign);
		} else {
			return new SilenceResult<Null>(false, 1, "technicalSign丢失");
		}
		try {
			technicalService.insertTechnical(technical);
			return new SilenceResult<Null>(true, "保存成功");
		} catch (Exception e) {
			log.warn("保存失败");
			log.error(e.getMessage(), e);
			return new SilenceResult<Null>(false, 2, "保存失败");
		}
	}
}
