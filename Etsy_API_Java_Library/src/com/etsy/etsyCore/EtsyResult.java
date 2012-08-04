package com.etsy.etsyCore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.scribe.model.Response;

import com.etsy.etsyModels.*;

/**
 * Parses HTTP responses from the Etsy API.
 */
public class EtsyResult {
	
	private int count;
	private int maxCount;
	private List<BaseModel> results;
	private String error;
	private int code;
	
	/**
	 * Result Constructor.
	 */
	public EtsyResult(){
		count = -1;
		maxCount = -1;
		results = null;
		error = null;
		code = -1;
	}
	
	/**
	 * Returns the parsed HTTP error if it exists.
	 * @return The error as a String or null if there is no error.
	 */
	public String getError() {
		return error;
	}
	
	/**
	 * Returns the amount of results in the HTTP response.
	 * @return The amount of results or -1 if there was an error.
	 */
	public int getCount() {
		return count;
	}
	
	/**
	 * Returns the max count of results in the HTTP response.
	 * @return The max count of results of -1 if there was an error.
	 */
	public int getMaxCount() {
		return maxCount;
	}
	
	/**
	 * Returns the List of parsed Etsy models.
	 * @return A list of Etsy models parsed from the response or null if there was an error.
	 */
	public List<BaseModel> getResults() {
		return results;
	}
	
	/**
	 * Returns the HTTP response code.
	 * @return The HTTP response code.
	 */
	public int getCode(){
		return code;
	}
	
	/**
	 * Parses the HTTP response from a Response object.
	 * @param response The Response object to parse.
	 */
	public void parseResult(Response response){
		
		try{
			InputStream responseStream = response.getStream();
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(responseStream));
			String responseLine;
			StringBuilder responseBuilder = new StringBuilder();
			while((responseLine = bufferedReader.readLine()) != null){
				responseBuilder.append(responseLine);
			}
			String responseString = responseBuilder.toString();
			this.code = response.getCode();
			
			if(this.code == 200){
				JSONObject data = new JSONObject(responseString);
				String returnType = data.getString("type");
				this.maxCount = data.optInt("count");
				this.results = new ArrayList<BaseModel>();
				
				JSONArray results = data.getJSONArray("results");
				for(int i=0; i < results.length(); i++){
					BaseModel m = this.getObjectForType(returnType);
					if(m != null){
						m.parseData(results.getJSONObject(i));
						this.results.add(m);
					}
				}
				this.count = this.results.size();
			}
			else{
				this.error = responseString;
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (JSONException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Returns appropriate Etsy model based on a String value. 
	 * @param type The type field from a JSONObject.
	 * @return The corresponding Etsy model.
	 */
	private BaseModel getObjectForType(String type) {
						if(type.equalsIgnoreCase("ApiMethod")){
			return new ApiMethod();
		}
								else if(type.equalsIgnoreCase("Avatar")){
			return new Avatar();
		}
								else if(type.equalsIgnoreCase("BillCharge")){
			return new BillCharge();
		}
								else if(type.equalsIgnoreCase("BillPayment")){
			return new BillPayment();
		}
								else if(type.equalsIgnoreCase("BillingOverview")){
			return new BillingOverview();
		}
								else if(type.equalsIgnoreCase("Cart")){
			return new Cart();
		}
								else if(type.equalsIgnoreCase("CartListing")){
			return new CartListing();
		}
								else if(type.equalsIgnoreCase("Category")){
			return new Category();
		}
								else if(type.equalsIgnoreCase("Country")){
			return new Country();
		}
								else if(type.equalsIgnoreCase("Coupon")){
			return new Coupon();
		}
								else if(type.equalsIgnoreCase("DataType")){
			return new DataType();
		}
								else if(type.equalsIgnoreCase("FavoriteListing")){
			return new FavoriteListing();
		}
								else if(type.equalsIgnoreCase("FavoriteUser")){
			return new FavoriteUser();
		}
								else if(type.equalsIgnoreCase("FeaturedTreasury")){
			return new FeaturedTreasury();
		}
								else if(type.equalsIgnoreCase("Feedback")){
			return new Feedback();
		}
								else if(type.equalsIgnoreCase("FeedbackInfo")){
			return new FeedbackInfo();
		}
								else if(type.equalsIgnoreCase("ForumPost")){
			return new ForumPost();
		}
								else if(type.equalsIgnoreCase("Listing")){
			return new Listing();
		}
								else if(type.equalsIgnoreCase("ListingImage")){
			return new ListingImage();
		}
								else if(type.equalsIgnoreCase("Order")){
			return new Order();
		}
								else if(type.equalsIgnoreCase("ParamList")){
			return new ParamList();
		}
								else if(type.equalsIgnoreCase("PaymentTemplate")){
			return new PaymentTemplate();
		}
								else if(type.equalsIgnoreCase("Receipt")){
			return new Receipt();
		}
								else if(type.equalsIgnoreCase("Region")){
			return new Region();
		}
								else if(type.equalsIgnoreCase("ShippingInfo")){
			return new ShippingInfo();
		}
								else if(type.equalsIgnoreCase("ShippingTemplate")){
			return new ShippingTemplate();
		}
								else if(type.equalsIgnoreCase("ShippingTemplateEntry")){
			return new ShippingTemplateEntry();
		}
								else if(type.equalsIgnoreCase("Shop")){
			return new Shop();
		}
								else if(type.equalsIgnoreCase("ShopSection")){
			return new ShopSection();
		}
								else if(type.equalsIgnoreCase("Style")){
			return new Style();
		}
								else if(type.equalsIgnoreCase("Tag")){
			return new Tag();
		}
								else if(type.equalsIgnoreCase("Team")){
			return new Team();
		}
								else if(type.equalsIgnoreCase("Transaction")){
			return new Transaction();
		}
								else if(type.equalsIgnoreCase("Treasury")){
			return new Treasury();
		}
								else if(type.equalsIgnoreCase("TreasuryCounts")){
			return new TreasuryCounts();
		}
								else if(type.equalsIgnoreCase("TreasuryListing")){
			return new TreasuryListing();
		}
								else if(type.equalsIgnoreCase("TreasuryListingData")){
			return new TreasuryListingData();
		}
								else if(type.equalsIgnoreCase("User")){
			return new User();
		}
								else if(type.equalsIgnoreCase("UserAddress")){
			return new UserAddress();
		}
								else if(type.equalsIgnoreCase("UserProfile")){
			return new UserProfile();
		}
					
		else {
			return null;
		}
	}
}