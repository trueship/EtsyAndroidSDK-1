package com.etsy.etsyModels;

import org.json.JSONException;
import org.json.JSONObject;

public class FavoriteUser extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4146158149850402898L;
	private int user_id;
	private int favorite_user_id;
	private int target_user_id;
	private float creation_tsz;

	private User user;
	private User targetUser;

	
	public int getUserId() {
		return user_id;
	}
	
	public int getFavoriteUserId() {
		return favorite_user_id;
	}
	
	public int getTargetUserId() {
		return target_user_id;
	}
	
	public float getCreationTsz() {
		return creation_tsz;
	}

	public User getUser() {
		return user;
	}
	public User getTargetUser() {
		return targetUser;
	}

	@Override
	public void parseData(JSONObject data) throws JSONException {
		this.user_id = data.optInt("user_id");
		this.favorite_user_id = data.optInt("favorite_user_id");
		this.target_user_id = data.optInt("target_user_id");
		this.creation_tsz = data.optLong("creation_tsz");

		JSONObject userJSONObject = data.optJSONObject("User");
		if(userJSONObject != null){
			this.user = new User();
			this.user.parseData(userJSONObject);
		}
		JSONObject targetUserJSONObject = data.optJSONObject("TargetUser");
		if(targetUserJSONObject != null){
			this.targetUser = new User();
			this.targetUser.parseData(targetUserJSONObject);
		}
	}
	
	
}