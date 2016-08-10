package com.meihf.mjoyblog.service.user;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.meihf.mjoyblog.bean.PageBean;
import com.meihf.mjoyblog.bean.PageRetInfo;
import com.meihf.mjoyblog.bean.User;
import com.meihf.mjoyblog.dao.UserDao;
import com.meihf.mjoyblog.exception.BusiException;
import com.meihf.mjoyblog.util.DateUtil;
import com.meihf.mjoyblog.util.GlobalConstraints;
import com.meihf.mjoyblog.util.JBcrypt;
import com.meihf.mjoyblog.util.StringUtil;


/**
 * 用户表的服务的实现
 * @author 梅海风
 */
public class UserSvcImpl implements IUserSvc{
	
	@Autowired
	private UserDao userDao;

	private static Log log = LogFactory.getLog(UserSvcImpl.class);
	
	@Override
	public User getUserInfoByLoginName(String loginName) {
		if (StringUtil.isRealEmpty(loginName)) {
			return null;
		}
		//查询该登录名称的可用的用户
		Query query = new Query();
		query.addCriteria(Criteria.where("loginName").is(loginName));
		query.addCriteria(Criteria.where("isUsed").is(GlobalConstraints.BEAN_DATA_STATE_ISUSED));
		
		return userDao.queryOne(query);
	}

	@Override
	public User verifyAdminLogin(String loginName, String loginPwd) throws Exception {
		if (StringUtil.isRealEmpty(loginName) || StringUtil.isRealEmpty(loginPwd)) {
			throw new BusiException(GlobalConstraints.ErrorCode.EMPTY_NAME_OR_PWD);
		}

		User user = this.getUserInfoByLoginName(loginName);
		
		//校验密码
		if (user == null||!JBcrypt.checkpw(loginPwd, user.getLoginPwd())) {
			throw new BusiException(GlobalConstraints.ErrorCode.WRONG_NAME_OR_PWD);
		}
		
		return user;
	}

	@Override
	public void logLoginIP(String loginName, String loginIP)
			throws Exception {
		if (StringUtil.isRealEmpty(loginName)) {
			throw new BusiException(GlobalConstraints.ErrorCode.EMPTY_NAME_OR_PWD);
		}
		userDao.updateFirst(new Query(Criteria.where("loginName").is(loginName)), 
				new Update().set("autoLoginIP", loginIP));
	}

	@Override
	public User autoLogin(String ip) throws Exception {
		if (StringUtil.isRealEmpty(ip)) {
			throw new BusiException(GlobalConstraints.ErrorCode.AUTO_LOGIN_FAILD);
		}
		
		User user = userDao.queryOne(new Query(Criteria.where("autoLoginIP").is(ip)));
		
		if (user == null ||
				user.getRole() != GlobalConstraints.USER_ROLE_ID_ADMINISTRATOR ||
				user.getIsUsed() == GlobalConstraints.BEAN_DATA_STATE_NOTUSED) {
			throw new BusiException(GlobalConstraints.ErrorCode.AUTO_LOGIN_FAILD);
		}
		
		return user;
	}

	@Override
	public PageRetInfo<User> findByCondition(PageBean page, Object object,String email) {
		Query query = new Query();
		//--Condition 略 想到的时候在写吧
		query.with(new Sort(Direction.ASC,"createDate"));
		PageRetInfo<User> retInfo = new PageRetInfo<User>();
		retInfo.setTotal(userDao.getPageUsedCount(query,1,email));
		retInfo.setRows(userDao.getPage(query, page));
		log.debug(retInfo);
		return retInfo;
	}

	@Override
	public void deleteUserById(String loginName) {
		userDao.delete(new Query(Criteria.where("loginName").is(loginName)));
	}

	@Override
	public void addUser(String loginName, String loginPwd,String blog_name,String email) {
		User user = new User();
		user.setCreateDate(DateUtil.getCurrDate());
		user.setLoginName(loginName);
		user.setNickName(blog_name);
		user.setEmail(email);
		user.setLoginPwd(JBcrypt.hashpw(loginPwd, JBcrypt.gensalt()));
		user.setRole((short)1);
		user.setIsUsed((short)1);
		userDao.save(user);
	}

	@Override
	public int findByByLoginName(String loginName,String loginPwd,String email,String blog_name) throws Exception{
//		if (StringUtil.isRealEmpty(loginName) || StringUtil.isRealEmpty(loginPwd)
//				|| StringUtil.isRealEmpty(email) || StringUtil.isRealEmpty(blog_name)) {
//			throw new BusiException(GlobalConstraints.ErrorCode.EMPTY_NEW_SIGN);
//		}
		User user = userDao.queryById(loginName);
		if(user!=null){
			throw new BusiException(GlobalConstraints.ErrorCode.REPEAT_LOGIN_NAME);
		}
		return 0;
	}


}
