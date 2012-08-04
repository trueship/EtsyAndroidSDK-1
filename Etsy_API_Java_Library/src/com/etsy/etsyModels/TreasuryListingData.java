package com.etsy.etsyModels;

import org.json.JSONException;
import org.json.JSONObject;

public class TreasuryListingData extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6146201896135930599L;
	private int user_id;
	private String title;
	private float price;
	private int listing_id;
	private String state;
	private String shop_name;
	private int image_id;


	
	public int getUserId() {
		return user_id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public float getPrice() {
		return price;
	}
	
	public int getListingId() {
		return listing_id;
	}
	
	public String getState() {
		return state;
	}
	
	public String getShopName() {
		return shop_name;
	}
	
	public int getImageId() {
		return image_id;
	}


	@Override
	public void parseData(JSONObject data) throws JSONException {
		this.user_id = data.optInt("user_id");
		this.title = data.optString("title");
		this.price = data.optLong("price");
		this.listing_id = data.optInt("listing_id");
		this.state = data.optString("state");
		this.shop_name = data.optString("shop_name");
		this.image_id = data.optInt("image_id");

	}
	
	
}