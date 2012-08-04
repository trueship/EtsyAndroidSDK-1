package com.etsy.etsyModels;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ShippingTemplate extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -587097219451833963L;
	private int shipping_template_id;
	private String title;
	private int user_id;

	private ShippingTemplateEntry[] entries;

	
	public int getShippingTemplateId() {
		return shipping_template_id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public int getUserId() {
		return user_id;
	}

	public ShippingTemplateEntry[] getEntries() {
		return entries;
	}

	@Override
	public void parseData(JSONObject data) throws JSONException {
		this.shipping_template_id = data.optInt("shipping_template_id");
		this.title = data.optString("title");
		this.user_id = data.optInt("user_id");

		JSONArray entriesArray = data.optJSONArray("Entries");
		if (entriesArray != null){
			this.entries = new ShippingTemplateEntry[entriesArray.length()];
			for(int i = 0; i < entriesArray.length(); i++){
				this.entries[i] = new ShippingTemplateEntry();
				this.entries[i].parseData(entriesArray.getJSONObject(i));
			}
		}
	}
	
	
}