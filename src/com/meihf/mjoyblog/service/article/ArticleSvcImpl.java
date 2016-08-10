package com.meihf.mjoyblog.service.article;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.meihf.mjoyblog.bean.Article;
import com.meihf.mjoyblog.bean.PageBean;
import com.meihf.mjoyblog.bean.PageRetInfo;
import com.meihf.mjoyblog.dao.ArticleDao;


public class ArticleSvcImpl implements IArticleSvc {

	@Autowired
    private ArticleDao articleDao;
	
	private static Log log = LogFactory.getLog(ArticleSvcImpl.class);
	
	@Override
	public void updateByArticleId(String articleId) {
		
	}

	@Override
	public List<Article> queryAllArticlesByCatalogId(String catalogId) {
		return articleDao.queryList(new Query().addCriteria(Criteria.where("catalogId").is(catalogId)));
	}

	@Override
	public void deleteByArticleId(String articleId) {
		articleDao.delete(new Query().addCriteria(Criteria.where("articleId").is(articleId)));
	}
	
	@Override
	public void addOrUpdateArticle(String catalogId,String articleContent,String articleTitle,Date updateDate) {
		Query query = new Query().addCriteria(Criteria.where("catalogId").is(catalogId).and("articleTitle").is(articleTitle));
		Update update = new Update();
		update.set("updateDate", updateDate);
		update.set("articleContent", articleContent);
		articleDao.updateInser(query, update);
	}

	@Override
	public void removeArticleByCatIdAndArtTit(String catalogId,
			String articleTitle) {
		articleDao.delete(new Query().addCriteria(Criteria.where("catalogId").is(catalogId).and("articleTitle").is(articleTitle)));
	}

	@Override
	public List<Article> queryAllArticles() {
		return articleDao.queryList(new Query().with(new Sort(Direction.ASC,
				"writeDate")));
	}

	@Override
	public Article queryArticleByPath(String articlePath) {
		return  articleDao.queryOne(new Query().addCriteria(Criteria.where("articlePath").is(articlePath)));
	}

	@Override
	public Article queryBycatIdAndArtT(String catalogId, String articleTitle) {
		return articleDao.queryOne(new Query().addCriteria(Criteria.where("articleTitle").is(articleTitle).and("catalogId").is(catalogId)));
	}

	@Override
	public void addArticle(Article art) {
		articleDao.save(art);
	}

	@Override
	public void deleteEssay(String articleId) {
		articleDao.delete(new Query(Criteria.where("articleId").is(articleId)));
	}

	@Override
	public PageRetInfo<Article> findByCondition(PageBean page, Object object,
			String keywords) {
		Query query = new Query();
		query.with(new Sort(Direction.ASC,"writeDate"));
		PageRetInfo<Article> retInfo = new PageRetInfo<Article>();
		retInfo.setTotal(articleDao.getPageUsedCount(query,2,keywords));
		retInfo.setRows(articleDao.getPage(query, page));
		log.debug(retInfo);
		return retInfo;
	}
}
