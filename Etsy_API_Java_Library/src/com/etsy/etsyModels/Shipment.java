package com.etsy.etsyModels;

import org.json.JSONException;
import org.json.JSONObject;


public class Shipment extends  BaseModel {
    private String carrierName;
    private String receiptShippingId;
    private String trackingCode;
    private String trackingUrl;
    private String buyerNote;
    private int notificationDate;

    public String getCarrierName() {
        return carrierName;
    }

    public void setCarrierName(String carrierName) {
        this.carrierName = carrierName;
    }

    public String getReceiptShippingId() {
        return receiptShippingId;
    }

    public void setReceiptShippingId(String receiptShippingId) {
        this.receiptShippingId = receiptShippingId;
    }

    public String getTrackingCode() {
        return trackingCode;
    }

    public void setTrackingCode(String trackingCode) {
        this.trackingCode = trackingCode;
    }

    public String getTrackingUrl() {
        return trackingUrl;
    }

    public void setTrackingUrl(String trackingUrl) {
        this.trackingUrl = trackingUrl;
    }

    public String getBuyerNote() {
        return buyerNote;
    }

    public void setBuyerNote(String buyerNote) {
        this.buyerNote = buyerNote;
    }

    public int getNotificationDate() {
        return notificationDate;
    }

    public void setNotificationDate(int notificationDate) {
        this.notificationDate = notificationDate;
    }

    @Override
    public void parseData(JSONObject data) throws JSONException {
        this.carrierName = data.optString("carrier_name");
        this.receiptShippingId = data.optString("receipt_shipping_id");
        this.trackingCode = data.optString("tracking_code");
        this.buyerNote = data.optString("buyer_note");
        this.notificationDate = data.optInt("notification_date");
    }
}
