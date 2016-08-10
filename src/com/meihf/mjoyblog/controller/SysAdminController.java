package com.meihf.mjoyblog.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.meihf.mjoyblog.bean.Article;
import com.meihf.mjoyblog.bean.Catalog;
import com.meihf.mjoyblog.bean.PageBean;
import com.meihf.mjoyblog.bean.PageRetInfo;
import com.meihf.mjoyblog.bean.User;
import com.meihf.mjoyblog.service.article.IArticleSvc;
import com.meihf.mjoyblog.service.catalog.ICatalogSvc;
import com.meihf.mjoyblog.service.sysparam.ISysParamSvc;
import com.meihf.mjoyblog.service.user.IUserSvc;
import com.meihf.mjoyblog.util.Base64Util;
import com.meihf.mjoyblog.util.DateUtil;
import com.meihf.mjoyblog.util.GlobalConstraints;
import com.meihf.mjoyblog.util.MarkdownUtil;
import com.meihf.mjoyblog.util.PinyinUtil;
import com.meihf.mjoyblog.util.SessionUtil;
import com.meihf.mjoyblog.util.StringUtil;
import com.meihf.mjoyblog.util.SysUtils;


/**
 * 后台管理页面
 * @author meihf
 */
@Controller
@RequestMapping("/admin")
public class SysAdminController {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private IUserSvc userSvc;
	
	@Autowired
	private ISysParamSvc sysParamSvc;
	
	@Autowired
	private ICatalogSvc iCatalogSvc;
	
	@Autowired
	private IArticleSvc iArticleSvc;
	
	private static final Logger LOGGER = Logger.getLogger(SysAdminController.class); 
	
	/**
	 * @desc: 跳转至登录页面
	 * @author: 梅海风
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 * @date  : 2016年1月11日
	 */
	@RequestMapping(value = "/index.do")
	public String toLogin(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		Cookie[] cookies = request.getCookies();
		
		if (cookies != null && cookies.length > 0) {
			for (Cookie c : cookies) {
				if (GlobalConstraints.COOKIE_KEY_AUTO_LOGIN.equals(c.getName())
						&& GlobalConstraints.COOKIE_VALUE_AUTO_LOGIN.equals(c.getValue())) {
					String ip = SessionUtil.getIpAddress(request);
					User user = userSvc.autoLogin(ip);
					return loginSuccess(request, user);
				}
			}
		}
		
		request.setAttribute("loginName", request.getParameter("loginName"));
		request.setAttribute("loginPwd", request.getParameter("loginPwd"));
		request.setAttribute("errorMsg", request.getParameter("errorMsg"));
		
		return "/admin/login";
    }
	
	/**
	 * @desc: 请求登录 
	 * @author: 梅海风
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @date  : 2016年1月11日
	 */
	@RequestMapping(value = "/login.do")
	public String login(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		//获取参数
		String loginName = request.getParameter("loginName");
		String loginPwd = request.getParameter("loginPwd");
		String autoLogin = request.getParameter("autoLogin");
		String loginIP = SessionUtil.getIpAddress(request);
		
		//校验密码
		User user = userSvc.verifyAdminLogin(loginName, loginPwd);
		
		GlobalConstraints.MY_BLOG_NAME = user.getNickName();
		GlobalConstraints.MY_LOGIN_NAME = user.getLoginName();
		//记录自动登录IP
		if (!StringUtil.isRealEmpty(autoLogin) && "true".equals(autoLogin)) {
			Cookie c= new Cookie(GlobalConstraints.COOKIE_KEY_AUTO_LOGIN,
					GlobalConstraints.COOKIE_VALUE_AUTO_LOGIN);
			c.setPath("/");
			c.setMaxAge(60 * 60 * 24);
			response.addCookie(c);
			userSvc.logLoginIP(loginName, loginIP);
		}
		
		return loginSuccess(request, user);
    }

	/**
	 * @desc: 登录成功 页面重定向
	 * @author: 梅海风
	 * @param request
	 * @param user
	 * @return
	 * @throws Exception 
	 * @date  : 2016年1月12日
	 */
	private String loginSuccess(HttpServletRequest request, User user) throws Exception {
		//用户名密码校验成功,销毁Session重建,防止Session劫持
		request.getSession().invalidate();
		request.getSession(true).setAttribute(GlobalConstraints.SESSION_KEY_USER, user);
		if(user.getRole()==0){
			return "redirect:/admin/settings.do";
		}else{
			return "redirect:/index.do";
		}
	}
	
	/**
	 * @desc: 后台首页
	 * @author: 梅海风
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 * @date  : 2016年1月11日
	 */
	@RequestMapping(value = "/settings.do")
	public String settings(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		String blog_name = GlobalConstraints.MY_BLOG_NAME;
		request.setAttribute("blog_name", blog_name);
		return "/admin/admin";
	}
	
