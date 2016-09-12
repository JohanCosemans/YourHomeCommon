package net.yourhome.common.net.model.viewproperties;

import net.yourhome.common.base.enums.ViewTypes;

public class ImageButton extends Image {
	public ImageButton(ViewTypes type) {
		super(type);
	}
	public ImageButton() {
		super(ViewTypes.IMAGE_BUTTON);
	}
	protected ImageButton(String id,ViewTypes viewType, String icon, String draggable, String title) {
		super(id,viewType, icon, draggable, title);
	}
	public ImageButton(String id,String icon, String draggable, String title, String imageSrc) {
		this(id, ViewTypes.IMAGE_BUTTON, icon, draggable, title);
	}
	public ImageButton(String id,String image, String title) {
		this(id,image, image, title, image);
		this.setAttributeValue("imageSrc", image);
	}
}
