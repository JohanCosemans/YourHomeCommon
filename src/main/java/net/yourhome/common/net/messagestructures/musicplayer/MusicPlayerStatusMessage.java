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
package net.yourhome.common.net.messagestructures.musicplayer;

import org.json.JSONException;
import org.json.JSONObject;

import net.yourhome.common.base.enums.ControllerTypes;
import net.yourhome.common.base.enums.MessageTypes;
import net.yourhome.common.base.enums.ValueTypes;
import net.yourhome.common.net.messagestructures.JSONMessage;

public class MusicPlayerStatusMessage extends JSONMessage {

	public ValueTypes valueType;
	public MusicPlayerStatus status;

	public class MusicPlayerStatus {
		public boolean randomStatus = false;;
		public boolean isPlaying = false;
		public boolean isPaused = false;
		public boolean isStopped = true;
		public double trackProgressPercentage = 0.0;
		public String artist = "";
		public String title = "";
		public String imagePath = "";
		public int trackIndex = 0;

		public MusicPlayerStatus() {
		}

		public MusicPlayerStatus(JSONObject jsonObject) throws JSONException {
			this.randomStatus = jsonObject.getBoolean("randomStatus");
			this.isPaused = jsonObject.getBoolean("isPaused");
			this.isPlaying = jsonObject.getBoolean("isPlaying");
			this.isStopped = jsonObject.getBoolean("isStopped");
			this.artist = jsonObject.getString("artist");
			this.title = jsonObject.getString("title");
			this.trackIndex = jsonObject.getInt("trackIndex");
			this.imagePath = jsonObject.getString("imagePath");
			this.trackProgressPercentage = jsonObject.getDouble("trackProgressPercentage");
		}

		public JSONObject serialize() {
			JSONObject object = new JSONObject();
			try {
				object.accumulate("randomStatus", this.randomStatus);
				object.accumulate("isPaused", this.isPaused);
				object.accumulate("isPlaying", this.isPlaying);
				object.accumulate("isStopped", this.isStopped);
				object.accumulate("artist", this.artist);
				object.accumulate("title", this.title);
				object.accumulate("trackIndex", this.trackIndex);
				object.accumulate("imagePath", this.imagePath);
				object.accumulate("trackProgressPercentage", this.trackProgressPercentage);
			} catch (JSONException e) {
			}
			return object;
		}
	}

	public MusicPlayerStatusMessage() {
		this.type = MessageTypes.MusicPlayerStatus;
		this.status = new MusicPlayerStatus();
		this.controlIdentifiers.setControllerIdentifier(ControllerTypes.SPOTIFY);
	}

	public MusicPlayerStatusMessage(JSONObject jsonObject) throws JSONException {
		super(jsonObject);
		this.status = new MusicPlayerStatus(jsonObject.getJSONObject("status"));
	}

	@Override
	public JSONObject serialize() {
		JSONObject object = super.serialize();
		try {

			object.accumulate("status", this.status.serialize());
		} catch (JSONException e) {
			JSONMessage.log.error("Exception occured: ", e);
		}

		return object;
	}

}
