package com.meihf.mjoyblog.test;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.meihf.mjoyblog.bean.User;
import com.meihf.mjoyblog.dao.UserDao;
import com.meihf.mjoyblog.util.DateUtil;
import com.meihf.mjoyblog.util.GlobalConstraints;
import com.meihf.mjoyblog.util.JBcrypt;


/**
 * @desc:向User用户表中插入初始化数据
 * @author 梅海风
 */
@RunWith(SpringJUnit4ClassRunner.class) 
@ContextConfiguration(locations = {"file:WebContent/WEB-INF/spring-servlet.xml"})
public class UserInit{

	@Autowired
	private MongoTemplate mongoTemplate;
	@Autowired
	private UserDao userDao;
	
	@Test
	public void Test() {
		this.init();
		System.out.println(userDao.queryById("meihf").getNickName());
	}
	
	public void init() {
		//清空集合
		mongoTemplate.dropCollection(User.class);
		
		//初始化数据
		User u = new User();
		u.setLoginName("meihf");
		u.setLoginPwd(JBcrypt.hashpw("123456", JBcrypt.gensalt()));
		u.setNickName("梅BOSS");
		u.setRole(GlobalConstraints.USER_ROLE_ID_ADMINISTRATOR);
		u.setTel("15755115262");
		u.setEmail("meihf1992@sina.com");
		u.setIsUsed(GlobalConstraints.BEAN_DATA_STATE_ISUSED);
		u.setCreateDate(new Date());
		u.setBornDate(DateUtil.format2Date("1992-10-01", DateUtil.YYYY_MM_DD));
		u.setSex("1");
		u.setCreateDate2Str(DateUtil.format2Str(new Date()));
		u.setBornDate2Str(DateUtil.format2Str(DateUtil.format2Date("1992-10-01", DateUtil.YYYY_MM_DD)));
		u.setLastLoginDate2Str(DateUtil.format2Str(new Date()));
		userDao.save(u);
		
		User u1 = new User();
		u1.setLoginName("meihf2");
		u1.setLoginPwd(JBcrypt.hashpw("123456", JBcrypt.gensalt()));
		u1.setNickName("梅BOSS");
		u1.setRole(GlobalConstraints.USER_ROLE_ID_GUEST);
		u1.setTel("17310141320");
		u1.setEmail("meihf1992@sina.com");
		u1.setIsUsed(GlobalConstraints.BEAN_DATA_STATE_ISUSED);
		u1.setCreateDate(new Date());
		u1.setBornDate(DateUtil.format2Date("1992-10-01", DateUtil.YYYY_MM_DD));
		u1.setSex("0");
		u1.setCreateDate2Str(DateUtil.format2Str(new Date()));
		u1.setBornDate2Str(DateUtil.format2Str(DateUtil.format2Date("1992-10-01", DateUtil.YYYY_MM_DD)));
		u1.setLastLoginDate2Str(DateUtil.format2Str(new Date()));
		
		User u2 = new User();
		u2.setLoginName("meihf3");
		u2.setLoginPwd(JBcrypt.hashpw("123456", JBcrypt.gensalt()));
		u2.setNickName("梅BOSS");
		u2.setRole(GlobalConstraints.USER_ROLE_ID_GUEST);
		u2.setTel("17310141320");
		u2.setEmail("meihf1992@sina.com");
		u2.setIsUsed(GlobalConstraints.BEAN_DATA_STATE_ISUSED);
		u2.setCreateDate(new Date());
		u2.setBornDate(DateUtil.format2Date("1992-10-01", DateUtil.YYYY_MM_DD));
		u2.setSex("0");
		u2.setCreateDate2Str(DateUtil.format2Str(new Date()));
		u2.setBornDate2Str(DateUtil.format2Str(DateUtil.format2Date("1992-10-01", DateUtil.YYYY_MM_DD)));
		u2.setLastLoginDate2Str(DateUtil.format2Str(new Date()));
		
		User u21 = new User();
		u21.setLoginName("meihf31");
		u21.setLoginPwd(JBcrypt.hashpw("123456", JBcrypt.gensalt()));
		u21.setNickName("梅BOSS");
		u21.setRole(GlobalConstraints.USER_ROLE_ID_GUEST);
		u21.setTel("17310141320");
		u21.setEmail("meihf1992@sina.com");
		u21.setIsUsed(GlobalConstraints.BEAN_DATA_STATE_ISUSED);
		u21.setCreateDate(new Date());
		u21.setBornDate(DateUtil.format2Date("1992-10-01", DateUtil.YYYY_MM_DD));
		u21.setSex("0");
		u21.setCreateDate2Str(DateUtil.format2Str(new Date()));
		u21.setBornDate2Str(DateUtil.format2Str(DateUtil.format2Date("1992-10-01", DateUtil.YYYY_MM_DD)));
		u21.setLastLoginDate2Str(DateUtil.format2Str(new Date()));
		
		User u22 = new User();
		u22.setLoginName("meihf32");
		u22.setLoginPwd(JBcrypt.hashpw("123456", JBcrypt.gensalt()));
		u22.setNickName("梅BOSS");
		u22.setRole(GlobalConstraints.USER_ROLE_ID_GUEST);
		u22.setTel("17310141320");
		u22.setEmail("meihf1992@sina.com");
		u22.setIsUsed(GlobalConstraints.BEAN_DATA_STATE_ISUSED);
		u22.setCreateDate(new Date());
		u22.setBornDate(DateUtil.format2Date("1992-10-01", DateUtil.YYYY_MM_DD));
		u22.setSex("0");
		u22.setCreateDate2Str(DateUtil.format2Str(new Date()));
		u22.setBornDate2Str(DateUtil.format2Str(DateUtil.format2Date("1992-10-01", DateUtil.YYYY_MM_DD)));
		u22.setLastLoginDate2Str(DateUtil.format2Str(new Date()));
		
		User u23 = new User();
		u23.setLoginName("meihf33");
		u23.setLoginPwd(JBcrypt.hashpw("123456", JBcrypt.gensalt()));
		u23.setNickName("梅BOSS");
		u23.setRole(GlobalConstraints.USER_ROLE_ID_GUEST);
		u23.setTel("17310141320");
		u23.setEmail("meihf1992@sina.com");
		u23.setIsUsed(GlobalConstraints.BEAN_DATA_STATE_ISUSED);
		u23.setCreateDate(new Date());
		u23.setBornDate(DateUtil.format2Date("1992-10-01", DateUtil.YYYY_MM_DD));
		u23.setSex("0");
		u23.setCreateDate2Str(DateUtil.format2Str(new Date()));
		u23.setBornDate2Str(DateUtil.format2Str(DateUtil.format2Date("1992-10-01", DateUtil.YYYY_MM_DD)));
		u23.setLastLoginDate2Str(DateUtil.format2Str(new Date()));
		
		User u24 = new User();
		u24.setLoginName("meihf34");
		u24.setLoginPwd(JBcrypt.hashpw("123456", JBcrypt.gensalt()));
		u24.setNickName("梅BOSS");
		u24.setRole(GlobalConstraints.USER_ROLE_ID_GUEST);
		u24.setTel("17310141320");
		u24.setEmail("meihf1992@sina.com");
		u24.setIsUsed(GlobalConstraints.BEAN_DATA_STATE_ISUSED);
		u24.setCreateDate(new Date());
		u24.setBornDate(DateUtil.format2Date("1992-10-01", DateUtil.YYYY_MM_DD));
		u24.setSex("0");
		u24.setCreateDate2Str(DateUtil.format2Str(new Date()));
		u24.setBornDate2Str(DateUtil.format2Str(DateUtil.format2Date("1992-10-01", DateUtil.YYYY_MM_DD)));
		u24.setLastLoginDate2Str(DateUtil.format2Str(new Date()));
		
		User u25 = new User();
		u25.setLoginName("meihf35");
		u25.setLoginPwd(JBcrypt.hashpw("123456", JBcrypt.gensalt()));
		u25.setNickName("梅BOSS");
		u25.setRole(GlobalConstraints.USER_ROLE_ID_GUEST);
		u25.setTel("17310141320");
		u25.setEmail("meihf1992@sina.com");
		u25.setIsUsed(GlobalConstraints.BEAN_DATA_STATE_ISUSED);
		u25.setCreateDate(new Date());
		u25.setBornDate(DateUtil.format2Date("1992-10-01", DateUtil.YYYY_MM_DD));
		u25.setSex("0");
		u25.setCreateDate2Str(DateUtil.format2Str(new Date()));
		u25.setBornDate2Str(DateUtil.format2Str(DateUtil.format2Date("1992-10-01", DateUtil.YYYY_MM_DD)));
		u25.setLastLoginDate2Str(DateUtil.format2Str(new Date()));
		
		User u26 = new User();
		u26.setLoginName("meihf36");
		u26.setLoginPwd(JBcrypt.hashpw("123456", JBcrypt.gensalt()));
		u26.setNickName("梅BOSS");
		u26.setRole(GlobalConstraints.USER_ROLE_ID_GUEST);
		u26.setTel("17310141320");
		u26.setEmail("meihf1992@sina.com");
		u26.setIsUsed(GlobalConstraints.BEAN_DATA_STATE_ISUSED);
		u26.setCreateDate(new Date());
		u26.setBornDate(DateUtil.format2Date("1992-10-01", DateUtil.YYYY_MM_DD));
		u26.setSex("0");
		u26.setCreateDate2Str(DateUtil.format2Str(new Date()));
		u26.setBornDate2Str(DateUtil.format2Str(DateUtil.format2Date("1992-10-01", DateUtil.YYYY_MM_DD)));
		u26.setLastLoginDate2Str(DateUtil.format2Str(new Date()));
		
		User u27 = new User();
		u27.setLoginName("meihf37");
		u27.setLoginPwd(JBcrypt.hashpw("123456", JBcrypt.gensalt()));
		u27.setNickName("梅BOSS");
		u27.setRole(GlobalConstraints.USER_ROLE_ID_GUEST);
		u27.setTel("17310141320");
		u27.setEmail("meihf1992@sina.com");
		u27.setIsUsed(GlobalConstraints.BEAN_DATA_STATE_ISUSED);
		u27.setCreateDate(new Date());
		u27.setBornDate(DateUtil.format2Date("1992-10-01", DateUtil.YYYY_MM_DD));
		u27.setSex("0");
		u27.setCreateDate2Str(DateUtil.format2Str(new Date()));
		u27.setBornDate2Str(DateUtil.format2Str(DateUtil.format2Date("1992-10-01", DateUtil.YYYY_MM_DD)));
		u27.setLastLoginDate2Str(DateUtil.format2Str(new Date()));
		
		User u28 = new User();
		u28.setLoginName("meihf38");
		u28.setLoginPwd(JBcrypt.hashpw("123456", JBcrypt.gensalt()));
		u28.setNickName("梅BOSS");
		u28.setRole(GlobalConstraints.USER_ROLE_ID_GUEST);
		u28.setTel("17310141320");
		u28.setEmail("meihf1992@sina.com");
		u28.setIsUsed(GlobalConstraints.BEAN_DATA_STATE_ISUSED);
		u28.setCreateDate(new Date());
		u28.setBornDate(DateUtil.format2Date("1992-10-01", DateUtil.YYYY_MM_DD));
		u28.setSex("0");
		u28.setCreateDate2Str(DateUtil.format2Str(new Date()));
		u28.setBornDate2Str(DateUtil.format2Str(DateUtil.format2Date("1992-10-01", DateUtil.YYYY_MM_DD)));
		u28.setLastLoginDate2Str(DateUtil.format2Str(new Date()));
		
		User u29 = new User();
		u29.setLoginName("meihf39");
		u29.setLoginPwd(JBcrypt.hashpw("123456", JBcrypt.gensalt()));
		u29.setNickName("梅BOSS");
		u29.setRole(GlobalConstraints.USER_ROLE_ID_GUEST);
		u29.setTel("17310141320");
		u29.setEmail("meihf1992@sina.com");
		u29.setIsUsed(GlobalConstraints.BEAN_DATA_STATE_ISUSED);
		u29.setCreateDate(new Date());
		u29.setBornDate(DateUtil.format2Date("1992-10-01", DateUtil.YYYY_MM_DD));
		u29.setSex("0");
		u29.setCreateDate2Str(DateUtil.format2Str(new Date()));
		u29.setBornDate2Str(DateUtil.format2Str(DateUtil.format2Date("1992-10-01", DateUtil.YYYY_MM_DD)));
		u29.setLastLoginDate2Str(DateUtil.format2Str(new Date()));
		
		User u20 = new User();
		u20.setLoginName("meihf30");
		u20.setLoginPwd(JBcrypt.hashpw("123456", JBcrypt.gensalt()));
		u20.setNickName("梅BOSS");
		u20.setRole(GlobalConstraints.USER_ROLE_ID_GUEST);
		u20.setTel("17310141320");
		u20.setEmail("meihf1992@sina.com");
		u20.setIsUsed(GlobalConstraints.BEAN_DATA_STATE_ISUSED);
		u20.setCreateDate(new Date());
		u20.setBornDate(DateUtil.format2Date("1992-10-01", DateUtil.YYYY_MM_DD));
		u20.setSex("0");
		u20.setCreateDate2Str(DateUtil.format2Str(new Date()));
		u20.setBornDate2Str(DateUtil.format2Str(DateUtil.format2Date("1992-10-01", DateUtil.YYYY_MM_DD)));
		u20.setLastLoginDate2Str(DateUtil.format2Str(new Date()));
		userDao.save(u);
		userDao.save(u1);
		userDao.save(u2);
		userDao.save(u20);
		userDao.save(u21);
		userDao.save(u22);
		userDao.save(u23);
		userDao.save(u24);
		userDao.save(u25);
		userDao.save(u26);
		userDao.save(u27);
		userDao.save(u28);
		userDao.save(u29);
		
	}
	
}
