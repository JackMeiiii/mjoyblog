package com.meihf.mjoyblog.bean;

/**
 * 封装一下页面配置信息
 * @author chenlu
 */
public class PageBean {
	private int page;
	private int size;
	
	private int startIndex;
	private int endIndex;
	
	
	public PageBean(int page, int size) {
		this.page = page;
		this.size = size;
		
		this.startIndex = ( page - 1 ) * size;
		this.endIndex = this.startIndex + size;
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

	public int getEndIndex() {
		return endIndex;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}
	
	
}
