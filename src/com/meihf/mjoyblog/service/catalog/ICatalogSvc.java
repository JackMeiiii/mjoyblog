package com.meihf.mjoyblog.service.catalog;

import java.util.List;

import com.meihf.mjoyblog.bean.Catalog;


/**
 * @desc: Ŀ¼�����ӿ�
 * @author ÷����
 */
public interface ICatalogSvc {
	public List<Catalog> queryAllCatalog(String loginName);

	public Catalog queryCatalogById(String catalogId);

	public Catalog queryCatalogByCatalogPath(String catalogPath);

	public List<Catalog> queryAllByCatalogCategories(String catagoryParameter);

	public void removeByCatalogId(String catalogId);
	
	public void addCatalog(Catalog catalog);
	
	public void updateCatalog(String catalogId);
}
