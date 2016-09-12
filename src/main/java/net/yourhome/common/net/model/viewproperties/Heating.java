package net.yourhome.common.net.model.viewproperties;

import net.yourhome.common.base.enums.PropertyTypes;
import net.yourhome.common.base.enums.ViewTypes;

public class Heating extends View {
	
	public Heating() {
		super(ViewTypes.HEATING);
	}
	protected Heating(String id,ViewTypes viewType, String icon, String draggable, String title) {
		super(id,viewType, icon, draggable, title);
	}
	
	public Heating(String id,String icon, String draggable, String title, String normalImageSrc, String coldImageSrc, String hotImageSrc) {
		this(id,ViewTypes.HEATING, icon, draggable, title);
		this.setAttributeValue("normalImageSrc", normalImageSrc);
		this.setAttributeValue("coldImageSrc", coldImageSrc);
		this.setAttributeValue("hotImageSrc", hotImageSrc);
	}
	@Override
	public void addProperties() {

		this.properties.put("normalImageSrc", new Property(PropertyTypes.IMAGE, "normalImageSrc", "Normal Image", null));
		this.properties.put("coldImageSrc", new Property(PropertyTypes.IMAGE, "coldImageSrc", "Cold Image", null));
		this.properties.put("hotImageSrc", new Property(PropertyTypes.IMAGE, "hotImageSrc", "Hot Image", null));
		
	}
}
