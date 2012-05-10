package com.youbuy.service.core;

import java.io.UnsupportedEncodingException;

public class FiftyNineSecondsService extends YoubuyService {

	/**
	 * before any call should add the method interface and calculate the sign
	 */
	
	private StringBuffer url;
	private FiftyNineSecondConfig fnc;
	
	public FiftyNineSecondsService(FiftyNineSecondConfig fnc){
		this.fnc = fnc;
		url = new StringBuffer("http://gw.api.59miao.com/Router/Rest");
	}
	
	/**
	 * to get the categories of commodity  
	 * @throws UnsupportedEncodingException 
	 */
	public String getItemCats() throws UnsupportedEncodingException{
		fnc.setMethod("59miao.itemcats.get");
		fnc.getMap().put("parent_cid", 0);
		fnc.getMap().put("fields", "cid,name");
		fnc.setSign();
		
		String result = YoubuyService.handleGet(YoubuyService.handleArguments(url, fnc));
		return result;
	}
	
	public static void main(String[] args){
		FiftyNineSecondConfig fnc = new FiftyNineSecondConfig();
		try {
			fnc.init();
			FiftyNineSecondsService fnss = new FiftyNineSecondsService(fnc);
			System.out.println(fnss.getItemCats());
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
