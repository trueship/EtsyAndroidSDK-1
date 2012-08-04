package com.etsy.etsyModels;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Treasury extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6501417274508310869L;
	private String id;
	private String title;
	private String description;
	private int homepage;
	private boolean mature;
	private String locale;
	private int comment_count;
	private JSONArray tags;
	private TreasuryCounts counts;
	private float hotness;
	private String hotness_color;
	private int user_id;
	private String user_name;
	private int user_avatar_id;
	private TreasuryListing listings;
	private int creation_tsz;


	
	public String getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getHomepage() {
		return homepage;
	}
	
	public boolean getMature() {
		return mature;
	}
	
	public String getLocale() {
		return locale;
	}
	
	public int getCommentCount() {
		return comment_count;
	}
	
	public JSONArray getTags() {
		return tags;
	}
	
	public TreasuryCounts getCounts() {
		return counts;
	}
	
	public float getHotness() {
		return hotness;
	}
	
	public String getHotnessColor() {
		return hotness_color;
	}
	
	public int getUserId() {
		return user_id;
	}
	
	public String getUserName() {
		return user_name;
	}
	
	public int getUserAvatarId() {
		return user_avatar_id;
	}
	
	public TreasuryListing getListings() {
		return listings;
	}
	
	public int getCreationTsz() {
		return creation_tsz;
	}


	@Override
	public void parseData(JSONObject data) throws JSONException {
		this.id = data.optString("id");
		this.title = data.optString("title");
		this.description = data.optString("description");
		this.homepage = data.optInt("homepage");
		this.mature = data.optBoolean("mature");
		this.locale = data.optString("locale");
		this.comment_count = data.optInt("comment_count");
		this.tags = data.optJSONArray("tags");
TreasuryCounts tmp_counts = new TreasuryCounts();
		tmp_counts.parseData(data.optJSONObject("counts"));
		this.counts = tmp_counts;
		this.hotness = data.optLong("hotness");
		this.hotness_color = data.optString("hotness_color");
		this.user_id = data.optInt("user_id");
		this.user_name = data.optString("user_name");
		this.user_avatar_id = data.optInt("user_avatar_id");
TreasuryListing tmp_listings = new TreasuryListing();
		tmp_listings.parseData(data.optJSONObject("listings"));
		this.listings = tmp_listings;
		this.creation_tsz = data.optInt("creation_tsz");

	}
	
	
}