package com.etsy.etsyModels;

import java.io.Serializable;

import org.json.JSONException;
import org.json.JSONObject;

public abstract class BaseModel implements Serializable{
	private static final long serialVersionUID = -4273544891826300016L;

	public abstract void parseData(JSONObject data) throws JSONException;
}
