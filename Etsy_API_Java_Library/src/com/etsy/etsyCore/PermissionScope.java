package com.etsy.etsyCore;

/**
 * This class wraps up the permission scopes used by the Etsy API during OAuth authentication.
 */
public class PermissionScope {
	public static final String READ_EMAIL_ADDRESSES = "email_r";
	public static final String READ_LISTINGS = "listings_r";
	public static final String WRITE_LISTINGS = "listings_w";
	public static final String DELETE_LISTINGS = "listings_d";
	public static final String READ_TRANSACTIONS = "transactions_r";
	public static final String READ_BILLING = "billing_r";
	public static final String READ_PROFILE = "profile_r";
	public static final String WRITE_PROFILE = "profile_w";
	public static final String READ_SHIPPING_ADDRESSES = "address_r";
	public static final String WRITE_SHIPPING_ADDRESSES = "address_w";
	public static final String READ_WRITE_FAVORITES = "favorites_rw";
	public static final String READ_WRITE_SHOPS = "shops_rw";
	public static final String READ_WRITE_CART = "cart_rw";
	public static final String READ_WRITE_RECOMMENDATION = "recommend_rw";
	public static final String READ_FEEDBACK = "feedback_r";
	public static final String WRITE_TREASURY = "treasury_w";
	
	private final String DELIMITER = "+";
	private String scope;
	
	/**
	 * Constructor that takes a scope.
	 * @param scope Initializes using this scope string.
	 */
	public PermissionScope(String scope){
		this.scope = scope;
	}
	
	/**
	 * Constructor that takes an array of scope strings and initializes using all those scopes.
	 * @param scopes The array of scopes to include.
	 */
	public PermissionScope(String[] scopes){
		scope = "";
		for(int i = 0; i < scopes.length; i++){
			scope += scopes[i];
			if(i < scopes.length - 1){
				scope += DELIMITER;
			}
		}
	}
	
	/**
	 * Returns the formatted scope string.
	 * @return The formmatted scope string.
	 */
	public String getScope(){
		return scope;
	}
}
