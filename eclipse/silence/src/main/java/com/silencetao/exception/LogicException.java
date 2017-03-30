package com.silencetao.exception;

/**
 * 逻辑异常处理类
 * @author Silence
 *
 */
public class LogicException extends SilenceException {

	public LogicException(String message) {
		super(message);
	}
	
	public LogicException(String message, Throwable cause) {
		super(message, cause);
	}

}
