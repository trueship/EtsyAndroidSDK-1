package com.etsy.etsyModels;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class User extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8791766047665382345L;
	private int user_id;
	private String login_name;
	private String primary_email;
	private float creation_tsz;
	private int referred_by_user_id;
	private FeedbackInfo feedback_info;

	private Shop[] shops;
	private UserProfile profile;
	private Order[] orders;
	private Receipt[] buyerReceipts;
	private Transaction[] buyerTransactions;
	private UserAddress[] addresses;
	private BillCharge[] charges;
	private BillPayment[] payments;

	
	public int getUserId() {
		return user_id;
	}
	
	public String getLoginName() {
		return login_name;
	}
	
	public String getPrimaryEmail() {
		return primary_email;
	}
	
	public float getCreationTsz() {
		return creation_tsz;
	}
	
	public int getReferredByUserId() {
		return referred_by_user_id;
	}
	
	public FeedbackInfo getFeedbackInfo() {
		return feedback_info;
	}

	public Shop[] getShops() {
		return shops;
	}
	public UserProfile getProfile() {
		return profile;
	}
	public Order[] getOrders() {
		return orders;
	}
	public Receipt[] getBuyerReceipts() {
		return buyerReceipts;
	}
	public Transaction[] getBuyerTransactions() {
		return buyerTransactions;
	}
	public UserAddress[] getAddresses() {
		return addresses;
	}
	public BillCharge[] getCharges() {
		return charges;
	}
	public BillPayment[] getPayments() {
		return payments;
	}

	@Override
	public void parseData(JSONObject data) throws JSONException {
		this.user_id = data.optInt("user_id");
		this.login_name = data.optString("login_name");
		this.primary_email = data.optString("primary_email");
		this.creation_tsz = data.optLong("creation_tsz");
		this.referred_by_user_id = data.optInt("referred_by_user_id");
FeedbackInfo tmp_feedback_info = new FeedbackInfo();
		tmp_feedback_info.parseData(data.optJSONObject("feedback_info"));
		this.feedback_info = tmp_feedback_info;

		JSONArray shopsArray = data.optJSONArray("Shops");
		if (shopsArray != null){
			this.shops = new Shop[shopsArray.length()];
			for(int i = 0; i < shopsArray.length(); i++){
				this.shops[i] = new Shop();
				this.shops[i].parseData(shopsArray.getJSONObject(i));
			}
		}
		JSONObject profileJSONObject = data.optJSONObject("Profile");
		if(profileJSONObject != null){
			this.profile = new UserProfile();
			this.profile.parseData(profileJSONObject);
		}
		JSONArray ordersArray = data.optJSONArray("Orders");
		if (ordersArray != null){
			this.orders = new Order[ordersArray.length()];
			for(int i = 0; i < ordersArray.length(); i++){
				this.orders[i] = new Order();
				this.orders[i].parseData(ordersArray.getJSONObject(i));
			}
		}
		JSONArray buyerReceiptsArray = data.optJSONArray("BuyerReceipts");
		if (buyerReceiptsArray != null){
			this.buyerReceipts = new Receipt[buyerReceiptsArray.length()];
			for(int i = 0; i < buyerReceiptsArray.length(); i++){
				this.buyerReceipts[i] = new Receipt();
				this.buyerReceipts[i].parseData(buyerReceiptsArray.getJSONObject(i));
			}
		}
		JSONArray buyerTransactionsArray = data.optJSONArray("BuyerTransactions");
		if (buyerTransactionsArray != null){
			this.buyerTransactions = new Transaction[buyerTransactionsArray.length()];
			for(int i = 0; i < buyerTransactionsArray.length(); i++){
				this.buyerTransactions[i] = new Transaction();
				this.buyerTransactions[i].parseData(buyerTransactionsArray.getJSONObject(i));
			}
		}
		JSONArray addressesArray = data.optJSONArray("Addresses");
		if (addressesArray != null){
			this.addresses = new UserAddress[addressesArray.length()];
			for(int i = 0; i < addressesArray.length(); i++){
				this.addresses[i] = new UserAddress();
				this.addresses[i].parseData(addressesArray.getJSONObject(i));
			}
		}
		JSONArray chargesArray = data.optJSONArray("Charges");
		if (chargesArray != null){
			this.charges = new BillCharge[chargesArray.length()];
			for(int i = 0; i < chargesArray.length(); i++){
				this.charges[i] = new BillCharge();
				this.charges[i].parseData(chargesArray.getJSONObject(i));
			}
		}
		JSONArray paymentsArray = data.optJSONArray("Payments");
		if (paymentsArray != null){
			this.payments = new BillPayment[paymentsArray.length()];
			for(int i = 0; i < paymentsArray.length(); i++){
				this.payments[i] = new BillPayment();
				this.payments[i].parseData(paymentsArray.getJSONObject(i));
			}
		}
	}
	
	
}