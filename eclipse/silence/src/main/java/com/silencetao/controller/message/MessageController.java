package com.silencetao.controller.message;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.jdbc.Null;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.silencetao.entity.Message;
import com.silencetao.entity.User;
import com.silencetao.service.message.MessageService;
import com.silencetao.utils.CookiesUtil;
import com.silencetao.utils.StringUtil;
import com.silencetao.view.MessageView;
import com.silencetao.view.Pages;
import com.silencetao.view.SilenceResult;

/**
 * 留言模块Controller层
 * @author Silence
 *
 */
@RequestMapping(value = "message")
@Controller
public class MessageController {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private MessageService messageService;
	
	/**
	 * 保存一条留言
	 * @param visitorSign
	 * @param message
	 * @param response
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "saveMessage")
	@ResponseBody
	public SilenceResult<Map<String, Object>> saveMessage(@CookieValue(value = "visitorSign", required = false) String visitorSign,
			Message message, HttpServletResponse response, HttpSession session) {
		User user = (User) session.getAttribute("userInfo");
		if(user != null) {
			message.setUserSign(user.getUserSign());
			CookiesUtil.clearCookie(response, "visitorSign");
		} else if(visitorSign != null) {
			message.setUserSign(visitorSign);
		} else {
			return new SilenceResult<Map<String, Object>>(false, 0, "未登录");
		}
		message.setMessageSign(StringUtil.getMd5(System.currentTimeMillis() + StringUtil.getRandom(10), "silenceMessage"));
		try {
			messageService.insertMessage(message);
			return new SilenceResult<Map<String, Object>>(true, queryMessages(user, message.getUserSign(), 1), "留言成功");
		} catch (Exception e) {
			log.warn("保存失败");
			log.error(e.getMessage(), e);
			return new SilenceResult<Map<String, Object>>(false, "留言失败");
		}
	}
	
	/**
	 * 获取留言
	 * @return
	 */
	@RequestMapping(value = "getMessages")
	@ResponseBody
	public SilenceResult<Map<String, Object>> getMessages(@CookieValue(value = "visitorSign", required = false) String visitorSign,
			HttpSession session, Pages pages) {
		User user = (User) session.getAttribute("userInfo");
		String sign = null;
		if(user != null) {
			sign = user.getUserSign();
		} else if(visitorSign != null) {
			sign = visitorSign;
		}
		return new SilenceResult<Map<String, Object>>(true, queryMessages(user, sign, pages.getCurrentPage()));
	}
	
	/**
	 * 获取留言(内部函数,多次调用)
	 * @return
	 */
	private Map<String, Object> queryMessages(User user, String sign, long currentPage) {
		Map<String, Object> map = new HashMap<String, Object>();
		Pages pages = new Pages();
		pages.setTotalCount(messageService.getMessageNum());
		pages.setTotalPage(pages.getTotalCount() % pages.getPageSize() == 0 ? pages.getTotalCount() / pages.getPageSize() : pages.getTotalCount() / pages.getPageSize() + 1);
		pages.setCurrentPage(currentPage);
		List<MessageView> messageViews = messageService.getMessages((pages.getCurrentPage() - 1) * pages.getPageSize(), pages.getPageSize());
		for(int i = 0; i < messageViews.size(); i++) {
			messageViews.get(i).setReplyList(messageService.getReplies(messageViews.get(i).getMessageId()));
			if(user != null && (user.getUserRank() >= 6 || user.getUserSign().equals(messageViews.get(i).getUserSign()))) {
				messageViews.get(i).setPermitReply(true);
			} else if(sign != null && sign.equals(messageViews.get(i).getUserSign())) {
				messageViews.get(i).setPermitReply(true);
			} else {
				messageViews.get(i).setPermitReply(false);
			}
		}
		map.put("messages", messageViews);
		map.put("pages", pages);
		map.put("messageNum", messageService.getMessageNum());
		return map;
	}
}
