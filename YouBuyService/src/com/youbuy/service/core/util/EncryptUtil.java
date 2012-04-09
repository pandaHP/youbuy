package com.youbuy.service.core.util;

import java.security.MessageDigest;

public class EncryptUtil {

	public static String md5(String message) {
		try {
			byte[] btInput = message.getBytes();
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			mdInst.update(btInput);
			byte[] md = mdInst.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < md.length; i++) {
				int val = ((int) md[i]) & 0xff;
				if (val < 16)
					sb.append("0");
				sb.append(Integer.toHexString(val));

			}
			return sb.toString();
		} catch (Exception e) {
			return null;
		}
	}
	
	public static void main(String[] args){
		String s =  "432229e00595840cb6d5f80d7b72f359" + "appkey2012032298formatxmlsign_methodmd5sourceapi.tool.vancl.comt20120409090220ttidapi.tool.vancl.com2012032298apitool_wap_2.0uidA9FFDE3559430A7B1E23A03F24FCDA05ver1.0";
		String encyped = md5(s);
		System.out.println(encyped);
	}
}
