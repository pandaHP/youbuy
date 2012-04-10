package com.youbuy.service.core;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.youbuy.service.core.util.EncryptUtil;

public class VanclConfig extends Configuration {

	private String appSecret = "432229e00595840cb6d5f80d7b72f359";

	private String appKey = "2012032298";
	private String sign;
	private String ver = "1.0";
	private String sign_method = "md5";
	private String t;
	private String format;
	private String source = "api.tool.vancl.com";
	private String uid = "A9FFDE3559430A7B1E23A03F24FCDA05";
	private String ttid = "api.tool.vancl.com2012032298apitool_wap_2.0";

	public void init() {
		super.getMap().put("appKey", appKey);
		super.getMap().put("ver", ver);
		super.getMap().put("sign_method", sign_method);
		super.getMap().put("source", source);
		super.getMap().put("uid", uid);
		super.getMap().put("ttid", ttid);
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

	public void setSign() {
		String s = appSecret + "appkey" + appKey + "format"
				+ format + "sign_method" + sign_method + "source" + source
				+ "t" + t + "ttid" + ttid + "uid" + uid + "ver" + ver;
		String sign = EncryptUtil.md5(s);
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

	public void setT() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		String time = sdf.format(new Date()).toString();
		super.getMap().put("t", "20120410095553");
		this.t = "20120410095553";
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
