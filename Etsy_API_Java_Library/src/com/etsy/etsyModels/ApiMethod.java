package com.etsy.etsyModels;

import org.json.JSONException;
import org.json.JSONObject;

public class ApiMethod extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8582916799134364809L;
	private String name;
	private String uri;
	private ParamList params;
	private ParamList defaults;
	private String type;
	private String visibility;
	private String http_method;


	
	public String getName() {
		return name;
	}
	
	public String getUri() {
		return uri;
	}
	
	public ParamList getParams() {
		return params;
	}
	
	public ParamList getDefaults() {
		return defaults;
	}
	
	public String getType() {
		return type;
	}
	
	public String getVisibility() {
		return visibility;
	}
	
	public String getHttpMethod() {
		return http_method;
	}


	@Override
	public void parseData(JSONObject data) throws JSONException {
		this.name = data.optString("name");
		this.uri = data.optString("uri");
ParamList tmp_params = new ParamList();
		tmp_params.parseData(data.optJSONObject("params"));
		this.params = tmp_params;
ParamList tmp_defaults = new ParamList();
		tmp_defaults.parseData(data.optJSONObject("defaults"));
		this.defaults = tmp_defaults;
		this.type = data.optString("type");
		this.visibility = data.optString("visibility");
		this.http_method = data.optString("http_method");

	}
	
	
}