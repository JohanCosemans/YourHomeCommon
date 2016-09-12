package net.yourhome.common.base.enums;

public enum GeneralCommands implements EnumConverter<String,GeneralCommands> {
	ALL_ON("AllOn"),
    ALL_OFF("AllOff");
	
    private final String value;
    
    GeneralCommands(String value) {
        this.value = (String) value;
    }
    
	/* Reverse enum methods */
	private static ReverseEnumMap<String,GeneralCommands> map = new ReverseEnumMap<String,GeneralCommands>(GeneralCommands.class);
	
	public String convert() {
		return value;
	}
	
	public static GeneralCommands convert(String val) {
		return map.get(val);
	}

	public static String getNodeIdentifier(){
		return "General";
	}
}
