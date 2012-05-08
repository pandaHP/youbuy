package com.youbuy.service.core;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FiftyNineSecondConfig extends Configuration {

	private String app_key = "1004464";
	private String appSecret = "7813da96f2921bf17026cbf1c9cd3c47";

	private String method;
	private String timestamp;
	private String format = "xml";
	private String v = "1.0";
	private String sign;
	private String sign_method = "md5";

	public void init() throws UnsupportedEncodingException {
		super.getMap().put("app_key", URLEncoder.encode(app_key, "UTF-8"));
		super.getMap().put("v", URLEncoder.encode(v, "UTF-8"));
		super.getMap().put("sign_method",
				URLEncoder.encode(sign_method, "UTF-8"));
		super.getMap().put("format", URLEncoder.encode(format, "UTF-8"));
		
		this.setTimestamp();
	}

	public String getApp_key() {
		return app_key;
	}

	public void setApp_key(String app_key) {
		this.app_key = app_key;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp() throws UnsupportedEncodingException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = sdf.format(new Date()).toString();
		super.getMap().put("timestamp", URLEncoder.encode(time,"UTF-8"));
		this.timestamp = time;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getV() {
		return v;
	}

	public void setV(String v) {
		this.v = v;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getSign_method() {
		return sign_method;
	}

	public void setSign_method(String sign_method) {
		this.sign_method = sign_method;
	}
	
	
}
