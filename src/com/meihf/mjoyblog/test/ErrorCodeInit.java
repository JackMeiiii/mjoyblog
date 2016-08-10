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
 * @desc:��ErrorCode���������в����ʼ������
 * @author ÷����
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
		//��ռ���
		mongoTemplate.dropCollection(ErrorCode.class);
		
		//��ʼ������
		ErrorCode data = new ErrorCode();
		data.setCode(GlobalConstraints.ErrorCode.EMPTY_NAME_OR_PWD);
		data.setMessage("�û����������벻��Ϊ��");
		errorCodeDao.save(data);
		
		data.setCode(GlobalConstraints.ErrorCode.WRONG_NAME_OR_PWD);
		data.setMessage("�û��������������");
		errorCodeDao.save(data);
		
		data.setCode(GlobalConstraints.ErrorCode.AUTO_LOGIN_FAILD);
		data.setMessage("�����µ�¼");
		errorCodeDao.save(data);
		
		data.setCode(GlobalConstraints.ErrorCode.REPEAT_LOGIN_NAME);
		data.setMessage("�û����ظ���������ע��");
		errorCodeDao.save(data);
		
		data.setCode(GlobalConstraints.ErrorCode.EMPTY_NEW_SIGN);
		data.setMessage("ע�����Ϣ����Ϊ�գ�����");
		errorCodeDao.save(data);
		
		
	}
	
}
