package com.meihf.mjoyblog.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.meihf.mjoyblog.bean.Catalog;
import com.meihf.mjoyblog.dao.CatalogDao;
import com.meihf.mjoyblog.util.DateUtil;

/**
 * @desc添加目录
 * @author 梅海风
 */
@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = {"file:WebContent/WEB-INF/spring-servlet.xml"})
public class CatalogUnit {
	@Autowired
	private CatalogDao catalogDao;
	@Autowired
	private MongoTemplate mongoTemplate;
	@Test
	public void Test(){
		mongoTemplate.dropCollection(Catalog.class);
		this.Init();
		System.out.println(catalogDao.queryList(new Query()).size());
	}
	public void Init(){
		Catalog catalog = new Catalog();
		catalog.setCatalogId("你好今天");
		catalog.setCatalogPath("/MJoyBlog/main/hello/today");
		catalog.setPermission((short) 1);
		catalog.setState((short) 1);
		catalog.setCreateDate(DateUtil.getCurrDate());
		catalog.setCategories("你好");
		catalog.setloginName("meihf2");;
		
		Catalog catalog1 = new Catalog();
		catalog1.setCatalogId("你好明天");
		catalog1.setCategories("你好");
		catalog1.setCatalogPath("/MJoyBlog/main/hello/tomorrow");
		catalog1.setPermission((short) 3);
		catalog1.setState((short) 3);
		catalog1.setCreateDate(DateUtil.getCurrDate());
		catalog1.setloginName("meihf2");;
		
		Catalog catalog2 = new Catalog();
		catalog2.setCatalogId("你好后天");
		catalog2.setCategories("你好");
		catalog2.setCatalogPath("/MJoyBlog/main/hello/tdat");
		catalog2.setPermission((short) 2);
		catalog2.setState((short) 2);
		catalog2.setCreateDate(DateUtil.getCurrDate());
		catalog2.setloginName("meihf3");;
		
		
		Catalog catalog3 = new Catalog();
		catalog3.setCatalogId("hello今天");
		catalog3.setCategories("hellos");
		catalog3.setCatalogPath("/MJoyBlog/main/hellos/today");
		catalog3.setPermission((short) 4);
		catalog3.setState((short) 4);
		catalog3.setCreateDate(DateUtil.getCurrDate());
		catalog3.setloginName("meihf3");;
		
		Catalog catalog4 = new Catalog();
		catalog4.setCatalogId("hello明天");
		catalog4.setCategories("hellos");
		catalog4.setCatalogPath("/MJoyBlog/main/hellos/tomorrow");
		catalog4.setPermission((short) 5);
		catalog4.setState((short) 5);
		catalog4.setCreateDate(DateUtil.getCurrDate());
		catalog4.setloginName("meihf4");;
		
		Catalog catalog5 = new Catalog();
		catalog5.setCatalogId("hello后天");
		catalog5.setCategories("hellos");
		catalog5.setCatalogPath("/MJoyBlog/main/hellos/tdat");
		catalog5.setPermission((short) 6);
		catalog5.setState((short) 6);
		catalog5.setCreateDate(DateUtil.getCurrDate());
		catalog5.setloginName("meihf4");
		
		
		catalogDao.save(catalog1);
		catalogDao.save(catalog2);
		catalogDao.save(catalog);
		catalogDao.save(catalog3);
		catalogDao.save(catalog4);
		catalogDao.save(catalog5);
	}

}
