package com.etsy.etsyModels;

import org.json.JSONException;
import org.json.JSONObject;

public class CartListing extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6157001915576553577L;
	private int listing_id;
	private int purchase_quantity;
	private String purchase_state;


	
	public int getListingId() {
		return listing_id;
	}
	
	public int getPurchaseQuantity() {
		return purchase_quantity;
	}
	
	public String getPurchaseState() {
		return purchase_state;
	}


	@Override
	public void parseData(JSONObject data) throws JSONException {
		this.listing_id = data.optInt("listing_id");
		this.purchase_quantity = data.optInt("purchase_quantity");
		this.purchase_state = data.optString("purchase_state");

	}
	
	
}