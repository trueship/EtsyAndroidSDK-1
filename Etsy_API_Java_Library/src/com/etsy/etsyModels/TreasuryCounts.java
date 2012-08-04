package com.etsy.etsyModels;

import org.json.JSONException;
import org.json.JSONObject;

public class TreasuryCounts extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5557102527443710707L;
	private int clicks;
	private int views;
	private int shares;
	private int reports;


	
	public int getClicks() {
		return clicks;
	}
	
	public int getViews() {
		return views;
	}
	
	public int getShares() {
		return shares;
	}
	
	public int getReports() {
		return reports;
	}


	@Override
	public void parseData(JSONObject data) throws JSONException {
		this.clicks = data.optInt("clicks");
		this.views = data.optInt("views");
		this.shares = data.optInt("shares");
		this.reports = data.optInt("reports");

	}
	
	
}