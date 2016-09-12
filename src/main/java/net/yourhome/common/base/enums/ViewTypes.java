package net.yourhome.common.base.enums;

    public enum ViewTypes implements EnumConverter<String,ViewTypes>
    {
    	CLOCK_DIGITAL("clock_digital"),
    	CLOCK_ANALOG("clock_analog"),
    	COLOR_PICKER("color_picker"),
    	TEXT("text"),
    	WEB_LINK("web_link"),
    	WEB_STATIC_HTML("web_static_html"),
    	WEB_RSS("web_rss"),
    	HEATING("heating"),
    	IMAGE_BUTTON("image_button"),
    	MULTI_STATE_BUTTON("multi_state_button"),
    	IMAGE("image"),
    	SHAPE("shape"),
    	LINE_GRAPH("line_graph"),
    	PLUS_MIN_VALUE("plus_min_value"),
    	SENSOR("sensor"),
    	SENSOR_WITH_INDICATOR("sensor_with_indicator"),
    	SLIDER("slider"),
    	CAMERA("camera"),
    	TRACK_DISPLAY("track_display"),
    	PLAYLIST("playlist"),
    	PLAYLISTS("playlists"),
    	ALBUM_IMAGE("album_image"),
    	TRACK_PROGRESS("track_progress");
        
        private final String value;
        
        ViewTypes(String value) {
            this.value = (String) value;
        }
        
    	/* Reverse enum methods */
    	private static ReverseEnumMap<String,ViewTypes> map = new ReverseEnumMap<String,ViewTypes>(ViewTypes.class);
    	
    	public String convert() {
    		return value;
    	}
    	
    	public static ViewTypes convert(String val) {
    		return map.get(val);
    	}
        
    }

