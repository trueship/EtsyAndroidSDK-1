package com.etsy.etsyRequests;

public class BillPaymentsRequest extends EtsyRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1294522821918683910L;
	protected BillPaymentsRequest(String requestUrl, String requestType){
		super(requestUrl, requestType);
	}

		/*
	 * Get a list of all methods available.
	 */
	public static BillPaymentsRequest getMethodTable(){
		String methodUrl = "/";
		String methodType = "GET";
		BillPaymentsRequest er = new BillPaymentsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Get server time, in epoch seconds notation.
	 */
	public static BillPaymentsRequest getServerEpoch(){
		String methodUrl = "/server/epoch";
		String methodType = "GET";
		BillPaymentsRequest er = new BillPaymentsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Check that the server is alive.
	 */
	public static BillPaymentsRequest ping(){
		String methodUrl = "/server/ping";
		String methodType = "GET";
		BillPaymentsRequest er = new BillPaymentsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Retrieves a set of BillPayment objects associated to a User.
	 */
	public static BillPaymentsRequest findAllUserPayments(String userId){
		String methodUrl = "/users/" + userId + "/payments";
		String methodType = "GET";
		BillPaymentsRequest er = new BillPaymentsRequest(methodUrl, methodType);

		return er;
	}
	}