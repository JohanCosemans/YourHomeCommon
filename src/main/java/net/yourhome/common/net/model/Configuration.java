package net.yourhome.common.net.model;

import org.json.JSONException;
import org.json.JSONObject;

public class Configuration {
	private String name;
	private String file;
	private Integer version;
	private long size;

	public Configuration() {}
	public Configuration(JSONObject jsonObject) throws JSONException {
		this.name = jsonObject.getString("name");
		this.file = jsonObject.getString("file");
		this.version = jsonObject.getInt("version");
		this.size = jsonObject.getLong("size");
	}
	public JSONObject serialize() throws JSONException {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("name", name);
		jsonObject.put("file", file);
		jsonObject.put("version", version);
		jsonObject.put("size", size);
		return jsonObject;
	}
	
	/**
	 * @return the size
	 */
	public long getSize() {
		return size;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(long size) {
		this.size = size;
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
	 * @return the file
	 */
	public String getFile() {
		return file;
	}
	/**
	 * @param file the file to set
	 */
	public void setFile(String file) {
		this.file = file;
	}
	/**
	 * @return the version
	 */
	public Integer getVersion() {
		return version;
	}
	/**
	 * @param version the version to set
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}

	
}
