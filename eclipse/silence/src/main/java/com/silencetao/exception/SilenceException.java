package com.silencetao.exception;

/**
 * 相关业务异常处理类
 * @author Silence
 *
 */
public class SilenceException extends RuntimeException {

	public SilenceException(String message) {
		super(message);
	}
	
	public SilenceException(String message, Throwable cause) {
		super(message, cause);
	}
}
