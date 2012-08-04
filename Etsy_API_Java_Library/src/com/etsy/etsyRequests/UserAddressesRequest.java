package com.etsy.etsyRequests;

public class UserAddressesRequest extends EtsyRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7958534981153741383L;
	protected UserAddressesRequest(String requestUrl, String requestType){
		super(requestUrl, requestType);
	}

		/*
	 * Get a list of all methods available.
	 */
	public static UserAddressesRequest getMethodTable(){
		String methodUrl = "/";
		String methodType = "GET";
		UserAddressesRequest er = new UserAddressesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Get server time, in epoch seconds notation.
	 */
	public static UserAddressesRequest getServerEpoch(){
		String methodUrl = "/server/epoch";
		String methodType = "GET";
		UserAddressesRequest er = new UserAddressesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Check that the server is alive.
	 */
	public static UserAddressesRequest ping(){
		String methodUrl = "/server/ping";
		String methodType = "GET";
		UserAddressesRequest er = new UserAddressesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Creates a new UserAddress.
	 */
	public static UserAddressesRequest createUserAddress(String userId){
		String methodUrl = "/users/" + userId + "/addresses/";
		String methodType = "POST";
		UserAddressesRequest er = new UserAddressesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Retrieves a UserAddress by id.
	 */
	public static UserAddressesRequest getUserAddress(String userId, String userAddressId){
		String methodUrl = "/users/" + userId + "/addresses/" + userAddressId;
		String methodType = "GET";
		UserAddressesRequest er = new UserAddressesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Deletes the UserAddress with the given id.
	 */
	public static UserAddressesRequest deleteUserAddress(String userId, String userAddressId){
		String methodUrl = "/users/" + userId + "/addresses/" + userAddressId;
		String methodType = "DELETE";
		UserAddressesRequest er = new UserAddressesRequest(methodUrl, methodType);

		return er;
	}
	}