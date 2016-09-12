package net.yourhome.common.net.messagestructures.http;

import org.json.JSONException;
import org.json.JSONObject;

import net.yourhome.common.base.enums.ControllerTypes;
import net.yourhome.common.net.messagestructures.JSONMessage;

public class HttpNodeMessage extends JSONMessage {

	public String name; // e.g. XBMC Title 
	public int id;
	public int parentId;
	
	public HttpNodeMessage() {
		this.controlIdentifiers.setControllerIdentifier(ControllerTypes.HTTP); // HTTP command
	}
	public HttpNodeMessage(JSONMessage message) throws JSONException {
		super(message);
    }
    public JSONObject serialize() {
    	JSONObject object = super.serialize();
    	try {
			object.put("name", name);
			object.put("id", id);
			object.put("parentId", parentId);
		} catch (JSONException e) {
			log.error("Exception occured: ",e);
		}
    	return object;
    }
}