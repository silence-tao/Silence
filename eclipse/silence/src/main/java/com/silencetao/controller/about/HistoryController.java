package com.silencetao.controller.about;

import com.silencetao.entity.Comment;
import com.silencetao.entity.History;
import com.silencetao.entity.Picture;
import com.silencetao.entity.User;
import com.silencetao.exception.DatabaseException;
import com.silencetao.exception.MessageExcetion;
import com.silencetao.exception.SilenceException;
import com.silencetao.service.about.HistoryService;
import com.silencetao.service.module.PictureService;
import com.silencetao.utils.CookiesUtil;
import com.silencetao.utils.MailUtil;
import com.silencetao.utils.StringUtil;
import com.silencetao.utils.UploadUtil;
import com.silencetao.view.CommentView;
import com.silencetao.view.HistoryView;
import com.silencetao.view.Pages;
import com.silencetao.view.SilenceResult;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.jdbc.Null;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
@RequestMapping("history")
public class HistoryController {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private HistoryService historyService;
	
	@Autowired
	private PictureService pictureService;

	@RequestMapping(value = "gethistories")
	@ResponseBody
	public SilenceResult<List<HistoryView>> getHistories(int currentPage) {
		log.info("获取第" + currentPage + "页的项目进度");
		try {
			log.info("获取成功");
			return new SilenceResult<List<HistoryView>>(true, historyService.getHistoryViews((currentPage - 1) * 10, 10));
		} catch (Exception e) {
			log.warn("获取失败");
			log.error(e.getMessage(), e);
			return new SilenceResult<List<HistoryView>>(false, "获取失败");
		}
	}
	
	@RequestMapping(value = "savehistory", method = RequestMethod.POST)
	@ResponseBody
	public SilenceResult<List<HistoryView>> savehistory(MultipartHttpServletRequest muliRequest, History history) {
		log.info("保存一条进程信息");
		Iterator<String> iterator = muliRequest.getFileNames();
		history.setHistorySign(StringUtil.getMd5(System.currentTimeMillis() + StringUtil.getRandom(10), "silenceHistory"));
		try {
			List<Picture> pictures = new ArrayList<Picture>();
			while(iterator.hasNext()) {
				String fileName = iterator.next();
				MultipartFile file = muliRequest.getFile(fileName);
				String path = UploadUtil.uploadFile(file, "img/history");
				if(path != null && !"".equals(path)) {
					Picture picture = new Picture();
					picture.setRealPath(path);
					picture.setPertain(history.getHistorySign());
					pictures.add(picture);
				}
			}
			List<HistoryView> historyViews = historyService.saveHistory(history, pictures);
			log.info("保存成功");
			return new SilenceResult<List<HistoryView>>(true, historyViews);
		} catch (DatabaseException e) {
			log.warn(e.getMessage());
			throw new MessageExcetion(e.getMessage());
		} catch (SilenceException e) {
			log.warn(e.getMessage());
			throw new MessageExcetion(e.getMessage());
		} catch (Exception e) {
			log.warn("保存失败");
			log.error(e.getMessage(), e);
			throw new MessageExcetion("保存失败");
		}
	}

	@RequestMapping(value = "upload")
	@ResponseBody
	public String uploadPicture() {
		String resultStr = "";
		MailUtil mailUtil = new MailUtil("7777", "3333", "taogu2010@yeah.net");
		mailUtil.run();
		if (mailUtil.isResult())
			resultStr = resultStr + "邮件发送成功";
		else {
			resultStr = resultStr + "邮件发送失败";
		}
		return resultStr;
	}
	
	@RequestMapping(value = "detail/{historyId}")
	public String getDetail(@PathVariable(value = "historyId") long historyId,
			HttpServletRequest request) {
		HistoryView historyView = historyService.getHisotryView(historyId);
		if(historyView != null) {
			request.setAttribute("historyView", historyView);
			return "/about/detail";
		}
		return "redirect:/history";
	}
	
	/**
	 * 获取心路历程主页显示数据
	 * @return
	 */
	@RequestMapping(value = "getHistoryHome")
	@ResponseBody
	public SilenceResult<List<HistoryView>> getHistoryHome() {
		return new SilenceResult<List<HistoryView>>(true, historyService.getHistoryHome());
	}
	
	/**
	 * 设置是否在首页显示
	 * @param history
	 * @param essaySign
	 * @return
	 */
	@RequestMapping(value = "isHomeShow")
	@ResponseBody
	public SilenceResult<Null> isHomeShow(History history, String essaySign) {
		history.setHistorySign(essaySign);
		try {
			int result = historyService.updateHomeShow(history);
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
}