package net.yourhome.common.net.model.viewproperties;

import net.yourhome.common.base.enums.PropertyTypes;
import net.yourhome.common.base.enums.ViewTypes;

public class Sensor extends View {
	public static String COLOR = "color";
	public static String SIZE = "size";
	
	// Sensor
	public Sensor() {
		super(ViewTypes.SENSOR);
	}
	public Sensor(ViewTypes type) {
		super(type);
	}
	protected Sensor(String id, ViewTypes viewType, String icon, String draggable, String title) {
		super(id,viewType, icon, draggable, title);
	}
	public Sensor(String id, String icon, String draggable, String title, String color, Double size) {
		this(id,ViewTypes.SENSOR, icon, draggable, title);
		this.setAttributeValue(COLOR, color);
		this.setAttributeValue(SIZE, size+"");
	}
	@Override
	public void addProperties() {
		this.properties.put(COLOR, new Property(PropertyTypes.COLOR, COLOR, "Color", null));
		this.properties.put(SIZE, new Property(PropertyTypes.DOUBLE, SIZE, "Size", null));
		
	}
}
