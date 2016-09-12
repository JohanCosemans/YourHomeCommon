package net.yourhome.common.net.model.viewproperties;

import net.yourhome.common.base.enums.PropertyTypes;
import net.yourhome.common.base.enums.ViewTypes;

public class Slider extends View {

	public static String MAXIMUM = "maximum";
	public static String MINIMUM = "minimum";
	public Slider() {
		super(ViewTypes.SLIDER);
	}
	protected Slider(String id,ViewTypes viewType, String icon, String draggable, String title) {
		super( id,viewType, icon, draggable, title);
	}
	public Slider(String id,String icon, String draggable, String title,  Double maximum, Double minimum) {
		this(id, ViewTypes.SLIDER, icon, draggable, title);

		this.setAttributeValue(MAXIMUM, maximum+"");
		this.setAttributeValue(MINIMUM, minimum+"");
	}
	@Override
	public void addProperties() {
		this.properties.put(MAXIMUM, new Property(PropertyTypes.DOUBLE, MAXIMUM, "Maximum", null));
		this.properties.put(MINIMUM, new Property(PropertyTypes.DOUBLE, MINIMUM, "Minimum", null));
		
	}

}
