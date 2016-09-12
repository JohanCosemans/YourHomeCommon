package net.yourhome.common.net.model.viewproperties;

import net.yourhome.common.base.enums.PropertyTypes;
import net.yourhome.common.base.enums.ViewTypes;

public class Shape extends View {

	public static String COLOR = "color";
	public static String CORNER_RADIUS = "corner_radius";
	
	public Shape() {
		super(ViewTypes.SHAPE);
	}
	protected Shape( String id,ViewTypes viewType, String icon, String draggable, String title) {
		super(id,viewType, icon, draggable, title);
	}
	public Shape( String id,String icon, String draggable, String title, String color, Double radius) {
		this(id,ViewTypes.SHAPE, icon, draggable, title);
		this.setAttributeValue(COLOR, color);
		this.setAttributeValue(CORNER_RADIUS, radius+"");
	}
	@Override
	public void addProperties() {
		this.properties.put(COLOR, new Property(PropertyTypes.COLOR, COLOR, "Color", null));
		this.properties.put(CORNER_RADIUS, new Property(PropertyTypes.DOUBLE, CORNER_RADIUS, "Corner Radius", null));
		
	}
}
