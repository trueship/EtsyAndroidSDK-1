package com.etsy.etsyModels;

import org.json.JSONException;
import org.json.JSONObject;

public class SelectedVariations extends BaseModel {

    /**
	 * 
	 */
	private static final long serialVersionUID = -2133905722879498365L;

	private int propertyId;

    private int valueId;

    private String formattedName;

    private String formattedValue;

    private boolean isValid;

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public int getValueId() {
        return valueId;
    }

    public void setValueId(int valueId) {
        this.valueId = valueId;
    }

    public String getFormattedName() {
        return formattedName;
    }

    public void setFormattedName(String formattedName) {
        this.formattedName = formattedName;
    }

    public String getFormattedValue() {
        return formattedValue;
    }

    public void setFormattedValue(String formattedValue) {
        this.formattedValue = formattedValue;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    @Override
    public void parseData(JSONObject data) throws JSONException {
        this.propertyId = data.optInt("property_id");
        this.valueId = data.optInt("value_id");
        this.formattedName = data.optString("formatted_name");
        this.formattedValue = data.optString("formatted_value");
        this.isValid = data.optBoolean("is_valid");
    }
}
