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
 * @desc:��Ҫ���ܵĹ�����
 */
public final class SysUtils {

	private SysUtils() {};

	/**
	 * ��ȡҳ���ҳ��Ϣ,���û�����ṩһ��Ĭ�ϵ���Ϣ.
	 * @param request
	 * @return
	 */
	public static PageBean getPageInfo(HttpServletRequest request) {
		//��ҳ��Ϣ
		String page = request.getParameter("page");
		String rowsSize = request.getParameter("rows");
		int pageNo = 0;
		int pageSize = 10;
		try {
			pageSize = Integer.parseInt(rowsSize);
			pageNo = Integer.parseInt(page);
		} catch (NumberFormatException e) {
			//�����ʾû���� ����
		}
		
		PageBean info = new PageBean(pageNo, pageSize);
		return info;
	}
	
	
	/**
	 * ����Session�е�¼���û�ʵ��
	 * @param request
	 * @param user
	 */
	public static void setLoginedUser(HttpServletRequest request, User user) {
		request.getSession(true).setAttribute(GlobalConstraints.SESSION_KEY_USER, user);
	}
	
	/**
	 * ��Session�л�ȡ��¼���û�ʵ��
	 * @param request
	 * @return
	 */
	public static User getLoginedUser(HttpServletRequest request) {
		return (User) request.getSession(true).getAttribute(GlobalConstraints.SESSION_KEY_USER);
	}
	
	/**
	 * ����json
	 * @param response
	 * @param responseObject
	 */
	public static void returnJson(HttpServletResponse response,
			Object responseObject) {
		//��ʵ�����ת��ΪJSON Objectת��
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
	 * ����json
	 * @param response
	 * @param responseObject
	 */
	public static void returnJsonArray(HttpServletResponse response,
			Object responseObject) {
		//��ʵ�����ת��ΪJSON Objectת��
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
