package net.yourhome.common.net.messagestructures;

import org.apache.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

import net.yourhome.common.base.enums.ControllerTypes;
import net.yourhome.common.base.enums.MessageTypes;
import net.yourhome.common.net.model.binding.ControlIdentifiers;


public abstract class JSONMessage {

    protected static Logger log = Logger.getLogger(JSONMessage.class);
	public MessageTypes type;
	public ControlIdentifiers controlIdentifiers;
	public boolean broadcast;

	public JSONMessage() {
		controlIdentifiers = new ControlIdentifiers();
	}
	public JSONMessage(JSONObject jsonObject) throws JSONException {
		controlIdentifiers = new ControlIdentifiers(jsonObject.getJSONObject("controlIdentifiers"));
		try {
		broadcast = jsonObject.getBoolean("broadcast");
		}catch(JSONException e) { broadcast = false; }
		type = MessageTypes.convert(jsonObject.getString("type"));
	}
	public JSONMessage(JSONMessage message) {
		controlIdentifiers = message.controlIdentifiers;
		type = message.type;
		broadcast = message.broadcast;
	}
    public JSONObject serialize()
    {
    	JSONObject jsonObj = new JSONObject();

		try {
			jsonObj.accumulate("controlIdentifiers", controlIdentifiers.serialize());
			jsonObj.accumulate("type", type.convert());
			jsonObj.accumulate("broadcast", broadcast);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			log.error("Exception occured: ",e);
		}
	    	
        return jsonObj;
    }

}
