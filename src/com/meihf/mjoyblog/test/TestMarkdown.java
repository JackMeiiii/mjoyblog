package com.meihf.mjoyblog.test;

import com.meihf.mjoyblog.util.MarkdownUtil;


/**
 * @desc: 测试一下 markdown 转HTML
 * @author 梅海风
 */
public class TestMarkdown {
	
	public static void main(String[] args){
		StringBuilder sb = new StringBuilder();
		sb.append("# HJoyBlog\n"
				+ "学习Java，尝试做一个简单的轻博客系统,顺便当做朋友滴毕业设计 :)"
				+ "\n"
				+ "\n"
				+ "##特色\n"
				+ "* SpringMVC\n"
				+ "* MongoDB\n"
				+ "* MarkDown\n"
				+ "* jQuery\n"
				+ "* Pure");
		String html = MarkdownUtil.parse(sb.toString());
		System.out.println(html);
	}
}
