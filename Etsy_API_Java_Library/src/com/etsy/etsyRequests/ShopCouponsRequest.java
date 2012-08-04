package com.etsy.etsyRequests;

public class ShopCouponsRequest extends EtsyRequest{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3906738643220103373L;
	protected ShopCouponsRequest(String requestUrl, String requestType){
		super(requestUrl, requestType);
	}

		/*
	 * Get a list of all methods available.
	 */
	public static ShopCouponsRequest getMethodTable(){
		String methodUrl = "/";
		String methodType = "GET";
		ShopCouponsRequest er = new ShopCouponsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Get server time, in epoch seconds notation.
	 */
	public static ShopCouponsRequest getServerEpoch(){
		String methodUrl = "/server/epoch";
		String methodType = "GET";
		ShopCouponsRequest er = new ShopCouponsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Check that the server is alive.
	 */
	public static ShopCouponsRequest ping(){
		String methodUrl = "/server/ping";
		String methodType = "GET";
		ShopCouponsRequest er = new ShopCouponsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Retrieves all Shop_Coupons by shop_id
	 */
	public static ShopCouponsRequest findAllShopCoupons(String shopId){
		String methodUrl = "/shops/" + shopId + "/coupons";
		String methodType = "GET";
		ShopCouponsRequest er = new ShopCouponsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Creates a new Coupon.
	 */
	public static ShopCouponsRequest createCoupon(String shopId){
		String methodUrl = "/shops/" + shopId + "/coupons";
		String methodType = "POST";
		ShopCouponsRequest er = new ShopCouponsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Retrieves a Shop_Coupon by id and shop_id
	 */
	public static ShopCouponsRequest findCoupon(String shopId, String couponId){
		String methodUrl = "/shops/" + shopId + "/coupons/" + couponId;
		String methodType = "GET";
		ShopCouponsRequest er = new ShopCouponsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Updates a coupon
	 */
	public static ShopCouponsRequest updateCoupon(String shopId, String couponId){
		String methodUrl = "/shops/" + shopId + "/coupons/" + couponId;
		String methodType = "PUT";
		ShopCouponsRequest er = new ShopCouponsRequest(methodUrl, methodType);

		return er;
	}
		/*
	 * Deletes a coupon
	 */
	public static ShopCouponsRequest deleteCoupon(String shopId, String couponId){
		String methodUrl = "/shops/" + shopId + "/coupons/" + couponId;
		String methodType = "DELETE";
		ShopCouponsRequest er = new ShopCouponsRequest(methodUrl, methodType);

		return er;
	}
	}