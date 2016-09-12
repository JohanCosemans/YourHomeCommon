package net.yourhome.common.base.enums;

    public enum ControllerTypes implements EnumConverter<String,ControllerTypes>
    {
        SPOTIFY("spotify"),
        ZWAVE("zwave"),
        RADIO("radio"),
        HTTP("http"),
        GENERAL("general"),
		IPCAMERA("ipcamera"),
		THERMOSTAT("thermostat"),
		PHILIPS_HUE("philips_hue"),
		UNKNOWN("unknown"),
		DEMO("demo");
        
        private final String value;
        
        ControllerTypes(String value) {
            this.value = (String) value;
        }
        
    	/* Reverse enum methods */
    	private static ReverseEnumMap<String,ControllerTypes> map = new ReverseEnumMap<String,ControllerTypes>(ControllerTypes.class);
    	
    	public String convert() {
    		return value;
    	}
    	
    	public static ControllerTypes convert(String val) {
    		return map.get(val);
    	}
    	
    	public String getValue() {
    		return this.value;
    	}
        
    }

