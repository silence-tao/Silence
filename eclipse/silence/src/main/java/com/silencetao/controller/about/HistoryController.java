package com.silencetao.controller.about;

import com.silencetao.entity.History;
import com.silencetao.entity.Picture;
import com.silencetao.service.about.HistoryService;
import com.silencetao.service.module.PictureService;
import com.silencetao.utils.StringUtil;
import com.silencetao.utils.UploadUtil;
import com.silencetao.view.HistoryView;
import com.silencetao.view.SilenceResult;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
@RequestMapping("about")
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
			historyService.insertHistory(history);
			while(iterator.hasNext()) {
				String fileName = iterator.next();
				MultipartFile file = muliRequest.getFile(fileName);
				Picture picture = new Picture();
				picture.setRealPath(UploadUtil.uploadFile(file, "img/history"));
				picture.setPertain(history.getHistorySign());
				pictureService.insertPicture(picture);
			}
			log.info("保存成功");
			return new SilenceResult<List<HistoryView>>(true, historyService.getHistoryViews(0, 10));
		} catch (Exception e) {
			log.warn("保存失败");
			log.error(e.getMessage(), e);
			return new SilenceResult<List<HistoryView>>(false, "保存失败");
		}
	}

	/*@RequestMapping(value = "upload", method = RequestMethod.POST)
	public String uploadPicture(
			@RequestParam(value = "picture", required = false) MultipartFile picture,
			HttpServletRequest request) {
		String result = UploadUtil.uploadFile(picture, "img");
		String resultStr = "";
		MailUtil mailUtil = new MailUtil("测试邮件", "测试专用", "1228714091@qq.com");
		mailUtil.run();
		if (result != null)
			resultStr = "上传成功!";
		else {
			resultStr = "上传失败!";
		}
		if (mailUtil.isResult())
			resultStr = resultStr + "邮件发送成功";
		else {
			resultStr = resultStr + "邮件发送失败";
		}
		request.setAttribute("result", resultStr + "<br />" + result);
		return "redirect:history";
	}
	
	@RequestMapping(value = "history", method = RequestMethod.GET)
	public String initHistory(HttpServletRequest request) {
		request.setAttribute("result", "应该是我想得那样吧");
		return "about/history";
	}*/
}