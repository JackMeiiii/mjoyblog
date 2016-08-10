package com.meihf.mjoyblog.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.meihf.mjoyblog.bean.ErrorCode;
import com.meihf.mjoyblog.dao.ErrorCodeDao;
import com.meihf.mjoyblog.util.GlobalConstraints;


/**
 * @desc:向ErrorCode错误编码表中插入初始化数据
 * @author 梅海风
 */
@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = {"file:WebContent/WEB-INF/spring-servlet.xml"})
public class ErrorCodeInit{

	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private ErrorCodeDao errorCodeDao;
	
	@Test
	public void Test() {
		this.init();
		System.out.println(errorCodeDao.queryById(
				GlobalConstraints.ErrorCode.EMPTY_NAME_OR_PWD).getMessage());
	}
	
	public void init() {
		//清空集合
		mongoTemplate.dropCollection(ErrorCode.class);
		
		//初始化数据
		ErrorCode data = new ErrorCode();
		data.setCode(GlobalConstraints.ErrorCode.EMPTY_NAME_OR_PWD);
		data.setMessage("用户名或者密码不能为空");
		errorCodeDao.save(data);
		
		data.setCode(GlobalConstraints.ErrorCode.WRONG_NAME_OR_PWD);
		data.setMessage("用户名或者密码错误");
		errorCodeDao.save(data);
		
		data.setCode(GlobalConstraints.ErrorCode.AUTO_LOGIN_FAILD);
		data.setMessage("请重新登录");
		errorCodeDao.save(data);
		
		data.setCode(GlobalConstraints.ErrorCode.REPEAT_LOGIN_NAME);
		data.setMessage("用户名重复，请重新注册");
		errorCodeDao.save(data);
		
		data.setCode(GlobalConstraints.ErrorCode.EMPTY_NEW_SIGN);
		data.setMessage("注册的信息不能为空，请检查");
		errorCodeDao.save(data);
		
		
	}
	
}
