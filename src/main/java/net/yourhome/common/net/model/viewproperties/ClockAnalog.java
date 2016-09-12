package net.yourhome.common.net.model.viewproperties;

import net.yourhome.common.base.enums.ViewTypes;

public class ClockAnalog extends View {
	public ClockAnalog() {
		super(ViewTypes.CLOCK_ANALOG);
	}
	protected ClockAnalog( String id,ViewTypes viewType, String icon, String draggable, String title) {
		super(id,viewType, icon, draggable, title);
	}
	public ClockAnalog( String id,String icon, String draggable, String title) {
		this(id,ViewTypes.CLOCK_ANALOG, icon, draggable, title);
	}
	@Override
	public void addProperties() {
		// TODO Auto-generated method stub
		
	}
}
