package com.etsy.etsyModels;

import org.json.JSONException;
import org.json.JSONObject;

public class ParamList extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3199342662215552846L;
	private String param_name;


	
	public String getParamName() {
		return param_name;
	}


	@Override
	public void parseData(JSONObject data) throws JSONException {
		this.param_name = data.optString("param_name");

	}
	
	
}