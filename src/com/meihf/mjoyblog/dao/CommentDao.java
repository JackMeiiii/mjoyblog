package com.meihf.mjoyblog.dao;

import com.meihf.mjoyblog.bean.Comment;


public class CommentDao extends CommonDao<Comment> {

	@Override
	protected Class<Comment> getEntityClass() {
		return Comment.class;
	}

}
