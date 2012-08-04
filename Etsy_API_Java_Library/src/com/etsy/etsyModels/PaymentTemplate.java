package com.etsy.etsyModels;

import org.json.JSONException;
import org.json.JSONObject;

public class PaymentTemplate extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2473776397001327452L;
	private int payment_template_id;
	private boolean allow_bt;
	private boolean allow_check;
	private boolean allow_mo;
	private boolean allow_other;
	private boolean allow_paypal;
	private boolean allow_cc;
	private String paypal_email;
	private String name;
	private String first_line;
	private String second_line;
	private String city;
	private String state;
	private String zip;
	private int country_id;
	private int user_id;
	private int listing_payment_id;

	private Country country;
	private User user;

	
	public int getPaymentTemplateId() {
		return payment_template_id;
	}
	
	public boolean getAllowBt() {
		return allow_bt;
	}
	
	public boolean getAllowCheck() {
		return allow_check;
	}
	
	public boolean getAllowMo() {
		return allow_mo;
	}
	
	public boolean getAllowOther() {
		return allow_other;
	}
	
	public boolean getAllowPaypal() {
		return allow_paypal;
	}
	
	public boolean getAllowCc() {
		return allow_cc;
	}
	
	public String getPaypalEmail() {
		return paypal_email;
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
	
	public int getUserId() {
		return user_id;
	}
	
	public int getListingPaymentId() {
		return listing_payment_id;
	}

	public Country getCountry() {
		return country;
	}
	public User getUser() {
		return user;
	}

	@Override
	public void parseData(JSONObject data) throws JSONException {
		this.payment_template_id = data.optInt("payment_template_id");
		this.allow_bt = data.optBoolean("allow_bt");
		this.allow_check = data.optBoolean("allow_check");
		this.allow_mo = data.optBoolean("allow_mo");
		this.allow_other = data.optBoolean("allow_other");
		this.allow_paypal = data.optBoolean("allow_paypal");
		this.allow_cc = data.optBoolean("allow_cc");
		this.paypal_email = data.optString("paypal_email");
		this.name = data.optString("name");
		this.first_line = data.optString("first_line");
		this.second_line = data.optString("second_line");
		this.city = data.optString("city");
		this.state = data.optString("state");
		this.zip = data.optString("zip");
		this.country_id = data.optInt("country_id");
		this.user_id = data.optInt("user_id");
		this.listing_payment_id = data.optInt("listing_payment_id");

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