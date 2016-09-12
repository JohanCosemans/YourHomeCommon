package net.yourhome.common.base.enums.zwave;

import net.yourhome.common.base.enums.EnumConverter;
import net.yourhome.common.base.enums.ReverseEnumMap;

public enum DataHistoryPeriodTypes  implements EnumConverter<Integer, DataHistoryPeriodTypes> {
	
	REALTIME(0),
    DAILY(1),
    WEEKLY(2),
    MONTHLY(3);
    
    private final Integer value;
    
    DataHistoryPeriodTypes(int value) {
        this.value = (Integer) value;
    }
    
	
	/* Reverse enum methods */
	private static ReverseEnumMap<Integer,DataHistoryPeriodTypes> map = new ReverseEnumMap<Integer,DataHistoryPeriodTypes>(DataHistoryPeriodTypes.class);
	

	public Integer convert() {
		return value;
	}
	
	public DataHistoryPeriodTypes convert(Integer val) {
		return map.get(val);
	}

	public static DataHistoryPeriodTypes fromInt(int val) {
		return map.get((Integer)val);
	}
}
