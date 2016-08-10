package com.meihf.mjoyblog.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.meihf.mjoyblog.bean.Article;
import com.meihf.mjoyblog.bean.Catalog;
import com.meihf.mjoyblog.bean.Comment;
import com.meihf.mjoyblog.service.article.IArticleSvc;
import com.meihf.mjoyblog.service.catalog.ICatalogSvc;
import com.meihf.mjoyblog.service.comment.ICommentSvc;
import com.meihf.mjoyblog.service.sysparam.ISysParamSvc;
import com.meihf.mjoyblog.util.Base64Util;
import com.meihf.mjoyblog.util.DateUtil;
import com.meihf.mjoyblog.util.GlobalConstraints;
import com.meihf.mjoyblog.util.SessionUtil;
import com.meihf.mjoyblog.util.StringUtil;


@Controller
public class MainPageController {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private ISysParamSvc iSysParamSvc;
	@Autowired
	private IArticleSvc iArticleSvc;
	@Autowired
	private ICatalogSvc iCatalogSvc;
	@Autowired
	private ICommentSvc iCommentSvc;
	
	public ModelAndView toHomePage() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("hello", mongoTemplate.getDb());
		mv.setViewName("main");
		return mv;
	}
	
	@RequestMapping(value = "/main")
	public String queryByCatalogId(Comment comment,HttpServletRequest request,HttpServletResponse response) throws Exception {
		String path = (String) request.getAttribute("subPath");
		String paths[] = path.split("/");
		String catalogPath="";
		String articlePath="";
		List<Article> artList = new ArrayList<Article>();
		if(paths.length==2 && path.length()!=0){
			catalogPath = "/MJoyBlog/main"+path;
			List<Catalog> catList = new ArrayList<Catalog>();
			Catalog catalog = new Catalog();
			catList = iCatalogSvc.queryAllCatalog(GlobalConstraints.MY_LOGIN_NAME);
			catalog = iCatalogSvc.queryCatalogByCatalogPath(catalogPath);
			artList = iArticleSvc.queryAllArticlesByCatalogId(catalog
					.getCatalogId());
			request.setAttribute("catalogPath", catalogPath);
			request.setAttribute("catalogId", catalog.getCatalogId());
			request.setAttribute("createDate",
					DateUtil.format2Str(catalog.getCreateDate()));
			request.setAttribute("artList", artList);
			request.setAttribute("blog_name", GlobalConstraints.MY_BLOG_NAME);
			request.setAttribute("catList", catList);
			request.setAttribute("status", 1);
		}
		else if(paths.length==3 && path.length()!=0){
			articlePath = "/MJoyBlog/main"+path;
			if(comment.getContent()!=null){
				String content = new String(comment.getContent().getBytes("ISO-8859-1"),"utf-8");
				String username = new String(comment.getUsername().getBytes("ISO-8859-1"),"utf-8");
				String site = new String(comment.getSite().getBytes("ISO-8859-1"),"utf-8");
				comment.setArticlePath(articlePath);;
				comment.setCommentDate(DateUtil.getCurrDate());
				comment.setContent(content);
				comment.setSite(site);
				comment.setUsername(username);
				iCommentSvc.saveContent(comment);
			}
			Article article = new Article();
			List<Comment> comList = new ArrayList<Comment>();
			List<Map<String,Object>> comments = new ArrayList<Map<String,Object>>();
			comList = iCommentSvc.queryCommentsByarticle(articlePath);
			if(comList!=null){
				for(Comment com:comList){
					Map<String,Object> each = new LinkedHashMap<String, Object>();
					each.put("username",com.getUsername());
					each.put("content",com.getContent());
					comments.add(each);
				}
				request.setAttribute("comments", comments);
			}
			article =  iArticleSvc.queryArticleByPath(articlePath);
			request.setAttribute("articleContent", article.getArticleContent());
			request.setAttribute("createDate", article.getWriteDate2Str());
			request.setAttribute("articleTitle", article.getArticleTitle());
			request.setAttribute("articlePath", article.getArticlePath());
			request.setAttribute("status", 6);
			
		}
		return "main";
	}

	@RequestMapping(value = "/index.do")
	public String queryAll(HttpServletRequest request) throws Exception {
		String s = request.getParameter("s");
		String searchText;
//		String blog_name = iSysParamSvc
//				.getValueByCode(user.getNickName());
		List<Map<String, Object>> datas = new ArrayList<Map<String, Object>>();
		List<Catalog> catList = iCatalogSvc.queryAllCatalog(GlobalConstraints.MY_LOGIN_NAME);
		List<Article> artList = new ArrayList<Article>();
		if (s != null) {
			searchText = Base64Util.decode(s, "Unicode");
			for (Catalog catalog : catList) {
				artList = iArticleSvc.queryAllArticlesByCatalogId(catalog
						.getCatalogId());
				if (catalog.getCatalogId().contains(searchText)) {
					Map<String, Object> each = new HashMap<String, Object>();
					each.put("catalogId", catalog.getCatalogId());
					each.put("createDate",
							DateUtil.format2Str(catalog.getCreateDate()));
					each.put("catalogPath", catalog.getCatalogPath());
					each.put("articles", artList);
					datas.add(each);
				} else {
					for (Article article : artList) {
						if (article.getArticleContent().contains(searchText)
								|| article.getArticleTitle().contains(
										searchText)) {
							Map<String, Object> each = new HashMap<String, Object>();
							each.put("catalogId", catalog.getCatalogId());
							each.put("createDate", DateUtil.format2Str(catalog
									.getCreateDate()));
							each.put("catalogPath", catalog.getCatalogPath());
							each.put("articles", artList);
							datas.add(each);
						}
					}
				}
			}
			request.setAttribute("searchVal", searchText);
			request.setAttribute("datas", datas);
			request.setAttribute("status", 2);
			request.setAttribute("selected", "search");
		} else if(catList.size()!=0){
			for (Catalog catalog : catList) {
				Map<String, Object> each = new HashMap<String, Object>();
				artList = iArticleSvc.queryAllArticlesByCatalogId(catalog
						.getCatalogId());
				each.put("catalogId", catalog.getCatalogId());
				each.put("createDate",
						DateUtil.format2Str(catalog.getCreateDate()));
				each.put("catalogPath", catalog.getCatalogPath());
				each.put("articles", artList);
				datas.add(each);
			}
			request.setAttribute("datas", datas);
			request.setAttribute("status", 0);
		}
		else{
			request.setAttribute("date", DateUtil.getCurrentDay());
			request.setAttribute("status", 5);
		}
		if(SessionUtil.isLogined(request)){
			request.setAttribute("isLogined", 1);
		}
		request.setAttribute("catList", catList);
		request.setAttribute("blog_name", GlobalConstraints.MY_BLOG_NAME);
		return "main";
	}
	
	@RequestMapping("/category")
	public String category(HttpServletRequest request) throws Exception{
		String getPath = (String) request.getAttribute("pathURL");
		String categories = getPath.substring(getPath.toString().lastIndexOf("category")+9);
		if(!StringUtil.isEnglish(categories)){
			categories = Base64Util.decode(categories, "Unicode");
		}
		List<Article> artList = new ArrayList<Article>();
		List<Catalog> newCatList = iCatalogSvc.queryAllByCatalogCategories(categories);
		List<Catalog> catList = iCatalogSvc.queryAllCatalog(GlobalConstraints.MY_LOGIN_NAME);
		List<Map<String, Object>> datas = new ArrayList<Map<String, Object>>();
		for (Catalog catalog : newCatList) {
			Map<String, Object> each = new HashMap<String, Object>();
			artList = iArticleSvc.queryAllArticlesByCatalogId(catalog
					.getCatalogId());
			each.put("catalogId", catalog.getCatalogId());
			each.put("createDate",
					DateUtil.format2Str(catalog.getCreateDate()));
			each.put("catalogPath", catalog.getCatalogPath());
			each.put("articles", artList);
			datas.add(each);
		}
		request.setAttribute("searchVal", categories);
		request.setAttribute("datas", datas);
		request.setAttribute("catList", catList);
		request.setAttribute("blog_name", GlobalConstraints.MY_BLOG_NAME);
		request.setAttribute("selected", "categories");
		return "category";
	}
	@RequestMapping("/categories")
	public String categories(HttpServletRequest request) throws Exception {
		List<Catalog> catList = iCatalogSvc.queryAllCatalog(GlobalConstraints.MY_LOGIN_NAME);
		Map<String,Object> datas = new LinkedHashMap<String, Object>();
		String category="";
		String getCategory="";
		String[] categories;
		int count=0;
		for(Catalog catalog:catList){
			getCategory = catalog.getCategories();
			if(category==""||!category.contains(getCategory)){
				category += getCategory+"+";
			}
		}
		
		categories = category.split("[+]");
		for(String categ:categories){
			count = iCatalogSvc.queryAllByCatalogCategories(categ).size();
		    datas.put(categ,count);
		}
		request.setAttribute("catList", catList);
		request.setAttribute("datas", datas);
		request.setAttribute("blog_name", GlobalConstraints.MY_BLOG_NAME);
		request.setAttribute("selected", "categories");
		return "categories";
	}

	@RequestMapping("/archive")
	public String archive(HttpServletRequest request) throws Exception {
		Map<String, List<Map<String, Object>>> datas = new LinkedHashMap<String, List<Map<String,Object>>>();
		List<Map<String, Object>> cataData = new ArrayList<Map<String, Object>>();
		List<Catalog> catList = new ArrayList<Catalog>();
		catList = iCatalogSvc.queryAllCatalog(GlobalConstraints.MY_LOGIN_NAME);
		String year = "";
		String getYear = "";
		String[] years;
		String createDate = "";
		for (Catalog catalog : catList) {
			createDate = DateUtil.format2Str(catalog.getCreateDate());
			getYear = createDate.split("-")[0];
			if (year == ""||!year.contains(getYear)) {
				year += getYear + "+";
			}
		}
		years = year.split("[+]");
		for (String yea : years) {
			for (Catalog catalog : catList) {
				Map<String, Object> catInfo = new HashMap<String, Object>();
				createDate = DateUtil.format2Str(catalog.getCreateDate());
				if (createDate.contains(yea)) {
					catInfo.put("createDate", createDate);
					catInfo.put("catalogId", catalog.getCatalogId());
					catInfo.put("catalogPath", catalog.getCatalogPath());
					cataData.add(catInfo);
				}
			}
			datas.put(yea, cataData);
		}
		request.setAttribute("datas", datas);
		request.setAttribute("catList", catList);
		request.setAttribute("blog_name", GlobalConstraints.MY_BLOG_NAME);
		request.setAttribute("selected", "archive");
		return "archive";
	}
}
