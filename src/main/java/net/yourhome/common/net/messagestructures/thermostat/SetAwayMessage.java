package net.yourhome.common.net.messagestructures.thermostat;

import java.util.Date;

import org.json.JSONException;
import org.json.JSONObject;

import net.yourhome.common.base.enums.MessageTypes;
import net.yourhome.common.net.messagestructures.JSONMessage;
import net.yourhome.common.net.messagestructures.general.SetValueMessage;

public class SetAwayMessage extends SetValueMessage {
	
    public SetAwayMessage()
    {
        type = MessageTypes.SetAway;
    }
    
    public Date until;

	public SetAwayMessage(JSONMessage message) throws JSONException {
		super(message);
    }
	public SetAwayMessage(JSONObject jsonObject) throws JSONException {
		super(jsonObject);
		this.until = new Date(jsonObject.getLong("until"));
    }
    public JSONObject serialize()
    {
    	JSONObject jsonObj = super.serialize();
		try {
			jsonObj.accumulate("until", until.getTime());	    	
		} catch (JSONException e) {
			log.error("Exception occured: ",e);
		}
        return jsonObj;
    }
}
