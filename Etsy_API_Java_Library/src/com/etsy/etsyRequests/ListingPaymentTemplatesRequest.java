package com.etsy.etsyRequests;

public class ListingPaymentTemplatesRequest extends EtsyRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1039943628781168527L;
	protected ListingPaymentTemplatesRequest(String requestUrl, String requestType){
		super(requestUrl, requestType);
	}

		/*
	 * Get a list of all methods available.
	 */
	public static ListingPaymentTemplatesRequest getMethodTable(){
		String methodUrl = "/";
		String methodType = "GET";
		ListingPaymentTemplatesRequest er = new ListingPaymentTemplatesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Creates a new PaymentTemplate
	 */
	public static ListingPaymentTemplatesRequest createPaymentTemplate(){
		String methodUrl = "/payments/templates";
		String methodType = "POST";
		ListingPaymentTemplatesRequest er = new ListingPaymentTemplatesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Retrieves a PaymentTemplate by id.
	 */
	public static ListingPaymentTemplatesRequest getPaymentTemplate(String paymentTemplateId){
		String methodUrl = "/payments/templates/" + paymentTemplateId;
		String methodType = "GET";
		ListingPaymentTemplatesRequest er = new ListingPaymentTemplatesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Updates a PaymentTemplate
	 */
	public static ListingPaymentTemplatesRequest updatePaymentTemplate(String paymentTemplateId){
		String methodUrl = "/payments/templates/" + paymentTemplateId;
		String methodType = "PUT";
		ListingPaymentTemplatesRequest er = new ListingPaymentTemplatesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Get server time, in epoch seconds notation.
	 */
	public static ListingPaymentTemplatesRequest getServerEpoch(){
		String methodUrl = "/server/epoch";
		String methodType = "GET";
		ListingPaymentTemplatesRequest er = new ListingPaymentTemplatesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Check that the server is alive.
	 */
	public static ListingPaymentTemplatesRequest ping(){
		String methodUrl = "/server/ping";
		String methodType = "GET";
		ListingPaymentTemplatesRequest er = new ListingPaymentTemplatesRequest(methodUrl, methodType);

		return er;
	}
	}