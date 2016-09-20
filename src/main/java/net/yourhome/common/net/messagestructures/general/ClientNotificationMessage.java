/*-
 * Copyright (c) 2016 Coteq, Johan Cosemans
 * All rights reserved.
 *
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY COTEQ AND CONTRIBUTORS
 * ``AS IS'' AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE FOUNDATION OR CONTRIBUTORS
 * BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package net.yourhome.common.net.messagestructures.general;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import net.yourhome.common.base.enums.ControllerTypes;
import net.yourhome.common.base.enums.MessageTypes;
import net.yourhome.common.base.enums.MobileNotificationTypes;
import net.yourhome.common.net.messagestructures.JSONMessage;

public class ClientNotificationMessage extends JSONMessage {

	public MobileNotificationTypes notificationType;
	public String title;
	public String message;

	public String imagePath;
	public String videoPath;

	public String windowTitle;
	public String subtitle;
	public long startDate;
	public boolean cancel = false;

	public ClientNotificationMessage() {
		this.controlIdentifiers.setControllerIdentifier(ControllerTypes.GENERAL);
		this.type = MessageTypes.ClientNotification;
	}

	public ClientNotificationMessage(JSONObject jsonObject) throws JSONException {
		super(jsonObject);
	}

	public Map<String, String> getMessageMap() {
		Map<String, String> returnmap = new HashMap<String, String>();
		returnmap.put("title", this.title);
		returnmap.put("message", this.message);
		returnmap.put("imagePath", this.imagePath);
		returnmap.put("videoPath", this.videoPath);
		returnmap.put("windowTitle", this.windowTitle);
		returnmap.put("subtitle", this.subtitle);
		returnmap.put("startDate", this.startDate + "");
		returnmap.put("notificationType", this.notificationType.convert());
		returnmap.put("controllerIdentifier", this.controlIdentifiers.getControllerIdentifier().convert());
		returnmap.put("nodeIdentifier", this.controlIdentifiers.getNodeIdentifier());
		returnmap.put("valueIdentifier", this.controlIdentifiers.getValueIdentifier());
		returnmap.put("cancel", this.cancel ? "true" : "false");
		return returnmap;
	}

	@Override
	public JSONObject serialize() {
		JSONObject object = super.serialize();
		try {
			object.put("title", this.title);
			object.put("message", this.message);
			object.put("imagePath", this.imagePath);
			object.put("videoPath", this.videoPath);
			object.put("windowTitle", this.windowTitle);
			object.put("subtitle", this.subtitle);
			object.put("defaultDate", this.startDate);
			object.put("notificationType", this.notificationType.convert());
			object.put("cancel", this.cancel);
		} catch (JSONException e) {
			JSONMessage.log.error("Exception occured: ", e);
		}
		return object;
	}
}
