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

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import net.yourhome.common.base.enums.ControllerTypes;
import net.yourhome.common.base.enums.MessageTypes;
import net.yourhome.common.net.messagestructures.JSONMessage;

public class PlaylistMessage extends JSONMessage {

	public List<PlaylistItem> playlist = new ArrayList<PlaylistItem>();
	public int trackIndex;

	public PlaylistMessage() {
		this.type = MessageTypes.Playlist;
		this.controlIdentifiers.setControllerIdentifier(ControllerTypes.SPOTIFY);
	}

	public PlaylistMessage(JSONObject jsonObject) throws JSONException {
		super(jsonObject);
		try {
			this.trackIndex = jsonObject.getInt("trackIndex");
		} catch (JSONException e) {
		}

		// Parse values in playlist list
		JSONArray playlistArray = jsonObject.getJSONArray("Playlist");
		for (int i = 0; i < playlistArray.length(); i++) {
			JSONObject playlistItem = playlistArray.getJSONObject(i);
			PlaylistMessage.PlaylistItem playlistItemNew = new PlaylistItem();

			try {
				playlistItemNew.trackIndex = playlistItem.getInt("trackIndex");
			} catch (JSONException e) {
			}
			try {
				playlistItemNew.title = playlistItem.getString("title");
			} catch (JSONException e) {
			}
			try {
				playlistItemNew.artist = playlistItem.getString("artist");
			} catch (JSONException e) {
			}

			this.playlist.add(playlistItemNew);
		}

	}

	@Override
	public JSONObject serialize() {
		JSONObject object = super.serialize();
		JSONArray playlistArray = new JSONArray();
		if (this.playlist != null) {
			for (PlaylistItem item : this.playlist) {
				JSONObject playlistRow;
				try {
					playlistRow = new JSONObject();
					playlistRow.accumulate("trackIndex", item.trackIndex);
					playlistRow.accumulate("title", item.title);
					playlistRow.accumulate("artist", item.artist);
					playlistArray.put(playlistRow);
				} catch (JSONException e) {
					JSONMessage.log.error("Exception occured: ", e);
				}
			}
			try {
				object.put("Playlist", playlistArray);
				object.put("trackIndex", this.trackIndex);
			} catch (JSONException e) {
				JSONMessage.log.error("Exception occured: ", e);
			}
		}
		return object;
	}

	public class PlaylistItem {
		public int trackIndex;
		public String title;
		public String artist;
	}
}
