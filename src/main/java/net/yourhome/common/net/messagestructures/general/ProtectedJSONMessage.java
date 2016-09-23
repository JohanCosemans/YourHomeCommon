package net.yourhome.common.net.messagestructures.general;

import org.json.JSONException;
import org.json.JSONObject;

import net.yourhome.common.net.messagestructures.JSONMessage;

public class ProtectedJSONMessage extends JSONMessage {

	public boolean isProtected = false;
	public String protectionCode = "";

	public ProtectedJSONMessage() {
		super();
	}

	public ProtectedJSONMessage(JSONObject jsonObject) throws JSONException {
		super(jsonObject);
		try {
			this.isProtected = jsonObject.getBoolean("protected");
			this.protectionCode = jsonObject.getString("protectionCode");
		} catch (JSONException e) {
		}
	}

	@Override
	public JSONObject serialize() {
		JSONObject jsonObj = super.serialize();

		try {
			jsonObj.accumulate("protected", isProtected);
			jsonObj.accumulate("protectionCode", protectionCode);
		} catch (JSONException e) {
			JSONMessage.log.error("Exception occured: ", e);
		}

		return jsonObj;
	}

	public ProtectedJSONMessage(JSONMessage message) {
		super();
	}
}
