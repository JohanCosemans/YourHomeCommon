package net.yourhome.common.base.enums;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.json.JSONException;
import org.json.JSONObject;

import net.yourhome.common.net.messagestructures.JSONMessage;
import net.yourhome.common.net.messagestructures.general.ActivationMessage;
import net.yourhome.common.net.messagestructures.general.ClientMessageMessage;
import net.yourhome.common.net.messagestructures.general.ClientNotificationMessage;
import net.yourhome.common.net.messagestructures.general.GCMRegistrationMessage;
import net.yourhome.common.net.messagestructures.general.SetValueMessage;
import net.yourhome.common.net.messagestructures.general.ValueChangedMessage;
import net.yourhome.common.net.messagestructures.general.ValueHistoryMessage;
import net.yourhome.common.net.messagestructures.general.ValueHistoryRequest;
import net.yourhome.common.net.messagestructures.http.HttpCommandMessage;
import net.yourhome.common.net.messagestructures.ipcamera.SnapshotMessage;
import net.yourhome.common.net.messagestructures.ipcamera.SnapshotRequestMessage;
import net.yourhome.common.net.messagestructures.musicplayer.MusicPlayerStatusMessage;
import net.yourhome.common.net.messagestructures.musicplayer.PlaylistMessage;
import net.yourhome.common.net.messagestructures.musicplayer.PlaylistRequestMessage;
import net.yourhome.common.net.messagestructures.musicplayer.PlaylistsMessage;
import net.yourhome.common.net.messagestructures.musicplayer.PlaylistsRequestMessage;
import net.yourhome.common.net.messagestructures.musicplayer.TrackProgressMessage;
import net.yourhome.common.net.messagestructures.musicplayer.TrackProgressRequestMessage;
import net.yourhome.common.net.messagestructures.radio.RadioOnOffMessage;
import net.yourhome.common.net.messagestructures.thermostat.SetAwayMessage;

public enum MessageTypes implements EnumConverter<String,MessageTypes>
    {
		JSON("JSON", SetValueMessage.class),
		SetValue("SetValue", SetValueMessage.class),
		Activation("Activation", ActivationMessage.class),
		ValueChanged("ValueChanged", ValueChangedMessage.class),
		ValueHistory("ValueHistory",ValueHistoryMessage.class),
		ValueHistoryRequest("ValueHistoryRequest",ValueHistoryRequest.class),
		ClientMessage("ClientMessage",ClientMessageMessage.class),
		ClientNotification("ClientNotification",ClientNotificationMessage.class),
		GCMRegistration("GCMRegistration",GCMRegistrationMessage.class),
		
		// IP Camera
		Snapshot("Snapshot", SnapshotMessage.class),
		SnapshotRequest("SnapshotRequest", SnapshotRequestMessage.class),
		// Radio
		RadioOnOff("RadioOnOff", RadioOnOffMessage.class),
		// Music Player
		MusicPlayerStatus("MusicPlayerStatus",MusicPlayerStatusMessage.class),
		PlaylistRequest("PlaylistRequest",PlaylistRequestMessage.class),
		Playlist("Playlist",PlaylistMessage.class),
		PlaylistsRequest("PlaylistsRequest",PlaylistsRequestMessage.class),
		Playlists("Playlists",PlaylistsMessage.class),
		TrackProgress("TrackProgress",TrackProgressMessage.class),
		TrackProgressRequest("TrackProgressRequest",TrackProgressRequestMessage.class),
		// HTTP
		HttpCommand("HttpCommand", HttpCommandMessage.class),
		// Thermostat
		SetAway("SetAway", SetAwayMessage.class);
	
		private final String messageTypeName;
        private final Class<?> messageClass;
        
        MessageTypes(String messageTypeName, Class<?> messageClass) {
        	this.messageTypeName = messageTypeName;
            this.messageClass =  messageClass;
        }
        
    	/* Reverse enum methods */
    	private static ReverseEnumMap<String,MessageTypes> map = new ReverseEnumMap<String,MessageTypes>(MessageTypes.class);
    	
    	public String convert() {
    		return messageTypeName;
    	}
    	
    	public static MessageTypes convert(String messageTypeName) {
    		return map.get(messageTypeName);
    	}
    	
    	public static JSONMessage getMessage(JSONObject jsonObject) throws ClassNotFoundException, NoSuchMethodException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, JSONException {
    		String type = jsonObject.getString("type");
    		MessageTypes messageType = MessageTypes.convert(type);
    		Constructor<?> constructor = messageType.messageClass.getConstructor(JSONObject.class);
    		Object instance = constructor.newInstance(jsonObject);
    		return (JSONMessage) instance;
    	}
        
    }

