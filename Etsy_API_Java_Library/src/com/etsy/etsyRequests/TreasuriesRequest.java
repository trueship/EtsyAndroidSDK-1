package com.etsy.etsyRequests;

public class TreasuriesRequest extends EtsyRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = 975157317015733867L;
	protected TreasuriesRequest(String requestUrl, String requestType){
		super(requestUrl, requestType);
	}

		/*
	 * Get a list of all methods available.
	 */
	public static TreasuriesRequest getMethodTable(){
		String methodUrl = "/";
		String methodType = "GET";
		TreasuriesRequest er = new TreasuriesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Get server time, in epoch seconds notation.
	 */
	public static TreasuriesRequest getServerEpoch(){
		String methodUrl = "/server/epoch";
		String methodType = "GET";
		TreasuriesRequest er = new TreasuriesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Check that the server is alive.
	 */
	public static TreasuriesRequest ping(){
		String methodUrl = "/server/ping";
		String methodType = "GET";
		TreasuriesRequest er = new TreasuriesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Search Treasuries or else List all Treasuries
	 */
	public static TreasuriesRequest findAllTreasuries(){
		String methodUrl = "/treasuries";
		String methodType = "GET";
		TreasuriesRequest er = new TreasuriesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Create a Treasury
	 */
	public static TreasuriesRequest createTreasury(){
		String methodUrl = "/treasuries";
		String methodType = "POST";
		TreasuriesRequest er = new TreasuriesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Get a Treasury
	 */
	public static TreasuriesRequest getTreasury(String treasuryKey){
		String methodUrl = "/treasuries/" + treasuryKey;
		String methodType = "GET";
		TreasuriesRequest er = new TreasuriesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Delete a Treasury
	 */
	public static TreasuriesRequest deleteTreasury(String treasuryKey){
		String methodUrl = "/treasuries/" + treasuryKey;
		String methodType = "DELETE";
		TreasuriesRequest er = new TreasuriesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Get a Treasury's Comments
	 */
	public static TreasuriesRequest findTreasuryComments(String treasuryKey){
		String methodUrl = "/treasuries/" + treasuryKey + "/comments";
		String methodType = "GET";
		TreasuriesRequest er = new TreasuriesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Leave a comment on a Treasury List
	 */
	public static TreasuriesRequest postTreasuryComment(String treasuryKey){
		String methodUrl = "/treasuries/" + treasuryKey + "/comments";
		String methodType = "POST";
		TreasuriesRequest er = new TreasuriesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Delete a given comment on a Treasury List
	 */
	public static TreasuriesRequest deleteTreasuryComment(String treasuryKey, String commentId){
		String methodUrl = "/treasuries/" + treasuryKey + "/comments/" + commentId;
		String methodType = "DELETE";
		TreasuriesRequest er = new TreasuriesRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Get a user's Treasuries
	 */
	public static TreasuriesRequest findAllUserTreasuries(String userId){
		String methodUrl = "/users/" + userId + "/treasuries";
		String methodType = "GET";
		TreasuriesRequest er = new TreasuriesRequest(methodUrl, methodType);

		return er;
	}
	}