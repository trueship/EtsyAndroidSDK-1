package com.etsy.etsyModels;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DataType extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3234884340266884671L;
	private String type;
	private JSONArray values;


	
	public String getType() {
		return type;
	}
	
	public JSONArray getValues() {
		return values;
	}


	@Override
	public void parseData(JSONObject data) throws JSONException {
		this.type = data.optString("type");
		this.values = data.optJSONArray("values");

	}
	
	
}