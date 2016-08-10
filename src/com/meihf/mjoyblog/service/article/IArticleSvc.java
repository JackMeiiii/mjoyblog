package com.meihf.mjoyblog.service.article;

import java.util.Date;
import java.util.List;

import com.meihf.mjoyblog.bean.Article;
import com.meihf.mjoyblog.bean.PageBean;
import com.meihf.mjoyblog.bean.PageRetInfo;


public interface IArticleSvc {

	public void updateByArticleId(String articleId);
	
	public List<Article> queryAllArticlesByCatalogId(String catalogId);
	
	public void deleteByArticleId(String articleId);
	
	public void addOrUpdateArticle(String catalogId,String articleContent,String articleTitle,Date updateDate);

	public void removeArticleByCatIdAndArtTit(String catalogId,
			String articleTitle);

	public List<Article> queryAllArticles();

	public Article queryArticleByPath(String articlePath);

	public Article queryBycatIdAndArtT(String catalogId, String articleTitle);

	public void addArticle(Article art);

	public void deleteEssay(String articleId);

	public PageRetInfo<Article> findByCondition(PageBean page, Object object,
			String keywords);
}
