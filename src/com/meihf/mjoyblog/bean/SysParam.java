package com.meihf.mjoyblog.bean;

import org.springframework.data.annotation.Id;

/**
 * ϵͳ���ñ�
 * @author ÷����
 */
public class SysParam {

	/** ���ñ��� */
	@Id
	private String code;
	/** ����key,���û����ͱ���һ�� */
	private String key;
	/** ����ֵ */
	private String value;
	/** �������� */
	private String desc;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
