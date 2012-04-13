package com.youbuy.service.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
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
		List<String> sortedKeys = new ArrayList<String>(keys);
		Collections.sort(sortedKeys, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}

		});

		int i = 0;
		for (String s : sortedKeys) {
			if (i == 0) {
				url.append("?" + s + "=" + prop.get(s).toString());
			} else {
				url.append("&" + s + "=" + prop.get(s).toString());
			}

			i++;
		}

		System.out.println(url.toString());
		return url.toString();
	}

	public static String handleGet(String url) {
		HttpClient httpclient = new DefaultHttpClient();
		try {
			HttpGet httpget = new HttpGet(url);
			ResponseHandler<String> responseHandler = new BasicResponseHandler();
		
			String response = httpclient.execute(httpget, responseHandler);
			return response ;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			httpclient.getConnectionManager().shutdown();
		}
		return null;
	}

	public static Object handlePost(String url) {
		return null;
	}

}
