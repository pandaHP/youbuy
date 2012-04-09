package com.youbuy.service.core;

import java.util.HashMap;

public abstract class Configuration {

	private HashMap<String,Object> map;

	public HashMap<String,Object> getMap() {
		return map;
	}

	public void setMap(HashMap<String,Object> map) {
		this.map = map;
	}
	
	
}
