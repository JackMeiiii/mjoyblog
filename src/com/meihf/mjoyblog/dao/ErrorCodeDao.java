package com.meihf.mjoyblog.dao;

import com.meihf.mjoyblog.bean.ErrorCode;


public class ErrorCodeDao extends CommonDao<ErrorCode> {

	@Override
	protected Class<ErrorCode> getEntityClass() {
		return ErrorCode.class;
	}

}
