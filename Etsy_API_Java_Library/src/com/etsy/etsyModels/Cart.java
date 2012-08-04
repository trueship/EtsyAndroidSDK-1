package com.etsy.etsyModels;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Cart extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2817769006045674798L;
	private int cart_id;
	private String shop_name;
	private String message_to_seller;
	private int destination_country_id;
	private String coupon_code;
	private String currency_code;
	private String total;
	private String subtotal;
	private String shipping_cost;
	private String tax_cost;
	private String discount_amount;
	private String shipping_discount_amount;
	private String tax_discount_amount;
	private String url;
	private CartListing cartListings;

	private Shop shop;
	private Listing[] listings;
	private Coupon coupon;

	
	public int getCartId() {
		return cart_id;
	}
	
	public String getShopName() {
		return shop_name;
	}
	
	public String getMessageToSeller() {
		return message_to_seller;
	}
	
	public int getDestinationCountryId() {
		return destination_country_id;
	}
	
	public String getCouponCode() {
		return coupon_code;
	}
	
	public String getCurrencyCode() {
		return currency_code;
	}
	
	public String getTotal() {
		return total;
	}
	
	public String getSubtotal() {
		return subtotal;
	}
	
	public String getShippingCost() {
		return shipping_cost;
	}
	
	public String getTaxCost() {
		return tax_cost;
	}
	
	public String getDiscountAmount() {
		return discount_amount;
	}
	
	public String getShippingDiscountAmount() {
		return shipping_discount_amount;
	}
	
	public String getTaxDiscountAmount() {
		return tax_discount_amount;
	}
	
	public String getUrl() {
		return url;
	}
	
	public CartListing getCartListings() {
		return cartListings;
	}

	public Shop getShop() {
		return shop;
	}
	public Listing[] getListings() {
		return listings;
	}
	public Coupon getCoupon() {
		return coupon;
	}

	@Override
	public void parseData(JSONObject data) throws JSONException {
		this.cart_id = data.optInt("cart_id");
		this.shop_name = data.optString("shop_name");
		this.message_to_seller = data.optString("message_to_seller");
		this.destination_country_id = data.optInt("destination_country_id");
		this.coupon_code = data.optString("coupon_code");
		this.currency_code = data.optString("currency_code");
		this.total = data.optString("total");
		this.subtotal = data.optString("subtotal");
		this.shipping_cost = data.optString("shipping_cost");
		this.tax_cost = data.optString("tax_cost");
		this.discount_amount = data.optString("discount_amount");
		this.shipping_discount_amount = data.optString("shipping_discount_amount");
		this.tax_discount_amount = data.optString("tax_discount_amount");
		this.url = data.optString("url");
		this.cartListings = new CartListing();
		this.cartListings.parseData(data.optJSONObject("listings"));

		JSONObject shopJSONObject = data.optJSONObject("Shop");
		if(shopJSONObject != null){
			this.shop = new Shop();
			this.shop.parseData(shopJSONObject);
		}
		JSONArray listingsArray = data.optJSONArray("Listings");
		if (listingsArray != null){
			this.listings = new Listing[listingsArray.length()];
			for(int i = 0; i < listingsArray.length(); i++){
				this.listings[i] = new Listing();
				this.listings[i].parseData(listingsArray.getJSONObject(i));
			}
		}
		JSONObject couponJSONObject = data.optJSONObject("Coupon");
		if(couponJSONObject != null){
			this.coupon = new Coupon();
			this.coupon.parseData(couponJSONObject);
		}
	}
	
	
}