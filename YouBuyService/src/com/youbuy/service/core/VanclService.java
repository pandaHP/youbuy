package com.youbuy.service.core;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.youbuy.service.core.util.DBParserUtil;

public class VanclService extends YoubuyService {

	private StringBuffer url;
	private VanclConfig vc;

	public VanclService(VanclConfig vc) {
		this.vc = vc;
		url = new StringBuffer("http://p-api.gicp.net");
	}

	/**
	 * get the volume sales
	 * 
	 * @return string
	 * @throws UnsupportedEncodingException 
	 */
	public String getWeeklyranking() throws UnsupportedEncodingException {
		url.append("/salesvolume/weeklyranking");
		vc.setSign();
		String result = YoubuyService.handleGet(YoubuyService.handleArguments(
				url, vc));
		url = new StringBuffer(url.substring(0, 21));
		return result;
	}

	/**
	 * get males ranking
	 * 
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public String getMalesRanking() throws UnsupportedEncodingException {
		url.append("/salesvolume/malesranking");
		vc.setSign();
		String result = YoubuyService.handleGet(YoubuyService.handleArguments(
				url, vc));
		url = new StringBuffer(url.substring(0, 21));
		return result;
	}

	/**
	 * get females ranking
	 * 
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public String getLadiesRanking() throws UnsupportedEncodingException {
		url.append("/salesvolume/ladiesranking");
		vc.setSign();
		String result = YoubuyService.handleGet(YoubuyService.handleArguments(
				url, vc));
		url = new StringBuffer(url.substring(0, 21));
		return result;
	}

	/**
	 * get the detailed information of product
	 * @throws UnsupportedEncodingException 
	 */
	public String getProductDetail(String productId) throws UnsupportedEncodingException {
		url.append("/product/detail");
		vc.getMap().put("productcode", URLEncoder.encode(productId,"UTF-8"));
		vc.setSign();
		String result = YoubuyService.handleGet(YoubuyService.handleArguments(
				url, vc));
		url = new StringBuffer(url.substring(0, 21));
		return result;
	}

	/**
	 * get the hot searched keywords
	 * @throws UnsupportedEncodingException 
	 */
	public String getHotkeywords() throws UnsupportedEncodingException {
		url.append("/search/hotkeywords");
		vc.setSign();
		String result = YoubuyService.handleGet(YoubuyService.handleArguments(
				url, vc));
		url = new StringBuffer(url.substring(0, 21));
		return result;
	}

	/**
	 * for test the service
	 * 
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		VanclConfig vc = new VanclConfig();
		vc.init();
		VanclService vs = new VanclService(vc);
		String result = vs.getHotkeywords();
		System.out.println(result);
		// DBParserUtil.parseDealVancl(result);
	}
}
