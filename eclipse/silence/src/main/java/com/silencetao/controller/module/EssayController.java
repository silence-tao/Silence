package com.silencetao.controller.module;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.silencetao.service.module.EssayService;
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
}
