package com.meihf.mjoyblog.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.meihf.mjoyblog.util.GlobalConstraints;


/**
 * @desc:全局异常处理信息
 * @author 梅海风
 */
public class MJoyBlogExceptionHandler implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception e) {
		ModelAndView mv = null;
		if (e instanceof BusiException) {
			BusiException busiEx = (BusiException)e;
			switch (busiEx.getErrorCode()) {
			case (GlobalConstraints.ErrorCode.EMPTY_NAME_OR_PWD) :
				mv = new ModelAndView();
				mv.addObject("loginName", request.getParameter("loginName"));
				mv.addObject("loginPwd", request.getParameter("loginPwd"));
				mv.addObject("errorMsg", busiEx.getMessage());
				mv.setViewName("/admin/login");
			break;
			case (GlobalConstraints.ErrorCode.WRONG_NAME_OR_PWD) :
				mv = new ModelAndView();
				mv.addObject("loginName", request.getParameter("loginName"));
				mv.addObject("loginPwd", request.getParameter("loginPwd"));
				mv.addObject("errorMsg", busiEx.getMessage());
				mv.setViewName("/admin/login");
			break;
			case (GlobalConstraints.ErrorCode.AUTO_LOGIN_FAILD) :
				mv = new ModelAndView();
				mv.addObject("loginName", request.getParameter("loginName"));
				mv.addObject("loginPwd", request.getParameter("loginPwd"));
				mv.addObject("errorMsg", busiEx.getMessage());
				mv.setViewName("/admin/login");
				break;
			case (GlobalConstraints.ErrorCode.NOT_EXSIT_DATA):		
				 				mv=new ModelAndView();		
				 			    mv.addObject("errorMsg",busiEx.getMessage());		
				 			    mv.setViewName("/admin/setting");		
				 			    break;
			case (GlobalConstraints.ErrorCode.REPEAT_LOGIN_NAME):
								mv=new ModelAndView();
								mv.addObject("errorMsg",busiEx.getMessage());
								mv.setViewName("/admin/sign");
			case (GlobalConstraints.ErrorCode.EMPTY_NEW_SIGN):
								mv=new ModelAndView();
								mv.addObject("errorMsg",busiEx.getMessage());
								mv.setViewName("/admin/sign");
			default :
				break;
			}
		}
		return mv;
	}

}
