package com.etsy.etsyRequests;

public class ReceiptsRequest extends EtsyRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1782733545383096172L;
	protected ReceiptsRequest(String requestUrl, String requestType){
		super(requestUrl, requestType);
	}

		/*
	 * Get a list of all methods available.
	 */
	public static ReceiptsRequest getMethodTable(){
		String methodUrl = "/";
		String methodType = "GET";
		ReceiptsRequest er = new ReceiptsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Retrieves a Receipt by id.
	 */
	public static ReceiptsRequest getReceipt(String receiptId){
		String methodUrl = "/receipts/" + receiptId;
		String methodType = "GET";
		ReceiptsRequest er = new ReceiptsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Updates a Receipt
	 */
	public static ReceiptsRequest updateReceipt(String receiptId){
		String methodUrl = "/receipts/" + receiptId;
		String methodType = "PUT";
		ReceiptsRequest er = new ReceiptsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Retrieves a set of Transaction objects associated to a Receipt.
	 */
	public static ReceiptsRequest findAllReceiptTransactions(String receiptId){
		String methodUrl = "/receipts/" + receiptId + "/transactions";
		String methodType = "GET";
		ReceiptsRequest er = new ReceiptsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Get server time, in epoch seconds notation.
	 */
	public static ReceiptsRequest getServerEpoch(){
		String methodUrl = "/server/epoch";
		String methodType = "GET";
		ReceiptsRequest er = new ReceiptsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Check that the server is alive.
	 */
	public static ReceiptsRequest ping(){
		String methodUrl = "/server/ping";
		String methodType = "GET";
		ReceiptsRequest er = new ReceiptsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Retrieves a set of Receipt objects associated to a Shop.
	 */
	public static ReceiptsRequest findAllShopReceipts(String shopId){
		String methodUrl = "/shops/" + shopId + "/receipts";
		String methodType = "GET";
		ReceiptsRequest er = new ReceiptsRequest(methodUrl, methodType);

		return er;
	}
	}