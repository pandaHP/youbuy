package com.youbuy.service.core;

public class VanclConfig extends Configuration{

	private String appKey;
	private String sign;
	private String ver;
	private String sign_method;
	private String t;
	private String format;
	private String source;
	private String uid;
	private String ttid;
	
	public VanclConfig () {
	
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		super.getMap().put("appKey", appKey);
		this.appKey = appKey;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		super.getMap().put("sign", sign);
		this.sign = sign;
	}

	public String getVer() {
		return ver;
	}

	public void setVer(String ver) {
		super.getMap().put("ver", ver);
		this.ver = ver;
	}

	public String getSign_method() {
		return sign_method;
	}

	public void setSign_method(String sign_method) {
		super.getMap().put("sign_method", sign_method);
		this.sign_method = sign_method;
	}

	public String getT() {
		return t;
	}

	public void setT(String t) {
		super.getMap().put("t", t);
		this.t = t;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		super.getMap().put("format", format);
		this.format = format;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		super.getMap().put("source", source);
		this.source = source;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		super.getMap().put("uid", uid);
		this.uid = uid;
	}

	public String getTtid() {
		return ttid;
	}

	public void setTtid(String ttid) {
		super.getMap().put("ttid", ttid);
		this.ttid = ttid;
	}

}
