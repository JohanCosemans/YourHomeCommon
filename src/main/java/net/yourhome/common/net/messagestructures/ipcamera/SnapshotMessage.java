package net.yourhome.common.net.messagestructures.ipcamera;

import org.json.JSONException;
import org.json.JSONObject;

import net.yourhome.common.base.enums.ControllerTypes;
import net.yourhome.common.base.enums.MessageTypes;
import net.yourhome.common.base.enums.ValueTypes;
import net.yourhome.common.net.messagestructures.JSONMessage;

public class SnapshotMessage extends JSONMessage {

	public int cameraId;
	public String snapshotUrl;
	public String videoPath;
	public ValueTypes valueType;
	
	public SnapshotMessage() {
		this.controlIdentifiers.setControllerIdentifier(ControllerTypes.IPCAMERA); //IP Camera
		this.type = MessageTypes.Snapshot;
		this.valueType = ValueTypes.IP_CAMERA;
	}
	public SnapshotMessage(JSONMessage message) {
		super(message);
		this.type = MessageTypes.Snapshot;
		this.valueType = ValueTypes.IP_CAMERA;
    }
	public SnapshotMessage(JSONObject jsonObject) throws JSONException {
		super(jsonObject);
 		cameraId = jsonObject.getInt("cameraId");
 		snapshotUrl = jsonObject.getString("snapshotUrl");
 		try {
 			videoPath = jsonObject.getString("videoPath");
 		}catch(JSONException ex) {}

		this.valueType = ValueTypes.convert(jsonObject.getString("valueType"));
	}
    public JSONObject serialize() {
    	JSONObject object = super.serialize();
    	try {
			object.put("cameraId",cameraId);
			object.put("snapshotUrl", snapshotUrl);
			object.put("videoPath", videoPath);
			object.put("valueType", valueType.convert());
		} catch (JSONException e) {
			log.error("Exception occured: ",e);
		}
    	return object;
    }

}
