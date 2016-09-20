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

import net.yourhome.common.base.enums.MessageTypes;
import net.yourhome.common.net.messagestructures.JSONMessage;

public class PlaylistsMessage extends JSONMessage {

	public List<PlaylistDescription> playlists = new ArrayList<PlaylistDescription>();

	public PlaylistsMessage() {
		super();
		this.type = MessageTypes.Playlists;
	}

	public PlaylistsMessage(JSONObject jsonObject) throws JSONException {
		super(jsonObject);
		// Parse values in playlist list
		JSONArray playlistArray = jsonObject.getJSONArray("Playlists");
		for (int i = 0; i < playlistArray.length(); i++) {
			JSONObject playlistItem = playlistArray.getJSONObject(i);

			Integer playlistNumber = playlistItem.getInt("id");
			String playlistName = playlistItem.getString("name");

			this.playlists.add(new PlaylistDescription(playlistNumber, playlistName));
		}
	}

	@Override
	public JSONObject serialize() {
		JSONObject object = super.serialize();
		JSONArray playlistArray = new JSONArray();

		for (int i = 0; i < this.playlists.size(); i++) {
			PlaylistDescription p = this.playlists.get(i);
			JSONObject playlistRow = new JSONObject();
			try {
				playlistRow.put("id", p.id);
				playlistRow.put("name", p.name);
				playlistArray.put(playlistRow);
			} catch (JSONException e) {
				JSONMessage.log.error("Exception occured: ", e);
			}
		}
		try {
			object.put("Playlists", playlistArray);
		} catch (JSONException e) {
			JSONMessage.log.error("Exception occured: ", e);
		}
		return object;
	}

	public class PlaylistDescription {

		public int id;
		public String name;

		public PlaylistDescription(int id, String name) {
			this.id = id;
			this.name = name;
		}
	}

}
