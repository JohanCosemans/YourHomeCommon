package net.yourhome.common.net.model.viewproperties;

import net.yourhome.common.base.enums.PropertyTypes;
import net.yourhome.common.base.enums.ViewTypes;

public class ClockDigital extends View {

	public static String COLOR = "color";
	public static String SIZE = "size";
	public static String AMPM = "AMPM";
	public ClockDigital() {
		super(ViewTypes.CLOCK_DIGITAL);
	}
	protected ClockDigital(String id, ViewTypes viewType, String icon, String draggable, String title) {
		super(id,viewType, icon, draggable, title);
	}
	public ClockDigital( String id,String icon, String draggable, String title, String color, Double size, boolean amPm) {
		this(id,ViewTypes.CLOCK_DIGITAL, icon, draggable, title);
		this.setAttributeValue(COLOR, color);
		this.setAttributeValue(SIZE, size+"");
		this.setAttributeValue(AMPM, amPm?"true":"false");
	}
	@Override
	public void addProperties() {
		this.properties.put(COLOR, new Property(PropertyTypes.COLOR, COLOR, "Color", null));
		this.properties.put(SIZE, new Property(PropertyTypes.DOUBLE, SIZE, "Size", null));
		this.properties.put(AMPM, new Property(PropertyTypes.BOOLEAN, AMPM, "AM/PM", null));
		
	}
}
