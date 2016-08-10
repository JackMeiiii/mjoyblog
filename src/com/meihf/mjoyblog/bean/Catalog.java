package com.meihf.mjoyblog.bean;

import java.util.Date;

import org.springframework.data.annotation.Id;

/**
 * 目录表
 * @author 梅海风
 *
 */
public class Catalog {
	/*目录名*/
	@Id
	private String catalogId;
	/*自定义URL*/
	private String catalogPath;
	/*权限*/
	private short permission;
	/*状态*/
	private short state;
	/*日期*/
	private Date createDate;
	/**日期2Str*/
	private String createDate2Str;
	/*分类*/
	private String categories;
	/**博客名称---也是数据库名称*/
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
