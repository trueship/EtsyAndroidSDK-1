package com.etsy.etsyModels;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Transaction extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9088323166398192522L;
	private int transaction_id;
	private String title;
	private String description;
	private int seller_user_id;
	private int buyer_user_id;
	private float creation_tsz;
	private float paid_tsz;
	private float shipped_tsz;
	private float price;
	private String currency_code;
	private int quantity;
	private JSONArray tags;
	private JSONArray materials;
	private int image_listing_id;
	private int receipt_id;
	private float shipping_cost;
	private int listing_id;
	private int seller_feedback_id;
	private int buyer_feedback_id;
	private String transaction_type;
	private String url;

	private User buyer;
	private ListingImage mainImage;
	private Listing listing;
	private User seller;
	private Receipt receipt;

	
	public int getTransactionId() {
		return transaction_id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getDescription() {
		return description;
	}
	
	public int getSellerUserId() {
		return seller_user_id;
	}
	
	public int getBuyerUserId() {
		return buyer_user_id;
	}
	
	public float getCreationTsz() {
		return creation_tsz;
	}
	
	public float getPaidTsz() {
		return paid_tsz;
	}
	
	public float getShippedTsz() {
		return shipped_tsz;
	}
	
	public float getPrice() {
		return price;
	}
	
	public String getCurrencyCode() {
		return currency_code;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public JSONArray getTags() {
		return tags;
	}
	
	public JSONArray getMaterials() {
		return materials;
	}
	
	public int getImageListingId() {
		return image_listing_id;
	}
	
	public int getReceiptId() {
		return receipt_id;
	}
	
	public float getShippingCost() {
		return shipping_cost;
	}
	
	public int getListingId() {
		return listing_id;
	}
	
	public int getSellerFeedbackId() {
		return seller_feedback_id;
	}
	
	public int getBuyerFeedbackId() {
		return buyer_feedback_id;
	}
	
	public String getTransactionType() {
		return transaction_type;
	}
	
	public String getUrl() {
		return url;
	}

	public User getBuyer() {
		return buyer;
	}
	public ListingImage getMainImage() {
		return mainImage;
	}
	public Listing getListing() {
		return listing;
	}
	public User getSeller() {
		return seller;
	}
	public Receipt getReceipt() {
		return receipt;
	}

	@Override
	public void parseData(JSONObject data) throws JSONException {
		this.transaction_id = data.optInt("transaction_id");
		this.title = data.optString("title");
		this.description = data.optString("description");
		this.seller_user_id = data.optInt("seller_user_id");
		this.buyer_user_id = data.optInt("buyer_user_id");
		this.creation_tsz = data.optLong("creation_tsz");
		this.paid_tsz = data.optLong("paid_tsz");
		this.shipped_tsz = data.optLong("shipped_tsz");
		this.price = data.optLong("price");
		this.currency_code = data.optString("currency_code");
		this.quantity = data.optInt("quantity");
		this.tags = data.optJSONArray("tags");
		this.materials = data.optJSONArray("materials");
		this.image_listing_id = data.optInt("image_listing_id");
		this.receipt_id = data.optInt("receipt_id");
		this.shipping_cost = data.optLong("shipping_cost");
		this.listing_id = data.optInt("listing_id");
		this.seller_feedback_id = data.optInt("seller_feedback_id");
		this.buyer_feedback_id = data.optInt("buyer_feedback_id");
		this.transaction_type = data.optString("transaction_type");
		this.url = data.optString("url");

		JSONObject buyerJSONObject = data.optJSONObject("Buyer");
		if(buyerJSONObject != null){
			this.buyer = new User();
			this.buyer.parseData(buyerJSONObject);
		}
		JSONObject mainImageJSONObject = data.optJSONObject("MainImage");
		if(mainImageJSONObject != null){
			this.mainImage = new ListingImage();
			this.mainImage.parseData(mainImageJSONObject);
		}
		JSONObject listingJSONObject = data.optJSONObject("Listing");
		if(listingJSONObject != null){
			this.listing = new Listing();
			this.listing.parseData(listingJSONObject);
		}
		JSONObject sellerJSONObject = data.optJSONObject("Seller");
		if(sellerJSONObject != null){
			this.seller = new User();
			this.seller.parseData(sellerJSONObject);
		}
		JSONObject receiptJSONObject = data.optJSONObject("Receipt");
		if(receiptJSONObject != null){
			this.receipt = new Receipt();
			this.receipt.parseData(receiptJSONObject);
		}
	}
	
	
}