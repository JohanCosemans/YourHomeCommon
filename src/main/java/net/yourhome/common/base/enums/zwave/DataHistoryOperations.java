package net.yourhome.common.base.enums.zwave;

import net.yourhome.common.base.enums.EnumConverter;
import net.yourhome.common.base.enums.ReverseEnumMap;

public enum DataHistoryOperations  implements EnumConverter<Integer,DataHistoryOperations> {
	NO_OPERATION(0),
	DELTA(1),
    AVERAGE(2),
    MIN(3),
    MAX(4);
    
    private final Integer value;
    
    DataHistoryOperations(int value) {
        this.value = (Integer) value;
    }
    
	
	/* Reverse enum methods */
	private static ReverseEnumMap<Integer,DataHistoryOperations> map = new ReverseEnumMap<Integer,DataHistoryOperations>(DataHistoryOperations.class);
	

	public Integer convert() {
		return value;
	}
	
	public DataHistoryOperations convert(Integer val) {
		return map.get(val);
	}

	public static DataHistoryOperations fromInt(Integer val) {
		return map.get((Integer)val);
	}
}
