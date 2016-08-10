package com.meihf.mjoyblog.service.user;

import com.meihf.mjoyblog.bean.PageBean;
import com.meihf.mjoyblog.bean.PageRetInfo;
import com.meihf.mjoyblog.bean.User;


/**
 * �û���ķ���
 * @author ��Ԫ��
 */
public interface IUserSvc {

	/**
	 * ���ݵ�¼���Ʋ�ѯ�û���Ϣ
	 * @param loginName
	 * @return
	 */
	User getUserInfoByLoginName(String loginName);
	
	/**
	 * ��֤����Ա��¼������
	 * @param loginName
	 * @param loginPwd
	 * @throws Exception
	 * @return
	 */
	User verifyAdminLogin(String loginName, String loginPwd) throws Exception;
	
	/**
	 * @desc: ��¼����IP��ַ
	 * @author: ��Ԫ��
	 * @param loginName
	 * @param loginIP
	 * @throws Exception
	 * @date  : 2016��1��12��
	 */
	void logLoginIP(String loginName, String loginIP) throws Exception;

	/**
	 * @desc: �Զ���¼
	 * @author: ��Ԫ��
	 * @param ip
	 * @return
	 * @date  : 2016��1��12��
	 */
	User autoLogin(String ip)  throws Exception;

	PageRetInfo<User> findByCondition(PageBean page, Object object,String email);

	void deleteUserById(String longinName);

	void addUser(String loginName, String loginPwd,String blog_name,String email);

	int findByByLoginName(String loginName,String loginPwd,String email,String blog_name) throws Exception;
}
