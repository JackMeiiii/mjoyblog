package com.meihf.mjoyblog.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @desc:��Session�йصĹ�����
 * @author ÷����
 */
public final class SessionUtil {

	private SessionUtil() {};
	
	/**
	 * @desc: ����Ա�Ƿ��¼
	 * @author: ÷����
	 * @param request
	 * @return
	 * @date  : 2015��12��30��
	 */
	public static boolean isLogined (HttpServletRequest request) {
		//��У��
		if (request == null || request.getSession() == null) {
			return false;
		}
		return request.getSession().getAttribute(GlobalConstraints.SESSION_KEY_USER)!=null;
	}
	
	/**
	 * @desc: ��ȡ�û�IP��ַ���������磩
	 * @author: ÷����
	 * @param request
	 * @return
	 * @date  : 2016��1��12��
	 */
	public static String getIpAddress(HttpServletRequest request) {
		// ��ȡ��������IP��ַ,���ͨ�������������͸������ǽ��ȡ��ʵIP��ַ
		String ip = request.getHeader("X-Forwarded-For");

		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			if (ip == null || ip.length() == 0
					|| "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("Proxy-Client-IP");
			}
			if (ip == null || ip.length() == 0
					|| "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("WL-Proxy-Client-IP");
			}
			if (ip == null || ip.length() == 0
					|| "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("HTTP_CLIENT_IP");
			}
			if (ip == null || ip.length() == 0
					|| "unknown".equalsIgnoreCase(ip)) {
				ip = request.getHeader("HTTP_X_FORWARDED_FOR");
			}
			if (ip == null || ip.length() == 0
					|| "unknown".equalsIgnoreCase(ip)) {
				ip = request.getRemoteAddr();
			}
		} else if (ip.length() > 15) {
			String[] ips = ip.split(",");
			for (int index = 0; index < ips.length; index++) {
				String strIp = (String) ips[index];
				if (!("unknown".equalsIgnoreCase(strIp))) {
					ip = strIp;
					break;
				}
			}
		}
		return ip;
	}
}
