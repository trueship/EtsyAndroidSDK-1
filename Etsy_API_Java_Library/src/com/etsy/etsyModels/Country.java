package com.etsy.etsyModels;

import org.json.JSONException;
import org.json.JSONObject;

public class Country extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2753968618245666341L;
	private int country_id;
	private String iso_country_code;
	private String world_bank_country_code;
	private String name;
	private String slug;
	private float lat;
	private float lon;


	
	public int getCountryId() {
		return country_id;
	}
	
	public String getIsoCountryCode() {
		return iso_country_code;
	}
	
	public String getWorldBankCountryCode() {
		return world_bank_country_code;
	}
	
	public String getName() {
		return name;
	}
	
	public String getSlug() {
		return slug;
	}
	
	public float getLat() {
		return lat;
	}
	
	public float getLon() {
		return lon;
	}


	@Override
	public void parseData(JSONObject data) throws JSONException {
		this.country_id = data.optInt("country_id");
		this.iso_country_code = data.optString("iso_country_code");
		this.world_bank_country_code = data.optString("world_bank_country_code");
		this.name = data.optString("name");
		this.slug = data.optString("slug");
		this.lat = data.optLong("lat");
		this.lon = data.optLong("lon");

	}
	
	
}