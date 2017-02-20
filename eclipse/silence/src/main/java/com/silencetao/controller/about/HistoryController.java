package com.silencetao.controller.about;

import com.silencetao.entity.History;
import com.silencetao.service.about.HistoryService;
import com.silencetao.utils.MailUtil;
import com.silencetao.utils.UploadUtil;

import java.io.PrintStream;
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

@Controller
@RequestMapping({ "about" })
public class HistoryController {
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private HistoryService historyService;

	@RequestMapping(value = "history", method = RequestMethod.GET)
	@ResponseBody
	public List<History> toHistory(HttpServletRequest request) {
		List<History> histories = this.historyService.getHistories(0, 10, "desc");
		for (History history : histories) {
			System.out.println(history);
		}
		return histories;
	}

	@RequestMapping(value = "upload", method = RequestMethod.POST)
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
		return "about/history";
	}
}