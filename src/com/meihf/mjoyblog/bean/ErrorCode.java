package com.meihf.mjoyblog.bean;

import org.springframework.data.annotation.Id;

/**
 * ������־��
 * @author ÷����
 */
public class ErrorCode {
	/*���Ա���*/
	@Id
	private int code;
	/*������Ϣ*/
	private String message;

	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
