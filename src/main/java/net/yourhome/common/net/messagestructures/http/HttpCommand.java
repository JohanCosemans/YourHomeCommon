/*-
 * Copyright (c) 2016 Coteq, Johan Cosemans
 * All rights reserved.
 *
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY COTEQ AND CONTRIBUTORS
 * ``AS IS'' AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE FOUNDATION OR CONTRIBUTORS
 * BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
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

	public HttpCommand() {
	}

	public JSONObject serialize() {
		JSONObject json = new JSONObject();
		json.put("id", this.id);
		json.put("parentNodeId", this.parentNodeId);
		json.put("name", this.name);
		json.put("description", this.description);
		json.put("url", this.url);
		json.put("httpMethod", this.httpMethod);
		json.put("messageType", this.messageType);
		json.put("messageBody", this.messageBody);
		json.put("additionalHeaders", this.additionalHeaders);
		return json;
	}

	public HttpCommand(ResultSet result) throws SQLException {
		this.id = result.getInt("id");
		try {
			this.parentNodeId = result.getInt("parentNodeId");
		} catch (SQLException e) {
		}
		try {
			this.name = result.getString("name");
		} catch (SQLException e) {
		}
		try {
			this.description = result.getString("description");
		} catch (SQLException e) {
		}
		this.url = result.getString("url");
		this.httpMethod = result.getString("httpMethod");
		try {
			this.messageType = result.getString("messageType");
		} catch (SQLException e) {
		}
		try {
			this.messageBody = result.getString("messageBody");
		} catch (SQLException e) {
		}

		for (int i = 1; i < 5; i++) {
			try {
				String headerKey = result.getString("header" + i + "Key");
				String headerValue = result.getString("header" + i + "Value");
				if (headerKey != null || headerValue != null) {
					this.addHeader(headerKey, headerValue);
				}
			} catch (SQLException e) {
			}
		}
	}

	public HttpCommand(JSONObject result) throws JSONException {
		try {
			this.id = result.getInt("id");
		} catch (JSONException e) {
		}
		try {
			this.parentNodeId = result.getInt("parentNodeId");
		} catch (JSONException e) {
		}
		try {
			this.name = result.getString("name");
		} catch (JSONException e) {
		}
		try {
			this.description = result.getString("description");
		} catch (JSONException e) {
		}
		this.url = result.getString("url");
		this.httpMethod = result.getString("httpMethod");
		try {
			this.messageType = result.getString("messageType");
		} catch (JSONException e) {
		}
		try {
			this.messageBody = result.getString("messageBody");
		} catch (JSONException e) {
		}

		this.additionalHeaders = new HashMap<String, String>();
		JSONObject additionalHeadersObj = result.getJSONObject("additionalHeaders");
		if (additionalHeadersObj != null) {
			String[] names = JSONObject.getNames(additionalHeadersObj);
			if (names != null && names.length > 0) {
				for (String key : names) {
					this.additionalHeaders.put(key, additionalHeadersObj.getString(key));
				}
			}
		}
	}

	public void addHeader(String key, String value) {

		if (this.additionalHeaders == null) {
			this.additionalHeaders = new HashMap<String, String>();
		}

		if (this.additionalHeaders.containsKey(key)) {
			this.additionalHeaders.remove(key);
		}

		this.additionalHeaders.put(key, value);

	}

	public Map<String, String> getHeaders() {
		return this.additionalHeaders;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the parentNodeId
	 */
	public int getParentNodeId() {
		return this.parentNodeId;
	}

	/**
	 * @param parentNodeId
	 *            the parentNodeId to set
	 */
	public void setParentNodeId(int parentNodeId) {
		this.parentNodeId = parentNodeId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return this.url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the httpMethod
	 */
	public String getHttpMethod() {
		return this.httpMethod;
	}

	/**
	 * @param httpMethod
	 *            the httpMethod to set
	 */
	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}

	/**
	 * @return the messageType
	 */
	public String getMessageType() {
		return this.messageType;
	}

	/**
	 * @param messageType
	 *            the messageType to set
	 */
	public void setMessageType(String messageType) {
		this.messageType = messageType;
	}

	/**
	 * @return the messageBody
	 */
	public String getMessageBody() {
		return this.messageBody;
	}

	/**
	 * @param messageBody
	 *            the messageBody to set
	 */
	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}

}
