package com.silencetao.exception;

/**
 * 数据库操作异常处理类
 * @author Silence
 *
 */
public class DatabaseException extends SilenceException {

	public DatabaseException(String message) {
		super(message);
	}
	
	public DatabaseException(String message, Throwable cause) {
		super(message, cause);
	}

}
