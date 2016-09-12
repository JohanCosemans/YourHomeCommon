package net.yourhome.common.net.messagestructures.general;

import org.json.JSONException;
import org.json.JSONObject;

import net.yourhome.common.base.enums.ControllerTypes;
import net.yourhome.common.base.enums.MessageTypes;
import net.yourhome.common.net.messagestructures.JSONMessage;

public class ClientMessageMessage extends JSONMessage {
	public String messageContent;
	public ClientMessageMessage() {
		this.controlIdentifiers.setControllerIdentifier(ControllerTypes.GENERAL);
		this.type = MessageTypes.ClientMessage;
	}
	public ClientMessageMessage(JSONObject jsonObject) throws JSONException {
		super(jsonObject);
		this.messageContent = jsonObject.getString("messageContent");
    }
	public ClientMessageMessage(String messageContent) {
		this();
		this.messageContent = messageContent;
	}

    public JSONObject serialize() {
    	JSONObject object = super.serialize();
    	try {
			object.put("messageContent", messageContent);
		} catch (JSONException e) {
			log.error("Exception occured: ",e);
		}
    	return object;
    }
}
