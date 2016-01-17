package com.isobar.runkeeper.healthgraph.utils;

import com.google.gson.Gson;

public class JsonUtil {

	private static JsonUtil jsonUtil = null;
	
	private JsonUtil(){
		
	}
	
	public static JsonUtil getInstance(){
		if(jsonUtil == null){
			synchronized (JsonUtil.class) {
				if(jsonUtil == null){
					jsonUtil = new JsonUtil();
				}
			}
		}
		return jsonUtil;
	}
	
	public <T> T getObject(String jsonParam, Class<?> clazz){
		Gson gson = new Gson();
		return (T) gson.fromJson(jsonParam, clazz);
	}
}
