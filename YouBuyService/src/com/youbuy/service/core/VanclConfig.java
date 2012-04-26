package com.youbuy.service.core;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.youbuy.service.core.util.EncryptUtil;

public class VanclConfig extends Configuration {

	private String appSecret = "432229e00595840cb6d5f80d7b72f359";

	private String appKey ="2012032298";
	private String sign;
	private String ver = "1.0";
	private String sign_method = "md5";
	private String t;
	private String format = "xml";
	private String source = "api.tool.vancl.com";
	private String uid = "A9FFDE3559430A7B1E23A03F24FCDA05";
	private String ttid = "api.tool.vancl.com2012032298apitool_wap_2.0";

	public void init() throws UnsupportedEncodingException {
		super.getMap().put("appkey", URLEncoder.encode(appKey,"UTF-8"));
		super.getMap().put("ver", URLEncoder.encode(ver,"UTF-8"));
		super.getMap().put("sign_method", URLEncoder.encode(sign_method,"UTF-8"));
		super.getMap().put("source", URLEncoder.encode(source,"UTF-8"));
		super.getMap().put("uid", URLEncoder.encode(uid,"UTF-8"));
		super.getMap().put("ttid", URLEncoder.encode(ttid,"UTF-8"));
		super.getMap().put("format", URLEncoder.encode(format,"UTF-8"));
		this.setT();
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		super.getMap().put("appkey", appKey);
		this.appKey = appKey;
	}

	public String getSign() {
		return sign;
	}

	public void setSign() throws UnsupportedEncodingException {
//		String s = appSecret + "appkey" + appKey + "format"
//				+ format + "sign_method" + sign_method + "source" + source
//				+ "t" + t + "ttid" + ttid + "uid" + uid + "ver" + ver;
		List<String> sortedKeys = YoubuyService.sortedKeys(super.getMap());
		String s = appSecret;
		for(String key : sortedKeys){
			String temp = key+super.getMap().get(key);
			s += temp;
		}
		System.out.println("before encryped :" + s);
		String sign = EncryptUtil.md5(s);
		System.out.println("sign : " + sign);
		super.getMap().put("sign", URLEncoder.encode(sign,"UTF-8"));
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

	public void setT() throws UnsupportedEncodingException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
		String time = sdf.format(new Date()).toString();
		super.getMap().put("t", URLEncoder.encode(time,"UTF-8"));
		this.t = time;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) throws UnsupportedEncodingException {
		super.getMap().put("format", URLEncoder.encode(format,"UTF-8"));
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
