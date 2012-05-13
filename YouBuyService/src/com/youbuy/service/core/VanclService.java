package com.youbuy.service.core;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

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
	 * 
	 * @throws UnsupportedEncodingException
	 */
	public String getProductDetail(String productId)
			throws UnsupportedEncodingException {
		url.append("/product/detail");
		vc.getMap().put("productcode", URLEncoder.encode(productId, "UTF-8"));
		vc.setSign();
		String result = YoubuyService.handleGet(YoubuyService.handleArguments(
				url, vc));
		url = new StringBuffer(url.substring(0, 21));
		return result;
	}
	
	/**
	 * get the detailed information of one color
	 * @throws UnsupportedEncodingException 
	 */
	public String getProductDetailOfOneColor(String productId) throws UnsupportedEncodingException{
		url.append("/product/productinfo");
		vc.getMap().put("productcode", URLEncoder.encode(productId, "UTF-8"));
		vc.setSign();
		String result = YoubuyService.handleGet(YoubuyService.handleArguments(
				url, vc));
		url = new StringBuffer(url.substring(0, 21));
		return result;
	}
	
	/**
	 * get all the products of the specific product's style
	 * @throws UnsupportedEncodingException 
	 */
	public String getProductsForSample(String productId) throws UnsupportedEncodingException{
		url.append("/product/producthome");
		vc.getMap().put("productcode", URLEncoder.encode(productId, "UTF-8"));
		vc.setSign();
		String result = YoubuyService.handleGet(YoubuyService.handleArguments(
				url, vc));
		url = new StringBuffer(url.substring(0, 21));
		return result;
	}
	
	/**
	 * get all the products of one styleId
	 * @throws UnsupportedEncodingException 
	 */
	public String getProductsForStyle(String styleid) throws UnsupportedEncodingException{
		url.append("/product/productlist");
		vc.getMap().put("styleid", URLEncoder.encode(styleid, "UTF-8"));
		vc.setSign();
		String result = YoubuyService.handleGet(YoubuyService.handleArguments(
				url, vc));
		url = new StringBuffer(url.substring(0, 21));
		return result;
	}
	
	/**
	 * get all the categories
	 * @throws UnsupportedEncodingException 
	 */
	public String getAllCategories() throws UnsupportedEncodingException{
		url.append("/category/list");
		vc.setSign();
		String result = YoubuyService.handleGet(YoubuyService.handleArguments(
				url, vc));
		url = new StringBuffer(url.substring(0, 21));
		return result;
	}
	
	/**
	 * get comment list
	 * @throws UnsupportedEncodingException 
	 */
	public String getCommentList(String styleid) throws UnsupportedEncodingException{
		url.append("/product/commentlist");
		vc.getMap().put("styleid", URLEncoder.encode(styleid, "UTF-8"));
		vc.setSign();
		String result = YoubuyService.handleGet(YoubuyService.handleArguments(
				url, vc));
		url = new StringBuffer(url.substring(0, 21));
		return result;
	}
	
	/**
	 * get question list
	 * @throws UnsupportedEncodingException 
	 */
	public String getQuestionList(String styleid) throws UnsupportedEncodingException{
		url.append("/product/questionlist");
		vc.getMap().put("styleid", URLEncoder.encode(styleid, "UTF-8"));
		vc.setSign();
		String result = YoubuyService.handleGet(YoubuyService.handleArguments(
				url, vc));
		url = new StringBuffer(url.substring(0, 21));
		return result;
	}
	
	

	/**
	 * get the hot searched keywords
	 * 
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
		String result = vs.getProductDetailOfOneColor("0051138");
		System.out.println(result);
		// DBParserUtil.parseDealVancl(result);
	}
}
