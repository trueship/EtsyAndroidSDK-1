package com.etsy.etsyRequests;

public class TransactionsRequest extends EtsyRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = 358343926843410150L;
	protected TransactionsRequest(String requestUrl, String requestType){
		super(requestUrl, requestType);
	}

		/*
	 * Get a list of all methods available.
	 */
	public static TransactionsRequest getMethodTable(){
		String methodUrl = "/";
		String methodType = "GET";
		TransactionsRequest er = new TransactionsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Get server time, in epoch seconds notation.
	 */
	public static TransactionsRequest getServerEpoch(){
		String methodUrl = "/server/epoch";
		String methodType = "GET";
		TransactionsRequest er = new TransactionsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Check that the server is alive.
	 */
	public static TransactionsRequest ping(){
		String methodUrl = "/server/ping";
		String methodType = "GET";
		TransactionsRequest er = new TransactionsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Retrieves a set of Transaction objects associated to a Shop.
	 */
	public static TransactionsRequest findAllShopTransactions(String shopId){
		String methodUrl = "/shops/" + shopId + "/transactions";
		String methodType = "GET";
		TransactionsRequest er = new TransactionsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Retrieves a Transaction by id.
	 */
	public static TransactionsRequest getTransaction(String transactionId){
		String methodUrl = "/transactions/" + transactionId;
		String methodType = "GET";
		TransactionsRequest er = new TransactionsRequest(methodUrl, methodType);

		return er;
	}
	}