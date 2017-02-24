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
	
	/**
	 * 获取字符串的MD5
	 * @param str
	 * @param slat
	 * @return
	 */
	public static String getMd5(String str, String slat) {
		String base = str + "/" + slat;
		log.info("为字符串" + base + "生成MD5字符串");
		return DigestUtils.md5DigestAsHex(base.getBytes());
	}
	
	/**
	 * 生成指定位数的随机数
	 * @param len
	 * @return
	 */
	public static String getRandom(long len) {
		int ans = 0;
		while(Math.log10(ans) + 1 < len) {
			ans = (int) (Math.random() * Math.pow(10, len));
		}
		return Integer.toString(ans);
	}
}
