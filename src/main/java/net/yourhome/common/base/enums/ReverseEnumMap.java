package net.yourhome.common.base.enums;

import java.util.HashMap;
import java.util.Map;

public class ReverseEnumMap<T,V extends Enum<V> & EnumConverter<T,V>> {
	  private Map<T, V> map = new HashMap<T, V>();
	  
	  public ReverseEnumMap(Class<V> valueType) {
	    for (V v : valueType.getEnumConstants()) {
	      map.put(v.convert(), v);
	    }
	  }

	  public V get(T num) {
	    return map.get(num);
	  }
}
