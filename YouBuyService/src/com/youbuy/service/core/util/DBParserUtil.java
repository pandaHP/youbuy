package com.youbuy.service.core.util;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import youbuy.db.dao.CityDAO;
import youbuy.db.dao.DealDAO;
import youbuy.db.dao.MerchantDAO;
import youbuy.db.model.City;
import youbuy.db.model.Deal;
import youbuy.db.model.Merchant;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class DBParserUtil {

	public static void parseDealVancl(String dealXML) {
		StringReader sr = new StringReader(dealXML);

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;

		City sh = new City();
		sh.setCityName("ShangHai");
		sh.setCityId(1);
		sh.setCityTimezone("");
		sh.setCityLat("N30");
		sh.setCityLong("E120");
		sh.setCityWebsite("www.youbuy.com/sh");
		CityDAO cityDAO = new CityDAO();
		cityDAO.save(sh);

		Merchant mer = new Merchant();
		mer.setMerchUrl("www.vancl.com");
		mer.setMerchTel("123456789");
		mer.setMerchName("Vancl");
		mer.setMerchId(1);
		mer.setMerchEmail("@vancl.com");
		MerchantDAO md = new MerchantDAO();
		md.save(mer);

		try {

			dBuilder = dbFactory.newDocumentBuilder();

			Document doc = dBuilder.parse(new InputSource(sr));
			doc.getDocumentElement().normalize();

			NodeList nl = doc.getElementsByTagName("product");
			int len = nl.getLength();
			DealDAO dd = new DealDAO();
			for (int i = 1; i < len-1; i++) {
				Deal deal = new Deal();
				Node node = nl.item(i);

				if (node.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) node;
					String product_name = getTagValue("product_name", eElement);
					String price = getTagValue("price", eElement);
					String image_name = getTagValue("image_name", eElement);
					String image_path = getTagValue("image_path", eElement);

					deal.setDealDesc(product_name);
					deal.setDealImg(image_path + image_name);
					deal.setDealPrice(price);
					deal.setCityId(sh.getCityId());
					deal.setMerchId(mer.getMerchId());
					System.out.println("merchid:" + mer.getMerchId());
					deal.setDealId(i);
					System.out.println("dealid:" + i);
					
					dd.save(deal);
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			sr.close();
		}
	}
	
	
	public static void parseDeal59Seconds(String dealXML) {
		StringReader sr = new StringReader(dealXML);

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		
		try {

			dBuilder = dbFactory.newDocumentBuilder();

			Document doc = dBuilder.parse(new InputSource(sr));
			doc.getDocumentElement().normalize();

			NodeList nl = doc.getElementsByTagName("");
			int len = nl.getLength();
			DealDAO dd = new DealDAO();
			for (int i = 1; i < len-1; i++) {
				Deal deal = new Deal();
				Node node = nl.item(i);

				if (node.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) node;
					String product_name = getTagValue("product_name", eElement);
					String image_name = getTagValue("image_name", eElement);
					String image_path = getTagValue("image_path", eElement);

					deal.setDealDesc(product_name);
					deal.setDealImg(image_path + image_name);
					deal.setDealId(i);
					System.out.println("dealid:" + i);
					
					dd.save(deal);
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			sr.close();
		}
	}
	
	public static List<Integer> getAllCats(String xmlCats){
		StringReader sr = new StringReader(xmlCats);

		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		try {

			dBuilder = dbFactory.newDocumentBuilder();

			Document doc = dBuilder.parse(new InputSource(sr));
			doc.getDocumentElement().normalize();

			NodeList nl = doc.getElementsByTagName("itemcat");
			int len = nl.getLength();
			ArrayList<Integer> cats = new ArrayList<Integer>();
			for (int i = 1; i < len-1; i++) {
				Node node = nl.item(i);

				if (node.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) node;
					Integer cid = Integer.valueOf(getTagValue("cid", eElement));
					cats.add(cid);
				}
			}
			
			return cats;
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			sr.close();
		}
		
		return null;
	}
	
	//TBD
	public static int getPageSize(String xmlTotalResults){
		
		return 0;
	}

	private static String getTagValue(String sTag, Element eElement) {
		NodeList nlList = eElement.getElementsByTagName(sTag).item(0)
				.getChildNodes();

		Node nValue = (Node) nlList.item(0);

		return nValue.getNodeValue();
	}
}
