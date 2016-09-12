package net.yourhome.common.net.messagestructures.radio;


import org.json.JSONException;
import org.json.JSONObject;

import net.yourhome.common.base.enums.ControllerTypes;
import net.yourhome.common.base.enums.MessageTypes;
import net.yourhome.common.base.enums.ValueTypes;
import net.yourhome.common.net.messagestructures.JSONMessage;

public class RadioOnOffMessage extends JSONMessage {

	public boolean status;	// true = ON or false = OFF
	public boolean stopSharing = false;
	
	public RadioOnOffMessage() {
		this.type = MessageTypes.RadioOnOff;
		this.controlIdentifiers.setControllerIdentifier(ControllerTypes.RADIO);
	}
	public RadioOnOffMessage(JSONMessage message) throws JSONException {
		super(message);
    }
	public RadioOnOffMessage(JSONObject object) throws JSONException {
		super(object);
		status = object.getBoolean("status");
    }
	
    public JSONObject serialize()
    {

    	JSONObject returnObject = super.serialize();
		try {
			returnObject.accumulate("status", status);
		} catch (JSONException e) {
			log.error("Exception occured: ",e);
		}
    	return returnObject;

    }
}
