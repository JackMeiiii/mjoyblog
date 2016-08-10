package com.meihf.mjoyblog.service.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.meihf.mjoyblog.bean.Comment;
import com.meihf.mjoyblog.dao.CommentDao;


public class CommentSvcImpl implements ICommentSvc {
	
	@Autowired
	private CommentDao commentDao;
	@Override
	public void saveContent(Comment comment) {
		commentDao.save(comment);
	}
	@Override
	public List<Comment> queryCommentsByarticle(String articlePath) {
		return commentDao.queryList(new Query().addCriteria(Criteria.where("articlePath").is(articlePath)));
	}

}
