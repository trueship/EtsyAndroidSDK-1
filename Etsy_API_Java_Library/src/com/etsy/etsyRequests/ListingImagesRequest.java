package com.etsy.etsyRequests;

public class ListingImagesRequest extends EtsyRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3562858132709666538L;
	protected ListingImagesRequest(String requestUrl, String requestType){
		super(requestUrl, requestType);
	}

		/*
	 * Get a list of all methods available.
	 */
	public static ListingImagesRequest getMethodTable(){
		String methodUrl = "/";
		String methodType = "GET";
		ListingImagesRequest er = new ListingImagesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Upload a new listing image
	 */
	public static ListingImagesRequest uploadListingImage(String listingId){
		String methodUrl = "/listings/" + listingId + "/images";
		String methodType = "POST";
		ListingImagesRequest er = new ListingImagesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Retrieves a Image_Listing by id.
	 */
	public static ListingImagesRequest getImage_Listing(String listingId, String listingImageId){
		String methodUrl = "/listings/" + listingId + "/images/" + listingImageId;
		String methodType = "GET";
		ListingImagesRequest er = new ListingImagesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Deletes a listing image
	 */
	public static ListingImagesRequest deleteListingImage(String listingId, String listingImageId){
		String methodUrl = "/listings/" + listingId + "/images/" + listingImageId;
		String methodType = "DELETE";
		ListingImagesRequest er = new ListingImagesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Get server time, in epoch seconds notation.
	 */
	public static ListingImagesRequest getServerEpoch(){
		String methodUrl = "/server/epoch";
		String methodType = "GET";
		ListingImagesRequest er = new ListingImagesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Check that the server is alive.
	 */
	public static ListingImagesRequest ping(){
		String methodUrl = "/server/ping";
		String methodType = "GET";
		ListingImagesRequest er = new ListingImagesRequest(methodUrl, methodType);

		return er;
	}
	}