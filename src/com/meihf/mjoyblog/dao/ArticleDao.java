package com.meihf.mjoyblog.dao;

import com.meihf.mjoyblog.bean.Article;


public class ArticleDao extends CommonDao<Article> {

	@Override
	protected Class<Article> getEntityClass() {
		return Article.class;
	}

}
