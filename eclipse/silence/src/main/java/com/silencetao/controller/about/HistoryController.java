package com.silencetao.controller.about;

import com.silencetao.entity.History;
import com.silencetao.entity.Picture;
import com.silencetao.service.about.HistoryService;
import com.silencetao.service.module.PictureService;
import com.silencetao.utils.MailUtil;
import com.silencetao.utils.StringUtil;
import com.silencetao.utils.UploadUtil;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	@RequestMapping(value = "gethistories", method = RequestMethod.GET)
	@ResponseBody
	public List<History> toHistory(HttpServletRequest request) {
		List<History> histories = this.historyService.getHistories(0, 10, "desc");
		return histories;
	}
	
	@RequestMapping(value = "savehistory", method = RequestMethod.POST)
	@ResponseBody
	public History uploadPicture(MultipartHttpServletRequest muliRequest, History history) {
		log.info("保存一条进程信息");
		Iterator<String> iterator = muliRequest.getFileNames();
		history.setHistorySign(StringUtil.getMd5(System.currentTimeMillis() + StringUtil.getRandom(10), "silenceHistory"));
		try {
			historyService.insertHistory(history);
			while(iterator.hasNext()) {
				String fileName = iterator.next();
				System.out.println(fileName);
				MultipartFile file = muliRequest.getFile(fileName);
				Picture picture = new Picture();
				picture.setRealPath(UploadUtil.uploadFile(file, "img/history"));
				picture.setPertain(history.getHistorySign());
				pictureService.insertPicture(picture);
			}
			log.info("保存成功");
		} catch (Exception e) {
			log.warn("保存失败");
			log.error(e.getMessage(), e);
		}
		return history;
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