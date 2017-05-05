package com.silencetao.controller.module;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.silencetao.service.module.EssayService;
import com.silencetao.view.EssayView;
import com.silencetao.view.Pages;
import com.silencetao.view.SilenceResult;

/**
 * 文章排行榜Controller层实现
 * @author Silence
 *
 */
@RequestMapping(value = "essay")
@Controller
public class EssayController {
	
	@Autowired
	private EssayService essayService;

	/**
	 * 获取最新文章和点击量最高的文章
	 * @return
	 */
	@RequestMapping(value = "getEssay")
	@ResponseBody
	public SilenceResult<Map<String, Object>> getEssay() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("newEssay", essayService.getNewEssay());
		map.put("hotEssay", essayService.getHotEssay());
		return new SilenceResult<Map<String,Object>>(true, map);
	}
	
	@RequestMapping(value = "{action}", method = RequestMethod.GET)
	public String to(@PathVariable(value = "action") String action) {
		return "essay/" + action;
	}
	
	/**
	 * 获取所有文章
	 * @param pages
	 * @return
	 */
	@RequestMapping(value = "getAllEssay")
	@ResponseBody
	public SilenceResult<Map<String, Object>> getAllEssay(Pages pages) {
		Map<String, Object> map = new HashMap<String, Object>();
		pages.setTotalCount(essayService.getEssayNum());
		pages.setTotalPage(pages.getTotalCount() % pages.getPageSize() == 0 ? pages.getTotalCount() / pages.getPageSize() : pages.getTotalCount() / pages.getPageSize() + 1);
		List<EssayView> essayViews = essayService.getEssays(pages);
		map.put("essays", essayViews);
		map.put("pages", pages);
		return new SilenceResult<Map<String, Object>>(true, map);
	}
}
