package com.meihf.mjoyblog.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.meihf.mjoyblog.bean.SysParam;
import com.meihf.mjoyblog.dao.SysParamDao;
import com.meihf.mjoyblog.util.GlobalConstraints;

/**
 * @desc:向ErrorCode错误编码表中插入初始化数据
 * @author 梅海风
 */
@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = {"file:WebContent/WEB-INF/spring-servlet.xml"})
public class SysParamInit {
	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private SysParamDao sysParamDao;
	
	@Test
	public void Test() {
		this.init();
//		System.out.println(sysParamDao.queryById(
//				GlobalConstraints.SYS_PARAM.BLOG_NAME));
	}
	public void init(){
		SysParam sysParam = new SysParam();
		sysParam.setCode("blog_name");
		sysParam.setDesc("博客名称");
		sysParam.setKey("blog_name");
		sysParam.setValue("梅BOSS");
		sysParamDao.save(sysParam);
		
	}
}
