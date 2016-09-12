package net.yourhome.common.base.enums;

public interface EnumConverter <T,E extends Enum<E> & EnumConverter<T,E>> {
	  T convert();
	  //E convert(T val);
}