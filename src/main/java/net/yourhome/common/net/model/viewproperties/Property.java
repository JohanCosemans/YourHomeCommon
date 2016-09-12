package net.yourhome.common.net.model.viewproperties;

import org.json.JSONException;
import org.json.JSONObject;

import net.yourhome.common.base.enums.PropertyTypes;

public class Property {
	private PropertyTypes type;
	private String key;
	private String value;
	private String description;
	
	public Property(JSONObject json) throws JSONException {
		setType(json.getString("type"));
		this.key = json.getString("key");
		this.value = json.getString("value");
		this.description = json.getString("description");
	}
	public Property(PropertyTypes type, String key, String description, String value) {
		this.type = type;
		this.key = key;
		this.description = description;
		this.value = value;
	}
	
	
	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}


	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}


	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}


	/**
	 * @return the propertyType
	 */
	public String getType() {
		return type.convert();
	}
	/**
	 * @param propertyType the propertyType to set
	 */
	public void setType(String propertyType) {
		this.type = PropertyTypes.convert(propertyType);
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	
	

}