	@RequestMapping(value="/sign.do")
	public String sign(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String loginName = request.getParameter("loginName");
		String loginPwd = request.getParameter("loginPwd");
		String email = request.getParameter("email");
		String blogName = request.getParameter("nickName");
		if(loginName==null){
			return "/admin/sign";
		}
		int i = userSvc.findByByLoginName(loginName,loginPwd,email,blogName);
		if(i!=0){
			return "/admin/sign";
		}
		else{
			GlobalConstraints.MY_BLOG_NAME = blogName;
			GlobalConstraints.MY_LOGIN_NAME = loginName;
			userSvc.addUser(loginName,loginPwd,blogName,email);
			request.setAttribute("blog_name", blogName);
			request.setAttribute("status", 5);
			return "redirect:/index.do";
		}
	}
	

	@RequestMapping(value="/mains")
	public void getContentBycatIdAndArtT(HttpServletRequest request,HttpServletResponse response,String catalogId,String articleTitle){
		Article art = iArticleSvc.queryBycatIdAndArtT(Base64Util.decode(catalogId, "Unicode"),articleTitle);
		String artt = art.getArticleTitle();
		String artct = art.getArticleContent();
		StringBuilder xmlResult = new StringBuilder();
		xmlResult.append("<root>");
		xmlResult.append("<artt>"+artt+"</artt>");
		xmlResult.append("<artct>"+artct+"</artct>");
		xmlResult.append("</root>");
		try {
			response.setContentType("text/xml;charset=UTF-8");
			response.getWriter().write(xmlResult.toString());
		} catch (IOException e) {
			LOGGER.error("错误信息"+e.getMessage());
		}
	}
	
	@RequestMapping(value="/editor")
	public String editor2(HttpServletRequest request,HttpServletResponse response){
		String catalogId = Base64Util.decode(request.getParameter("catalogId"), "Unicode");
		
		List<Article> artList = new ArrayList<Article>();
		List<Map<String,Object>> adatas = new ArrayList<Map<String,Object>>();
		artList = iArticleSvc.queryAllArticlesByCatalogId(catalogId);
		String articleTitle="";
		String articlePath = "";
		String articleContent = "";
		for(Article art:artList){
			Map<String, Object> map = new LinkedHashMap<String, Object>();
			articleTitle = art.getArticleTitle();
			articlePath = art.getArticlePath();
			articleContent = art.getArticleContent();
			map.put("articleTitle", articleTitle);
			map.put("articlePath", articlePath);
			map.put(articleTitle, articleContent);
			adatas.add(map);
		}
		List<Catalog> catList = new ArrayList<Catalog>();
		List<Map<String,Object>> cdatas = new ArrayList<Map<String,Object>>();
		catList = iCatalogSvc.queryAllCatalog(GlobalConstraints.MY_LOGIN_NAME);
		String catId="";
		for(Catalog cat:catList){
			catId = cat.getCatalogId();
			Map<String,Object> map = new LinkedHashMap<String, Object>();
			map.put("catalogId", catId);
			cdatas.add(map);
		}
		String nowTimes = DateUtil.getNowTime();
		String nowTime = DateUtil.getCurrentDay();
		request.setAttribute("adatas", adatas);
		request.setAttribute("cdatas", cdatas);
		request.setAttribute("nowTime", nowTime);
		request.setAttribute("nowTimes", nowTimes);
		return "/admin/editor";
	}
	
	@RequestMapping(value ="/editor.do")
	public String editor(HttpServletRequest request,HttpServletResponse response){
		List<Catalog> catList = new ArrayList<Catalog>();
		List<Map<String,Object>> cdatas = new ArrayList<Map<String,Object>>();
		catList = iCatalogSvc.queryAllCatalog(GlobalConstraints.MY_LOGIN_NAME);
		String catId="";
		for(Catalog cat:catList){
			catId = cat.getCatalogId();
			System.out.println(catId);
			Map<String,Object> map = new LinkedHashMap<String, Object>();
			map.put("catalogId", catId);
			cdatas.add(map);
		}
		String nowTimes = DateUtil.getNowTime();
		String nowTime = DateUtil.getCurrentDay();
		request.setAttribute("cdatas", cdatas);
		request.setAttribute("nowTime", nowTime);
		request.setAttribute("nowTimes", nowTimes);
		return "/admin/editor";
	} 
	
	@RequestMapping(value="/removeCatalog")
	public void removeCatalog(HttpServletRequest request,HttpServletResponse response,String catalogId){
		iCatalogSvc.removeByCatalogId(catalogId);
	}
	
