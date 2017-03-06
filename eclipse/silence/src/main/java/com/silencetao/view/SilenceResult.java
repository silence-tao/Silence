package com.silencetao.view;

/**
 * Ajax请求响应公共类
 * @author 陈涛
 *
 * @param <T>
 */
public class SilenceResult<T> {

	private boolean isSuccess;//成功或失败
	private T data;//返回的数据,这里定义为泛型,为得是能接收所有的类
	private int status;//状态码
	private String message;//响应信息,包括状态信息和错误信息
	
	public SilenceResult() {
		
	}

	public SilenceResult(boolean isSuccess, T data) {
		this.isSuccess = isSuccess;
		this.data = data;
	}

	public SilenceResult(boolean isSuccess, String message) {
		this.isSuccess = isSuccess;
		this.message = message;
	}

	public SilenceResult(boolean isSuccess, int status, String message) {
		this.isSuccess = isSuccess;
		this.status = status;
		this.message = message;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "SilenceResult [isSuccess=" + isSuccess + ", data=" + data
				+ ", status=" + status + ", message=" + message + "]";
	}
}
