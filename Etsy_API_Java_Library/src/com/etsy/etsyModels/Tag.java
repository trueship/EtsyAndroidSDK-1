package com.etsy.etsyModels;

import org.json.JSONException;
import org.json.JSONObject;

public class Tag extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2584698239763238664L;
	private String tag;
	private String name;
	private int num_listings;
	private int weight;


	
	public String getTag() {
		return tag;
	}
	
	public String getName() {
		return name;
	}
	
	public int getNumListings() {
		return num_listings;
	}
	
	public int getWeight() {
		return weight;
	}


	@Override
	public void parseData(JSONObject data) throws JSONException {
		this.tag = data.optString("tag");
		this.name = data.optString("name");
		this.num_listings = data.optInt("num_listings");
		this.weight = data.optInt("weight");

	}
	
	
}