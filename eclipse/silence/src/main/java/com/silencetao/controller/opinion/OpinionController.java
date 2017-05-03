package com.silencetao.controller.opinion;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.jdbc.Null;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.silencetao.entity.Opinion;
import com.silencetao.entity.User;
import com.silencetao.service.opinion.OpinionService;
import com.silencetao.utils.CookiesUtil;
import com.silencetao.view.EssayView;
import com.silencetao.view.Pages;
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
	
	/**
	 * 保存一条分享生活
	 * @param opinion
	 * @param session
	 * @return
	 */
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
	
	/**
	 * 获取分享生活
	 * @param pages
	 * @return
	 */
	@RequestMapping(value = "getOpinions")
	@ResponseBody
	public SilenceResult<Map<String, Object>> getOpinions(Pages pages) {
		Map<String, Object> map = new HashMap<String, Object>();
		pages.setTotalCount(opinionService.getOpinionNum());
		pages.setTotalPage(pages.getTotalCount() % pages.getPageSize() == 0 ? pages.getTotalCount() / pages.getPageSize() : pages.getTotalCount() / pages.getPageSize() + 1);
		map.put("pages", pages);
		map.put("opinions", opinionService.getOpinions(pages));
		return new SilenceResult<Map<String,Object>>(true, map);
	}
	
	@RequestMapping(value = "detail/{opinionId}")
	public String showOpinion(@PathVariable(value = "opinionId") long opinionId, HttpServletRequest request) {
		EssayView opinionView = opinionService.getOpinionById(opinionId);
		if(opinionView != null) {
			request.setAttribute("opinionView", opinionView);
			Map<String, EssayView> map = opinionService.getOpinionBorder(opinionId);
			request.setAttribute("front", map.get("front"));
			request.setAttribute("after", map.get("after"));
			return "/opinion/detail";
		}
		return "redirect:/opinion";
	}
}
