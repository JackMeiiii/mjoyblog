package com.meihf.mjoyblog.dao;

import com.meihf.mjoyblog.bean.Catalog;


public class CatalogDao extends CommonDao<Catalog> {

	@Override
	protected Class<Catalog> getEntityClass() {
		return Catalog.class;
	}

}
