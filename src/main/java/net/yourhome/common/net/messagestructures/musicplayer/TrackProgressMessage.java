package net.yourhome.common.net.messagestructures.musicplayer;

import org.json.JSONException;
import org.json.JSONObject;

import net.yourhome.common.base.enums.ControllerTypes;
import net.yourhome.common.base.enums.MessageTypes;
import net.yourhome.common.net.messagestructures.JSONMessage;

public class TrackProgressMessage  extends JSONMessage {
	
	public double trackProgressPercentage;
	
	public TrackProgressMessage() {
		this.type = MessageTypes.TrackProgress;
	}
	public TrackProgressMessage(JSONObject jsonObject) throws JSONException {
		super(jsonObject);
		this.trackProgressPercentage = jsonObject.getDouble("trackProgressPercentage");
    }
    public JSONObject serialize()
    {
    	JSONObject object = super.serialize();
    	try {
			object.put("trackProgressPercentage", trackProgressPercentage);
		} catch (JSONException e) {
			log.error("Exception occured: ",e);
		}

    	return object;
    }
	

}
