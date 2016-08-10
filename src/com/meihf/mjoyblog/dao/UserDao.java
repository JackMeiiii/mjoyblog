package com.meihf.mjoyblog.dao;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;

import com.meihf.mjoyblog.bean.PageBean;
import com.meihf.mjoyblog.bean.User;


public class UserDao extends CommonDao<User> {

	@Override
	protected Class<User> getEntityClass() {
		return User.class;
	}
}
