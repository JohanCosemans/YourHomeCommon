package net.yourhome.common.net.messagestructures.general;

import org.json.JSONException;
import org.json.JSONObject;

import net.yourhome.common.base.enums.MessageTypes;
import net.yourhome.common.net.messagestructures.JSONMessage;

public class ActivationMessage extends JSONMessage {
	
    public ActivationMessage()
    {
        type = MessageTypes.Activation;
    }
    
	public ActivationMessage(JSONMessage message) throws JSONException {
		super(message);
    }
	public ActivationMessage(JSONObject jsonObject) throws JSONException {
		super(jsonObject);
    }
    public JSONObject serialize()
    {
    	JSONObject returnObject = super.serialize();
/*		try {
		} catch (JSONException e) {
			log.error("Exception occured: ",e);
		}*/
    	return returnObject;
    }
}
