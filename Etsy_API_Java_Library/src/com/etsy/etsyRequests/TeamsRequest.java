package com.etsy.etsyRequests;

public class TeamsRequest extends EtsyRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2344602027195494013L;
	protected TeamsRequest(String requestUrl, String requestType){
		super(requestUrl, requestType);
	}

		/*
	 * Get a list of all methods available.
	 */
	public static TeamsRequest getMethodTable(){
		String methodUrl = "/";
		String methodType = "GET";
		TeamsRequest er = new TeamsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Get server time, in epoch seconds notation.
	 */
	public static TeamsRequest getServerEpoch(){
		String methodUrl = "/server/epoch";
		String methodType = "GET";
		TeamsRequest er = new TeamsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Check that the server is alive.
	 */
	public static TeamsRequest ping(){
		String methodUrl = "/server/ping";
		String methodType = "GET";
		TeamsRequest er = new TeamsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Returns all Teams
	 */
	public static TeamsRequest findAllTeams(){
		String methodUrl = "/teams";
		String methodType = "GET";
		TeamsRequest er = new TeamsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Returns a list of users for a specific team
	 */
	public static TeamsRequest findAllUsersForTeam(String teamId){
		String methodUrl = "/teams/" + teamId + "/users/";
		String methodType = "GET";
		TeamsRequest er = new TeamsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Returns specified team by ID or team name
	 */
	public static TeamsRequest findTeams(String teamIds){
		String methodUrl = "/teams/" + teamIds + "/";
		String methodType = "GET";
		TeamsRequest er = new TeamsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Returns a list of teams for a specific user
	 */
	public static TeamsRequest findAllTeamsForUser(String userId){
		String methodUrl = "/users/" + userId + "/teams";
		String methodType = "GET";
		TeamsRequest er = new TeamsRequest(methodUrl, methodType);

		return er;
	}
	}