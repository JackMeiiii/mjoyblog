package com.meihf.mjoyblog.util;

/**
 * ȫ�ֳ�������
 * @author ÷����
 */
public class GlobalConstraints {
	
	private GlobalConstraints() {};
	
	/** ���б��е�����״̬ - δ�� */
	public static final short BEAN_DATA_STATE_NOTUSED = 0;
	/** ���б��е�����״̬ - ʹ�� */
	public static final short BEAN_DATA_STATE_ISUSED = 1;
	
	/** �û����н�ɫID - ����Ա */
	public static final short USER_ROLE_ID_ADMINISTRATOR = 0;
	/** �û����н�ɫID - �ÿ� */
	public static final short USER_ROLE_ID_GUEST = 1;
	
	/** Session�й���Ա����Ϣ */
	public static final String SESSION_KEY_USER = "MJOY_USER_INFO";
	
	/** Cookie����Ϣ */
	public static final String COOKIE_KEY_AUTO_LOGIN = "MJOY_BLOG_AUTO_LOGIN";
	public static final String COOKIE_VALUE_AUTO_LOGIN = "TRUE";
	
	/** ������� */
	public interface ErrorCode {
		/** δ֪�쳣����ʾ��Ϣ */
		public static final String UNKNOW_ERROR_MESSAGE = "δ֪�쳣";
		
		/** �û���������Ϊ�� */
		public static final int EMPTY_NAME_OR_PWD = 10001;
		/** �û������������ */
		public static final int WRONG_NAME_OR_PWD = 10002;
		/** �Զ���¼ʧ�� */
		public static final int AUTO_LOGIN_FAILD = 10003;
		/** �����޴�����*/		
		public static final int NOT_EXSIT_DATA = 90000;
		/**�û����ظ�����������*/
		public static final int REPEAT_LOGIN_NAME = 10004;
		/**ע����û����������䲩��������Ϊ��*/
		public static final int EMPTY_NEW_SIGN = 10005;
	}
	
	/** ����·�� */
	public interface REQUEST_URL {
		/** ��ת��¼ҳ�� */
		public static final String TOLOGIN = "/admin/index.do";
		/** ��¼���� */
		public static final String LOGIN = "/admin/login.do";
		/** ע������*/
		public static final String SIGN = "/admin/sign.do";
		/** ��תע������*/
		public static final String TOSIGN = "/admin/addUser";
	}
	
	/** �������� */
		public static String MY_BLOG_NAME = "";
	/**��¼��*/
		public static String MY_LOGIN_NAME ="";
}
