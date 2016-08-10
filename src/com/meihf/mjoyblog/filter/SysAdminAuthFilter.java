package com.meihf.mjoyblog.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import com.meihf.mjoyblog.util.GlobalConstraints;
import com.meihf.mjoyblog.util.SessionUtil;


/**
 * @desc:后台登录权限校验
 * @author 梅海风
 */
public class SysAdminAuthFilter extends OncePerRequestFilter{

	private static Log LOGGER = LogFactory.getLog(SysAdminAuthFilter.class);
	
	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		if (isToLogin(request) || SessionUtil.isLogined(request) || isToSign(request)) {
			filterChain.doFilter(request, response);
		} else {
			LOGGER.info("管理员未登录，跳转至登录页面...");
			response.sendRedirect(request.getContextPath() + GlobalConstraints.REQUEST_URL.TOLOGIN);
		}
	}

	/**
	 * @desc: 校验是否是跳转登录页面或者是登陆请求
	 * @author: 梅海风
	 * @param request
	 * @return
	 * @date  : 2016年1月12日
	 */
	private boolean isToLogin(HttpServletRequest request) {
		return (request.getContextPath() + GlobalConstraints.REQUEST_URL.TOLOGIN).equals(request.getRequestURI())
				|| (request.getContextPath() + GlobalConstraints.REQUEST_URL.LOGIN).equals(request.getRequestURI());
	}

	private boolean isToSign(HttpServletRequest request){
		return (request.getContextPath() + GlobalConstraints.REQUEST_URL.SIGN).equals(request.getRequestURI())
				|| (request.getContextPath() + GlobalConstraints.REQUEST_URL.TOSIGN).equals(request.getRequestURI());
	}
}