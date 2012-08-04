package com.etsy.etsyModels;

import org.json.JSONException;
import org.json.JSONObject;

public class FeedbackInfo extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9054479733500869663L;
	private int count;
	private int score;


	
	public int getCount() {
		return count;
	}
	
	public int getScore() {
		return score;
	}


	@Override
	public void parseData(JSONObject data) throws JSONException {
		this.count = data.optInt("count");
		this.score = data.optInt("score");

	}
	
	
}