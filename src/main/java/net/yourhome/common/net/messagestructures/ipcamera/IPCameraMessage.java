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
		this.controlIdentifiers.setControllerIdentifier(ControllerTypes.IPCAMERA); // IP
																					// Camera
		// this.type = "IPCamera";
	}

	public IPCameraMessage(JSONMessage message) throws JSONException {
		super(message);
	}

	@Override
	public JSONObject serialize() {
		JSONObject object = super.serialize();
		try {
			object.put("name", this.name);
			object.put("id", this.id);
			object.put("videoUrl", this.videoUrl);
			object.put("snapshotUrl", this.snapshotUrl);
		} catch (JSONException e) {
			JSONMessage.log.error("Exception occured: ", e);
		}
		return object;
	}

}
