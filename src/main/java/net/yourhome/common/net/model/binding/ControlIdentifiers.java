package net.yourhome.common.net.model.binding;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

import net.yourhome.common.base.enums.ControllerTypes;

public class ControlIdentifiers {
	
	private ControllerTypes controllerIdentifier;
	private String nodeIdentifier;
	private String valueIdentifier;
	public ControlIdentifiers(){}
	public ControlIdentifiers(JSONObject json) throws JSONException {
		this.controllerIdentifier = ControllerTypes.convert(json.get("controllerIdentifier").toString());
		try {
		this.nodeIdentifier = json.get("nodeIdentifier").toString();
		}catch(JSONException e) {}
		try {
		this.valueIdentifier = json.get("valueIdentifier").toString();
		}catch(JSONException e) {}
	}
	public ControlIdentifiers(ResultSet result) throws SQLException {
		this.controllerIdentifier = ControllerTypes.convert(result.getString("controller_identifier"));
		try {
		this.nodeIdentifier = result.getString("node_identifier");
		}catch(SQLException e) {}
		try {
		this.valueIdentifier = result.getString("value_identifier");
		}catch(SQLException e) {}
	}
	public ControlIdentifiers(String controllerIdentifier) {
		this.controllerIdentifier = ControllerTypes.convert(controllerIdentifier);
	}
	public ControlIdentifiers(String controllerIdentifier, String nodeIdentifier, String valueIdentifier) {
		this(controllerIdentifier);
		this.nodeIdentifier = nodeIdentifier;
		this.valueIdentifier = valueIdentifier;
	}
	public ControlIdentifiers(ControllerTypes controllerIdentifier, String nodeIdentifier, String valueIdentifier) {
		this.controllerIdentifier = controllerIdentifier;
		this.nodeIdentifier = nodeIdentifier;
		this.valueIdentifier = valueIdentifier;
	}
	
	public String getKey() {
		return this.controllerIdentifier.convert()+"/"+this.nodeIdentifier+"/"+this.valueIdentifier;
	}
	
	public String toString() {
		return getKey();
	}

    public JSONObject serialize()
    {
    	JSONObject jsonObj = new JSONObject();
    	try {
    		jsonObj.put("controllerIdentifier", controllerIdentifier.convert());
			jsonObj.put("nodeIdentifier", nodeIdentifier);
    		jsonObj.put("valueIdentifier", valueIdentifier);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObj;
    }
	/**
	 * @return the controllerIdentifier
	 */
	public ControllerTypes getControllerIdentifier() {
		return controllerIdentifier;
	}
	/**
	 * @param controllerIdentifier the controllerIdentifier to set
	 */
	public void setControllerIdentifier(ControllerTypes controllerIdentifier) {
		this.controllerIdentifier = controllerIdentifier;
	}
	/**
	 * @return the nodeIdentifier
	 */
	public String getNodeIdentifier() {
		return nodeIdentifier;
	}
	/**
	 * @param nodeIdentifier the nodeIdentifier to set
	 */
	public void setNodeIdentifier(String nodeIdentifier) {
		this.nodeIdentifier = nodeIdentifier;
	}
	/**
	 * @return the valueIdentifier
	 */
	public String getValueIdentifier() {
		return valueIdentifier;
	}
	/**
	 * @param valueIdentifier the valueIdentifier to set
	 */
	public void setValueIdentifier(String valueIdentifier) {
		this.valueIdentifier = valueIdentifier;
	}
	public boolean equals(Object o) {
		if(o instanceof ControlIdentifiers) {
			if(this.controllerIdentifier != null && this.controllerIdentifier.equals(((ControlIdentifiers)o).getControllerIdentifier())
					&& this.nodeIdentifier != null && this.nodeIdentifier.equals(((ControlIdentifiers)o).getNodeIdentifier())
							&& this.valueIdentifier != null&& this.valueIdentifier.equals(((ControlIdentifiers)o).getValueIdentifier())) {
				return true;
			}
		}
		return false;
	}
	
	

}
