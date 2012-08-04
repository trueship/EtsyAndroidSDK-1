package com.etsy.etsyModels;

import org.json.JSONException;
import org.json.JSONObject;

public class Coupon extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7153533561895263275L;
	private int coupon_id;
	private String coupon_code;
	private boolean seller_active;
	private int pct_discount;
	private boolean free_shipping;
	private boolean domestic_only;


	
	public int getCouponId() {
		return coupon_id;
	}
	
	public String getCouponCode() {
		return coupon_code;
	}
	
	public boolean getSellerActive() {
		return seller_active;
	}
	
	public int getPctDiscount() {
		return pct_discount;
	}
	
	public boolean getFreeShipping() {
		return free_shipping;
	}
	
	public boolean getDomesticOnly() {
		return domestic_only;
	}


	@Override
	public void parseData(JSONObject data) throws JSONException {
		this.coupon_id = data.optInt("coupon_id");
		this.coupon_code = data.optString("coupon_code");
		this.seller_active = data.optBoolean("seller_active");
		this.pct_discount = data.optInt("pct_discount");
		this.free_shipping = data.optBoolean("free_shipping");
		this.domestic_only = data.optBoolean("domestic_only");

	}
	
	
}