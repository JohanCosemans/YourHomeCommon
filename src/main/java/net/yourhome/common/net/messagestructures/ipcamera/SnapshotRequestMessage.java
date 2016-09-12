package net.yourhome.common.net.messagestructures.ipcamera;

import org.json.JSONException;
import org.json.JSONObject;

import net.yourhome.common.base.enums.ControllerTypes;
import net.yourhome.common.base.enums.MessageTypes;
import net.yourhome.common.net.messagestructures.JSONMessage;

public class SnapshotRequestMessage extends JSONMessage {

	public SnapshotRequestMessage() {
		this.controlIdentifiers.setControllerIdentifier(ControllerTypes.IPCAMERA); //IP Camera
		this.type = MessageTypes.SnapshotRequest;
	}
	public SnapshotRequestMessage(JSONObject Object) throws JSONException {
		super(Object);
    }
    public JSONObject serialize() {
    	JSONObject object = super.serialize();
    	return object;
    }

}
