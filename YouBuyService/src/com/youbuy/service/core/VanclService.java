package com.youbuy.service.core;

import java.io.UnsupportedEncodingException;

public class VanclService extends YoubuyService {

	private StringBuffer url;
	private VanclConfig vc;

	public VanclService(VanclConfig vc) {
		this.vc = vc;
		url = new StringBuffer("http://p-api.gicp.net");
	}

	// to get the vancl sales volume
	public String getWeeklyranking() {
		url.append("/salesvolume/weeklyranking");
		return YoubuyService.handleGet(YoubuyService.handleArguments(url, vc));
	}

	public String getMalesRanking() {
		url.append("/salesvolume/malesranking");
		return YoubuyService.handleGet(YoubuyService.handleArguments(url, vc));
	}

	public String getLadiesRanking() {
		url.append("/salesvolume/ladiesranking");
		return YoubuyService.handleGet(YoubuyService.handleArguments(url, vc));
	}

	/**
	 * for test the service
	 * 
	 * @throws UnsupportedEncodingException
	 */
	public static void main(String[] args) throws UnsupportedEncodingException {
		VanclConfig vc = new VanclConfig();
		vc.init();
		vc.setFormat("xml");
		vc.setT();
		vc.setSign();
		VanclService vs = new VanclService(vc);
		String result = vs.getLadiesRanking();
		System.out.println(result);
	}
}
