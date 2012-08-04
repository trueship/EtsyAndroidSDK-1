package com.etsy.etsyRequests;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;

import org.scribe.utils.OAuthEncoder;

public abstract class EtsyRequest implements Serializable{
	private static final long serialVersionUID = 2715154933950012215L;
	
	private String requestUrl;
	private String requestType;
	private String requestParameters;

	protected EtsyRequest(String requestUrl, String requestType){
		this.requestUrl = requestUrl;
		this.requestType = requestType;
		this.requestParameters = "";
	}

	public String getMethod(){
		return requestUrl + requestParameters;
	}

	public String getType(){
		return requestType;
	}
	
	public String getParams(){
		return requestParameters;
	}
	
	public void addParams(Map<String, String> parameters){
		String paramSuffix = "";
		
		if(parameters.size() > 0){
			paramSuffix = "?";
			Iterator<String> keyIterator = parameters.keySet().iterator();
			while(keyIterator.hasNext()){
				String currentKey = OAuthEncoder.encode(keyIterator.next());
				paramSuffix += currentKey + "=" + parameters.get(currentKey);
				if(keyIterator.hasNext()){
					paramSuffix += "&";
				}
			}
		}
		
		requestParameters = paramSuffix.replace(' ', '+');
	}
}