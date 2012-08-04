package com.etsy.etsyModels;

import org.json.JSONException;
import org.json.JSONObject;

public class BillingOverview extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1199974964670652535L;
	private boolean is_overdue;
	private String currency_code;
	private float overdue_balance;
	private float balance_due;
	private float total_balance;
	private int date_due;
	private int date_overdue;


	
	public boolean getIsOverdue() {
		return is_overdue;
	}
	
	public String getCurrencyCode() {
		return currency_code;
	}
	
	public float getOverdueBalance() {
		return overdue_balance;
	}
	
	public float getBalanceDue() {
		return balance_due;
	}
	
	public float getTotalBalance() {
		return total_balance;
	}
	
	public int getDateDue() {
		return date_due;
	}
	
	public int getDateOverdue() {
		return date_overdue;
	}


	@Override
	public void parseData(JSONObject data) throws JSONException {
		this.is_overdue = data.optBoolean("is_overdue");
		this.currency_code = data.optString("currency_code");
		this.overdue_balance = data.optLong("overdue_balance");
		this.balance_due = data.optLong("balance_due");
		this.total_balance = data.optLong("total_balance");
		this.date_due = data.optInt("date_due");
		this.date_overdue = data.optInt("date_overdue");

	}
	
	
}