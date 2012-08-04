package com.etsy.etsyRequests;

public class TaxonomyRequest extends EtsyRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3963093237063702726L;
	protected TaxonomyRequest(String requestUrl, String requestType){
		super(requestUrl, requestType);
	}

		/*
	 * Get a list of all methods available.
	 */
	public static TaxonomyRequest getMethodTable(){
		String methodUrl = "/";
		String methodType = "GET";
		TaxonomyRequest er = new TaxonomyRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Retrieves a top-level Category by tag.
	 */
	public static TaxonomyRequest getCategory(String tag){
		String methodUrl = "/categories/" + tag;
		String methodType = "GET";
		TaxonomyRequest er = new TaxonomyRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Retrieves a second-level Category by tag and subtag.
	 */
	public static TaxonomyRequest getSubCategory(String tag, String subtag){
		String methodUrl = "/categories/" + tag + "/" + subtag;
		String methodType = "GET";
		TaxonomyRequest er = new TaxonomyRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Retrieves a third-level Category by tag, subtag and subsubtag.
	 */
	public static TaxonomyRequest getSubSubCategory(String tag, String subtag, String subsubtag){
		String methodUrl = "/categories/" + tag + "/" + subtag + "/" + subsubtag;
		String methodType = "GET";
		TaxonomyRequest er = new TaxonomyRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Get server time, in epoch seconds notation.
	 */
	public static TaxonomyRequest getServerEpoch(){
		String methodUrl = "/server/epoch";
		String methodType = "GET";
		TaxonomyRequest er = new TaxonomyRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Check that the server is alive.
	 */
	public static TaxonomyRequest ping(){
		String methodUrl = "/server/ping";
		String methodType = "GET";
		TaxonomyRequest er = new TaxonomyRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Retrieves all top-level Categories.
	 */
	public static TaxonomyRequest findAllTopCategory(){
		String methodUrl = "/taxonomy/categories";
		String methodType = "GET";
		TaxonomyRequest er = new TaxonomyRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Retrieves children of a top-level Category by tag.
	 */
	public static TaxonomyRequest findAllTopCategoryChildren(String tag){
		String methodUrl = "/taxonomy/categories/" + tag;
		String methodType = "GET";
		TaxonomyRequest er = new TaxonomyRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Retrieves children of a second-level Category by tag and subtag.
	 */
	public static TaxonomyRequest findAllSubCategoryChildren(String tag, String subtag){
		String methodUrl = "/taxonomy/categories/" + tag + "/" + subtag;
		String methodType = "GET";
		TaxonomyRequest er = new TaxonomyRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Retrieve all suggested styles.
	 */
	public static TaxonomyRequest findSuggestedStyles(){
		String methodUrl = "/taxonomy/styles";
		String methodType = "GET";
		TaxonomyRequest er = new TaxonomyRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Retrieves all related tags for the given tag set.
	 */
	public static TaxonomyRequest findPopularTags(){
		String methodUrl = "/taxonomy/tags";
		String methodType = "GET";
		TaxonomyRequest er = new TaxonomyRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Retrieves all related tags for the given tag set.
	 */
	public static TaxonomyRequest findAllRelatedTags(String tags){
		String methodUrl = "/taxonomy/tags/" + tags;
		String methodType = "GET";
		TaxonomyRequest er = new TaxonomyRequest(methodUrl, methodType);

		return er;
	}
	}