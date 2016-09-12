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
 * THIS SOFTWARE IS PROVIDED BY THE NETBSD FOUNDATION, INC. AND CONTRIBUTORS
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
package net.yourhome.common.net.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

public class ServerInfo {

	private String name;
	private Integer port;
	private Map<String, Configuration> configurations;
	private String version;

	public ServerInfo() {
		this.configurations = new HashMap<String, Configuration>();
	}

	public ServerInfo(JSONObject jsonObject) throws JSONException {
		this();
		this.name = jsonObject.getString("name");
		this.port = jsonObject.getInt("port");
		try {
			this.version = jsonObject.getString("version");
		} catch (JSONException e) {
		}

		JSONObject configurationsObject = jsonObject.getJSONObject("configurations");

		Iterator<String> it = configurationsObject.keys();
		while (it.hasNext()) {
			Configuration configuration = new Configuration(configurationsObject.getJSONObject(it.next()));
			this.configurations.put(configuration.getFile(), configuration);
		}
	}

	public JSONObject serialize() throws JSONException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", this.name);
		jsonObject.put("port", this.port);
		jsonObject.put("version", this.version);
		JSONObject configurationsMap = new JSONObject();
		for (String configFileName : this.configurations.keySet()) {
			configurationsMap.put(configFileName, this.configurations.get(configFileName).serialize());
		}
		jsonObject.put("configurations", configurationsMap);
		return jsonObject;
	}

	/**
	 * @return the configurations
	 */
	public Map<String, Configuration> getConfigurations() {
		return this.configurations;
	}

	/**
	 * @param configurations
	 *            the configurations to set
	 */
	public void setConfigurations(Map<String, Configuration> configurations) {
		this.configurations = configurations;
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
	 * @return the port
	 */
	public Integer getPort() {
		return this.port;
	}

	/**
	 * @param port
	 *            the port to set
	 */
	public void setPort(Integer port) {
		this.port = port;
	}

	/**
	 * @return the version
	 */
	public String getVersion() {
		return this.version;
	}

	/**
	 * @param version
	 *            the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}

}
