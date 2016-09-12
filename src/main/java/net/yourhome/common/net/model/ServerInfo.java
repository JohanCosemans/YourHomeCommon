package net.yourhome.common.net.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;


public class ServerInfo {
	
	private String name;
	private Integer port;
	private Map<String,Configuration> configurations;
	private String version;

	public ServerInfo() {
		configurations = new HashMap<String,Configuration>();
	}
	public ServerInfo(JSONObject jsonObject) throws JSONException {
		this();
		this.name = jsonObject.getString("name");
		this.port = jsonObject.getInt("port");
		try {
		this.version = jsonObject.getString("version");
		}catch(JSONException e) {}
		
		JSONObject configurationsObject = jsonObject.getJSONObject("configurations");

		Iterator<String> it = configurationsObject.keys();
		while(it.hasNext()) {
			Configuration configuration = new Configuration(configurationsObject.getJSONObject(it.next()));
			configurations.put(configuration.getFile(), configuration);
		}
	}
	public JSONObject serialize() throws JSONException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", name);
		jsonObject.put("port", port);
		jsonObject.put("version", version);
		JSONObject configurationsMap = new JSONObject();
		for(String configFileName : configurations.keySet()) {
			configurationsMap.put(configFileName, configurations.get(configFileName).serialize());
		}
		jsonObject.put("configurations",configurationsMap);		
		return jsonObject;
	}
	
	/**
	 * @return the configurations
	 */
	public Map<String, Configuration> getConfigurations() {
		return configurations;
	}
	/**
	 * @param configurations the configurations to set
	 */
	public void setConfigurations(Map<String, Configuration> configurations) {
		this.configurations = configurations;
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
	 * @return the port
	 */
	public Integer getPort() {
		return port;
	}
	/**
	 * @param port the port to set
	 */
	public void setPort(Integer port) {
		this.port = port;
	}
	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}
	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	

}
