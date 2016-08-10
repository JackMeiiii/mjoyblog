package com.meihf.mjoyblog.util;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.markdown4j.Markdown4jProcessor;

/**
 * @desc: Markdown�Ľ�����
 * @author ��Ԫ��
 */
public final class MarkdownUtil {

	private MarkdownUtil() {}
	
	private final static Markdown4jProcessor parser;
	private final static Log log = LogFactory.getLog(MarkdownUtil.class);
	
	static {
		parser = new Markdown4jProcessor();
	}
	
	/**
	 * @desc: ��MarkdownתΪHTML
	 * @author: ��Ԫ��
	 * @param markdown
	 * @return
	 * @date  : 2016��1��14��
	 */
	public static String parse(String markdown) {
		if (StringUtil.isRealEmpty(markdown)) {
			return StringUtil.EMPTY_STR;
		}
		try {
			return parser.process(markdown);
		} catch (IOException e) {
			log.error("Markdown����ʧ�ܣ����ݣ�\n" + markdown,e);
			return StringUtil.EMPTY_STR;
		}
	}
}
