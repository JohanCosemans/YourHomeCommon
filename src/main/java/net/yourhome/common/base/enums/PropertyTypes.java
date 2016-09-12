package net.yourhome.common.base.enums;

    public enum PropertyTypes implements EnumConverter<String,PropertyTypes>
    {
    	IMAGE("image"),
    	IMAGE_STATE("image_state"),
    	ALIGNMENT("alignment"),
    	STRING("string"),
    	DOUBLE("double"),
    	COLOR("color"),
    	BOOLEAN("boolean");
        
        private final String value;
        
        PropertyTypes(String value) {
            this.value = (String) value;
        }
        
    	/* Reverse enum methods */
    	private static ReverseEnumMap<String,PropertyTypes> map = new ReverseEnumMap<String,PropertyTypes>(PropertyTypes.class);
    	
    	public String convert() {
    		return value;
    	}
    	
    	public static PropertyTypes convert(String val) {
    		return map.get(val);
    	}
        
    }

