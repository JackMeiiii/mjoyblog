package com.meihf.mjoyblog.test;

import com.meihf.mjoyblog.util.MarkdownUtil;


/**
 * @desc: ����һ�� markdown תHTML
 * @author ÷����
 */
public class TestMarkdown {
	
	public static void main(String[] args){
		StringBuilder sb = new StringBuilder();
		sb.append("# HJoyBlog\n"
				+ "ѧϰJava��������һ���򵥵��Ჩ��ϵͳ,˳�㵱�����ѵα�ҵ��� :)"
				+ "\n"
				+ "\n"
				+ "##��ɫ\n"
				+ "* SpringMVC\n"
				+ "* MongoDB\n"
				+ "* MarkDown\n"
				+ "* jQuery\n"
				+ "* Pure");
		String html = MarkdownUtil.parse(sb.toString());
		System.out.println(html);
	}
}
