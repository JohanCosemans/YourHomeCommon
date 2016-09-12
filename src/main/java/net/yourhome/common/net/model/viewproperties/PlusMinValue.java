package net.yourhome.common.net.model.viewproperties;

import net.yourhome.common.base.enums.PropertyTypes;
import net.yourhome.common.base.enums.ViewTypes;

public class PlusMinValue extends View {
	public static String STEP = "step";
	public static String COLOR = "color";
	public static String SIZE = "size";
	
	public PlusMinValue() {
		super(ViewTypes.PLUS_MIN_VALUE);
	}
	protected PlusMinValue(String id, ViewTypes viewType, String icon, String draggable, String title) {
		super(id,viewType, icon, draggable, title);
	}
	public PlusMinValue(String id, String icon, String draggable, String title) {
		this(id,ViewTypes.PLUS_MIN_VALUE, icon, draggable, title);
	}
	public PlusMinValue(String id, String icon, String draggable, String title, Double step, String color, int size) {
		this(id,ViewTypes.PLUS_MIN_VALUE, icon, draggable, title);
		this.setAttributeValue(STEP, step+"");
		this.setAttributeValue(COLOR, color);
		this.setAttributeValue(SIZE, size+"");
	}
	@Override
	public void addProperties() {
		this.properties.put(STEP, new Property(PropertyTypes.DOUBLE, STEP, "Step increase/decrease", null));
		this.properties.put(COLOR, new Property(PropertyTypes.COLOR, COLOR, "Color", null));
		this.properties.put(SIZE, new Property(PropertyTypes.DOUBLE, SIZE, "Size", null));
	}
}
