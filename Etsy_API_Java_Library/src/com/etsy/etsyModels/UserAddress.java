package com.etsy.etsyModels;

import org.json.JSONException;
import org.json.JSONObject;

public class UserAddress extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -785666095808878422L;
	private int user_address_id;
	private int user_id;
	private String name;
	private String first_line;
	private String second_line;
	private String city;
	private String state;
	private String zip;
	private int country_id;
	private String country_name;

	private Country country;
	private User user;

	
	public int getUserAddressId() {
		return user_address_id;
	}
	
	public int getUserId() {
		return user_id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getFirstLine() {
		return first_line;
	}
	
	public String getSecondLine() {
		return second_line;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getState() {
		return state;
	}
	
	public String getZip() {
		return zip;
	}
	
	public int getCountryId() {
		return country_id;
	}
	
	public String getCountryName() {
		return country_name;
	}

	public Country getCountry() {
		return country;
	}
	public User getUser() {
		return user;
	}

	@Override
	public void parseData(JSONObject data) throws JSONException {
		this.user_address_id = data.optInt("user_address_id");
		this.user_id = data.optInt("user_id");
		this.name = data.optString("name");
		this.first_line = data.optString("first_line");
		this.second_line = data.optString("second_line");
		this.city = data.optString("city");
		this.state = data.optString("state");
		this.zip = data.optString("zip");
		this.country_id = data.optInt("country_id");
		this.country_name = data.optString("country_name");

		JSONObject countryJSONObject = data.optJSONObject("Country");
		if(countryJSONObject != null){
			this.country = new Country();
			this.country.parseData(countryJSONObject);
		}
		JSONObject userJSONObject = data.optJSONObject("User");
		if(userJSONObject != null){
			this.user = new User();
			this.user.parseData(userJSONObject);
		}
	}
	
	
}