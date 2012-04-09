package com.youbuy.service.core;

public class VanclService extends YoubuyService {

	private StringBuffer url;
	private VanclConfig vc;

	public VanclService(VanclConfig vc) {
		this.vc = vc;
		url = new StringBuffer("http://p-api.gicp.net");
	}

	public Object getWeeklyranking() {
		url.append("/salesvolume/weeklyranking");
		YoubuyService.handleArguments(url,vc);
		return YoubuyService.handleGet(YoubuyService.handleArguments(url,vc));
	}
	
	
	
}
