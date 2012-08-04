package com.etsy.etsyModels;

import org.json.JSONException;
import org.json.JSONObject;

public class UserProfile extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8560910552168722074L;
	private int user_profile_id;
	private int user_id;
	private String login_name;
	private String bio;
	private String gender;
	private String birth_month;
	private String birth_day;
	private String birth_year;
	private float join_tsz;
	private String materials;
	private int country_id;
	private String region;
	private String city;
	private String location;
	private int avatar_id;
	private float lat;
	private float lon;
	private int transaction_buy_count;
	private int transaction_sold_count;
	private boolean is_seller;
	private String image_url_75x75;
	private String first_name;
	private String last_name;

	private Country country;

	
	public int getUserProfileId() {
		return user_profile_id;
	}
	
	public int getUserId() {
		return user_id;
	}
	
	public String getLoginName() {
		return login_name;
	}
	
	public String getBio() {
		return bio;
	}
	
	public String getGender() {
		return gender;
	}
	
	public String getBirthMonth() {
		return birth_month;
	}
	
	public String getBirthDay() {
		return birth_day;
	}
	
	public String getBirthYear() {
		return birth_year;
	}
	
	public float getJoinTsz() {
		return join_tsz;
	}
	
	public String getMaterials() {
		return materials;
	}
	
	public int getCountryId() {
		return country_id;
	}
	
	public String getRegion() {
		return region;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getLocation() {
		return location;
	}
	
	public int getAvatarId() {
		return avatar_id;
	}
	
	public float getLat() {
		return lat;
	}
	
	public float getLon() {
		return lon;
	}
	
	public int getTransactionBuyCount() {
		return transaction_buy_count;
	}
	
	public int getTransactionSoldCount() {
		return transaction_sold_count;
	}
	
	public boolean getIsSeller() {
		return is_seller;
	}
	
	public String getImageUrl75x75() {
		return image_url_75x75;
	}
	
	public String getFirstName() {
		return first_name;
	}
	
	public String getLastName() {
		return last_name;
	}

	public Country getCountry() {
		return country;
	}

	@Override
	public void parseData(JSONObject data) throws JSONException {
		this.user_profile_id = data.optInt("user_profile_id");
		this.user_id = data.optInt("user_id");
		this.login_name = data.optString("login_name");
		this.bio = data.optString("bio");
		this.gender = data.optString("gender");
		this.birth_month = data.optString("birth_month");
		this.birth_day = data.optString("birth_day");
		this.birth_year = data.optString("birth_year");
		this.join_tsz = data.optLong("join_tsz");
		this.materials = data.optString("materials");
		this.country_id = data.optInt("country_id");
		this.region = data.optString("region");
		this.city = data.optString("city");
		this.location = data.optString("location");
		this.avatar_id = data.optInt("avatar_id");
		this.lat = data.optLong("lat");
		this.lon = data.optLong("lon");
		this.transaction_buy_count = data.optInt("transaction_buy_count");
		this.transaction_sold_count = data.optInt("transaction_sold_count");
		this.is_seller = data.optBoolean("is_seller");
		this.image_url_75x75 = data.optString("image_url_75x75");
		this.first_name = data.optString("first_name");
		this.last_name = data.optString("last_name");

		JSONObject countryJSONObject = data.optJSONObject("Country");
		if(countryJSONObject != null){
			this.country = new Country();
			this.country.parseData(countryJSONObject);
		}
	}
	
	
}