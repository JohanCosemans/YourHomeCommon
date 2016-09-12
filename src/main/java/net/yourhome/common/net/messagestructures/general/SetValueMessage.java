package net.yourhome.common.net.messagestructures.general;

import org.json.JSONException;
import org.json.JSONObject;

import net.yourhome.common.base.enums.MessageTypes;
import net.yourhome.common.net.messagestructures.JSONMessage;

public class SetValueMessage extends JSONMessage {
	
    public SetValueMessage()
    {
        type = MessageTypes.SetValue;
    }
    
    public String value;

	public SetValueMessage(JSONMessage message) throws JSONException {
		super(message);
    }
	public SetValueMessage(JSONObject jsonObject) throws JSONException {
		super(jsonObject);
		this.value = jsonObject.getString("value");
    }
    public JSONObject serialize()
    {
    	JSONObject jsonObj = super.serialize();
		try {
			jsonObj.accumulate("value", value);	    	
		} catch (JSONException e) {
			log.error("Exception occured: ",e);
		}
        return jsonObj;
    }
}
