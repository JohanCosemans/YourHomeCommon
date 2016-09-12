package net.yourhome.common.net.model.viewproperties;

import net.yourhome.common.base.enums.PropertyTypes;
import net.yourhome.common.base.enums.ViewTypes;

public class MultiStateButton extends View {

	public MultiStateButton() {
		super(ViewTypes.MULTI_STATE_BUTTON);
	}
	protected MultiStateButton(String id,ViewTypes viewType, String icon, String draggable, String title) {
		super(id, viewType, icon, draggable, title);
	}
	public MultiStateButton(String id,String icon, String draggable, String title) {
		this(id,ViewTypes.MULTI_STATE_BUTTON, icon, draggable, title);
	}
	
	public void addState(String stateKey, String description, String value) {
		this.setProperty(new Property(PropertyTypes.IMAGE_STATE, stateKey, description, value));
	}
	@Override
	public void addProperties() {
		// TODO Auto-generated method stub
		
	}
}
