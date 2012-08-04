package com.etsy.etsyandroid.test;

import static org.junit.Assert.*;

import java.net.ProxySelector;
import java.util.List;

import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.ProxySelectorRoutePlanner;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.scribe.model.Token;

import betamax.Betamax;
import betamax.Recorder;

import com.etsy.etsyCore.BaseTokenStorage;
import com.etsy.etsyCore.EtsyRequestManager;
import com.etsy.etsyCore.EtsyResult;
import com.etsy.etsyCore.MapStorage;
import com.etsy.etsyCore.PermissionScope;
import com.etsy.etsyModels.BaseModel;
import com.etsy.etsyModels.Listing;
import com.etsy.etsyModels.ShippingInfo;
import com.etsy.etsyModels.User;
import com.etsy.etsyRequests.EtsyRequest;
import com.etsy.etsyRequests.ListingsRequest;
import com.etsy.etsyRequests.UsersRequest;

public class EtsyRequestTests {
	private EtsyRequestManager requestManager;
	private final String apiKey = "k37kydm6oly86w7e8o7lsx52";
    private final String apiSecret = "2oigiwvdjo";
    private final String callback = "etsyandroidexample://calvinhu.net/";
    private final String[] scope_array = {PermissionScope.READ_LISTINGS, PermissionScope.READ_FEEDBACK};
    private final PermissionScope scope = new PermissionScope(scope_array);

	@Before
	public void setup(){
		requestManager = new EtsyRequestManager(apiKey, apiSecret, callback, scope);
		requestManager.setRequestToken(new Token("c33579fd3430e360007d4bccf6bd8a", "3fc005733a"));
    	String verifierUrl = "7023ce4f";
    	BaseTokenStorage tokenStore = new MapStorage();
		requestManager.finishAuthentication(verifierUrl, tokenStore);
		
		DefaultHttpClient client = new DefaultHttpClient();
		HttpRoutePlanner routePlanner = new ProxySelectorRoutePlanner(
		    client.getConnectionManager().getSchemeRegistry(),
		    ProxySelector.getDefault()
		);
		client.setRoutePlanner(routePlanner);
	}

    @Rule public Recorder recorder = new Recorder();
    
    @Betamax(tape="EtsyRequestTestsTape")
    @Test
    public void testGetUsers(){
    	EtsyRequest request = UsersRequest.getUser("joshhalickman");
    	EtsyResult result = requestManager.runRequest(request);
    	List<BaseModel> modelList = result.getResults();
    	assertEquals(((User)modelList.get(0)).getLoginName(), "joshhalickman");
    }
    
    @Betamax(tape="EtsyRequestTestsTape")
    @Test
    public void testGetListings(){
    	EtsyRequest request = ListingsRequest.getListing("92439453");
    	EtsyResult result = requestManager.runRequest(request);
    	List<BaseModel> modelList = result.getResults();
    	assertEquals(((Listing)modelList.get(0)).getTitle(), "Etsy Stickers (Set of 5)");
    }
    
    @Betamax(tape="EtsyRequestTestsTape")
    @Test
    public void testGetShippingInfo(){
    	EtsyRequest request = ListingsRequest.findAllListingShippingInfo("92439453");
    	EtsyResult result = requestManager.runRequest(request);
    	List<BaseModel> modelList = result.getResults();
    	assertEquals(((ShippingInfo)modelList.get(0)).getOriginCountryName(), "United States");
    	assertEquals(((ShippingInfo)modelList.get(3)).getDestinationCountryName(), "Austria");
    }

}
