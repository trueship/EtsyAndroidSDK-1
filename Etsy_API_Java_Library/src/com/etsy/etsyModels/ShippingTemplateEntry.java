package com.etsy.etsyModels;

import org.json.JSONException;
import org.json.JSONObject;

public class ShippingTemplateEntry extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4160232521863154238L;
	private int shipping_template_entry_id;
	private int shipping_template_id;
	private String currency_code;
	private int origin_country_id;
	private int destination_country_id;
	private int destination_region_id;
	private float primary_cost;
	private float secondary_cost;

	private Country originCountry;
	private Country destinationCountry;
	private Region destinationRegion;
	private ShippingTemplate template;

	
	public int getShippingTemplateEntryId() {
		return shipping_template_entry_id;
	}
	
	public int getShippingTemplateId() {
		return shipping_template_id;
	}
	
	public String getCurrencyCode() {
		return currency_code;
	}
	
	public int getOriginCountryId() {
		return origin_country_id;
	}
	
	public int getDestinationCountryId() {
		return destination_country_id;
	}
	
	public int getDestinationRegionId() {
		return destination_region_id;
	}
	
	public float getPrimaryCost() {
		return primary_cost;
	}
	
	public float getSecondaryCost() {
		return secondary_cost;
	}

	public Country getOriginCountry() {
		return originCountry;
	}
	public Country getDestinationCountry() {
		return destinationCountry;
	}
	public Region getDestinationRegion() {
		return destinationRegion;
	}
	public ShippingTemplate getTemplate() {
		return template;
	}

	@Override
	public void parseData(JSONObject data) throws JSONException {
		this.shipping_template_entry_id = data.optInt("shipping_template_entry_id");
		this.shipping_template_id = data.optInt("shipping_template_id");
		this.currency_code = data.optString("currency_code");
		this.origin_country_id = data.optInt("origin_country_id");
		this.destination_country_id = data.optInt("destination_country_id");
		this.destination_region_id = data.optInt("destination_region_id");
		this.primary_cost = data.optLong("primary_cost");
		this.secondary_cost = data.optLong("secondary_cost");

		JSONObject originCountryJSONObject = data.optJSONObject("OriginCountry");
		if(originCountryJSONObject != null){
			this.originCountry = new Country();
			this.originCountry.parseData(originCountryJSONObject);
		}
		JSONObject destinationCountryJSONObject = data.optJSONObject("DestinationCountry");
		if(destinationCountryJSONObject != null){
			this.destinationCountry = new Country();
			this.destinationCountry.parseData(destinationCountryJSONObject);
		}
		JSONObject destinationRegionJSONObject = data.optJSONObject("DestinationRegion");
		if(destinationRegionJSONObject != null){
			this.destinationRegion = new Region();
			this.destinationRegion.parseData(destinationRegionJSONObject);
		}
		JSONObject templateJSONObject = data.optJSONObject("Template");
		if(templateJSONObject != null){
			this.template = new ShippingTemplate();
			this.template.parseData(templateJSONObject);
		}
	}
	
	
}