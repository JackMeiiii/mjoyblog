package com.meihf.mjoyblog.service.error;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.meihf.mjoyblog.bean.ErrorCode;
import com.meihf.mjoyblog.dao.ErrorCodeDao;
import com.meihf.mjoyblog.util.GlobalConstraints;


/**
 * @desc:�����������ʵ��
 * @author ÷����
 */
public class ErrorCodeSvcImpl implements IErrorCodeSvc {
	@Autowired
	private ErrorCodeDao errorCodeDao;
	
	private static Log log = LogFactory.getLog(ErrorCodeSvcImpl.class);
	
	@Override
	public String getMessage(int code) {
		ErrorCode bean = errorCodeDao.queryById(code);
		if(bean != null){
			return bean.getMessage();
		}
		log.error("����ID:["+code+"]"+"�Ҳ�����Ӧ�Ĵ�����Ϣ");
		return GlobalConstraints.ErrorCode.UNKNOW_ERROR_MESSAGE;
	}


}
