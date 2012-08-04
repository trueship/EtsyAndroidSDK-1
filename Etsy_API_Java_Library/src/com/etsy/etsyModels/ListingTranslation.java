package com.etsy.etsyModels;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ListingTranslation extends BaseModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3492761489076168692L;
	private int listingId;
	private String language;
	private String title;
	private String description;
	private JSONArray tags;

	public int getListingId(){
		return listingId;
	}
	
	public String getLanguage(){
		return language;
	}
	
	public String getTitle(){
		return title;
	}
	
	public String getDescription(){
		return description;
	}
	
	public JSONArray getTags(){
		return tags;
	}
	
	@Override
	public void parseData(JSONObject data) throws JSONException {
		this.listingId = data.optInt("listing_id");
		this.language = data.optString("language");
		this.title = data.optString("title");
		this.description = data.optString("description");
		this.tags = data.optJSONArray("tags");
	}
	
}
