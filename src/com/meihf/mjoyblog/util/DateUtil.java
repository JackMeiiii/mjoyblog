package com.meihf.mjoyblog.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.time.DateUtils;

/**
 * @desc: ����ʱ�乤����
 * @author ÷����
 */
public final class DateUtil extends DateUtils{
	
	private DateUtil() {};
	
	// һ��ĺ����� 86400000 = 24*60*60*1000;
	private static final int MILLIS_PER_DAY = 86400000;
	// һСʱ�ĺ�����600000 = 24*60*60*1000;
	private static final int MILLIS_PER_HOUR = 3600000;
	//���ڸ�ʽ
	
	/** yyyy-MM-dd */
	public static final String YYYY_MM_DD = "yyyy-MM-dd";
	
	/** yyyy-MM-dd HH:mm:ss */
	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * ��ȡ��ǰ������(String ������)
	 * @return
	 */
	public static String getCurrentDay() {
		Date nowDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD);
		return sdf.format(nowDate);
	}
	
	/**
	 * ��ȡ��ǰʱ��(�ַ������� ����)
	 * @return
	 */
	public static String getNowTime() {
		Date nowDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
		return sdf.format(nowDate);
	}
	/**
	 * @desc: ��Date��ʽתΪString
	 * @author: ÷����
	 * @param date
	 * @return
	 * @date  : 2016��3��29��
	 */
	public static String format2Str(Date date){
		String ret = "";
		SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD);
		try{
			ret = sdf.format(date);
		}catch(Exception e){
			e.printStackTrace();
		}

		return ret;
	}
	/**
	 * @desc: ��ȡ��ǰʱ��Date����
	 * @author: ÷����
	 * @return
	 * @date  : 2016��1��15��
	 */
	public static synchronized Date getCurrDate() {
		Calendar calendar = Calendar.getInstance();
		return calendar.getTime();
	}
	
	/**
	 * @desc:��ȡ���ڸ�ʽ������ 
	 * @author: ÷����
	 * @param parttern
	 * @return
	 * @date  : 2016��1��15��
	 */
	private static SimpleDateFormat getFormatter(String parttern) {
		return new SimpleDateFormat(parttern);
	}
	
	
	/**
	 * @desc: ���ַ�������Ĭ��ת�����ڸ�ʽ��Date���� (����formater����ת��)
	 * @author: ÷����
	 * @param strDate
	 * @return
	 * @date  : 2016��1��15��
	 */
	public static Date format2Date(String strDate,String Formater) {
		Date d = null;
		if ("".equals(strDate)){
			return null;
		}else{
			try {
				d = getFormatter(Formater).parse(strDate);
			} catch (ParseException pex) {
				return null;
			}
		}
		return d;
	}
	
	/**
	 * ��ȡʱ���
	 * 
	 * @param choose
	 * @param lastDate
	 * @return
	 */
	public static long getDf(String choose, String lastDate) {
		SimpleDateFormat sdf = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
		try {
			Date ld = sdf.parse(lastDate);
			Date now = sdf.parse(getNowTime());
			long msecond = now.getTime() - ld.getTime();
			if (choose.equals("s")) {
				return msecond / 1000;
			}
			if (choose.equals("m")) {
				return msecond / (1000 * 60);
			}
			if (choose.equals("h")) {
				return msecond / MILLIS_PER_HOUR;
			}
			if (choose.equals("d")) {
				return msecond / MILLIS_PER_DAY;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * @��ȡ���µ�����(�������һ��)
	 * @param args
	 */
	public static int getDaysOfMouth() {
		String[] dates = getCurrentDay().split("-");
		int year = Integer.parseInt(dates[0]);
		int mouth = Integer.parseInt(dates[1]);
		int Aday=0;
		String m1 = "1,3,5,7,8,10,12";
		String m2 = "4,6,9,11";
		if (m1.contains(String.valueOf(mouth))) {
			Aday = 31;
		}
		if (m2.contains(String.valueOf(mouth))) {
			Aday = 30;
		}
		if ((0 == year % 400) || (0 == year % 4 && 0 != year % 100)) {
			Aday=29;
		}else{
			Aday=28;
		}
		return Aday;
	}
}
