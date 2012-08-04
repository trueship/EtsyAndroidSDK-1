package com.etsy.etsyRequests;

public class ShopsRequest extends EtsyRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1235035283711425946L;
	protected ShopsRequest(String requestUrl, String requestType){
		super(requestUrl, requestType);
	}

		/*
	 * Get a list of all methods available.
	 */
	public static ShopsRequest getMethodTable(){
		String methodUrl = "/";
		String methodType = "GET";
		ShopsRequest er = new ShopsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Get server time, in epoch seconds notation.
	 */
	public static ShopsRequest getServerEpoch(){
		String methodUrl = "/server/epoch";
		String methodType = "GET";
		ShopsRequest er = new ShopsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Check that the server is alive.
	 */
	public static ShopsRequest ping(){
		String methodUrl = "/server/ping";
		String methodType = "GET";
		ShopsRequest er = new ShopsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Finds all Shops.  If there is a keywords parameter, finds shops with shop_name starting with keywords.
	 */
	public static ShopsRequest findAllShops(){
		String methodUrl = "/shops";
		String methodType = "GET";
		ShopsRequest er = new ShopsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Retrieves a Shop by id.
	 */
	public static ShopsRequest getShop(String shopId){
		String methodUrl = "/shops/" + shopId;
		String methodType = "GET";
		ShopsRequest er = new ShopsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Updates a Shop
	 */
	public static ShopsRequest updateShop(String shopId){
		String methodUrl = "/shops/" + shopId;
		String methodType = "PUT";
		ShopsRequest er = new ShopsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Upload a new shop banner image
	 */
	public static ShopsRequest uploadShopBanner(String shopId){
		String methodUrl = "/shops/" + shopId + "/appearance/banner";
		String methodType = "POST";
		ShopsRequest er = new ShopsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Deletes a shop banner image
	 */
	public static ShopsRequest deleteShopBanner(String shopId){
		String methodUrl = "/shops/" + shopId + "/appearance/banner";
		String methodType = "DELETE";
		ShopsRequest er = new ShopsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Finds all of a Shop's draft listings
	 */
	public static ShopsRequest findAllShopListingsDraft(String shopId){
		String methodUrl = "/shops/" + shopId + "/listings/draft";
		String methodType = "GET";
		ShopsRequest er = new ShopsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Retrieves Listings associated to a Shop that are expired
	 */
	public static ShopsRequest findAllShopListingsExpired(String shopId){
		String methodUrl = "/shops/" + shopId + "/listings/expired";
		String methodType = "GET";
		ShopsRequest er = new ShopsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Retrieves a Listing associated to a Shop that is inactive
	 */
	public static ShopsRequest getShopListingExpired(String shopId, String listingId){
		String methodUrl = "/shops/" + shopId + "/listings/expired/" + listingId;
		String methodType = "GET";
		ShopsRequest er = new ShopsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Retrieves Listings associated to a Shop that are featured
	 */
	public static ShopsRequest findAllShopListingsFeatured(String shopId){
		String methodUrl = "/shops/" + shopId + "/listings/featured";
		String methodType = "GET";
		ShopsRequest er = new ShopsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Retrieves Listings associated to a Shop that are inactive
	 */
	public static ShopsRequest findAllShopListingsInactive(String shopId){
		String methodUrl = "/shops/" + shopId + "/listings/inactive";
		String methodType = "GET";
		ShopsRequest er = new ShopsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Retrieves a Listing associated to a Shop that is inactive
	 */
	public static ShopsRequest getShopListingInactive(String shopId, String listingId){
		String methodUrl = "/shops/" + shopId + "/listings/inactive/" + listingId;
		String methodType = "GET";
		ShopsRequest er = new ShopsRequest(methodUrl, methodType);

		return er;
	}
	}