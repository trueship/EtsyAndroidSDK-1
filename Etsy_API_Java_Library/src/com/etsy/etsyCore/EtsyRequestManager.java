package com.etsy.etsyCore;

import java.io.OutputStream;

import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;
import com.etsy.etsyRequests.EtsyRequest;
import com.etsy.etsyScribe.EtsyAPI;

/**
 * This class deals with the OAuth authentication of and requests to the Etsy RESTful API.
 */

public class EtsyRequestManager{
	private String apiKey, apiSecret, callback, scope;
	private final String TOKEN_NAME = "EtsyApiAccessToken";
	private final String API_ENDPOINT = "http://openapi.etsy.com/v2";
	
	private OAuthService etsyService;
	private Token requestToken;
	private Token accessToken;
	private BaseTokenStorage storageInterface;
	
	/**
	 * Constructs an EtsyRequestManager that will authenticate with the provided credentials.
	 * @param apiKey Your OAuth consumer key.
	 * @param apiSecret Your OAuth consumer secret.
	 * @param callback Your OAuth callback url.
	 * @param scope A PermissionScope object that contains the requested permission scopes.
	 */
	public EtsyRequestManager(String apiKey, String apiSecret, String callback, PermissionScope scope){
		this.apiKey = apiKey;
		this.apiSecret = apiSecret;
		this.callback = callback;
		
		ServiceBuilder esb = new ServiceBuilder()
			.provider(EtsyAPI.class)
			.apiKey(this.apiKey)
			.apiSecret(this.apiSecret)
			.callback(this.callback);
		
		if(scope != null){
			this.scope = scope.getScope();
			esb = esb.scope(this.scope);
		}
		
		etsyService = esb.build();
	
		requestToken = null;
		accessToken = null;
		storageInterface = null;
	}
	
	public EtsyRequestManager(String apiKey, String apiSecret, String callback, PermissionScope scope, OutputStream outputStream){
		this.apiKey = apiKey;
		this.apiSecret = apiSecret;
		this.callback = callback;
		
		ServiceBuilder esb = new ServiceBuilder()
			.provider(EtsyAPI.class)
			.apiKey(this.apiKey)
			.apiSecret(this.apiSecret)
			.callback(this.callback)
			.debugStream(outputStream); //Delete in production.
		
		if(scope != null){
			this.scope = scope.getScope();
			esb = esb.scope(this.scope);
		}
		
		etsyService = esb.build();
	
		requestToken = null;
		accessToken = null;
		storageInterface = null;
	}
	
	/**
	 * First part of the OAuth authentication process.
	 * @return Returns the url that the user needs to sign in at.
	 */
	public String startAuthentication(){
		requestToken = etsyService.getRequestToken();
		String url = etsyService.getAuthorizationUrl(requestToken);
		return url;
	}
	
	/**
	 * Second half of the OAuth authentication process.
	 * @param uri The uri that contains the OAuth verification code.
	 * @param storageInterface The token storage object that the access token will be stored in for future use.
	 * 			If null, the accessToken will not be stored.
	 * @return True if authentication was successful and access token was received. Otherwise, false.
	 */
	public boolean finishAuthentication(String verifierString, BaseTokenStorage storageInterface){
		accessToken = null;
		
		if(verifierString != null){
			Verifier verifier = new Verifier(verifierString);
			accessToken = etsyService.getAccessToken(requestToken, verifier);
			
			//Write access token to storage
			if(storageInterface != null){
				this.storageInterface = storageInterface;
				this.storageInterface.putToken(TOKEN_NAME, accessToken);
			}
			
		}
		
		return accessToken != null;
	}
	
	/**
	 * Retrieves an previously stored access token.
	 * @param storageInterface The storage object that contains the access token.
	 * @return True if access token was retrieved, false otherwise.
	 */
	public boolean retrieveAccessToken(){
		if(this.storageInterface != null){
			accessToken = this.storageInterface.getToken(TOKEN_NAME);
			if(accessToken != null){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Checks if access token is instantiated.
	 * @return True if access token is instantiated, false otherwise.
	 */
	public boolean hasAccessToken(){
		if(accessToken == null){
			return false;
		}
		return true;
	}
	
	/**
	 * Converts EtsyRequest methodType String to Verb.
	 * @param methodType The String representation of the HTTP request type.
	 * @return The appropriate Verb object.
	 */
	private Verb convertToVerb(String methodType){
		if(methodType.equals("DELETE")){
			return Verb.DELETE;
		}
		else if(methodType.equals("POST")){
			return Verb.POST;
		}
		else if(methodType.equals("PUT")){
			return Verb.PUT;
		}
		else{
			return Verb.GET;
		}
	}

	/**
	 * Runs an Etsy API request.
	 * @param etsyRequest The EtsyRequest object to run.
	 * @return The Result object with the parsed HTTP response.
	 */
	public EtsyResult runRequest(EtsyRequest etsyRequest){
		EtsyResult result = new EtsyResult();
		StringBuilder url = new StringBuilder(API_ENDPOINT);
		if(accessToken != null) {
		    url.append(etsyRequest.getMethod());
		} else{
		    String method = etsyRequest.getMethod();
		    // check to see what separator should be used when appending the api_key to the full url.
		    String separator = "&";
		    if (method.indexOf("?") == -1) {
		        separator = "?";
		    }
		    url.append(method);
		    url.append(separator);
		    url.append("api_key=");
		    url.append(this.apiKey);
		}
		OAuthRequest request = new OAuthRequest(convertToVerb(etsyRequest.getType()), url.toString());
		etsyService.signRequest(accessToken, request);
		Response response = request.send();
		result.parseResult(response);
		return result;
	}
	
	
	/**
	 * Returns the BaseTokenStorage object.
	 * @return The BaseTokenStorage object passed in during finishAuthentication().
	 */
	public BaseTokenStorage getTokenStorage(){
		return storageInterface;
	}
	
	public Token getRequestToken(){
		return requestToken;
	}
	
	public void setRequestToken(Token requestToken){
		this.requestToken = requestToken;
	}
	
	public Token getAccessToken(){
		return accessToken;
	}
	
	public void setTokenStorage(BaseTokenStorage storage){
		this.storageInterface = storage;
	}
}
