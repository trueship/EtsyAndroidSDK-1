package com.etsy.etsyModels;

import org.json.JSONException;
import org.json.JSONObject;

public class Category extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2588123803228986579L;
	private int category_id;
	private String name;
	private String meta_title;
	private String meta_keywords;
	private String meta_description;
	private String page_description;
	private String page_title;
	private String category_name;
	private String short_name;
	private String long_name;
	private int num_children;


	
	public int getCategoryId() {
		return category_id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getMetaTitle() {
		return meta_title;
	}
	
	public String getMetaKeywords() {
		return meta_keywords;
	}
	
	public String getMetaDescription() {
		return meta_description;
	}
	
	public String getPageDescription() {
		return page_description;
	}
	
	public String getPageTitle() {
		return page_title;
	}
	
	public String getCategoryName() {
		return category_name;
	}
	
	public String getShortName() {
		return short_name;
	}
	
	public String getLongName() {
		return long_name;
	}
	
	public int getNumChildren() {
		return num_children;
	}


	@Override
	public void parseData(JSONObject data) throws JSONException {
		this.category_id = data.optInt("category_id");
		this.name = data.optString("name");
		this.meta_title = data.optString("meta_title");
		this.meta_keywords = data.optString("meta_keywords");
		this.meta_description = data.optString("meta_description");
		this.page_description = data.optString("page_description");
		this.page_title = data.optString("page_title");
		this.category_name = data.optString("category_name");
		this.short_name = data.optString("short_name");
		this.long_name = data.optString("long_name");
		this.num_children = data.optInt("num_children");

	}
	
	
}