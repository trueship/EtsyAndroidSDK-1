package com.etsy.etsyModels;

import org.json.JSONException;
import org.json.JSONObject;

public class ListingImage extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -540648797371344942L;
	private int listing_image_id;
	private String hex_code;
	private int red;
	private int green;
	private int blue;
	private int hue;
	private int saturation;
	private int brightness;
	private boolean is_black_and_white;
	private float creation_tsz;
	private int listing_id;
	private int rank;
	private String url_75x75;
	private String url_170x135;
	private String url_570xN;
	private String url_fullxfull;
	private int full_height;
	private int full_width;

	private Listing listing;

	
	public int getListingImageId() {
		return listing_image_id;
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
	
	public int getListingId() {
		return listing_id;
	}
	
	public int getRank() {
		return rank;
	}
	
	public String getUrl75x75() {
		return url_75x75;
	}
	
	public String getUrl170x135() {
		return url_170x135;
	}
	
	public String getUrl570xN() {
		return url_570xN;
	}
	
	public String getUrlFullxfull() {
		return url_fullxfull;
	}
	
	public int getFullHeight() {
		return full_height;
	}
	
	public int getFullWidth() {
		return full_width;
	}

	public Listing getListing() {
		return listing;
	}

	@Override
	public void parseData(JSONObject data) throws JSONException {
		this.listing_image_id = data.optInt("listing_image_id");
		this.hex_code = data.optString("hex_code");
		this.red = data.optInt("red");
		this.green = data.optInt("green");
		this.blue = data.optInt("blue");
		this.hue = data.optInt("hue");
		this.saturation = data.optInt("saturation");
		this.brightness = data.optInt("brightness");
		this.is_black_and_white = data.optBoolean("is_black_and_white");
		this.creation_tsz = data.optLong("creation_tsz");
		this.listing_id = data.optInt("listing_id");
		this.rank = data.optInt("rank");
		this.url_75x75 = data.optString("url_75x75");
		this.url_170x135 = data.optString("url_170x135");
		this.url_570xN = data.optString("url_570xN");
		this.url_fullxfull = data.optString("url_fullxfull");
		this.full_height = data.optInt("full_height");
		this.full_width = data.optInt("full_width");

		JSONObject listingJSONObject = data.optJSONObject("Listing");
		if(listingJSONObject != null){
			this.listing = new Listing();
			this.listing.parseData(listingJSONObject);
		}
	}
	
	
}