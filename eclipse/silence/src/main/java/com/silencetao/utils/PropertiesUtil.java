package com.silencetao.utils;

import java.util.Properties;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * 读取配置文件的工具类
 * @author Silence
 *
 */
public class PropertiesUtil extends PropertyPlaceholderConfigurer {
	private static Properties properties;

	public static String getProperties(String key) {
		return properties.getProperty(key);
	}

	protected void processProperties(
			ConfigurableListableBeanFactory beanFactoryToProcess,
			Properties props) throws BeansException {
		properties = props;
		super.processProperties(beanFactoryToProcess, props);
	}
}