package com.etsy.etsyRequests;

public class ShippingTemplateEntriesRequest extends EtsyRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8473794218532061799L;
	protected ShippingTemplateEntriesRequest(String requestUrl, String requestType){
		super(requestUrl, requestType);
	}

		/*
	 * Get a list of all methods available.
	 */
	public static ShippingTemplateEntriesRequest getMethodTable(){
		String methodUrl = "/";
		String methodType = "GET";
		ShippingTemplateEntriesRequest er = new ShippingTemplateEntriesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Get server time, in epoch seconds notation.
	 */
	public static ShippingTemplateEntriesRequest getServerEpoch(){
		String methodUrl = "/server/epoch";
		String methodType = "GET";
		ShippingTemplateEntriesRequest er = new ShippingTemplateEntriesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Check that the server is alive.
	 */
	public static ShippingTemplateEntriesRequest ping(){
		String methodUrl = "/server/ping";
		String methodType = "GET";
		ShippingTemplateEntriesRequest er = new ShippingTemplateEntriesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Creates a new ShippingTemplateEntry
	 */
	public static ShippingTemplateEntriesRequest createShippingTemplateEntry(){
		String methodUrl = "/shipping/templates/entries";
		String methodType = "POST";
		ShippingTemplateEntriesRequest er = new ShippingTemplateEntriesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Retrieves a ShippingTemplateEntry by id.
	 */
	public static ShippingTemplateEntriesRequest getShippingTemplateEntry(String shippingTemplateEntryId){
		String methodUrl = "/shipping/templates/entries/" + shippingTemplateEntryId;
		String methodType = "GET";
		ShippingTemplateEntriesRequest er = new ShippingTemplateEntriesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Updates a ShippingTemplateEntry
	 */
	public static ShippingTemplateEntriesRequest updateShippingTemplateEntry(String shippingTemplateEntryId){
		String methodUrl = "/shipping/templates/entries/" + shippingTemplateEntryId;
		String methodType = "PUT";
		ShippingTemplateEntriesRequest er = new ShippingTemplateEntriesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Deletes a ShippingTemplateEntry
	 */
	public static ShippingTemplateEntriesRequest deleteShippingTemplateEntry(String shippingTemplateEntryId){
		String methodUrl = "/shipping/templates/entries/" + shippingTemplateEntryId;
		String methodType = "DELETE";
		ShippingTemplateEntriesRequest er = new ShippingTemplateEntriesRequest(methodUrl, methodType);

		return er;
	}
	}