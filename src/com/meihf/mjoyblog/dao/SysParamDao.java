package com.meihf.mjoyblog.dao;

import com.meihf.mjoyblog.bean.SysParam;


public class SysParamDao extends CommonDao<SysParam>{

	@Override
	protected Class<SysParam> getEntityClass() {
		return SysParam.class;
	}

}
