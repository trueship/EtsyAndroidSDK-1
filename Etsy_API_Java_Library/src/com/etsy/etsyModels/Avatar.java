package com.etsy.etsyModels;

import org.json.JSONException;
import org.json.JSONObject;

public class Avatar extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7579204726440887508L;
	private int avatar_id;
	private String hex_code;
	private int red;
	private int green;
	private int blue;
	private int hue;
	private int saturation;
	private int brightness;
	private boolean is_black_and_white;
	private float creation_tsz;
	private int user_id;


	
	public int getAvatarId() {
		return avatar_id;
	}
	
	public String getHexCode() {
		return hex_code;
	}
	
	public int getRed() {
		return red;
	}
	
	public int getGreen() {
		return green;
	}
	
	public int getBlue() {
		return blue;
	}
	
	public int getHue() {
		return hue;
	}
	
	public int getSaturation() {
		return saturation;
	}
	
	public int getBrightness() {
		return brightness;
	}
	
	public boolean getIsBlackAndWhite() {
		return is_black_and_white;
	}
	
	public float getCreationTsz() {
		return creation_tsz;
	}
	
	public int getUserId() {
		return user_id;
	}


	@Override
	public void parseData(JSONObject data) throws JSONException {
		this.avatar_id = data.optInt("avatar_id");
		this.hex_code = data.optString("hex_code");
		this.red = data.optInt("red");
		this.green = data.optInt("green");
		this.blue = data.optInt("blue");
		this.hue = data.optInt("hue");
		this.saturation = data.optInt("saturation");
		this.brightness = data.optInt("brightness");
		this.is_black_and_white = data.optBoolean("is_black_and_white");
		this.creation_tsz = data.optLong("creation_tsz");
		this.user_id = data.optInt("user_id");

	}
	
	
}