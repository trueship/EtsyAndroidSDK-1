package com.etsy.etsyRequests;

public class CountriesRequest extends EtsyRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4920262228307284102L;
	protected CountriesRequest(String requestUrl, String requestType){
		super(requestUrl, requestType);
	}

		/*
	 * Get a list of all methods available.
	 */
	public static CountriesRequest getMethodTable(){
		String methodUrl = "/";
		String methodType = "GET";
		CountriesRequest er = new CountriesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Finds all Country.
	 */
	public static CountriesRequest findAllCountry(){
		String methodUrl = "/countries";
		String methodType = "GET";
		CountriesRequest er = new CountriesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Retrieves a Country by id.
	 */
	public static CountriesRequest getCountry(String countryId){
		String methodUrl = "/countries/" + countryId;
		String methodType = "GET";
		CountriesRequest er = new CountriesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Get server time, in epoch seconds notation.
	 */
	public static CountriesRequest getServerEpoch(){
		String methodUrl = "/server/epoch";
		String methodType = "GET";
		CountriesRequest er = new CountriesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Check that the server is alive.
	 */
	public static CountriesRequest ping(){
		String methodUrl = "/server/ping";
		String methodType = "GET";
		CountriesRequest er = new CountriesRequest(methodUrl, methodType);

		return er;
	}
	}