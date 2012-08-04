package com.etsy.etsyModels;

import org.json.JSONException;
import org.json.JSONObject;

public class FavoriteListing extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3838008077209921973L;
	private int listing_id;
	private int user_id;
	private String listing_state;
	private int create_date;
	private String state;
	private float creation_tsz;
	private int favorite_listing_id;

	private User user;
	private Listing listing;

	
	public int getListingId() {
		return listing_id;
	}
	
	public int getUserId() {
		return user_id;
	}
	
	public String getListingState() {
		return listing_state;
	}
	
	public int getCreateDate() {
		return create_date;
	}
	
	public String getState() {
		return state;
	}
	
	public float getCreationTsz() {
		return creation_tsz;
	}
	
	public int getFavoriteListingId() {
		return favorite_listing_id;
	}

	public User getUser() {
		return user;
	}
	public Listing getListing() {
		return listing;
	}

	@Override
	public void parseData(JSONObject data) throws JSONException {
		this.listing_id = data.optInt("listing_id");
		this.user_id = data.optInt("user_id");
		this.listing_state = data.optString("listing_state");
		this.create_date = data.optInt("create_date");
		this.state = data.optString("state");
		this.creation_tsz = data.optLong("creation_tsz");
		this.favorite_listing_id = data.optInt("favorite_listing_id");

		JSONObject userJSONObject = data.optJSONObject("User");
		if(userJSONObject != null){
			this.user = new User();
			this.user.parseData(userJSONObject);
		}
		JSONObject listingJSONObject = data.optJSONObject("Listing");
		if(listingJSONObject != null){
			this.listing = new Listing();
			this.listing.parseData(listingJSONObject);
		}
	}
	
	
}