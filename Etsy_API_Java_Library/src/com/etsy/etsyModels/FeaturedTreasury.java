package com.etsy.etsyModels;

import org.json.JSONException;
import org.json.JSONObject;

public class FeaturedTreasury extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -924956241116402980L;
	private int treasury_id;
	private int treasury_owner_id;
	private String url;
	private String region;
	private float active_date;


	
	public int getTreasuryId() {
		return treasury_id;
	}
	
	public int getTreasuryOwnerId() {
		return treasury_owner_id;
	}
	
	public String getUrl() {
		return url;
	}
	
	public String getRegion() {
		return region;
	}
	
	public float getActiveDate() {
		return active_date;
	}


	@Override
	public void parseData(JSONObject data) throws JSONException {
		this.treasury_id = data.optInt("treasury_id");
		this.treasury_owner_id = data.optInt("treasury_owner_id");
		this.url = data.optString("url");
		this.region = data.optString("region");
		this.active_date = data.optLong("active_date");

	}
	
	
}