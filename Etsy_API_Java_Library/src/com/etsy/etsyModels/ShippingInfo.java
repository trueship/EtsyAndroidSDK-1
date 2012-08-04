package com.etsy.etsyModels;

import org.json.JSONException;
import org.json.JSONObject;

public class ShippingInfo extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1028306612152637887L;
	private int shipping_info_id;
	private int origin_country_id;
	private int destination_country_id;
	private String currency_code;
	private float primary_cost;
	private float secondary_cost;
	private int listing_id;
	private int region_id;
	private String origin_country_name;
	private String destination_country_name;

	private Country destinationCountry;
	private Country originCountry;
	private Region region;

	
	public int getShippingInfoId() {
		return shipping_info_id;
	}
	
	public int getOriginCountryId() {
		return origin_country_id;
	}
	
	public int getDestinationCountryId() {
		return destination_country_id;
	}
	
	public String getCurrencyCode() {
		return currency_code;
	}
	
	public float getPrimaryCost() {
		return primary_cost;
	}
	
	public float getSecondaryCost() {
		return secondary_cost;
	}
	
	public int getListingId() {
		return listing_id;
	}
	
	public int getRegionId() {
		return region_id;
	}
	
	public String getOriginCountryName() {
		return origin_country_name;
	}
	
	public String getDestinationCountryName() {
		return destination_country_name;
	}

	public Country getDestinationCountry() {
		return destinationCountry;
	}
	public Country getOriginCountry() {
		return originCountry;
	}
	public Region getRegion() {
		return region;
	}

	@Override
	public void parseData(JSONObject data) throws JSONException {
		this.shipping_info_id = data.optInt("shipping_info_id");
		this.origin_country_id = data.optInt("origin_country_id");
		this.destination_country_id = data.optInt("destination_country_id");
		this.currency_code = data.optString("currency_code");
		this.primary_cost = data.optLong("primary_cost");
		this.secondary_cost = data.optLong("secondary_cost");
		this.listing_id = data.optInt("listing_id");
		this.region_id = data.optInt("region_id");
		this.origin_country_name = data.optString("origin_country_name");
		this.destination_country_name = data.optString("destination_country_name");

		JSONObject destinationCountryJSONObject = data.optJSONObject("DestinationCountry");
		if(destinationCountryJSONObject != null){
			this.destinationCountry = new Country();
			this.destinationCountry.parseData(destinationCountryJSONObject);
		}
		JSONObject originCountryJSONObject = data.optJSONObject("OriginCountry");
		if(originCountryJSONObject != null){
			this.originCountry = new Country();
			this.originCountry.parseData(originCountryJSONObject);
		}
		JSONObject regionJSONObject = data.optJSONObject("Region");
		if(regionJSONObject != null){
			this.region = new Region();
			this.region.parseData(regionJSONObject);
		}
	}
	
	
}