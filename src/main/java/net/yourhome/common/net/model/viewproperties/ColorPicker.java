package net.yourhome.common.net.model.viewproperties;

import net.yourhome.common.base.enums.ViewTypes;

public class ColorPicker extends View {

	public ColorPicker() {
		super(ViewTypes.COLOR_PICKER);
	}
	protected ColorPicker(String id, ViewTypes viewType, String icon, String draggable, String title) {
		super(id,viewType, icon, draggable, title);
	}
	public ColorPicker( String id, String icon, String draggable, String title) {
		this(id,ViewTypes.COLOR_PICKER, icon, draggable, title);
	}
	@Override
	public void addProperties() {
		
	}
}
