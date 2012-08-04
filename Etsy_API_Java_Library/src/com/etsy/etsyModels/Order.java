package com.etsy.etsyModels;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Order extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2139289521540816906L;
	private int order_id;
	private int user_id;
	private float creation_tsz;

	private User user;
	private Receipt[] receipts;

	
	public int getOrderId() {
		return order_id;
	}
	
	public int getUserId() {
		return user_id;
	}
	
	public float getCreationTsz() {
		return creation_tsz;
	}

	public User getUser() {
		return user;
	}
	public Receipt[] getReceipts() {
		return receipts;
	}

	@Override
	public void parseData(JSONObject data) throws JSONException {
		this.order_id = data.optInt("order_id");
		this.user_id = data.optInt("user_id");
		this.creation_tsz = data.optLong("creation_tsz");

		JSONObject userJSONObject = data.optJSONObject("User");
		if(userJSONObject != null){
			this.user = new User();
			this.user.parseData(userJSONObject);
		}
		JSONArray receiptsArray = data.optJSONArray("Receipts");
		if (receiptsArray != null){
			this.receipts = new Receipt[receiptsArray.length()];
			for(int i = 0; i < receiptsArray.length(); i++){
				this.receipts[i] = new Receipt();
				this.receipts[i].parseData(receiptsArray.getJSONObject(i));
			}
		}
	}
	
	
}