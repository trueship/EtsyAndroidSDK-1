package com.etsy.etsyRequests;

public class ShopSectionsRequest extends EtsyRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5826151412107658294L;
	protected ShopSectionsRequest(String requestUrl, String requestType){
		super(requestUrl, requestType);
	}

		/*
	 * Get a list of all methods available.
	 */
	public static ShopSectionsRequest getMethodTable(){
		String methodUrl = "/";
		String methodType = "GET";
		ShopSectionsRequest er = new ShopSectionsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Get server time, in epoch seconds notation.
	 */
	public static ShopSectionsRequest getServerEpoch(){
		String methodUrl = "/server/epoch";
		String methodType = "GET";
		ShopSectionsRequest er = new ShopSectionsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Check that the server is alive.
	 */
	public static ShopSectionsRequest ping(){
		String methodUrl = "/server/ping";
		String methodType = "GET";
		ShopSectionsRequest er = new ShopSectionsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Retrieves a set of ShopSection objects associated to a Shop.
	 */
	public static ShopSectionsRequest findAllShopSections(String shopId){
		String methodUrl = "/shops/" + shopId + "/sections";
		String methodType = "GET";
		ShopSectionsRequest er = new ShopSectionsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Creates a new ShopSection.
	 */
	public static ShopSectionsRequest createShopSection(String shopId){
		String methodUrl = "/shops/" + shopId + "/sections";
		String methodType = "POST";
		ShopSectionsRequest er = new ShopSectionsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Retrieves a ShopSection by id and shop_id
	 */
	public static ShopSectionsRequest getShopSection(String shopId, String shopSectionId){
		String methodUrl = "/shops/" + shopId + "/sections/" + shopSectionId;
		String methodType = "GET";
		ShopSectionsRequest er = new ShopSectionsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Updates a ShopSection with the given id.
	 */
	public static ShopSectionsRequest updateShopSection(String shopId, String shopSectionId){
		String methodUrl = "/shops/" + shopId + "/sections/" + shopSectionId;
		String methodType = "PUT";
		ShopSectionsRequest er = new ShopSectionsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Deletes the ShopSection with the given id.
	 */
	public static ShopSectionsRequest deleteShopSection(String shopId, String shopSectionId){
		String methodUrl = "/shops/" + shopId + "/sections/" + shopSectionId;
		String methodType = "DELETE";
		ShopSectionsRequest er = new ShopSectionsRequest(methodUrl, methodType);

		return er;
	}
	}