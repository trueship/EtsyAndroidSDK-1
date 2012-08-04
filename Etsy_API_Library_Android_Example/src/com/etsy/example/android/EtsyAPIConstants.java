package com.etsy.example.android;

import com.etsy.etsyCore.PermissionScope;

/*
 * Enter your Etsy API info here.
 */

public interface EtsyAPIConstants {
	public static final String apiKey = "your_api_consumer_key";
    public static final String apiSecret = "your_api_consumer_secret";
    public static final String callback = "your_callback";
    public static final String[] scope_array = {PermissionScope.READ_LISTINGS, PermissionScope.READ_FEEDBACK};
    public static final PermissionScope scope = new PermissionScope(scope_array);
    
}
