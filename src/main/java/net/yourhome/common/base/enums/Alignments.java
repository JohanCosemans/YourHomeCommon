package net.yourhome.common.base.enums;

public enum Alignments implements EnumConverter<String,Alignments> {
	LEFT("left"),
	CENTER("center"),
    RIGHT("right");
	
    private final String value;
    
    Alignments(String value) {
        this.value = (String) value;
    }
    
	/* Reverse enum methods */
	private static ReverseEnumMap<String,Alignments> map = new ReverseEnumMap<String,Alignments>(Alignments.class);
	
	public String convert() {
		return value;
	}
	
	public static Alignments convert(String val) {
		return map.get(val);
	}

	public static String getNodeIdentifier(){
		return "General";
	}
}
