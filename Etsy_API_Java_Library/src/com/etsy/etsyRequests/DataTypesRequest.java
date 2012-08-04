package com.etsy.etsyRequests;

public class DataTypesRequest extends EtsyRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3454663673673886300L;
	protected DataTypesRequest(String requestUrl, String requestType){
		super(requestUrl, requestType);
	}

		/*
	 * Get a list of all methods available.
	 */
	public static DataTypesRequest getMethodTable(){
		String methodUrl = "/";
		String methodType = "GET";
		DataTypesRequest er = new DataTypesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Get server time, in epoch seconds notation.
	 */
	public static DataTypesRequest getServerEpoch(){
		String methodUrl = "/server/epoch";
		String methodType = "GET";
		DataTypesRequest er = new DataTypesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Check that the server is alive.
	 */
	public static DataTypesRequest ping(){
		String methodUrl = "/server/ping";
		String methodType = "GET";
		DataTypesRequest er = new DataTypesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Describes the legal values for Listing.occasion.
	 */
	public static DataTypesRequest describeOccasionEnum(){
		String methodUrl = "/types/enum/occasion";
		String methodType = "GET";
		DataTypesRequest er = new DataTypesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Describes the legal values for Listing.recipient.
	 */
	public static DataTypesRequest describeRecipientEnum(){
		String methodUrl = "/types/enum/recipient";
		String methodType = "GET";
		DataTypesRequest er = new DataTypesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Describes the legal values for Listing.when_made.
	 */
	public static DataTypesRequest describeWhenMadeEnum(){
		String methodUrl = "/types/enum/when_made";
		String methodType = "GET";
		DataTypesRequest er = new DataTypesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Describes the legal values for Listing.who_made.
	 */
	public static DataTypesRequest describeWhoMadeEnum(){
		String methodUrl = "/types/enum/who_made";
		String methodType = "GET";
		DataTypesRequest er = new DataTypesRequest(methodUrl, methodType);

		return er;
	}
	}