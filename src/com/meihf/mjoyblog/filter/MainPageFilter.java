package com.meihf.mjoyblog.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpUtils;

import org.springframework.web.filter.OncePerRequestFilter;

public class MainPageFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain fc)
			throws ServletException, IOException {
			@SuppressWarnings("deprecation")
		 	CharSequence requestPath = HttpUtils.getRequestURL(request);
//			String[] paths = requestPath.toString().split("/");
			int last = requestPath.toString().lastIndexOf("main");
			String strPath = requestPath.toString().substring(last+4);
			request.setAttribute("subPath", strPath);
			request.getRequestDispatcher("/main").forward(request, response);
		}
	}
