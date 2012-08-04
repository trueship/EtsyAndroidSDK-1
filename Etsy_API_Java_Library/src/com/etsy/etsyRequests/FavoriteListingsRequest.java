package com.etsy.etsyRequests;

public class FavoriteListingsRequest extends EtsyRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3396932859342834864L;
	protected FavoriteListingsRequest(String requestUrl, String requestType){
		super(requestUrl, requestType);
	}

		/*
	 * Get a list of all methods available.
	 */
	public static FavoriteListingsRequest getMethodTable(){
		String methodUrl = "/";
		String methodType = "GET";
		FavoriteListingsRequest er = new FavoriteListingsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Get server time, in epoch seconds notation.
	 */
	public static FavoriteListingsRequest getServerEpoch(){
		String methodUrl = "/server/epoch";
		String methodType = "GET";
		FavoriteListingsRequest er = new FavoriteListingsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Check that the server is alive.
	 */
	public static FavoriteListingsRequest ping(){
		String methodUrl = "/server/ping";
		String methodType = "GET";
		FavoriteListingsRequest er = new FavoriteListingsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Finds all favorite listings for a user
	 */
	public static FavoriteListingsRequest findAllUserFavoriteListings(String userId){
		String methodUrl = "/users/" + userId + "/favorites/listings";
		String methodType = "GET";
		FavoriteListingsRequest er = new FavoriteListingsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Finds a favorite listing for a user
	 */
	public static FavoriteListingsRequest findUserFavoriteListings(String userId, String listingId){
		String methodUrl = "/users/" + userId + "/favorites/listings/" + listingId;
		String methodType = "GET";
		FavoriteListingsRequest er = new FavoriteListingsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Creates a new favorite listing for a user
	 */
	public static FavoriteListingsRequest createUserFavoriteListings(String userId, String listingId){
		String methodUrl = "/users/" + userId + "/favorites/listings/" + listingId;
		String methodType = "POST";
		FavoriteListingsRequest er = new FavoriteListingsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Delete a favorite listing for a user
	 */
	public static FavoriteListingsRequest deleteUserFavoriteListings(String userId, String listingId){
		String methodUrl = "/users/" + userId + "/favorites/listings/" + listingId;
		String methodType = "DELETE";
		FavoriteListingsRequest er = new FavoriteListingsRequest(methodUrl, methodType);

		return er;
	}
	}