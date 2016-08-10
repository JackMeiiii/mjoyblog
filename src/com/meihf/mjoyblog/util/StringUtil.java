package com.meihf.mjoyblog.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang.StringUtils;

import sun.misc.BASE64Encoder;

/**
 * @desc:�ַ���������  ��չ Apache StringUtils
 * @author ��Ԫ��
 */
public final class StringUtil extends StringUtils {
	
	private StringUtil() {};
	
	public static final String EMPTY_STR = "";

	/**
	 * @desc: �ж��ַ����Ƿ�Ϊ��,�հ��ַ�ҲΪ��
	 * @author: ��Ԫ��
	 * @param str
	 * @return
	 * @date  : 2016��1��7��
	 */
	public static boolean isRealEmpty(String str) {
		return str == null || str.trim().length() == 0;
	}

	/**
	 * @desc: ��MD5�����ַ���
	 * @author: ��Ԫ��
	 * @param str
	 * @return
	 * @date  : 2015��12��29��
	 */
	public static String encryptByMD5(String str) {
		if (StringUtil.isRealEmpty(str)) {
		     return str;
		}
		String retStr = null;
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("md5");
		} catch (NoSuchAlgorithmException e) {
			//������û��....���Ժ�����...
		}
		byte[] buf = md.digest(str.getBytes());
		BASE64Encoder encoder = new BASE64Encoder();
		retStr = encoder.encode(buf);
		return retStr;

	}
	
	/**
	 * @desc: ����Unicode�����������ж����ĺ���
	 * @author: ÷����
	 * @param c
	 * @return 
	 * @date  : 2016��3��31��
	 */
		private static boolean isChinese(char c) {
			Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
			if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
					|| ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
					|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
					|| ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
					|| ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
					|| ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
					|| ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
				return true;
			}
			return false;
		}
	
	/**
	 * @desc: �������ж����ĺ���
	 * @author: ÷����
	 * @param strName
	 * @return 
	 * @date  : 2016��3��31��
	 */
	public static boolean isChinese(String strName) {
		char[] ch = strName.toCharArray();
		for (int i = 0; i<ch.length; i++) {
			char c = ch[i];
			if (isChinese(c)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @desc: �ж��Ƿ���Ӣ��
	 * @author: ÷����
	 * @param word
	 * @return
	 * @date  : 2016��3��31��
	 */
	public static boolean isEnglish(String word) {  
        boolean sign = true;
        for (int i = 0; i < word.length(); i++) {  
            if (!(word.charAt(i) >= 'A' && word.charAt(i) <= 'Z')  
                    && !(word.charAt(i) >= 'a' && word.charAt(i) <= 'z')) {  
                return false;  
            }  
        }  
        return true;  
    }  
}
