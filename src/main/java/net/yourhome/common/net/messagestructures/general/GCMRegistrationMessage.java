package net.yourhome.common.net.messagestructures.general;

import org.json.JSONException;
import org.json.JSONObject;

import net.yourhome.common.base.enums.ControllerTypes;
import net.yourhome.common.base.enums.MessageTypes;
import net.yourhome.common.net.messagestructures.JSONMessage;

public class GCMRegistrationMessage extends JSONMessage {
	public String registrationId;
	public String name;
	public Integer screenHeight;
	public Integer screenWidth;
	
	public GCMRegistrationMessage() {
		this.controlIdentifiers.setControllerIdentifier(ControllerTypes.GENERAL);
		this.type = MessageTypes.GCMRegistration;
	}
	public GCMRegistrationMessage(JSONMessage jsonMessage) throws JSONException {
		super(jsonMessage);
	}
	public GCMRegistrationMessage(JSONObject jsonObject) throws JSONException {
		super(jsonObject);
		
		registrationId = jsonObject.getString("registrationId");
		try {
			name = jsonObject.getString("name");
		}catch(JSONException e) { name = "Unknown"; }

		try {
			screenHeight = jsonObject.getInt("screenHeight");
			screenWidth = jsonObject.getInt("screenWidth");
		}catch(JSONException e) { }
	}
	public GCMRegistrationMessage(String registrationId, String name) {
		this();
		this.registrationId = registrationId;
		this.name = name;
	}
	
    public JSONObject serialize() {
    	JSONObject object = super.serialize();
    	try {
    		object.put("registrationId", registrationId);
    		object.put("name", name);
    		object.put("screenHeight", screenHeight);
			object.put("screenWidth", screenWidth);
		} catch (JSONException e) {
			log.error("Exception occured: ",e);
		}
    	return object;
    }
}
