package com.etsy.etsyRequests;

public class ShowcaseRequest extends EtsyRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1334823644344211018L;
	protected ShowcaseRequest(String requestUrl, String requestType){
		super(requestUrl, requestType);
	}

		/*
	 * Get a list of all methods available.
	 */
	public static ShowcaseRequest getMethodTable(){
		String methodUrl = "/";
		String methodType = "GET";
		ShowcaseRequest er = new ShowcaseRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Get server time, in epoch seconds notation.
	 */
	public static ShowcaseRequest getServerEpoch(){
		String methodUrl = "/server/epoch";
		String methodType = "GET";
		ShowcaseRequest er = new ShowcaseRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Check that the server is alive.
	 */
	public static ShowcaseRequest ping(){
		String methodUrl = "/server/ping";
		String methodType = "GET";
		ShowcaseRequest er = new ShowcaseRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Returns active showcase listings for the given lookup name.  This is related to but slightly different from the name field returned, which is a name value suitable for display
	 */
	public static ShowcaseRequest getActiveShowcaseListingsByLookupName(String name){
		String methodUrl = "/showcases/" + name;
		String methodType = "GET";
		ShowcaseRequest er = new ShowcaseRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Returns active showcase listings for the given tag / category.
	 */
	public static ShowcaseRequest getActiveShowcaseListingsByTag(String tag){
		String methodUrl = "/showcases/tags/" + tag;
		String methodType = "GET";
		ShowcaseRequest er = new ShowcaseRequest(methodUrl, methodType);

		return er;
	}
	}