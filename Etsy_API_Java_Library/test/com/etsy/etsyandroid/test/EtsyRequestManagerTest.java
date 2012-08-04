package com.etsy.etsyandroid.test;

import java.net.ProxySelector;

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
import com.etsy.etsyRequests.EtsyRequest;
import com.etsy.etsyRequests.UsersRequest;

import static org.junit.Assert.*;

public class EtsyRequestManagerTest{
	private EtsyRequestManager requestManager;
	private final String apiKey = "k37kydm6oly86w7e8o7lsx52";
    private final String apiSecret = "2oigiwvdjo";
    private final String callback = "etsyandroidexample://calvinhu.net/";
    private final String[] scope_array = {PermissionScope.READ_LISTINGS, PermissionScope.READ_FEEDBACK};
    private final PermissionScope scope = new PermissionScope(scope_array);
    
    private BaseTokenStorage tokenStore;
	
    
    @Before
	public void setup(){
		requestManager = new EtsyRequestManager(apiKey, apiSecret, callback, scope);
		
		DefaultHttpClient client = new DefaultHttpClient();
		HttpRoutePlanner routePlanner = new ProxySelectorRoutePlanner(
		    client.getConnectionManager().getSchemeRegistry(),
		    ProxySelector.getDefault()
		);
		client.setRoutePlanner(routePlanner);
	}


    @Rule public Recorder recorder = new Recorder();
    
    @Betamax(tape="EtsyAPILibraryTape")
    @Test
	public void testStartAuthentication() {
		String returnedUrl = requestManager.startAuthentication();
		assertEquals(returnedUrl, "http://www.etsy.com/oauth/signin?oauth_token=" + requestManager.getRequestToken().getToken());
	
	}

    @Betamax(tape="EtsyAPILibraryTape")
    @Test
	public void testFinishAuthentication() {
    	requestManager.setRequestToken(new Token("f4a0cebde3873d6f6cd6c545793a96", "9461ca5764"));
    	
    	String verifierUrl = "6a133d23";
    	tokenStore = new MapStorage();
		boolean oAuthSuccess = requestManager.finishAuthentication(verifierUrl, tokenStore);
		assertEquals(oAuthSuccess, true);
    }

    @Betamax(tape="EtsyAPILibraryTape")
    @Test
	public void testRetrieveAccessToken() {
    	authenticate();
    	
		Token accessTokenBefore = requestManager.getAccessToken();
		assertEquals(true, requestManager.retrieveAccessToken());
		Token accessTokenAfter = requestManager.getAccessToken();
		
		assertEquals(accessTokenBefore.getToken(), accessTokenAfter.getToken());
		assertEquals(accessTokenBefore.getSecret(), accessTokenAfter.getSecret());
	}

    @Betamax(tape="EtsyAPILibraryTape")
    @Test
	public void testHasAccessToken() {
		assertEquals(requestManager.hasAccessToken(), false);
		authenticate();
		assertEquals(requestManager.hasAccessToken(), true);
	}

    @Betamax(tape="EtsyAPILibraryTape")
    @Test
	public void testRunRequest() {
    	EtsyRequest request = UsersRequest.ping();
    	authenticate();
    	EtsyResult result = requestManager.runRequest(request);
    	assertNotNull(result);
    	assertEquals(result.getCode(), 200);
	}
    
    @Betamax(tape="EtsyAPILibraryTape")
    @Test
	public void testGetTokenStorage() {
    	assertEquals(requestManager.getAccessToken(), null);
    	authenticate();
		assertEquals(tokenStore, requestManager.getTokenStorage());
	}

    public void authenticate(){
    	requestManager.setRequestToken(new Token("f4a0cebde3873d6f6cd6c545793a96", "9461ca5764"));
    	String verifierUrl = "6a133d23";
    	tokenStore = new MapStorage();
		requestManager.finishAuthentication(verifierUrl, tokenStore);
    }
}
