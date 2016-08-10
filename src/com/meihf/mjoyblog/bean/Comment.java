package com.meihf.mjoyblog.bean;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class Comment {

	/*����·��*/
	private String articlePath;
	/*�û���*/
	private String username;
	/*����*/
	private String email;
	/*�ص�*/
	private String site;
	/*��������*/
	private String content;
	/*ʱ��*/
	private Date commentDate;
	
	public String getArticlePath() {
		return articlePath;
	}
	public void setArticlePath(String articlePath) {
		this.articlePath = articlePath;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	@Override
	public String toString() {
		return "Comment [articlePath=" + articlePath + ", username=" + username
				+ ", email=" + email + ", site=" + site + ", content="
				+ content + ", commentDate=" + commentDate + "]";
	}
	
	
}
