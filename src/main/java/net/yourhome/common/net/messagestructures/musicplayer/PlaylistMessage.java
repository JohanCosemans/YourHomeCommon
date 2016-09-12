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
			trackIndex = jsonObject.getInt("trackIndex");
		}catch(JSONException e) {}
		
		// Parse values in playlist list
		JSONArray playlistArray = jsonObject.getJSONArray("Playlist");
		for(int i=0;i<playlistArray.length();i++) {
			JSONObject playlistItem = playlistArray.getJSONObject(i);
			PlaylistMessage.PlaylistItem playlistItemNew = new PlaylistItem();
			
			try {
			playlistItemNew.trackIndex = playlistItem.getInt("trackIndex");
			} catch (JSONException e) {}
			try {
			playlistItemNew.title = playlistItem.getString("title");
			} catch (JSONException e) {}
			try {
			playlistItemNew.artist = playlistItem.getString("artist");
			} catch (JSONException e) {}

			playlist.add(playlistItemNew);
		}
		
    }
    public JSONObject serialize() {
    	JSONObject object = super.serialize(); 
    	JSONArray playlistArray = new JSONArray();
		if(playlist != null)   {
			for(PlaylistItem item : playlist) {
				JSONObject playlistRow;
				try {
					playlistRow = new JSONObject();
					playlistRow.accumulate("trackIndex", item.trackIndex);
					playlistRow.accumulate("title", item.title);
					playlistRow.accumulate("artist", item.artist);
					playlistArray.put(playlistRow);
				} catch (JSONException e) {
					log.error("Exception occured: ",e);
				}
			}
		try {
			object.put("Playlist",playlistArray);
			object.put("trackIndex",trackIndex);
		} catch (JSONException e) {
			log.error("Exception occured: ",e);
		}
		}
    	return object;
    }
    
    public class PlaylistItem {
        public int 	  trackIndex;
        public String title;
        public String artist;
    }
}
