package com.etsy.etsyModels;

import org.json.JSONException;
import org.json.JSONObject;

public class ShopTranslation extends BaseModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4660683018371843065L;
	private int shopId;
	private String language;
	private String announcement;
	private String policyWelcome;
	private String policyPayment;
	private String policyShipping;
	private String policyRefunds;
	private String policyAdditional;
	private String policySellerInfo;
	private String saleMessage;
	private String title;
	private String vacationAutoreply;
	private String vacationMessage;
	
	public int getShopId(){
		return shopId;
	}
	
	public String getLanguage(){
		return language;
	}
	
	public String getAnnouncement(){
		return announcement;
	}
	
	public String getPolicyWelcome(){
		return policyWelcome;
	}
	
	public String getPolicyPayment(){
		return policyPayment;
	}
	
	public String getPolicyShipping(){
		return policyShipping;
	}
	
	public String getPolicyRefunds(){
		return policyRefunds;
	}
	
	public String getPolicyAdditional(){
		return policyAdditional;
	}
	
	public String getPolicySellerInfo(){
		return policySellerInfo;
	}
	
	public String getSaleMessage(){
		return saleMessage;
	}

	public String getTitle(){
		return title;
	}
	
	public String getVacationAutoreply(){
		return vacationAutoreply;
	}
	
	public String getVacationMessage(){
		return vacationMessage;
	}
	
	@Override
	public void parseData(JSONObject data) throws JSONException {
		this.shopId = data.optInt("shop_id");
		this.language = data.optString("language");
		this.announcement = data.optString("announcement");
		this.policyWelcome = data.optString("policy_welcome");
		this.policyPayment = data.optString("policy_payment");
		this.policyShipping = data.optString("policy_shipping");
		this.policyRefunds = data.optString("policy_refunds");
		this.policyAdditional = data.optString("policy_additional");
		this.policySellerInfo = data.optString("policy_seller_info");
		this.saleMessage = data.optString("sale_message");
		this.title = data.optString("title");
		this.vacationAutoreply = data.optString("vacation_autoreply");
		this.vacationMessage = data.optString("vacation_message");
	}

}
