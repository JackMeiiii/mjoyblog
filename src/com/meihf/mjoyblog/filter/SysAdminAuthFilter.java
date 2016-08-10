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
 * @desc:��̨��¼Ȩ��У��
 * @author ÷����
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
			LOGGER.info("����Աδ��¼����ת����¼ҳ��...");
			response.sendRedirect(request.getContextPath() + GlobalConstraints.REQUEST_URL.TOLOGIN);
		}
	}

	/**
	 * @desc: У���Ƿ�����ת��¼ҳ������ǵ�½����
	 * @author: ÷����
	 * @param request
	 * @return
	 * @date  : 2016��1��12��
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