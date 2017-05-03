package com.silencetao.controller.technical;

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

import com.silencetao.entity.Technical;
import com.silencetao.entity.User;
import com.silencetao.service.technical.TechnicalService;
import com.silencetao.view.EssayView;
import com.silencetao.view.Pages;
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
	
	/**
	 * 保存一条技术分享
	 * @param technical
	 * @param session
	 * @return
	 */
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
	
	/**
	 * 获取技术分享
	 * @param pages
	 * @return
	 */
	@RequestMapping(value = "getTechnicals")
	@ResponseBody
	public SilenceResult<Map<String, Object>> getTechnicals(Pages pages) {
		Map<String, Object> map = new HashMap<String, Object>();
		pages.setTotalCount(technicalService.getTechnicalNum());
		pages.setTotalPage(pages.getTotalCount() % pages.getPageSize() == 0 ? pages.getTotalCount() / pages.getPageSize() : pages.getTotalCount() / pages.getPageSize() + 1);
		map.put("pages", pages);
		map.put("technicals", technicalService.getTechnicals(pages));
		return new SilenceResult<Map<String,Object>>(true, map);
	}
	
	@RequestMapping(value = "detail/{technicalId}")
	public String getTechnicalById(@PathVariable(value = "technicalId") long technicalId,
			HttpServletRequest request) {
		EssayView technicalView = technicalService.getTechnicalById(technicalId);
		if(technicalView != null) {
			request.setAttribute("technicalView", technicalView);
			Map<String, EssayView> map = technicalService.getTechnicalBorder(technicalId);
			request.setAttribute("front", map.get("front"));
			request.setAttribute("after", map.get("after"));
			return "/technical/detail";
		}
		return "redirect:/technical";
	}
}
