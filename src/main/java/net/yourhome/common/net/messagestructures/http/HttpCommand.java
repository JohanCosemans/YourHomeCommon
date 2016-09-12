package net.yourhome.common.net.messagestructures.http;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

public class HttpCommand {
	private int id;
	private int parentNodeId;
	private String name;
	private String description;
	private String url;
	private String httpMethod;
	private String messageType;
	private String messageBody;

	protected Map<String, String> additionalHeaders;

	public HttpCommand() { }
	
	public JSONObject serialize() {
		JSONObject json = new JSONObject();
		json.put("id", id);
		json.put("parentNodeId", parentNodeId);
		json.put("name", name);
		json.put("description",description);
		json.put("url", url);
		json.put("httpMethod", httpMethod);
		json.put("messageType", messageType);
		json.put("messageBody", messageBody);
		json.put("additionalHeaders", additionalHeaders);
		return json;
	}
	
 	public HttpCommand(ResultSet result) throws SQLException {
		id = result.getInt("id");
		try {
		parentNodeId = result.getInt("parentNodeId");
		}catch(SQLException e) {}
		try {
		name = result.getString("name");
		}catch(SQLException e) {}
		try {
		description = result.getString("description");
		}catch(SQLException e) {}
		url = result.getString("url");
		httpMethod = result.getString("httpMethod");
		try {
		messageType = result.getString("messageType");
		}catch(SQLException e) {}
		try {
		messageBody = result.getString("messageBody");
		}catch(SQLException e) {}
		
		for(int i=1;i<5;i++) {
			try {
				String headerKey = result.getString("header"+i+"Key");
				String headerValue = result.getString("header"+i+"Value");
				if(headerKey != null || headerValue != null) {
					addHeader(headerKey, headerValue);
				}
			}catch(SQLException e) {}
		}
	}
	
	public HttpCommand(JSONObject result) throws JSONException {
		try {
		id = result.getInt("id");
		}catch(JSONException e) {}
		try {
		parentNodeId = result.getInt("parentNodeId");
		}catch(JSONException e) {}
		try {
		name = result.getString("name");
		}catch(JSONException e) {}
		try {
		description = result.getString("description");
		}catch(JSONException e) {}
		url = result.getString("url");
		httpMethod = result.getString("httpMethod");
		try {
		messageType = result.getString("messageType");
		}catch(JSONException e) {}
		try {
		messageBody = result.getString("messageBody");
		}catch(JSONException e) {}

		additionalHeaders = new HashMap<String,String>();
		JSONObject additionalHeadersObj = result.getJSONObject("additionalHeaders");
		if(additionalHeadersObj != null) {
			String[] names = JSONObject.getNames(additionalHeadersObj);
			if(names != null && names.length > 0) {
				for(String key : names) {
					additionalHeaders.put(key, additionalHeadersObj.getString(key));
				}
			}
		}
	}
	
	public void addHeader(String key, String value) {
		
		if(additionalHeaders == null) {
			additionalHeaders = new HashMap<String,String>();
		}
		
		if(additionalHeaders.containsKey(key)) {
			additionalHeaders.remove(key);
		}
		
		additionalHeaders.put(key, value);
		
	}
	
	public Map<String,String> getHeaders() {
		return this.additionalHeaders;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the parentNodeId
	 */
	public int getParentNodeId() {
		return parentNodeId;
	}
	/**
	 * @param parentNodeId the parentNodeId to set
	 */
	public void setParentNodeId(int parentNodeId) {
		this.parentNodeId = parentNodeId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the httpMethod
	 */
	public String getHttpMethod() {
		return httpMethod;
	}
	/**
	 * @param httpMethod the httpMethod to set
	 */
	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}
	/**
	 * @return the messageType
	 */
	public String getMessageType() {
		return messageType;
	}
	/**
	 * @param messageType the messageType to set
	 */
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}
	/**
	 * @return the messageBody
	 */
	public String getMessageBody() {
		return messageBody;
	}
	/**
	 * @param messageBody the messageBody to set
	 */
	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}

}
