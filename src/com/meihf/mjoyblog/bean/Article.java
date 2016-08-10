package com.meihf.mjoyblog.bean;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class Article {

	/*文章Id*/
	@Id
	private String articleId;
	/*对应目录Id*/
	private String catalogId;
	/*自定义URL*/
	private String articlePath;
	/*标题*/
	private String articleTitle;
	/*内容*/
	private String articleContent;
	/*时间*/
	private Date writeDate;
	/*修改时间*/
	private Date updateDate;
	/*权限*/
	private short limit;
	/*浏览数量*/
	private Long scanNumber;
	/**抒写时间2str*/
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