	@RequestMapping(value="/removeArticle")
	public void removeArticle(HttpServletRequest request,HttpServletResponse response,String catalogId,String articleTitle){
		iArticleSvc.removeArticleByCatIdAndArtTit(Base64Util.decode(catalogId, "Unicode"),articleTitle);
		
	}
	
	@RequestMapping(value="/addCatalog")
	public void addCatalog(HttpServletRequest request,HttpServletResponse response,String catalogId,String categories){
		Catalog catalog = new Catalog();
		catalog.setCatalogId(catalogId);
		catalog.setCatalogPath("/MJoyBlog/main/"+PinyinUtil.cn2Spell(catalogId));
		catalog.setCategories(categories);
		catalog.setCreateDate(DateUtil.getCurrDate());
		catalog.setPermission((short) 2);
		catalog.setState((short) 2);
		catalog.setloginName(GlobalConstraints.MY_LOGIN_NAME);
		iCatalogSvc.addCatalog(catalog);
	}
	
	@RequestMapping(value="/updateCatalog")
	public void updateCatalog(HttpServletRequest request,HttpServletResponse response,String catalogId){
		iCatalogSvc.updateCatalog(catalogId);
	}
	
	@RequestMapping(value="/addArticle")
	public void addArticle(HttpServletRequest req,HttpServletResponse rep){
		Article art = new Article();
		String articleContent =  req.getParameter("articleContent");
		String articleTitle = req.getParameter("articleTitle");
		String catalogId = req.getParameter("catalogId");
		try{
			art = iArticleSvc.queryBycatIdAndArtT(catalogId, articleTitle);
		}catch(Exception e){
			LOGGER.error("查询为空"+e.getMessage());
		}
		if(art!=null){
			iArticleSvc.addOrUpdateArticle(catalogId,articleContent, articleTitle,DateUtil.getCurrDate());
		}
		else{
			Article arti = new Article();
			arti.setArticlePath("/MJoyBlog/main/"+PinyinUtil.cn2Spell(catalogId)+"/"+PinyinUtil.cn2Spell(articleTitle));
			arti.setArticleContent(MarkdownUtil.parse(articleContent));
			arti.setArticleTitle(articleTitle);
			arti.setCatalogId(catalogId);
			arti.setLimit((short) 2);
			arti.setScanNumber((long) 0);
			arti.setWriteDate(DateUtil.getCurrDate());
			arti.setWriteDate2Str(DateUtil.format2Str(DateUtil.getCurrDate()));
			arti.setArticleId(getArticleId());
			iArticleSvc.addArticle(arti);
		}
	}
	
	public String getArticleId(){
		int next = 0;
		int len = 0;
		int max = 0;
		List<Article> artList = new ArrayList<Article>();
		try{
			artList = iArticleSvc.queryAllArticles();
			len = artList.size();
		}catch(Exception e){
			LOGGER.error("错误信息"+e);
		}
		if(len!=0){
			max = Integer.valueOf(artList.get(0).getArticleId());
			for(int i =0;i<len;i++){
				next = Integer.valueOf(artList.get(i).getArticleId());
				if(max<=next){
					max = next;
				}
			}
			max += 1;
		}
		return String.valueOf(max);
	}
	
	@RequestMapping(value="/updateArticle")
	public void updateArticle(HttpServletRequest req,HttpServletResponse rep){
		
	}
	
	@RequestMapping("userInfo")
	public String userInfo(){
		return "admin/adminusersearch";
	}
	
	@RequestMapping("userDelete")
	public String userSearch(){
		return "admin/adminuserdelete";
	}
	
	@RequestMapping("essayInfo")
	public String essayInfo(){
		return "admin/adminessaysearch";
	}
	
	@RequestMapping("essayDelete")
	public String essayDelete(){
		return "admin/adminessaydelete";
	}
	
	@RequestMapping("findBlogUserList")
	public void findBlogUserList(HttpServletRequest request, HttpServletResponse response,String email){
			PageBean page = SysUtils.getPageInfo(request);
			PageRetInfo<User> retInfo = userSvc.findByCondition(page, null,email);
			SysUtils.returnJson(response, retInfo);
	}
	
	@RequestMapping("deleteUserById")
	public void deleteUserById(HttpServletRequest request,HttpServletResponse response,String loginName){
		userSvc.deleteUserById(loginName);
	}
	
	@RequestMapping("findBlogEssayByKeywords")
	public void findBlogEssayList(HttpServletRequest request, HttpServletResponse response,String keywords){
		PageBean page = SysUtils.getPageInfo(request);
		PageRetInfo<Article> retInfo = iArticleSvc.findByCondition(page,null,keywords);
		SysUtils.returnJson(response, retInfo);
}
	
	@RequestMapping("deleteBlogEssay")
	public void deleteBlogEssay(String articleId,HttpServletResponse response,HttpServletRequest request){
		iArticleSvc.deleteEssay(articleId);
	}

}
