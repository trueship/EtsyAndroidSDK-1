package com.etsy.etsyModels;

import org.json.JSONException;
import org.json.JSONObject;

public class BillCharge extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8001881964535052379L;
	private int bill_charge_id;
	private float creation_tsz;
	private String type;
	private int type_id;
	private int user_id;
	private float amount;
	private String currency_code;
	private int creation_year;
	private int creation_month;
	private float last_modified_tsz;


	
	public int getBillChargeId() {
		return bill_charge_id;
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
	
	public int getCreationYear() {
		return creation_year;
	}
	
	public int getCreationMonth() {
		return creation_month;
	}
	
	public float getLastModifiedTsz() {
		return last_modified_tsz;
	}


	@Override
	public void parseData(JSONObject data) throws JSONException {
		this.bill_charge_id = data.optInt("bill_charge_id");
		this.creation_tsz = data.optLong("creation_tsz");
		this.type = data.optString("type");
		this.type_id = data.optInt("type_id");
		this.user_id = data.optInt("user_id");
		this.amount = data.optLong("amount");
		this.currency_code = data.optString("currency_code");
		this.creation_year = data.optInt("creation_year");
		this.creation_month = data.optInt("creation_month");
		this.last_modified_tsz = data.optLong("last_modified_tsz");

	}
	
	
}