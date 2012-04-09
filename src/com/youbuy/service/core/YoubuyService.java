package com.youbuy.service.core;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

public class YoubuyService {

	public static String handleArguments(StringBuffer url, Configuration config) {
		HashMap<String, Object> prop = config.getMap();
		Set<String> keys = prop.keySet();
		int i = 0;
		for (String s : keys) {
			if (i == 0) {
				url.append("?" + prop.get(s).toString());
			} else {
				url.append("&" + prop.get(s).toString());
			}

			i++;
		}

		System.out.println(url.toString());
		return url.toString();
	}

	public static Object handleGet(String url) {
		HttpClient httpclient = new DefaultHttpClient();
		try {
			HttpGet httpget = new HttpGet(url);
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
			
			return httpclient.execute(httpget, responseHandler);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
		return null;
	}

	public static Object handlePost(String url) {
		return null;
	}

}