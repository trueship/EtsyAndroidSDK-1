package com.etsy.etsyRequests;

public class ShippingInfoRequest extends EtsyRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7426567460809673429L;
	protected ShippingInfoRequest(String requestUrl, String requestType){
		super(requestUrl, requestType);
	}

		/*
	 * Get a list of all methods available.
	 */
	public static ShippingInfoRequest getMethodTable(){
		String methodUrl = "/";
		String methodType = "GET";
		ShippingInfoRequest er = new ShippingInfoRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Creates a new ShippingInfo.
	 */
	public static ShippingInfoRequest createShippingInfo(String listingId){
		String methodUrl = "/listings/" + listingId + "/shipping/info";
		String methodType = "POST";
		ShippingInfoRequest er = new ShippingInfoRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Get server time, in epoch seconds notation.
	 */
	public static ShippingInfoRequest getServerEpoch(){
		String methodUrl = "/server/epoch";
		String methodType = "GET";
		ShippingInfoRequest er = new ShippingInfoRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Check that the server is alive.
	 */
	public static ShippingInfoRequest ping(){
		String methodUrl = "/server/ping";
		String methodType = "GET";
		ShippingInfoRequest er = new ShippingInfoRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Retrieves a ShippingInfo by id.
	 */
	public static ShippingInfoRequest getShippingInfo(String shippingInfoId){
		String methodUrl = "/shipping/info/" + shippingInfoId;
		String methodType = "GET";
		ShippingInfoRequest er = new ShippingInfoRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Updates a ShippingInfo with the given id.
	 */
	public static ShippingInfoRequest updateShippingInfo(String shippingInfoId){
		String methodUrl = "/shipping/info/" + shippingInfoId;
		String methodType = "PUT";
		ShippingInfoRequest er = new ShippingInfoRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Deletes the ShippingInfo with the given id.
	 */
	public static ShippingInfoRequest deleteShippingInfo(String shippingInfoId){
		String methodUrl = "/shipping/info/" + shippingInfoId;
		String methodType = "DELETE";
		ShippingInfoRequest er = new ShippingInfoRequest(methodUrl, methodType);

		return er;
	}
	}