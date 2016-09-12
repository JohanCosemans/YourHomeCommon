
package net.yourhome.common.base.enums;

    public enum ValueTypes implements EnumConverter<String,ValueTypes>
    {
    	SENSOR_GENERAL("sensor_general"),
    	SENSOR_TEMPERATURE("sensor_temperature"),
    	SENSOR_BINARY("sensor_binary"),
    	SENSOR_HUMIDITY("sensor_humidity"),
    	SENSOR_MOTION("sensor_motion"),
    	SENSOR_LUMINOSITY("sensor_luminosity"),
    	SENSOR_ALARM("sensor_alarm"),
    	SWITCH_BINARY("switch_binary"),
    	DIMMER("dimmer"),
    	COLOR_BULB("color_bulb"),
    	HEATING("heating"),
    	GENERAL_COMMAND("general_command"),
    	METER("meter"),
    	TEXT("text"),
    	//WEB_LINK("web_link"),
    	WEB_STATIC_HTML("web_static_html"),
    	//WEB_RSS("web_rss"),
    	IP_CAMERA("ip_camera"),
    	RADIO_STATION("radio_station"),
    	SCENE_ACTIVATION("scene_activation"),
    	WAIT("wait"),
    	SYSTEM_COMMAND("system_command"),
    	SEND_NOTIFICATION("send_notification"),
		SOUND_NOTIFICATION("sound_notification"),
    	HTTP_COMMAND("http_command"),
		MUSIC_PLAY_PAUSE("music_play_pause"),
		MUSIC_RANDOM("music_random"),
		MUSIC_ACTION("music_action"),
		MUSIC_PLAYLIST("music_playlist"),
		MUSIC_PLAYLISTS("music_playlists"),
		MUSIC_PROGRESS("music_progress"),
		MUSIC_ALBUM_IMAGE("music_album_image"),
		MUSIC_TRACK_DISPLAY("music_track_display"),
		
		/* Trigger types */
		EVENT("event"),
		TIME_PERIOD("period"),
		
    	//...
		UNKNOWN("unknown");
        
        private final String value;
        
        ValueTypes(String value) {
            this.value = (String) value;
        }
        
    	/* Reverse enum methods */
    	private static ReverseEnumMap<String,ValueTypes> map = new ReverseEnumMap<String,ValueTypes>(ValueTypes.class);
    	
    	public String convert() {
    		return value;
    	}
    	
    	public static ValueTypes convert(String val) {
    		ValueTypes valueType =  map.get(val);
    		return valueType==null?UNKNOWN:valueType;
    	}
    	
    	public String toString() {
    		return this.value;
    	}
    	public String getValue() {
    		return this.value;
    	}
        
    }

