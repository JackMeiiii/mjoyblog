package com.meihf.mjoyblog.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.meihf.mjoyblog.bean.PageBean;
import com.meihf.mjoyblog.bean.User;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @desc:主要功能的工具类
 */
public final class SysUtils {

	private SysUtils() {};

	/**
	 * 获取页面分页信息,如果没传会提供一个默认的信息.
	 * @param request
	 * @return
	 */
	public static PageBean getPageInfo(HttpServletRequest request) {
		//分页信息
		String page = request.getParameter("page");
		String rowsSize = request.getParameter("rows");
		int pageNo = 0;
		int pageSize = 10;
		try {
			pageSize = Integer.parseInt(rowsSize);
			pageNo = Integer.parseInt(page);
		} catch (NumberFormatException e) {
			//报错表示没传参 无视
		}
		
		PageBean info = new PageBean(pageNo, pageSize);
		return info;
	}
	
	
	/**
	 * 设置Session中登录的用户实体
	 * @param request
	 * @param user
	 */
	public static void setLoginedUser(HttpServletRequest request, User user) {
		request.getSession(true).setAttribute(GlobalConstraints.SESSION_KEY_USER, user);
	}
	
	/**
	 * 从Session中获取登录的用户实体
	 * @param request
	 * @return
	 */
	public static User getLoginedUser(HttpServletRequest request) {
		return (User) request.getSession(true).getAttribute(GlobalConstraints.SESSION_KEY_USER);
	}
	
	/**
	 * 返回json
	 * @param response
	 * @param responseObject
	 */
	public static void returnJson(HttpServletResponse response,
			Object responseObject) {
		//将实体对象转换为JSON Object转换
		JSONObject responseJSONObject = JSONObject.fromObject(responseObject);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.append(responseJSONObject.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
	
	/**
	 * 返回json
	 * @param response
	 * @param responseObject
	 */
	public static void returnJsonArray(HttpServletResponse response,
			Object responseObject) {
		//将实体对象转换为JSON Object转换
		JSONArray responseJSONObject = JSONArray.fromObject(responseObject);
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.append(responseJSONObject.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
}
