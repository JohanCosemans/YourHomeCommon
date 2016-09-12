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

	    public MusicPlayerStatus(){}
	    public MusicPlayerStatus(JSONObject jsonObject) throws JSONException {
	    	randomStatus = jsonObject.getBoolean("randomStatus");
			isPaused = jsonObject.getBoolean("isPaused");
			isPlaying = jsonObject.getBoolean("isPlaying");
			isStopped = jsonObject.getBoolean("isStopped");
			artist = jsonObject.getString("artist");
			title = jsonObject.getString("title");
			trackIndex = jsonObject.getInt("trackIndex");
			imagePath = jsonObject.getString("imagePath");
			trackProgressPercentage = jsonObject.getDouble("trackProgressPercentage");
	    }
	    public JSONObject serialize() {
	    	JSONObject object = new JSONObject();
	    	try {
				object.accumulate("randomStatus", randomStatus);
				object.accumulate("isPaused", isPaused);	
				object.accumulate("isPlaying", isPlaying);
				object.accumulate("isStopped", isStopped);
				object.accumulate("artist", artist);	    	
				object.accumulate("title", title);
		    	object.accumulate("trackIndex", trackIndex);
		    	object.accumulate("imagePath", imagePath);
				object.accumulate("trackProgressPercentage", trackProgressPercentage);
			} catch (JSONException e) {	}	
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
		status = new MusicPlayerStatus(jsonObject.getJSONObject("status"));
    }
	
    public JSONObject serialize()
    {
    	JSONObject object = super.serialize();
		try {
			
			object.accumulate("status", status.serialize());
		} catch (JSONException e) {
			log.error("Exception occured: ",e);
		}

    	return object;
    }
   
}
