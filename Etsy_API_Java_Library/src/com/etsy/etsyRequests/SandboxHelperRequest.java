package com.etsy.etsyRequests;

public class SandboxHelperRequest extends EtsyRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1395902706709537213L;
	protected SandboxHelperRequest(String requestUrl, String requestType){
		super(requestUrl, requestType);
	}

		/*
	 * Get a list of all methods available.
	 */
	public static SandboxHelperRequest getMethodTable(){
		String methodUrl = "/";
		String methodType = "GET";
		SandboxHelperRequest er = new SandboxHelperRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Creates a purchase for the current OAuth user, including Order, Receipt and Transaction resources. This method is only available via the Sandbox API. Listing IDs must be active, and belong to the same seller user ID. The buyer must have at least one UserAddress record, or an error will be thrown.
	 */
	public static SandboxHelperRequest createReceiptOnSandbox(){
		String methodUrl = "/receipts";
		String methodType = "POST";
		SandboxHelperRequest er = new SandboxHelperRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Get server time, in epoch seconds notation.
	 */
	public static SandboxHelperRequest getServerEpoch(){
		String methodUrl = "/server/epoch";
		String methodType = "GET";
		SandboxHelperRequest er = new SandboxHelperRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Check that the server is alive.
	 */
	public static SandboxHelperRequest ping(){
		String methodUrl = "/server/ping";
		String methodType = "GET";
		SandboxHelperRequest er = new SandboxHelperRequest(methodUrl, methodType);

		return er;
	}
	}