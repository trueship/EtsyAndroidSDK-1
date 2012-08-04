package com.etsy.etsyRequests;

public class BillChargesRequest extends EtsyRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1803741259124223489L;
	protected BillChargesRequest(String requestUrl, String requestType){
		super(requestUrl, requestType);
	}

		/*
	 * Get a list of all methods available.
	 */
	public static BillChargesRequest getMethodTable(){
		String methodUrl = "/";
		String methodType = "GET";
		BillChargesRequest er = new BillChargesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Get server time, in epoch seconds notation.
	 */
	public static BillChargesRequest getServerEpoch(){
		String methodUrl = "/server/epoch";
		String methodType = "GET";
		BillChargesRequest er = new BillChargesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Check that the server is alive.
	 */
	public static BillChargesRequest ping(){
		String methodUrl = "/server/ping";
		String methodType = "GET";
		BillChargesRequest er = new BillChargesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Retrieves a set of BillCharge objects associated to a User.
	 */
	public static BillChargesRequest findAllUserCharges(String userId){
		String methodUrl = "/users/" + userId + "/charges";
		String methodType = "GET";
		BillChargesRequest er = new BillChargesRequest(methodUrl, methodType);

		return er;
	}
	}