package com.meihf.mjoyblog.service.comment;

import java.util.List;

import com.meihf.mjoyblog.bean.Comment;

/**
 * @desc:  ���۽ӿ�
 * @author ÷����
 */
public interface ICommentSvc {
	public void saveContent(Comment comment);

	public List<Comment> queryCommentsByarticle(String catalogPath);
}
