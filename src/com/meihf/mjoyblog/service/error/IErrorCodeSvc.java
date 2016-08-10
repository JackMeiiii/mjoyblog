package com.meihf.mjoyblog.service.error;

/**
 * @desc:错误编码
 * @author 梅海风
 */
public interface IErrorCodeSvc {
	
	/**
	 * @desc: 根据错误编码获取提示信息
	 * @author: 梅海风
	 * @param code
	 * @return
	 * @date  : 2016年1月8日
	 */
	public String getMessage(int code);
}
