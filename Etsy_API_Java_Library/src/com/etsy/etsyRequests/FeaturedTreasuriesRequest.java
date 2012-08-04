package com.etsy.etsyRequests;

public class FeaturedTreasuriesRequest extends EtsyRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = -225704929838203399L;
	protected FeaturedTreasuriesRequest(String requestUrl, String requestType){
		super(requestUrl, requestType);
	}

		/*
	 * Get a list of all methods available.
	 */
	public static FeaturedTreasuriesRequest getMethodTable(){
		String methodUrl = "/";
		String methodType = "GET";
		FeaturedTreasuriesRequest er = new FeaturedTreasuriesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Finds all FeaturedTreasuries.
	 */
	public static FeaturedTreasuriesRequest findAllFeaturedTreasuries(){
		String methodUrl = "/featured_treasuries";
		String methodType = "GET";
		FeaturedTreasuriesRequest er = new FeaturedTreasuriesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Finds FeaturedTreasury by numeric ID.
	 */
	public static FeaturedTreasuriesRequest getFeaturedTreasuryById(String featuredTreasuryId){
		String methodUrl = "/featured_treasuries/" + featuredTreasuryId;
		String methodType = "GET";
		FeaturedTreasuriesRequest er = new FeaturedTreasuriesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Finds all listings for a certain FeaturedTreasury.
	 */
	public static FeaturedTreasuriesRequest findAllListingsForFeaturedTreasuryId(String featuredTreasuryId){
		String methodUrl = "/featured_treasuries/" + featuredTreasuryId + "/listings";
		String methodType = "GET";
		FeaturedTreasuriesRequest er = new FeaturedTreasuriesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Finds all active listings for a certain FeaturedTreasury.
	 */
	public static FeaturedTreasuriesRequest findAllActiveListingsForFeaturedTreasuryId(String featuredTreasuryId){
		String methodUrl = "/featured_treasuries/" + featuredTreasuryId + "/listings/active";
		String methodType = "GET";
		FeaturedTreasuriesRequest er = new FeaturedTreasuriesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Finds all FeaturedTreasury listings.
	 */
	public static FeaturedTreasuriesRequest findAllFeaturedListings(){
		String methodUrl = "/featured_treasuries/listings";
		String methodType = "GET";
		FeaturedTreasuriesRequest er = new FeaturedTreasuriesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Finds FeaturedTreasury listings that are currently displayed on a regional homepage.
	 */
	public static FeaturedTreasuriesRequest findAllCurrentFeaturedListings(){
		String methodUrl = "/featured_treasuries/listings/homepage_current";
		String methodType = "GET";
		FeaturedTreasuriesRequest er = new FeaturedTreasuriesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Finds all FeaturedTreasury by numeric owner_id.
	 */
	public static FeaturedTreasuriesRequest findAllFeaturedTreasuriesByOwner(String ownerId){
		String methodUrl = "/featured_treasuries/owner/" + ownerId;
		String methodType = "GET";
		FeaturedTreasuriesRequest er = new FeaturedTreasuriesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Get server time, in epoch seconds notation.
	 */
	public static FeaturedTreasuriesRequest getServerEpoch(){
		String methodUrl = "/server/epoch";
		String methodType = "GET";
		FeaturedTreasuriesRequest er = new FeaturedTreasuriesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Check that the server is alive.
	 */
	public static FeaturedTreasuriesRequest ping(){
		String methodUrl = "/server/ping";
		String methodType = "GET";
		FeaturedTreasuriesRequest er = new FeaturedTreasuriesRequest(methodUrl, methodType);

		return er;
	}
	}