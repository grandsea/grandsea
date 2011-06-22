package com.hundsun.finance.json;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

public class ExtHelper {
	
	public static ExtHelper createHelper(){
		return new ExtHelper();
	}
	
	public ExtHelper() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExtHelper(JsonConfig config) {
		super();
		this.config = config;
	}

	public String getGridJsonFromList(ExtGridJson model){
		Map map = new HashMap();
		map.put(model.getProperty().getTotalProperty(), model.getTotalCount());
		map.put(model.getProperty().getRootProperty(), model.getValueList());
		map.put(model.getProperty().getSuccessProperty(), true);
		JSONObject jsonObject = JSONObject.fromObject(map,config);
		return jsonObject.toString();
	}

	public JsonConfig getConfig() {
		return config;
	}

	private JsonConfig config = new JsonConfig();
}
