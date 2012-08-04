package com.etsy.etsyModels;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ShopSection extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3540894056199989812L;
	private int shop_section_id;
	private String title;
	private int rank;
	private int user_id;
	private int active_listing_count;

	private Shop shop;
	private Listing[] listings;

	
	public int getShopSectionId() {
		return shop_section_id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getRank() {
		return rank;
	}
	
	public int getUserId() {
		return user_id;
	}
	
	public int getActiveListingCount() {
		return active_listing_count;
	}

	public Shop getShop() {
		return shop;
	}
	public Listing[] getListings() {
		return listings;
	}

	@Override
	public void parseData(JSONObject data) throws JSONException {
		this.shop_section_id = data.optInt("shop_section_id");
		this.title = data.optString("title");
		this.rank = data.optInt("rank");
		this.user_id = data.optInt("user_id");
		this.active_listing_count = data.optInt("active_listing_count");

		JSONObject shopJSONObject = data.optJSONObject("Shop");
		if(shopJSONObject != null){
			this.shop = new Shop();
			this.shop.parseData(shopJSONObject);
		}
		JSONArray listingsArray = data.optJSONArray("Listings");
		if (listingsArray != null){
			this.listings = new Listing[listingsArray.length()];
			for(int i = 0; i < listingsArray.length(); i++){
				this.listings[i] = new Listing();
				this.listings[i].parseData(listingsArray.getJSONObject(i));
			}
		}
	}
	
	
}