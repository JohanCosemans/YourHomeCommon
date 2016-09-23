package net.yourhome.common.net.messagestructures.general;

import org.json.JSONException;
import org.json.JSONObject;

import net.yourhome.common.net.messagestructures.JSONMessage;

public class ProtectedJSONMessage extends JSONMessage {

	private boolean isProtected = false;
	private String protectionCode = "";

	public ProtectedJSONMessage() {
		super();
	}

	public ProtectedJSONMessage(JSONObject jsonObject) throws JSONException {
		super();
		try {
			this.isProtected = jsonObject.getBoolean("protected");
			this.protectionCode = jsonObject.getString("protectionCode");
		} catch (JSONException e) {
			this.isProtected = false;
		}
	}

	@Override
	public JSONObject serialize() {
		JSONObject jsonObj = super.serialize();

		try {
			jsonObj.accumulate("protected", isProtected);
		} catch (JSONException e) {
			JSONMessage.log.error("Exception occured: ", e);
		}

		return jsonObj;
	}

	public ProtectedJSONMessage(JSONMessage message) {
		super();
	}

	public boolean isProtected() {
		return isProtected;
	}

	public void setProtected(boolean isProtected) {
		this.isProtected = isProtected;
	}

}
