package com.etsy.etsyModels;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Team extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1947206159083363543L;
	private int group_id;
	private String name;
	private int create_date;
	private int update_date;
	private JSONArray tags;


	
	public int getGroupId() {
		return group_id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getCreateDate() {
		return create_date;
	}
	
	public int getUpdateDate() {
		return update_date;
	}
	
	public JSONArray getTags() {
		return tags;
	}


	@Override
	public void parseData(JSONObject data) throws JSONException {
		this.group_id = data.optInt("group_id");
		this.name = data.optString("name");
		this.create_date = data.optInt("create_date");
		this.update_date = data.optInt("update_date");
		this.tags = data.optJSONArray("tags");

	}
	
	
}