package net.yourhome.common.net.model.viewproperties;

import net.yourhome.common.base.enums.PropertyTypes;
import net.yourhome.common.base.enums.ViewTypes;

public class Image extends View {

	public Image() {
		super(ViewTypes.IMAGE);
	}
	public Image(ViewTypes type) {
		super(type);
	}
	protected Image(String id,ViewTypes viewType, String icon, String draggable, String title) {
		super(id,viewType, icon, draggable, title);
	}
	public Image(String id,String icon, String draggable, String title, String imageSrc) {
		this(id,ViewTypes.IMAGE, icon, draggable, title);
		this.setAttributeValue("imageSrc", imageSrc);
	}
	public Image(String id,String image, String title) {
		this(id,image, image, title, image);
		this.setAttributeValue("imageSrc", image);
	}
	@Override
	public void addProperties() {
		this.properties.put("imageSrc", new Property(PropertyTypes.IMAGE, "imageSrc", "Image", null));
		
	}
	
}
