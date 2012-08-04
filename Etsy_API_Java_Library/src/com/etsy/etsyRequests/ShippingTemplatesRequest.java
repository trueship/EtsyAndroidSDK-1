package com.etsy.etsyRequests;

public class ShippingTemplatesRequest extends EtsyRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8966868084771723705L;
	protected ShippingTemplatesRequest(String requestUrl, String requestType){
		super(requestUrl, requestType);
	}

		/*
	 * Get a list of all methods available.
	 */
	public static ShippingTemplatesRequest getMethodTable(){
		String methodUrl = "/";
		String methodType = "GET";
		ShippingTemplatesRequest er = new ShippingTemplatesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Get server time, in epoch seconds notation.
	 */
	public static ShippingTemplatesRequest getServerEpoch(){
		String methodUrl = "/server/epoch";
		String methodType = "GET";
		ShippingTemplatesRequest er = new ShippingTemplatesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Check that the server is alive.
	 */
	public static ShippingTemplatesRequest ping(){
		String methodUrl = "/server/ping";
		String methodType = "GET";
		ShippingTemplatesRequest er = new ShippingTemplatesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Creates a new ShippingTemplate
	 */
	public static ShippingTemplatesRequest createShippingTemplate(){
		String methodUrl = "/shipping/templates";
		String methodType = "POST";
		ShippingTemplatesRequest er = new ShippingTemplatesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Retrieves a ShippingTemplate by id.
	 */
	public static ShippingTemplatesRequest getShippingTemplate(String shippingTemplateId){
		String methodUrl = "/shipping/templates/" + shippingTemplateId;
		String methodType = "GET";
		ShippingTemplatesRequest er = new ShippingTemplatesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Updates a ShippingTemplate
	 */
	public static ShippingTemplatesRequest updateShippingTemplate(String shippingTemplateId){
		String methodUrl = "/shipping/templates/" + shippingTemplateId;
		String methodType = "PUT";
		ShippingTemplatesRequest er = new ShippingTemplatesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Deletes the ShippingTemplate with the given id.
	 */
	public static ShippingTemplatesRequest deleteShippingTemplate(String shippingTemplateId){
		String methodUrl = "/shipping/templates/" + shippingTemplateId;
		String methodType = "DELETE";
		ShippingTemplatesRequest er = new ShippingTemplatesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Retrieves a set of ShippingTemplateEntry objects associated to a ShippingTemplate.
	 */
	public static ShippingTemplatesRequest findAllShippingTemplateEntries(String shippingTemplateId){
		String methodUrl = "/shipping/templates/" + shippingTemplateId + "/entries";
		String methodType = "GET";
		ShippingTemplatesRequest er = new ShippingTemplatesRequest(methodUrl, methodType);

		return er;
	}
	}