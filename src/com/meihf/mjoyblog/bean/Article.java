package com.meihf.mjoyblog.bean;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class Article {

	/*����Id*/
	@Id
	private String articleId;
	/*��ӦĿ¼Id*/
	private String catalogId;
	/*�Զ���URL*/
	private String articlePath;
	/*����*/
	private String articleTitle;
	/*����*/
	private String articleContent;
	/*ʱ��*/
	private Date writeDate;
	/*�޸�ʱ��*/
	private Date updateDate;
	/*Ȩ��*/
	private short limit;
	/*�������*/
	private Long scanNumber;
	/**��дʱ��2str*/
	private String writeDate2Str;
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public String getArticleId() {
		return articleId;
	}
	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	public String getCatalogId() {
		return catalogId;
	}
	public void setCatalogId(String catalogId) {
		this.catalogId = catalogId;
	}
	public String getArticlePath() {
		return articlePath;
	}
	public void setArticlePath(String articlePath) {
		this.articlePath = articlePath;
	}
	public String getArticleTitle() {
		return articleTitle;
	}
	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}
	public String getArticleContent() {
		return articleContent;
	}
	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public short getLimit() {
		return limit;
	}
	public void setLimit(short limit) {
		this.limit = limit;
	}
	public Long getScanNumber() {
		return scanNumber;
	}
	public void setScanNumber(Long scanNumber) {
		this.scanNumber = scanNumber;
	}
	public String getWriteDate2Str() {
		return writeDate2Str;
	}
	public void setWriteDate2Str(String writeDate2Str) {
		this.writeDate2Str = writeDate2Str;
	}
	
	
}
