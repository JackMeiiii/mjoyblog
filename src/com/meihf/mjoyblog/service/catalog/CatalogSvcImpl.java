package com.meihf.mjoyblog.service.catalog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.meihf.mjoyblog.bean.Catalog;
import com.meihf.mjoyblog.dao.CatalogDao;


/**
 * @desc: 目录服务层实现
 * @author 梅海风
 */
public class CatalogSvcImpl implements ICatalogSvc {
	@Autowired
	private CatalogDao catalogDao;

	@Override
	public List<Catalog> queryAllCatalog(String loginName) {
		return catalogDao.queryList(new Query(Criteria.where("loginName").is(loginName)).with(new Sort(Direction.ASC,
				"createDate")));

	}

	@Override
	public Catalog queryCatalogById(String catalogId) {
		return catalogDao.queryOne(new Query().addCriteria(Criteria.where("catalogId").is(catalogId)));
	}

	@Override
	public Catalog queryCatalogByCatalogPath(String catalogPath) {
		return catalogDao.queryOne(new Query().addCriteria(Criteria.where("catalogPath").is(catalogPath)));
	}

	@Override
	public List<Catalog> queryAllByCatalogCategories(String catagoryParameter) {
		return catalogDao.queryList(new Query().addCriteria(Criteria.where("categories").is(catagoryParameter)));
	}

	@Override
	public void removeByCatalogId(String catalogId) {
		catalogDao.delete(new Query().addCriteria(Criteria.where("catalogId").is(catalogId)));
	}

	@Override
	public void addCatalog(Catalog catalog) {
		catalogDao.save(catalog);
	}

	@Override
	public void updateCatalog(String catalogId) {
		catalogDao.updateFirst(new Query().addCriteria(Criteria.where("catalogId").is(catalogId)), Update.update("catalogId", catalogId));
	}
}
