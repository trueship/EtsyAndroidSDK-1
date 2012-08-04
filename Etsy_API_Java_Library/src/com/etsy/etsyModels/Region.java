package com.etsy.etsyModels;

import org.json.JSONException;
import org.json.JSONObject;

public class Region extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5304078965172970685L;
	private int region_id;
	private String region_name;


	
	public int getRegionId() {
		return region_id;
	}
	
	public String getRegionName() {
		return region_name;
	}


	@Override
	public void parseData(JSONObject data) throws JSONException {
		this.region_id = data.optInt("region_id");
		this.region_name = data.optString("region_name");

	}
	
	
}