package com.etsy.etsyModels;

import org.json.JSONException;
import org.json.JSONObject;

public class Feedback extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3812472653588394173L;
	private int feedback_id;
	private int transaction_id;
	private int creator_user_id;
	private int target_user_id;
	private int seller_user_id;
	private int buyer_user_id;
	private float creation_tsz;
	private String message;
	private int value;
	private int image_feedback_id;
	private String image_url_25x25;
	private String image_url_155x125;
	private String image_url_fullxfull;

	private User buyer;
	private User seller;
	private User author;
	private User subject;
	private Transaction transaction;
	private Listing listing;

	
	public int getFeedbackId() {
		return feedback_id;
	}
	
	public int getTransactionId() {
		return transaction_id;
	}
	
	public int getCreatorUserId() {
		return creator_user_id;
	}
	
	public int getTargetUserId() {
		return target_user_id;
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
	
	public String getMessage() {
		return message;
	}
	
	public int getValue() {
		return value;
	}
	
	public int getImageFeedbackId() {
		return image_feedback_id;
	}
	
	public String getImageUrl25x25() {
		return image_url_25x25;
	}
	
	public String getImageUrl155x125() {
		return image_url_155x125;
	}
	
	public String getImageUrlFullxfull() {
		return image_url_fullxfull;
	}

	public User getBuyer() {
		return buyer;
	}
	public User getSeller() {
		return seller;
	}
	public User getAuthor() {
		return author;
	}
	public User getSubject() {
		return subject;
	}
	public Transaction getTransaction() {
		return transaction;
	}
	public Listing getListing() {
		return listing;
	}

	@Override
	public void parseData(JSONObject data) throws JSONException {
		this.feedback_id = data.optInt("feedback_id");
		this.transaction_id = data.optInt("transaction_id");
		this.creator_user_id = data.optInt("creator_user_id");
		this.target_user_id = data.optInt("target_user_id");
		this.seller_user_id = data.optInt("seller_user_id");
		this.buyer_user_id = data.optInt("buyer_user_id");
		this.creation_tsz = data.optLong("creation_tsz");
		this.message = data.optString("message");
		this.value = data.optInt("value");
		this.image_feedback_id = data.optInt("image_feedback_id");
		this.image_url_25x25 = data.optString("image_url_25x25");
		this.image_url_155x125 = data.optString("image_url_155x125");
		this.image_url_fullxfull = data.optString("image_url_fullxfull");

		JSONObject buyerJSONObject = data.optJSONObject("Buyer");
		if(buyerJSONObject != null){
			this.buyer = new User();
			this.buyer.parseData(buyerJSONObject);
		}
		JSONObject sellerJSONObject = data.optJSONObject("Seller");
		if(sellerJSONObject != null){
			this.seller = new User();
			this.seller.parseData(sellerJSONObject);
		}
		JSONObject authorJSONObject = data.optJSONObject("Author");
		if(authorJSONObject != null){
			this.author = new User();
			this.author.parseData(authorJSONObject);
		}
		JSONObject subjectJSONObject = data.optJSONObject("Subject");
		if(subjectJSONObject != null){
			this.subject = new User();
			this.subject.parseData(subjectJSONObject);
		}
		JSONObject transactionJSONObject = data.optJSONObject("Transaction");
		if(transactionJSONObject != null){
			this.transaction = new Transaction();
			this.transaction.parseData(transactionJSONObject);
		}
		JSONObject listingJSONObject = data.optJSONObject("Listing");
		if(listingJSONObject != null){
			this.listing = new Listing();
			this.listing.parseData(listingJSONObject);
		}
	}
	
	
}