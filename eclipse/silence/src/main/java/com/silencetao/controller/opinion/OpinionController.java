package com.silencetao.controller.opinion;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.jdbc.Null;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.silencetao.entity.Opinion;
import com.silencetao.entity.User;
import com.silencetao.service.opinion.OpinionService;
import com.silencetao.utils.CookiesUtil;
import com.silencetao.view.SilenceResult;

/**
 * 分享生活Controller实现
 * @author Silence
 *
 */
@RequestMapping(value = "opinion")
@Controller
public class OpinionController {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private OpinionService opinionService;
	
	@RequestMapping(value = "saveOpinion")
	@ResponseBody
	public SilenceResult<Null> saveOpinion(Opinion opinion, HttpSession session) {
		User user = (User) session.getAttribute("userInfo");
		if(user != null) {
			opinion.setPublisher(user.getUserSign());
		} else {
			return new SilenceResult<Null>(false, 0, "未登录");
		}
		String opinionSign = (String) session.getAttribute("opinionSign");
		if(opinionSign != null) {
			opinion.setOpinionSign(opinionSign);
		} else {
			return new SilenceResult<Null>(false, 1, "opinionSign丢失");
		}
		try {
			opinionService.insertOpinion(opinion);
			return new SilenceResult<Null>(true, "保存成功");
		} catch (Exception e) {
			log.warn("保存失败");
			log.error(e.getMessage(), e);
			return new SilenceResult<Null>(false, 2, "保存失败");
		}
	}
}
