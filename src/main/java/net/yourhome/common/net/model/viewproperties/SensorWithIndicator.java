package net.yourhome.common.net.model.viewproperties;

import net.yourhome.common.base.enums.PropertyTypes;
import net.yourhome.common.base.enums.ViewTypes;

public class SensorWithIndicator extends Sensor {
	public static String UP_IMAGE = "upImageSrc";
	public static String NEUTRAL_IMAGE = "neutralImageSrc";
	public static String DOWN_IMAGE = "downImageSrc";
	public static String COLOR = "color";
	public static String SIZE = "size";
	
	// Sensor
	public SensorWithIndicator() {
		super(ViewTypes.SENSOR_WITH_INDICATOR);
	}
	public SensorWithIndicator( String id,String icon, String draggable, String title, String upImageSrc, String neutralImageSrc, String downImageSrc, String color, Double size) {
		super(id,icon, draggable, title, color,size);
		
		this.setAttributeValue(UP_IMAGE, upImageSrc);
		this.setAttributeValue(NEUTRAL_IMAGE, neutralImageSrc);
		this.setAttributeValue(DOWN_IMAGE, downImageSrc);
	}
	@Override
	public void addProperties() {
		super.addProperties();
		this.properties.put(UP_IMAGE, new Property(PropertyTypes.IMAGE, UP_IMAGE, "Up image", null));
		this.properties.put(NEUTRAL_IMAGE, new Property(PropertyTypes.IMAGE, NEUTRAL_IMAGE, "Neutral image", null));
		this.properties.put(DOWN_IMAGE, new Property(PropertyTypes.IMAGE, DOWN_IMAGE, "Down image", null));	
	}
}
