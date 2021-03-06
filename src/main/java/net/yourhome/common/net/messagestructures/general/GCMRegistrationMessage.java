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

import org.json.JSONException;
import org.json.JSONObject;

import net.yourhome.common.base.enums.ControllerTypes;
import net.yourhome.common.base.enums.MessageTypes;
import net.yourhome.common.net.messagestructures.JSONMessage;

public class GCMRegistrationMessage extends JSONMessage {
	public String registrationId;
	public String name;
	public Integer screenHeight;
	public Integer screenWidth;

	public GCMRegistrationMessage() {
		this.controlIdentifiers.setControllerIdentifier(ControllerTypes.GENERAL);
		this.type = MessageTypes.GCMRegistration;
	}

	public GCMRegistrationMessage(JSONMessage jsonMessage) throws JSONException {
		super(jsonMessage);
	}

	public GCMRegistrationMessage(JSONObject jsonObject) throws JSONException {
		super(jsonObject);

		this.registrationId = jsonObject.getString("registrationId");
		try {
			this.name = jsonObject.getString("name");
		} catch (JSONException e) {
			this.name = "Unknown";
		}

		try {
			this.screenHeight = jsonObject.getInt("screenHeight");
			this.screenWidth = jsonObject.getInt("screenWidth");
		} catch (JSONException e) {
		}
	}

	public GCMRegistrationMessage(String registrationId, String name) {
		this();
		this.registrationId = registrationId;
		this.name = name;
	}

	@Override
	public JSONObject serialize() {
		JSONObject object = super.serialize();
		try {
			object.put("registrationId", this.registrationId);
			object.put("name", this.name);
			object.put("screenHeight", this.screenHeight);
			object.put("screenWidth", this.screenWidth);
		} catch (JSONException e) {
			JSONMessage.log.error("Exception occured: ", e);
		}
		return object;
	}
}
