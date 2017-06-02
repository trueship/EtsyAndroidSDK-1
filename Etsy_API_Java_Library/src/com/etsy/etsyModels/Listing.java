package com.etsy.etsyModels;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Listing extends BaseModel {

	/**
	 *
	 */
	private static final long serialVersionUID = 5348433468850149081L;
	private int listing_id;
	private String state;
	private int user_id;
	private int category_id;
	private String title;
	private String description;
	private float creation_tsz;
	private float ending_tsz;
	private float original_creation_tsz;
	private float last_modified_tsz;
	private String price;
	private String currency_code;
	private int quantity;
	private JSONArray tags;
	private JSONArray category_path;
	private JSONArray materials;
	private int shop_section_id;
	private int featured_rank;
	private float state_tsz;
	private int hue;
	private int saturation;
	private int brightness;
	private boolean is_black_and_white;
	private String url;
	private int views;
	private int num_favorers;
	private String who_made;
	private boolean is_supply;
	private String when_made;
	private String recipient;
	private String occasion;
	private JSONArray style;

	private User user;
	private Shop shop;
	private ShopSection section;
	private ListingImage[] images;
	private ListingImage mainImage;
	private ShippingInfo[] shippingInfo;
	private PaymentTemplate[] paymentInfo;
	private ListingTranslation[] translations;

	private int processingMin;
	private int processingMax;


	public int getListingId() {
		return listing_id;
	}

	public String getState() {
		return state;
	}

	public int getUserId() {
		return user_id;
	}

	public int getCategoryId() {
		return category_id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public float getCreationTsz() {
		return creation_tsz;
	}

	public float getEndingTsz() {
		return ending_tsz;
	}

	public float getOriginalCreationTsz() {
		return original_creation_tsz;
	}

	public float getLastModifiedTsz() {
		return last_modified_tsz;
	}

	public String getPrice() {
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

	public JSONArray getCategoryPath() {
		return category_path;
	}

	public JSONArray getMaterials() {
		return materials;
	}

	public int getShopSectionId() {
		return shop_section_id;
	}

	public int getFeaturedRank() {
		return featured_rank;
	}

	public float getStateTsz() {
		return state_tsz;
	}

	public int getHue() {
		return hue;
	}

	public int getSaturation() {
		return saturation;
	}

	public int getBrightness() {
		return brightness;
	}

	public boolean getIsBlackAndWhite() {
		return is_black_and_white;
	}

	public String getUrl() {
		return url;
	}

	public int getViews() {
		return views;
	}

	public int getNumFavorers() {
		return num_favorers;
	}

	public String getWhoMade() {
		return who_made;
	}

	public boolean getIsSupply() {
		return is_supply;
	}

	public String getWhenMade() {
		return when_made;
	}

	public String getRecipient() {
		return recipient;
	}

	public String getOccasion() {
		return occasion;
	}

	public JSONArray getStyle() {
		return style;
	}

	public User getUser() {
		return user;
	}
	public Shop getShop() {
		return shop;
	}
	public ShopSection getSection() {
		return section;
	}
	public ListingImage[] getImages() {
		return images;
	}
	public ListingImage getMainImage() {
		return mainImage;
	}
	public ShippingInfo[] getShippingInfo() {
		return shippingInfo;
	}
	public PaymentTemplate[] getPaymentInfo() {
		return paymentInfo;
	}
	public ListingTranslation[] getTranslations() {
		return translations;
	}

	public int getProcessingMin() {
	    return processingMin;
	}

	public int getProcessingMax() {
	    return processingMax;
	}

	@Override
	public void parseData(JSONObject data) throws JSONException {
		this.listing_id = data.optInt("listing_id");
		this.state = data.optString("state");
		this.user_id = data.optInt("user_id");
		this.category_id = data.optInt("category_id");
		this.title = data.optString("title");
		this.description = data.optString("description");
		this.creation_tsz = data.optLong("creation_tsz");
		this.ending_tsz = data.optLong("ending_tsz");
		this.original_creation_tsz = data.optLong("original_creation_tsz");
		this.last_modified_tsz = data.optLong("last_modified_tsz");
		this.price = data.optString("price");
		this.currency_code = data.optString("currency_code");
		this.quantity = data.optInt("quantity");
		this.tags = data.optJSONArray("tags");
		this.category_path = data.optJSONArray("category_path");
		this.materials = data.optJSONArray("materials");
		this.shop_section_id = data.optInt("shop_section_id");
		this.featured_rank = data.optInt("featured_rank");
		this.state_tsz = data.optLong("state_tsz");
		this.hue = data.optInt("hue");
		this.saturation = data.optInt("saturation");
		this.brightness = data.optInt("brightness");
		this.is_black_and_white = data.optBoolean("is_black_and_white");
		this.url = data.optString("url");
		this.views = data.optInt("views");
		this.num_favorers = data.optInt("num_favorers");
		this.who_made = data.optString("who_made");
		this.is_supply = data.optBoolean("is_supply");
		this.when_made = data.optString("when_made");
		this.recipient = data.optString("recipient");
		this.occasion = data.optString("occasion");
		this.style = data.optJSONArray("style");
		this.processingMin = data.optInt("processing_min");
		this.processingMax = data.optInt("processing_max");

		JSONObject userJSONObject = data.optJSONObject("User");
		if(userJSONObject != null){
			this.user = new User();
			this.user.parseData(userJSONObject);
		}
		JSONObject shopJSONObject = data.optJSONObject("Shop");
		if(shopJSONObject != null){
			this.shop = new Shop();
			this.shop.parseData(shopJSONObject);
		}
		JSONObject sectionJSONObject = data.optJSONObject("Section");
		if(sectionJSONObject != null){
			this.section = new ShopSection();
			this.section.parseData(sectionJSONObject);
		}
		JSONArray imagesArray = data.optJSONArray("Images");
		if (imagesArray != null){
			this.images = new ListingImage[imagesArray.length()];
			for(int i = 0; i < imagesArray.length(); i++){
				this.images[i] = new ListingImage();
				this.images[i].parseData(imagesArray.getJSONObject(i));
			}
		}
		JSONObject mainImageJSONObject = data.optJSONObject("MainImage");
		if(mainImageJSONObject != null){
			this.mainImage = new ListingImage();
			this.mainImage.parseData(mainImageJSONObject);
		}
		JSONArray shippingInfoArray = data.optJSONArray("ShippingInfo");
		if (shippingInfoArray != null){
			this.shippingInfo = new ShippingInfo[shippingInfoArray.length()];
			for(int i = 0; i < shippingInfoArray.length(); i++){
				this.shippingInfo[i] = new ShippingInfo();
				this.shippingInfo[i].parseData(shippingInfoArray.getJSONObject(i));
			}
		}
		JSONArray paymentInfoArray = data.optJSONArray("PaymentInfo");
		if (paymentInfoArray != null){
			this.paymentInfo = new PaymentTemplate[paymentInfoArray.length()];
			for(int i = 0; i < paymentInfoArray.length(); i++){
				this.paymentInfo[i] = new PaymentTemplate();
				this.paymentInfo[i].parseData(paymentInfoArray.getJSONObject(i));
			}
		}
		JSONArray translationsArray = data.optJSONArray("Translations");
		if (translationsArray != null){
			this.translations = new ListingTranslation[translationsArray.length()];
			for(int i = 0; i < translationsArray.length(); i++){
				this.translations[i] = new ListingTranslation();
				this.translations[i].parseData(translationsArray.getJSONObject(i));
			}
		}
	}


}