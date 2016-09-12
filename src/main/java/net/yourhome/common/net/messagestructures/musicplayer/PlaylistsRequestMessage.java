package net.yourhome.common.net.messagestructures.musicplayer;

import org.json.JSONException;
import org.json.JSONObject;

import net.yourhome.common.base.enums.ControllerTypes;
import net.yourhome.common.base.enums.MessageTypes;
import net.yourhome.common.net.messagestructures.JSONMessage;

public class PlaylistsRequestMessage extends JSONMessage {

	public PlaylistsRequestMessage() {
		super();
		this.type = MessageTypes.PlaylistsRequest;
        
	}
	public PlaylistsRequestMessage(JSONMessage message) {
		super(message);
    }
	public PlaylistsRequestMessage(JSONObject jsonObject) throws JSONException {
		super(jsonObject);
    }
	
    public JSONObject serialize()
    {
    	JSONObject object = super.serialize();

    	return object;
    }
	
}
