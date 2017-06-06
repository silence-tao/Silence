package com.silencetao.controller.opinion;

import java.util.HashMap;
import java.util.List;
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
			session.setAttribute("opinionSign", null);
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
	
	/**
	 * 获取分享生活主页数据
	 * @return
	 */
	@RequestMapping(value = "getOpinionHome")
	@ResponseBody
	public SilenceResult<List<EssayView>> getOpinionHome() {
		return new SilenceResult<List<EssayView>>(true, opinionService.getOpinionHome());
	}
	
	/**
	 * 设置是否在首页显示
	 * @param opinion
	 * @param essaySign
	 * @return
	 */
	@RequestMapping(value = "isHomeShow")
	@ResponseBody
	public SilenceResult<Null> isHomeShow(Opinion opinion, String essaySign) {
		opinion.setOpinionSign(essaySign);
		try {
			int result = opinionService.updateHomeShow(opinion);
			if(result > 0) {
				return new SilenceResult<Null>(true, "操作成功");
			} else {
				return new SilenceResult<Null>(false, "操作失败");
			}
		} catch (Exception e) {
			log.warn("操作失败");
			log.error(e.getMessage(), e);
			return new SilenceResult<Null>(false, "操作失败");
		}
	}
	
	/**
	 * 获取所有的分享生活,除了删除的
	 * @param pages
	 * @return
	 */
	@RequestMapping(value = "getAllOpinion")
	@ResponseBody
	public SilenceResult<Map<String, Object>> getAllOpinion(Pages pages) {
		Map<String, Object> map = new HashMap<String, Object>();
		pages.setTotalCount(opinionService.getAllOpinionNum());
		pages.setTotalPage(pages.getTotalCount() % pages.getPageSize() == 0 ? pages.getTotalCount() / pages.getPageSize() : pages.getTotalCount() / pages.getPageSize() + 1);
		map.put("pages", pages);
		List<EssayView> list = opinionService.getAllOpinion(pages);
		map.put("opinions", list);
		return new SilenceResult<Map<String,Object>>(true, map);
	}
	
	/**
	 * 删除一条分享生活,逻辑上的删除
	 * @param opinionId
	 * @return
	 */
	@RequestMapping(value = "deleteById")
	@ResponseBody
	public SilenceResult<Null> deleteById(String opinionId) {
		long id = Long.parseLong(opinionId);
		int result = opinionService.deleteById(id);
		if(result > 0) {
			return new SilenceResult<Null>(true, "删除成功");
		} else {
			return new SilenceResult<Null>(false, "删除失败");
		}
	}
	
	/**
	 * 根据opinionId获取一条分享生活
	 * @param opinionId
	 * @return
	 */
	@RequestMapping(value = "findOpinionById")
	@ResponseBody
	public SilenceResult<Opinion> findOpinionById(String opinionId) {
		long id = Long.parseLong(opinionId);
		return new SilenceResult<Opinion>(true, opinionService.findOpinionById(id));
	}
	
	/**
	 * 编辑分享生活信息
	 * @param opinion
	 * @return
	 */
	@RequestMapping(value = "editOpinion")
	@ResponseBody
	public SilenceResult<Null> editOpinion(Opinion opinion) {
		int result = opinionService.editOpinion(opinion);
		if(result > 0) {
			return new SilenceResult<Null>(true, "编辑成功");
		} else {
			return new SilenceResult<Null>(false, "编辑失败");
		}
	}
}