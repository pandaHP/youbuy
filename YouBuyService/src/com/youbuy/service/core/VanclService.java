package com.youbuy.service.core;

import java.io.UnsupportedEncodingException;

public class VanclService extends YoubuyService {

	private StringBuffer url;
	private VanclConfig vc;

	public VanclService(VanclConfig vc) {
		this.vc = vc;
		url = new StringBuffer("http://p-api.gicp.net");
	}

	public Object getWeeklyranking() {
		url.append("/salesvolume/weeklyranking");
		return YoubuyService.handleGet(YoubuyService.handleArguments(url, vc));
	}

	/**
	 * for test the service
	 * @throws UnsupportedEncodingException 
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		VanclConfig vc = new VanclConfig();
		vc.init();
		vc.setFormat("json");
		vc.setT();
		vc.setSign();
		VanclService vs = new VanclService(vc);
		Object result = vs.getWeeklyranking();
	}
}
