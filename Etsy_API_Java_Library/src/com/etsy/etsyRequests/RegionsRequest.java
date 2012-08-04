package com.etsy.etsyRequests;

public class RegionsRequest extends EtsyRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2629767932683100050L;
	protected RegionsRequest(String requestUrl, String requestType){
		super(requestUrl, requestType);
	}

		/*
	 * Get a list of all methods available.
	 */
	public static RegionsRequest getMethodTable(){
		String methodUrl = "/";
		String methodType = "GET";
		RegionsRequest er = new RegionsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Finds all Region.
	 */
	public static RegionsRequest findAllRegion(){
		String methodUrl = "/regions";
		String methodType = "GET";
		RegionsRequest er = new RegionsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Retrieves a Region by id.
	 */
	public static RegionsRequest getRegion(String regionId){
		String methodUrl = "/regions/" + regionId;
		String methodType = "GET";
		RegionsRequest er = new RegionsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Get server time, in epoch seconds notation.
	 */
	public static RegionsRequest getServerEpoch(){
		String methodUrl = "/server/epoch";
		String methodType = "GET";
		RegionsRequest er = new RegionsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Check that the server is alive.
	 */
	public static RegionsRequest ping(){
		String methodUrl = "/server/ping";
		String methodType = "GET";
		RegionsRequest er = new RegionsRequest(methodUrl, methodType);

		return er;
	}
	}