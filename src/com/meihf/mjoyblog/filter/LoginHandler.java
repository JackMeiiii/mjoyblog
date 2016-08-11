package com.meihf.mjoyblog.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.meihf.mjoyblog.util.GlobalConstraints;

public class LoginHandler implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("after");
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("postHandle");
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		System.out.println("≤‚ ‘÷Æ«∞");
		if(request.getSession().getAttribute(GlobalConstraints.SESSION_KEY_USER)!=null){
			return true;
		}
		response.sendRedirect(request.getContextPath()+"/admin/index.do");
		return false;
	}


}
