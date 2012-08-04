package com.etsy.etsyRequests;

public class CartsRequest extends EtsyRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3827848891992473358L;
	protected CartsRequest(String requestUrl, String requestType){
		super(requestUrl, requestType);
	}

		/*
	 * Get a list of all methods available.
	 */
	public static CartsRequest getMethodTable(){
		String methodUrl = "/";
		String methodType = "GET";
		CartsRequest er = new CartsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Get server time, in epoch seconds notation.
	 */
	public static CartsRequest getServerEpoch(){
		String methodUrl = "/server/epoch";
		String methodType = "GET";
		CartsRequest er = new CartsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Check that the server is alive.
	 */
	public static CartsRequest ping(){
		String methodUrl = "/server/ping";
		String methodType = "GET";
		CartsRequest er = new CartsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Get a user's Carts
	 */
	public static CartsRequest getAllUserCarts(String userId){
		String methodUrl = "/users/" + userId + "/carts";
		String methodType = "GET";
		CartsRequest er = new CartsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Add a listing to a cart
	 */
	public static CartsRequest addToCart(String userId){
		String methodUrl = "/users/" + userId + "/carts";
		String methodType = "POST";
		CartsRequest er = new CartsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Update a cart listing purchase quantity
	 */
	public static CartsRequest updateCartListingQuantity(String userId){
		String methodUrl = "/users/" + userId + "/carts";
		String methodType = "PUT";
		CartsRequest er = new CartsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Remove a listing from a cart
	 */
	public static CartsRequest removeCartListing(String userId){
		String methodUrl = "/users/" + userId + "/carts";
		String methodType = "DELETE";
		CartsRequest er = new CartsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Get a cart
	 */
	public static CartsRequest getUserCart(String userId, String cartId){
		String methodUrl = "/users/" + userId + "/carts/" + cartId;
		String methodType = "GET";
		CartsRequest er = new CartsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Update a cart
	 */
	public static CartsRequest updateCart(String userId, String cartId){
		String methodUrl = "/users/" + userId + "/carts/" + cartId;
		String methodType = "PUT";
		CartsRequest er = new CartsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Delete a cart
	 */
	public static CartsRequest deleteCart(String userId, String cartId){
		String methodUrl = "/users/" + userId + "/carts/" + cartId;
		String methodType = "DELETE";
		CartsRequest er = new CartsRequest(methodUrl, methodType);

		return er;
	}
	}