package com.etsy.etsyRequests;

public class BillingOverviewRequest extends EtsyRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5484468411454141600L;
	protected BillingOverviewRequest(String requestUrl, String requestType){
		super(requestUrl, requestType);
	}

		/*
	 * Get a list of all methods available.
	 */
	public static BillingOverviewRequest getMethodTable(){
		String methodUrl = "/";
		String methodType = "GET";
		BillingOverviewRequest er = new BillingOverviewRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Get server time, in epoch seconds notation.
	 */
	public static BillingOverviewRequest getServerEpoch(){
		String methodUrl = "/server/epoch";
		String methodType = "GET";
		BillingOverviewRequest er = new BillingOverviewRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Check that the server is alive.
	 */
	public static BillingOverviewRequest ping(){
		String methodUrl = "/server/ping";
		String methodType = "GET";
		BillingOverviewRequest er = new BillingOverviewRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Retrieves the user's current balance.
	 */
	public static BillingOverviewRequest getUserBillingOverview(String userId){
		String methodUrl = "/users/" + userId + "/billing/overview";
		String methodType = "GET";
		BillingOverviewRequest er = new BillingOverviewRequest(methodUrl, methodType);

		return er;
	}
	}