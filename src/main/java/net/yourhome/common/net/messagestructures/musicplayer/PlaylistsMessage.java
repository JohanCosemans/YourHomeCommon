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
		for(int i=0;i<playlistArray.length();i++) {
			JSONObject playlistItem = playlistArray.getJSONObject(i);
			
			Integer playlistNumber = playlistItem.getInt("id");
			String playlistName = playlistItem.getString("name");
			
			playlists.add(new PlaylistDescription(playlistNumber, playlistName));
		}
    }
    public JSONObject serialize() {
    	JSONObject object = super.serialize();
		JSONArray playlistArray = new JSONArray();
		
		for(int i=0;i<this.playlists.size();i++) {
			PlaylistDescription p = this.playlists.get(i);
			JSONObject playlistRow = new JSONObject();
    		try {
    			playlistRow.put("id", p.id);
    			playlistRow.put("name", p.name);
	    		playlistArray.put(playlistRow);
			} catch (JSONException e) {
				log.error("Exception occured: ",e);
			}
		}
		try {
			object.put("Playlists", playlistArray);
		} catch (JSONException e) {
			log.error("Exception occured: ",e);
		}
    	return object;
    }
    
    public class PlaylistDescription
    {
    	
        public int id;
        public String name;
        
        public PlaylistDescription(int id, String name) {
        	this.id = id;
        	this.name = name;
    	}
    }

}
