package com.meihf.mjoyblog.exception;

import com.meihf.mjoyblog.service.error.IErrorCodeSvc;
import com.meihf.mjoyblog.util.GlobalConstraints;
import com.meihf.mjoyblog.util.SpringBeanUtil;


/**
 * @desc: ͳһ�쳣Bean
 * @author ÷����
 */
public class BusiException extends Exception{

	private static final long serialVersionUID = 9999L;
	
	/** �����������ݿ�,��̬һ���㹻 */
	private static IErrorCodeSvc errorCodeSvc;
	
	static {
		errorCodeSvc = (IErrorCodeSvc) SpringBeanUtil.getBean("errorCodeSvc");
	}
	
	/** ������� */
	private int code;
	/** ������Ϣ */
	private String msg;
	
	/**
	 * Ĭ��δ֪�쳣
	 */
	public BusiException() {
		this.code = -1;
		this.msg = GlobalConstraints.ErrorCode.UNKNOW_ERROR_MESSAGE;
	}
	
	/**
	 * ���ݴ�������װ�쳣
	 * @param code
	 */
	public BusiException(int code) {
		this.code = code;
		this.msg = errorCodeSvc.getMessage(code);
	}

	public int getErrorCode() {
		return code;
	}

	/**
	 * ���ش�����Ϣ
	 */
	@Override
	public String getMessage() {
		return msg;
	}

}
