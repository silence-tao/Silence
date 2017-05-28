package com.silencetao.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.DigestUtils;

/**
 * 字符串处理工具类
 * @author Silence
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
		log.info("生成长度为" + len + "的随机数");
		int ans = 0;
		while(Math.log10(ans) + 1 < len) {
			ans = (int) (Math.random() * Math.pow(10, len));
		}
		return Integer.toString(ans);
	}
	
	/**
	 * 根据日期计算年龄
	 * @param birthDay
	 * @return
	 * @throws Exception
	 */
	public static int getAge(Date birthDay) throws Exception {  
        Calendar cal = Calendar.getInstance();  
        if (cal.before(birthDay)) {  
            throw new IllegalArgumentException(  
                    "The birthDay is before Now.It's unbelievable!");  
        }  
        int yearNow = cal.get(Calendar.YEAR);  
        int monthNow = cal.get(Calendar.MONTH);  
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);  
        cal.setTime(birthDay);  
        int yearBirth = cal.get(Calendar.YEAR);  
        int monthBirth = cal.get(Calendar.MONTH);  
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);  
        int age = yearNow - yearBirth;  
        if (monthNow <= monthBirth) {  
            if (monthNow == monthBirth) {  
                if (dayOfMonthNow < dayOfMonthBirth) age--;  
            }else{  
                age--;  
            }  
        }  
        return age;  
    }
	
	/**
	 * 将对象装换为Json
	 * @param object
	 * @return
	 */
	public static String toJson(Object object) {
		JSONObject json = JSONObject.fromObject(object);
		return json.toString();
	}
	
	public static Date stringToDate(String str) {
		log.info("字符串转换为日期对象");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
			log.warn("字符串转换为日期对象失败");
			log.error(e.getMessage());
		}
		return date;
	}
}
