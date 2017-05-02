package com.silencetao.controller.module;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.silencetao.entity.Comment;
import com.silencetao.entity.User;
import com.silencetao.service.module.CommentService;
import com.silencetao.utils.CookiesUtil;
import com.silencetao.view.CommentView;
import com.silencetao.view.Pages;
import com.silencetao.view.SilenceResult;

/**
 * 评论Controller层实现
 * @author Silence
 *
 */
@RequestMapping(value = "comment")
@Controller
public class CommentController {
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private CommentService commentService;

	/**
	 * 保存心路历程的一条评论
	 * @param visitorSign
	 * @param session
	 * @param response
	 * @param comment
	 * @param historyId
	 * @return
	 */
	@RequestMapping(value = "saveComment")
	@ResponseBody
	public SilenceResult<Map<String, Object>> saveComment(@CookieValue(value = "visitorSign", required = false) String visitorSign,
			HttpSession session, HttpServletResponse response, Comment comment) {
		User user = (User) session.getAttribute("userInfo");
		if(user != null) {
			comment.setUserSign(user.getUserSign());
			CookiesUtil.clearCookie(response, "visitorSign");
		} else if(visitorSign != null) {
			comment.setUserSign(visitorSign);
		} else {
			return new SilenceResult<Map<String, Object>>(false, 0, "未登录");
		}
		try {
			commentService.saveComment(comment);
			Pages pages = new Pages(1, 5);
			return new SilenceResult<Map<String,Object>>(true, queryComments(comment.getOwnerSign(), pages), "评论成功");
		} catch (Exception e) {
			log.warn("评论失败");
			log.error(e.getMessage(), e);
			return new SilenceResult<Map<String, Object>>(false, "评论失败");
		}
	}
	
	private Map<String, Object> queryComments(String ownerSign, Pages pages) {
		Map<String, Object> map = new HashMap<String, Object>();
		List<CommentView> commentViews = commentService.getComments(ownerSign, pages);
		pages.setTotalCount(commentService.getCommentNum(ownerSign));
		pages.setTotalPage(pages.getTotalCount() % pages.getPageSize() == 0 ? pages.getTotalCount() / pages.getPageSize() : pages.getTotalCount() / pages.getPageSize() + 1);
		map.put("comments", commentViews);
		map.put("pages", pages);
		return map;
	}
	
	/**
	 * 获取评论
	 * @param ownerSign
	 * @return
	 */
	@RequestMapping(value = "getComments")
	@ResponseBody
	public SilenceResult<Map<String, Object>> getComments(String ownerSign, Pages pages) {
		return new SilenceResult<Map<String,Object>>(true, queryComments(ownerSign, pages));
	}
}
