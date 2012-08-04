package com.etsy.etsyRequests;

public class AvatarRequest extends EtsyRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5130867575443453941L;
	protected AvatarRequest(String requestUrl, String requestType){
		super(requestUrl, requestType);
	}

		/*
	 * Get a list of all methods available.
	 */
	public static AvatarRequest getMethodTable(){
		String methodUrl = "/";
		String methodType = "GET";
		AvatarRequest er = new AvatarRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Get server time, in epoch seconds notation.
	 */
	public static AvatarRequest getServerEpoch(){
		String methodUrl = "/server/epoch";
		String methodType = "GET";
		AvatarRequest er = new AvatarRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Check that the server is alive.
	 */
	public static AvatarRequest ping(){
		String methodUrl = "/server/ping";
		String methodType = "GET";
		AvatarRequest er = new AvatarRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Upload a new user avatar image
	 */
	public static AvatarRequest uploadAvatar(String userId){
		String methodUrl = "/users/" + userId + "/avatar";
		String methodType = "POST";
		AvatarRequest er = new AvatarRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Get avatar image source
	 */
	public static AvatarRequest getAvatarImgSrc(String userId){
		String methodUrl = "/users/" + userId + "/avatar/src";
		String methodType = "GET";
		AvatarRequest er = new AvatarRequest(methodUrl, methodType);

		return er;
	}
	}