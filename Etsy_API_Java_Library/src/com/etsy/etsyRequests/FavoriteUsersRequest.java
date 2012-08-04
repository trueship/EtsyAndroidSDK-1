package com.etsy.etsyRequests;

public class FavoriteUsersRequest extends EtsyRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2824419824712854829L;
	protected FavoriteUsersRequest(String requestUrl, String requestType){
		super(requestUrl, requestType);
	}

		/*
	 * Get a list of all methods available.
	 */
	public static FavoriteUsersRequest getMethodTable(){
		String methodUrl = "/";
		String methodType = "GET";
		FavoriteUsersRequest er = new FavoriteUsersRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Get server time, in epoch seconds notation.
	 */
	public static FavoriteUsersRequest getServerEpoch(){
		String methodUrl = "/server/epoch";
		String methodType = "GET";
		FavoriteUsersRequest er = new FavoriteUsersRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Check that the server is alive.
	 */
	public static FavoriteUsersRequest ping(){
		String methodUrl = "/server/ping";
		String methodType = "GET";
		FavoriteUsersRequest er = new FavoriteUsersRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Finds all favorite users for a user
	 */
	public static FavoriteUsersRequest findAllUserFavoriteUsers(String userId){
		String methodUrl = "/users/" + userId + "/favorites/users";
		String methodType = "GET";
		FavoriteUsersRequest er = new FavoriteUsersRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Finds a favorite user for a user
	 */
	public static FavoriteUsersRequest findUserFavoriteUsers(String userId, String targetUserId){
		String methodUrl = "/users/" + userId + "/favorites/users/" + targetUserId;
		String methodType = "GET";
		FavoriteUsersRequest er = new FavoriteUsersRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Creates a new favorite listing for a user
	 */
	public static FavoriteUsersRequest createUserFavoriteUsers(String userId, String targetUserId){
		String methodUrl = "/users/" + userId + "/favorites/users/" + targetUserId;
		String methodType = "POST";
		FavoriteUsersRequest er = new FavoriteUsersRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Delete a favorite listing for a user
	 */
	public static FavoriteUsersRequest deleteUserFavoriteUsers(String userId, String targetUserId){
		String methodUrl = "/users/" + userId + "/favorites/users/" + targetUserId;
		String methodType = "DELETE";
		FavoriteUsersRequest er = new FavoriteUsersRequest(methodUrl, methodType);

		return er;
	}
	}