package com.meihf.mjoyblog.bean;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;

import com.meihf.mjoyblog.util.DateUtil;

/**
 * �û���
 * @author ÷����
 */
public class User {
	/** ��¼�� */
	@Id
	private String loginName;
	/** ��¼���� */
	private String loginPwd;
	/** �ǳ�--�������� */
	private String nickName;
	/** �ʼ� */
	private String email;
	/** �ֻ��� */
	private String tel;
	/** ��ɫ 0 - Administrator ; 1 - Guest */
	private short role;
	/**�Ա�  0--Ů  1--��*/
	private String sex;
	/** �������� */
	private Date createDate;
	/**��������תΪstr*/
	private String createDate2Str;
	/** ����¼���� */
	private Date lastLoginDate;
	/**����¼����תΪstr*/
	private String lastLoginDate2Str;
	/** �Զ���¼��IP��ַ */
	private String autoLoginIP;
	/** ��¼IP���� */
	private List<String> loginIPs;
	/** ����״̬ 0 - Del ; 1 - Used */
	private short isUsed;
	/**��������*/
	private Date bornDate;
	/**��������תΪstr*/
	private String bornDate2Str;
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBornDate() {
		return bornDate;
	}
	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPwd() {
		return loginPwd;
	}
	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public short getRole() {
		return role;
	}
	public void setRole(short role) {
		this.role = role;
	}
	public Date getCreateDate() {
		return createDate==null?null:(Date)createDate.clone();
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate==null?null:(Date)createDate.clone();
	}
	public Date getLastLoginDate() {
		return lastLoginDate==null?null:(Date)lastLoginDate.clone();
	}
	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate==null?null:(Date)lastLoginDate.clone();
	}
	public String getAutoLoginIP() {
		return autoLoginIP;
	}
	public void setAutoLoginIP(String autoLoginIP) {
		this.autoLoginIP = autoLoginIP;
	}
	public List<String> getLoginIPs() {
		return loginIPs;
	}
	public void setLoginIPs(List<String> loginIPs) {
		this.loginIPs = loginIPs;
	}
	public short getIsUsed() {
		return isUsed;
	}
	public void setIsUsed(short isUsed) {
		this.isUsed = isUsed;
	}
	public String getCreateDate2Str() {
		return createDate2Str;
	}
	public void setCreateDate2Str(String createDate2Str) {
		this.createDate2Str = createDate2Str;
	}
	public String getLastLoginDate2Str() {
		return lastLoginDate2Str;
	}
	public void setLastLoginDate2Str(String lastLoginDate2Str) {
		this.lastLoginDate2Str = lastLoginDate2Str;
	}
	public String getBornDate2Str() {
		return bornDate2Str;
	}
	public void setBornDate2Str(String bornDate2Str) {
		this.bornDate2Str = bornDate2Str;
	}
	
}
