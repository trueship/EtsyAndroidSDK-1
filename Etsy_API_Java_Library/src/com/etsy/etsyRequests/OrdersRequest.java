package com.etsy.etsyRequests;

public class OrdersRequest extends EtsyRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7343114852557357735L;
	protected OrdersRequest(String requestUrl, String requestType){
		super(requestUrl, requestType);
	}

		/*
	 * Get a list of all methods available.
	 */
	public static OrdersRequest getMethodTable(){
		String methodUrl = "/";
		String methodType = "GET";
		OrdersRequest er = new OrdersRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Retrieves a Order by id.
	 */
	public static OrdersRequest getOrder(String orderId){
		String methodUrl = "/orders/" + orderId;
		String methodType = "GET";
		OrdersRequest er = new OrdersRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Retrieves a set of Receipt objects associated to a Order.
	 */
	public static OrdersRequest findAllOrderReceipts(String orderId){
		String methodUrl = "/orders/" + orderId + "/receipts";
		String methodType = "GET";
		OrdersRequest er = new OrdersRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Get server time, in epoch seconds notation.
	 */
	public static OrdersRequest getServerEpoch(){
		String methodUrl = "/server/epoch";
		String methodType = "GET";
		OrdersRequest er = new OrdersRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Check that the server is alive.
	 */
	public static OrdersRequest ping(){
		String methodUrl = "/server/ping";
		String methodType = "GET";
		OrdersRequest er = new OrdersRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Retrieves a set of Order objects associated to a User.
	 */
	public static OrdersRequest findAllUserOrders(String userId){
		String methodUrl = "/users/" + userId + "/orders";
		String methodType = "GET";
		OrdersRequest er = new OrdersRequest(methodUrl, methodType);

		return er;
	}
	}