package com.silencetao.exception;

/**
 * Ajax请求异常提示信息类
 * @author Silence
 *
 */
public class MessageExcetion extends SilenceException {

	public MessageExcetion(String message) {
		super(message);
	}
	
	public MessageExcetion(String message, Throwable cause) {
		super(message, cause);
	}

}
