package com.youbuy.service.core;

import java.io.UnsupportedEncodingException;
import java.util.List;

import com.youbuy.service.core.util.DBParserUtil;

public class FiftyNineSecondsService extends YoubuyService {

	/**
	 * before any call should add the method interface and calculate the sign
	 */

	private StringBuffer url;
	private FiftyNineSecondConfig fnc;

	public FiftyNineSecondsService(FiftyNineSecondConfig fnc) {
		this.fnc = fnc;
		url = new StringBuffer("http://gw.api.59miao.com/Router/Rest");
	}

	/**
	 * to get the categories of commodity
	 * 
	 * @throws UnsupportedEncodingException
	 */
	public String getItemCats() throws UnsupportedEncodingException {
		fnc.setMethod("59miao.itemcats.get");
		fnc.getMap().put("parent_cid", 0);
		fnc.getMap().put("fields", "cid,name");
		fnc.setSign();

		String result = YoubuyService.handleGet(YoubuyService.handleArguments(
				url, fnc));
		url = new StringBuffer("http://gw.api.59miao.com/Router/Rest");
		fnc.getMap().clear();
		return result;
	}

	/**
	 * to get the commodity list according to categories
	 * 
	 * @param category
	 *            id
	 * @throws UnsupportedEncodingException
	 */
	public String getItemListByCats(int cid, int pageNo)
			throws UnsupportedEncodingException {
		fnc.setMethod("59miao.items.search");
		fnc.getMap().put("cid", cid);
		fnc.getMap().put("page_size", 40);
		fnc.getMap().put("page_no", pageNo);
		fnc.getMap()
				.put("fields",
						"iid,click_url,seller_url,title,sid,seller_name,cid,desc,pic_url,price,cash_ondelivery,freeshipment,installment,has_invoice,modified,price_reduction,price_decreases,original_price");
		fnc.setSign();
		String result = YoubuyService.handleGet(YoubuyService.handleArguments(
				url, fnc));
		url = new StringBuffer("http://gw.api.59miao.com/Router/Rest");
		fnc.getMap().clear();
		return result;
	}

	/**
	 * to get the information of shop
	 * 
	 * @param sid
	 * @throws UnsupportedEncodingException
	 */
	public String getShopInfo(int sid) throws UnsupportedEncodingException {
		fnc.setMethod("59miao.shops.get");
		fnc.getMap().put("sids", sid);
		fnc.getMap()
				.put("fields",
						"sid,name,desc,shop_cat,logo,created,modified,click_url,cashback,payment,shipment,shipment_fee,cash_ondelivery,freeshipment,installment,has_invoice,status");
		fnc.setSign();

		String result = YoubuyService.handleGet(YoubuyService.handleArguments(
				url, fnc));
		url = new StringBuffer("http://gw.api.59miao.com/Router/Rest");
		fnc.getMap().clear();
		return result;
	}

	public static void main(String[] args) {
		FiftyNineSecondConfig fnc = new FiftyNineSecondConfig();
		try {
			fnc.init();
			FiftyNineSecondsService fnss = new FiftyNineSecondsService(fnc);

			// first get the categories of the all items
			String xmlCats = fnss.getItemCats();
			List<Integer> cats = DBParserUtil.getAllCats(xmlCats);
			System.out.println(cats);
			for (int i : cats) {
				for (int n = 1; n <= 99; n++) {
					fnc.init();
					System.out.println(fnss.getItemListByCats(i, n));
				}
			}

		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
