package com.meihf.mjoyblog.util;

import java.util.Map;

import net.sf.json.JSONObject;

public class ResponseDataUtil {

	private Map<String,Object> data;

	public ResponseDataUtil(){}
	public ResponseDataUtil(Map<String, Object> data) {
		super();
		this.data = data;
	}
	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	
	public String toString() {
		return JSONObject.fromObject(this).toString();
	}
}
