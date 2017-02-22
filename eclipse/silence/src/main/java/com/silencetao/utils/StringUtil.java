package com.silencetao.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.DigestUtils;

/**
 * 字符串处理工具类
 * @author 
 *
 */
public class StringUtil {
	private static Logger log = LoggerFactory.getLogger(StringUtil.class);
	
	public static String getMd5(String str, String slat) {
		String base = str + "/" + slat;
		log.info("为字符串" + base + "生成MD5字符串");
		return DigestUtils.md5DigestAsHex(base.getBytes());
	}
}
