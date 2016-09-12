package net.yourhome.common.net.messagestructures.musicplayer;

import org.json.JSONException;
import org.json.JSONObject;

import net.yourhome.common.base.enums.ControllerTypes;
import net.yourhome.common.base.enums.MessageTypes;
import net.yourhome.common.net.messagestructures.JSONMessage;

public class TrackProgressRequestMessage  extends JSONMessage {

	public TrackProgressRequestMessage() {
		this.type = MessageTypes.TrackProgressRequest;
	}
	public TrackProgressRequestMessage(JSONMessage message) throws JSONException {
		super(message);
    }
    public JSONObject serialize()
    {
    	JSONObject object = super.serialize();

    	return object;
    }
}
