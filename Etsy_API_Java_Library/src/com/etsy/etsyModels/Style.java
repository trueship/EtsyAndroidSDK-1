package com.etsy.etsyModels;

import org.json.JSONException;
import org.json.JSONObject;

public class Style extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2123143301833607924L;
	private int style_id;
	private String style;


	
	public int getStyleId() {
		return style_id;
	}
	
	public String getStyle() {
		return style;
	}


	@Override
	public void parseData(JSONObject data) throws JSONException {
		this.style_id = data.optInt("style_id");
		this.style = data.optString("style");

	}
	
	
}