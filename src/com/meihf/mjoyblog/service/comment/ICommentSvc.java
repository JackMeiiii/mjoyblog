package com.meihf.mjoyblog.service.comment;

import java.util.List;

import com.meihf.mjoyblog.bean.Comment;

/**
 * @desc:  评论接口
 * @author 梅海风
 */
public interface ICommentSvc {
	public void saveContent(Comment comment);

	public List<Comment> queryCommentsByarticle(String catalogPath);
}
