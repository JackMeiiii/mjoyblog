package com.meihf.mjoyblog.bean;

import java.util.Date;

import org.springframework.data.annotation.Id;

/**
 * Ŀ¼��
 * @author ÷����
 *
 */
public class Catalog {
	/*Ŀ¼��*/
	@Id
	private String catalogId;
	/*�Զ���URL*/
	private String catalogPath;
	/*Ȩ��*/
	private short permission;
	/*״̬*/
	private short state;
	/*����*/
	private Date createDate;
	/**����2Str*/
	private String createDate2Str;
	/*����*/
	private String categories;
	/**��������---Ҳ�����ݿ�����*/
	private String loginName;

	public String getCategories() {
		return categories;
	}

	public String getloginName() {
		return loginName;
	}

	public void setloginName(String loginName) {
		this.loginName = loginName;
	}

	public void setCategories(String categories) {
		this.categories = categories;
	}

	public String getCatalogPath() {
		return catalogPath;
	}

	public void setCatalogPath(String catalogPath) {
		this.catalogPath = catalogPath;
	}

	public short getPermission() {
		return permission;
	}

	public void setPermission(short permission) {
		this.permission = permission;
	}
	public String getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(String catalogId) {
		this.catalogId = catalogId;
	}

	public short getState() {
		return state;
	}

	public void setState(short state) {
		this.state = state;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateDate2Str() {
		return createDate2Str;
	}

	public void setCreateDate2Str(String createDate2Str) {
		this.createDate2Str = createDate2Str;
	}
}
