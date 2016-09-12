package net.yourhome.common.base.enums;

    public enum MobileNotificationTypes implements EnumConverter<String,MobileNotificationTypes>
    {
        TEXT("text"),
        IMAGE("image"),
        DATE_TIME_PICKER("date_time_picker_dialog");
        
        private final String value;
        
        MobileNotificationTypes(String value) {
            this.value = (String) value;
        }
        
    	/* Reverse enum methods */
    	private static ReverseEnumMap<String,MobileNotificationTypes> map = new ReverseEnumMap<String,MobileNotificationTypes>(MobileNotificationTypes.class);
    	
    	public String convert() {
    		return value;
    	}
    	
    	public static MobileNotificationTypes convert(String val) {
    		return map.get(val);
    	}
    	
    	public String getValue() {
    		return this.value;
    	}
        
    }

