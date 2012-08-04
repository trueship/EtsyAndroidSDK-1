package com.etsy.etsyModels;

import org.json.JSONException;
import org.json.JSONObject;

public class TreasuryListing extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6900613266954308034L;
	private TreasuryListingData data;
	private int creation_tsz;


	
	public TreasuryListingData getData() {
		return data;
	}
	
	public int getCreationTsz() {
		return creation_tsz;
	}


	@Override
	public void parseData(JSONObject data) throws JSONException {
TreasuryListingData tmp_data = new TreasuryListingData();
		tmp_data.parseData(data.optJSONObject("data"));
		this.data = tmp_data;
		this.creation_tsz = data.optInt("creation_tsz");

	}
	
	
}