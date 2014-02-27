package com.etsy.etsyModels;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Receipt extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5105434964070945926L;
	private int receipt_id;
	private int order_id;
	private int seller_user_id;
	private int buyer_user_id;
	private float creation_tsz;
	private float last_modified_tsz;
	private String name;
	private String first_line;
	private String second_line;
	private String city;
	private String state;
	private String zip;
	private int country_id;
	private String payment_method;
	private String payment_email;
	private String message_from_seller;
	private String message_from_buyer;
	private boolean was_paid;
	private float total_tax_cost;
	private float total_price;
	private float total_shipping_cost;
	private String currency_code;
	private String message_from_payment;
	private boolean was_shipped;
	private String buyer_email;
	private String seller_email;
	private float discount_amt;
	private float subtotal;
	private float grandtotal;
	private String shipping_tracking_code;
	private String shipping_tracking_url;
	private String shipping_carrier;
	private String shipping_note;

	private Coupon coupon;
	private Country country;
	private User buyer;
	private Order order;
	private User seller;
	private Transaction[] transactions;
	private Listing[] listings;
    private Shipment[] shipments;

	
	public int getReceiptId() {
		return receipt_id;
	}
	
	public int getOrderId() {
		return order_id;
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
	
	public float getLastModifiedTsz() {
		return last_modified_tsz;
	}
	
	public String getName() {
		return name;
	}
	
	public String getFirstLine() {
		return first_line;
	}
	
	public String getSecondLine() {
		return second_line;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getState() {
		return state;
	}
	
	public String getZip() {
		return zip;
	}
	
	public int getCountryId() {
		return country_id;
	}
	
	public String getPaymentMethod() {
		return payment_method;
	}
	
	public String getPaymentEmail() {
		return payment_email;
	}
	
	public String getMessageFromSeller() {
		return message_from_seller;
	}
	
	public String getMessageFromBuyer() {
		return message_from_buyer;
	}
	
	public boolean getWasPaid() {
		return was_paid;
	}
	
	public float getTotalTaxCost() {
		return total_tax_cost;
	}
	
	public float getTotalPrice() {
		return total_price;
	}
	
	public float getTotalShippingCost() {
		return total_shipping_cost;
	}
	
	public String getCurrencyCode() {
		return currency_code;
	}
	
	public String getMessageFromPayment() {
		return message_from_payment;
	}
	
	public boolean getWasShipped() {
		return was_shipped;
	}
	
	public String getBuyerEmail() {
		return buyer_email;
	}
	
	public String getSellerEmail() {
		return seller_email;
	}
	
	public float getDiscountAmt() {
		return discount_amt;
	}
	
	public float getSubtotal() {
		return subtotal;
	}
	
	public float getGrandtotal() {
		return grandtotal;
	}
	
	public String getShippingTrackingCode() {
		return shipping_tracking_code;
	}
	
	public String getShippingTrackingUrl() {
		return shipping_tracking_url;
	}
	
	public String getShippingCarrier() {
		return shipping_carrier;
	}
	
	public String getShippingNote() {
		return shipping_note;
	}

	public Coupon getCoupon() {
		return coupon;
	}
	public Country getCountry() {
		return country;
	}
	public User getBuyer() {
		return buyer;
	}
	public Order getOrder() {
		return order;
	}
	public User getSeller() {
		return seller;
	}
	public Transaction[] getTransactions() {
		return transactions;
	}
	public Listing[] getListings() {
		return listings;
	}

    public Shipment[] getShipments() {
        return shipments;
    }

    public void setShipments(Shipment[] shipments) {
        this.shipments = shipments;
    }


	@Override
	public void parseData(JSONObject data) throws JSONException {
		this.receipt_id = data.optInt("receipt_id");
		this.order_id = data.optInt("order_id");
		this.seller_user_id = data.optInt("seller_user_id");
		this.buyer_user_id = data.optInt("buyer_user_id");
		this.creation_tsz = data.optLong("creation_tsz");
		this.last_modified_tsz = data.optLong("last_modified_tsz");
		this.name = data.optString("name");
		this.first_line = data.optString("first_line");
		this.second_line = data.optString("second_line");
		this.city = data.optString("city");
		this.state = data.optString("state");
		this.zip = data.optString("zip");
		this.country_id = data.optInt("country_id");
		this.payment_method = data.optString("payment_method");
		this.payment_email = data.optString("payment_email");
		this.message_from_seller = data.optString("message_from_seller");
		this.message_from_buyer = data.optString("message_from_buyer");
		this.was_paid = data.optBoolean("was_paid");
		this.total_tax_cost = (float) data.optDouble("total_tax_cost", 0.0f);
		this.total_price = (float) data.optDouble("total_price", 0.0f);
		this.total_shipping_cost = (float) data.optDouble("total_shipping_cost", 0.0f);
		this.currency_code = data.optString("currency_code");
		this.message_from_payment = data.optString("message_from_payment");
		this.was_shipped = data.optBoolean("was_shipped");
		this.buyer_email = data.optString("buyer_email");
		this.seller_email = data.optString("seller_email");
		this.discount_amt = data.optLong("discount_amt");
		this.subtotal = data.optLong("subtotal");
		this.grandtotal = data.optLong("grandtotal");
		this.shipping_tracking_code = data.optString("shipping_tracking_code");
		this.shipping_tracking_url = data.optString("shipping_tracking_url");
		this.shipping_carrier = data.optString("shipping_carrier");
		this.shipping_note = data.optString("shipping_note");

		JSONObject couponJSONObject = data.optJSONObject("Coupon");
		if(couponJSONObject != null){
			this.coupon = new Coupon();
			this.coupon.parseData(couponJSONObject);
		}
		JSONObject countryJSONObject = data.optJSONObject("Country");
		if(countryJSONObject != null){
			this.country = new Country();
			this.country.parseData(countryJSONObject);
		}
		JSONObject buyerJSONObject = data.optJSONObject("Buyer");
		if(buyerJSONObject != null){
			this.buyer = new User();
			this.buyer.parseData(buyerJSONObject);
		}
		JSONObject orderJSONObject = data.optJSONObject("Order");
		if(orderJSONObject != null){
			this.order = new Order();
			this.order.parseData(orderJSONObject);
		}
		JSONObject sellerJSONObject = data.optJSONObject("Seller");
		if(sellerJSONObject != null){
			this.seller = new User();
			this.seller.parseData(sellerJSONObject);
		}
		JSONArray transactionsArray = data.optJSONArray("Transactions");
		if (transactionsArray != null){
			this.transactions = new Transaction[transactionsArray.length()];
			for(int i = 0; i < transactionsArray.length(); i++){
				this.transactions[i] = new Transaction();
				this.transactions[i].parseData(transactionsArray.getJSONObject(i));
			}
		}
		JSONArray listingsArray = data.optJSONArray("Listings");
		if (listingsArray != null){
			this.listings = new Listing[listingsArray.length()];
			for(int i = 0; i < listingsArray.length(); i++){
				this.listings[i] = new Listing();
				this.listings[i].parseData(listingsArray.getJSONObject(i));
			}
		}
        JSONArray shipmentArray = data.optJSONArray("shipments");
        if(shipmentArray != null) {
            this.shipments = new Shipment[shipmentArray.length()];
            for(int i=0;i<shipmentArray.length();i++) {
                this.shipments[i] = new Shipment();
                this.shipments[i].parseData(shipmentArray.getJSONObject(i));
            }
        }
	}
	
	
}