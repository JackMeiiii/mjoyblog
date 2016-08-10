package com.meihf.mjoyblog.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpUtils;

import org.springframework.web.filter.OncePerRequestFilter;

public class CategoryFilter extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain fc)
			throws ServletException, IOException {
		@SuppressWarnings("deprecation")
	 	CharSequence requestPath = HttpUtils.getRequestURL(request);
		request.setAttribute("pathURL", requestPath.toString());
		request.getRequestDispatcher("/category").forward(request, response);		
	}

}
