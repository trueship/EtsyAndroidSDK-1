package com.etsy.etsyModels;

import org.json.JSONException;
import org.json.JSONObject;

public class BillPayment extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7976310709617745871L;
	private int bill_payment_id;
	private float creation_tsz;
	private String type;
	private int type_id;
	private int user_id;
	private float amount;
	private String currency_code;
	private int creation_month;
	private int creation_year;


	
	public int getBillPaymentId() {
		return bill_payment_id;
	}
	
	public float getCreationTsz() {
		return creation_tsz;
	}
	
	public String getType() {
		return type;
	}
	
	public int getTypeId() {
		return type_id;
	}
	
	public int getUserId() {
		return user_id;
	}
	
	public float getAmount() {
		return amount;
	}
	
	public String getCurrencyCode() {
		return currency_code;
	}
	
	public int getCreationMonth() {
		return creation_month;
	}
	
	public int getCreationYear() {
		return creation_year;
	}


	@Override
	public void parseData(JSONObject data) throws JSONException {
		this.bill_payment_id = data.optInt("bill_payment_id");
		this.creation_tsz = data.optLong("creation_tsz");
		this.type = data.optString("type");
		this.type_id = data.optInt("type_id");
		this.user_id = data.optInt("user_id");
		this.amount = data.optLong("amount");
		this.currency_code = data.optString("currency_code");
		this.creation_month = data.optInt("creation_month");
		this.creation_year = data.optInt("creation_year");

	}
	
	
}