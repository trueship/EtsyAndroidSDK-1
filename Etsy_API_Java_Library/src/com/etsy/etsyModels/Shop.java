package com.etsy.etsyModels;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Shop extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5450494864709068115L;
	private int shop_id;
	private String shop_name;
	private String first_line;
	private String second_line;
	private String city;
	private String state;
	private String zip;
	private int country_id;
	private int user_id;
	private float creation_tsz;
	private String title;
	private String announcement;
	private String currency_code;
	private boolean is_vacation;
	private String vacation_message;
	private String sale_message;
	private float last_updated_tsz;
	private int listing_active_count;
	private String login_name;
	private float lat;
	private float lon;
	private String alchemy_message;
	private boolean is_refusing_alchemy;
	private String policy_welcome;
	private String policy_payment;
	private String policy_shipping;
	private String policy_refunds;
	private String policy_additional;
	private String policy_seller_info;
	private float policy_updated_tsz;
	private String vacation_autoreply;
	private String ga_code;
	private String name;
	private String url;
	private String image_url_760x100;
	private int num_favorers;
	private JSONArray languages;

	private User user;
	private ShopSection[] sections;
	private Listing[] listings;
	private Receipt[] receipts;
	private Transaction[] transactions;
	private ShopTranslation[] translations;

	
	public int getShopId() {
		return shop_id;
	}
	
	public String getShopName() {
		return shop_name;
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
	
	public int getUserId() {
		return user_id;
	}
	
	public float getCreationTsz() {
		return creation_tsz;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAnnouncement() {
		return announcement;
	}
	
	public String getCurrencyCode() {
		return currency_code;
	}
	
	public boolean getIsVacation() {
		return is_vacation;
	}
	
	public String getVacationMessage() {
		return vacation_message;
	}
	
	public String getSaleMessage() {
		return sale_message;
	}
	
	public float getLastUpdatedTsz() {
		return last_updated_tsz;
	}
	
	public int getListingActiveCount() {
		return listing_active_count;
	}
	
	public String getLoginName() {
		return login_name;
	}
	
	public float getLat() {
		return lat;
	}
	
	public float getLon() {
		return lon;
	}
	
	public String getAlchemyMessage() {
		return alchemy_message;
	}
	
	public boolean getIsRefusingAlchemy() {
		return is_refusing_alchemy;
	}
	
	public String getPolicyWelcome() {
		return policy_welcome;
	}
	
	public String getPolicyPayment() {
		return policy_payment;
	}
	
	public String getPolicyShipping() {
		return policy_shipping;
	}
	
	public String getPolicyRefunds() {
		return policy_refunds;
	}
	
	public String getPolicyAdditional() {
		return policy_additional;
	}
	
	public String getPolicySellerInfo() {
		return policy_seller_info;
	}
	
	public float getPolicyUpdatedTsz() {
		return policy_updated_tsz;
	}
	
	public String getVacationAutoreply() {
		return vacation_autoreply;
	}
	
	public String getGaCode() {
		return ga_code;
	}
	
	public String getName() {
		return name;
	}
	
	public String getUrl() {
		return url;
	}
	
	public String getImageUrl760x100() {
		return image_url_760x100;
	}
	
	public int getNumFavorers() {
		return num_favorers;
	}
	
	public JSONArray getLanguages() {
		return languages;
	}

	public User getUser() {
		return user;
	}
	public ShopSection[] getSections() {
		return sections;
	}
	public Listing[] getListings() {
		return listings;
	}
	public Receipt[] getReceipts() {
		return receipts;
	}
	public Transaction[] getTransactions() {
		return transactions;
	}
	public ShopTranslation[] getTranslations() {
		return translations;
	}

	@Override
	public void parseData(JSONObject data) throws JSONException {
		this.shop_id = data.optInt("shop_id");
		this.shop_name = data.optString("shop_name");
		this.first_line = data.optString("first_line");
		this.second_line = data.optString("second_line");
		this.city = data.optString("city");
		this.state = data.optString("state");
		this.zip = data.optString("zip");
		this.country_id = data.optInt("country_id");
		this.user_id = data.optInt("user_id");
		this.creation_tsz = data.optLong("creation_tsz");
		this.title = data.optString("title");
		this.announcement = data.optString("announcement");
		this.currency_code = data.optString("currency_code");
		this.is_vacation = data.optBoolean("is_vacation");
		this.vacation_message = data.optString("vacation_message");
		this.sale_message = data.optString("sale_message");
		this.last_updated_tsz = data.optLong("last_updated_tsz");
		this.listing_active_count = data.optInt("listing_active_count");
		this.login_name = data.optString("login_name");
		this.lat = data.optLong("lat");
		this.lon = data.optLong("lon");
		this.alchemy_message = data.optString("alchemy_message");
		this.is_refusing_alchemy = data.optBoolean("is_refusing_alchemy");
		this.policy_welcome = data.optString("policy_welcome");
		this.policy_payment = data.optString("policy_payment");
		this.policy_shipping = data.optString("policy_shipping");
		this.policy_refunds = data.optString("policy_refunds");
		this.policy_additional = data.optString("policy_additional");
		this.policy_seller_info = data.optString("policy_seller_info");
		this.policy_updated_tsz = data.optLong("policy_updated_tsz");
		this.vacation_autoreply = data.optString("vacation_autoreply");
		this.ga_code = data.optString("ga_code");
		this.name = data.optString("name");
		this.url = data.optString("url");
		this.image_url_760x100 = data.optString("image_url_760x100");
		this.num_favorers = data.optInt("num_favorers");
		this.languages = data.optJSONArray("languages");

		JSONObject userJSONObject = data.optJSONObject("User");
		if(userJSONObject != null){
			this.user = new User();
			this.user.parseData(userJSONObject);
		}
		JSONArray sectionsArray = data.optJSONArray("Sections");
		if (sectionsArray != null){
			this.sections = new ShopSection[sectionsArray.length()];
			for(int i = 0; i < sectionsArray.length(); i++){
				this.sections[i] = new ShopSection();
				this.sections[i].parseData(sectionsArray.getJSONObject(i));
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
		JSONArray receiptsArray = data.optJSONArray("Receipts");
		if (receiptsArray != null){
			this.receipts = new Receipt[receiptsArray.length()];
			for(int i = 0; i < receiptsArray.length(); i++){
				this.receipts[i] = new Receipt();
				this.receipts[i].parseData(receiptsArray.getJSONObject(i));
			}
		}
		JSONArray transactionsArray = data.optJSONArray("Transactions");
		if (transactionsArray != null){
			this.transactions = new Transaction[transactionsArray.length()];
			for(int i = 0; i < transactionsArray.length(); i++){
				this.transactions[i] = new Transaction();
				this.transactions[i].parseData(transactionsArray.getJSONObject(i));
			}
		}
		JSONArray translationsArray = data.optJSONArray("Translations");
		if (translationsArray != null){
			this.translations = new ShopTranslation[translationsArray.length()];
			for(int i = 0; i < translationsArray.length(); i++){
				this.translations[i] = new ShopTranslation();
				this.translations[i].parseData(translationsArray.getJSONObject(i));
			}
		}
	}
	
	
}