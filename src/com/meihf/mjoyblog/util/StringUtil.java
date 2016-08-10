package com.meihf.mjoyblog.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang.StringUtils;

import sun.misc.BASE64Encoder;

/**
 * @desc:字符串工具类  扩展 Apache StringUtils
 * @author 韩元旭
 */
public final class StringUtil extends StringUtils {
	
	private StringUtil() {};
	
	public static final String EMPTY_STR = "";

	/**
	 * @desc: 判断字符串是否为空,空白字符也为空
	 * @author: 韩元旭
	 * @param str
	 * @return
	 * @date  : 2016年1月7日
	 */
	public static boolean isRealEmpty(String str) {
		return str == null || str.trim().length() == 0;
	}

	/**
	 * @desc: 用MD5加密字符串
	 * @author: 韩元旭
	 * @param str
	 * @return
	 * @date  : 2015年12月29日
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
			//不可能没有....所以忽略了...
		}
		byte[] buf = md.digest(str.getBytes());
		BASE64Encoder encoder = new BASE64Encoder();
		retStr = encoder.encode(buf);
		return retStr;

	}
	
	/**
	 * @desc: 根据Unicode编码完美的判断中文汉字
	 * @author: 梅海风
	 * @param c
	 * @return 
	 * @date  : 2016年3月31日
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
	 * @desc: 完整的判断中文汉字
	 * @author: 梅海风
	 * @param strName
	 * @return 
	 * @date  : 2016年3月31日
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
	 * @desc: 判断是否是英文
	 * @author: 梅海风
	 * @param word
	 * @return
	 * @date  : 2016年3月31日
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
