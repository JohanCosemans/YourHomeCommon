package net.yourhome.common.net.messagestructures.ipcamera;

import org.json.JSONException;
import org.json.JSONObject;

import net.yourhome.common.base.enums.ControllerTypes;
import net.yourhome.common.net.messagestructures.JSONMessage;

public class IPCameraMessage extends JSONMessage {

	public int id;
	public String name; 
	public String videoUrl;
	public String snapshotUrl;
	
	public IPCameraMessage() {
		this.controlIdentifiers.setControllerIdentifier(ControllerTypes.IPCAMERA); //IP Camera
		//this.type = "IPCamera";
	}
	public IPCameraMessage(JSONMessage message) throws JSONException {
		super(message);
    }

    public JSONObject serialize() {
    	JSONObject object = super.serialize();
    	try {
			object.put("name", name);
			object.put("id", id);
			object.put("videoUrl", videoUrl);
			object.put("snapshotUrl", snapshotUrl);
		} catch (JSONException e) {
			log.error("Exception occured: ",e);
		}
    	return object;
    }

}
