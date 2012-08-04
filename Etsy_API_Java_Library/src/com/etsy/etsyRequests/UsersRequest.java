package com.etsy.etsyRequests;

public class UsersRequest extends EtsyRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1424044279750512005L;
	protected UsersRequest(String requestUrl, String requestType){
		super(requestUrl, requestType);
	}

		/*
	 * Get a list of all methods available.
	 */
	public static UsersRequest getMethodTable(){
		String methodUrl = "/";
		String methodType = "GET";
		UsersRequest er = new UsersRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Get server time, in epoch seconds notation.
	 */
	public static UsersRequest getServerEpoch(){
		String methodUrl = "/server/epoch";
		String methodType = "GET";
		UsersRequest er = new UsersRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Check that the server is alive.
	 */
	public static UsersRequest ping(){
		String methodUrl = "/server/ping";
		String methodType = "GET";
		UsersRequest er = new UsersRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Finds all Users whose name or username match the keywords parameter.
	 */
	public static UsersRequest findAllUsers(){
		String methodUrl = "/users";
		String methodType = "GET";
		UsersRequest er = new UsersRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Retrieves a User by id.
	 */
	public static UsersRequest getUser(String userId){
		String methodUrl = "/users/" + userId;
		String methodType = "GET";
		UsersRequest er = new UsersRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Retrieves a set of UserAddress objects associated to a User.
	 */
	public static UsersRequest findAllUserAddresses(String userId){
		String methodUrl = "/users/" + userId + "/addresses";
		String methodType = "GET";
		UsersRequest er = new UsersRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Retrieves a set of FavoriteUser objects associated to a User.
	 */
	public static UsersRequest findAllUserFavoredBy(String userId){
		String methodUrl = "/users/" + userId + "/favored-by";
		String methodType = "GET";
		UsersRequest er = new UsersRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Retrieves a set of Feedback objects associated to a User.
	 */
	public static UsersRequest findAllUserFeedbackAsAuthor(String userId){
		String methodUrl = "/users/" + userId + "/feedback/as-author";
		String methodType = "GET";
		UsersRequest er = new UsersRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Retrieves a set of Feedback objects associated to a User.
	 */
	public static UsersRequest findAllUserFeedbackAsBuyer(String userId){
		String methodUrl = "/users/" + userId + "/feedback/as-buyer";
		String methodType = "GET";
		UsersRequest er = new UsersRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Retrieves a set of Feedback objects associated to a User.
	 */
	public static UsersRequest findAllUserFeedbackAsSeller(String userId){
		String methodUrl = "/users/" + userId + "/feedback/as-seller";
		String methodType = "GET";
		UsersRequest er = new UsersRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Retrieves a set of Feedback objects associated to a User.
	 */
	public static UsersRequest findAllUserFeedbackAsSubject(String userId){
		String methodUrl = "/users/" + userId + "/feedback/as-subject";
		String methodType = "GET";
		UsersRequest er = new UsersRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * 
                    Returns a set of FeedBack objects associated to a User.
                    This is essentially the union between the findAllUserFeedbackAsBuyer
                    and findAllUserFeedbackAsSubject methods.
	 */
	public static UsersRequest findAllFeedbackFromBuyers(String userId){
		String methodUrl = "/users/" + userId + "/feedback/from-buyers";
		String methodType = "GET";
		UsersRequest er = new UsersRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * 
                    Returns a set of FeedBack objects associated to a User.
                    This is essentially the union between
                    the findAllUserFeedbackAsBuyer and findAllUserFeedbackAsSubject methods.
	 */
	public static UsersRequest findAllFeedbackFromSellers(String userId){
		String methodUrl = "/users/" + userId + "/feedback/from-sellers";
		String methodType = "GET";
		UsersRequest er = new UsersRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Retrieves a set of PaymentTemplate objects associated to a User.
	 */
	public static UsersRequest findAllUserPaymentTemplates(String userId){
		String methodUrl = "/users/" + userId + "/payments/templates";
		String methodType = "GET";
		UsersRequest er = new UsersRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Retrieves a set of Receipt objects associated to a User.
	 */
	public static UsersRequest findAllUserBuyerReceipts(String userId){
		String methodUrl = "/users/" + userId + "/receipts";
		String methodType = "GET";
		UsersRequest er = new UsersRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Retrieves a set of ShippingTemplate objects associated to a User.
	 */
	public static UsersRequest findAllUserShippingTemplates(String userId){
		String methodUrl = "/users/" + userId + "/shipping/templates";
		String methodType = "GET";
		UsersRequest er = new UsersRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Retrieves a set of Shop objects associated to a User.
	 */
	public static UsersRequest findAllUserShops(String userId){
		String methodUrl = "/users/" + userId + "/shops";
		String methodType = "GET";
		UsersRequest er = new UsersRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Retrieves a set of Transaction objects associated to a User.
	 */
	public static UsersRequest findAllUserBuyerTransactions(String userId){
		String methodUrl = "/users/" + userId + "/transactions";
		String methodType = "GET";
		UsersRequest er = new UsersRequest(methodUrl, methodType);

		return er;
	}
	}