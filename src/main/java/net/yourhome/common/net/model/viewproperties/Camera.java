package net.yourhome.common.net.model.viewproperties;

import net.yourhome.common.base.enums.ViewTypes;

public class Camera extends View {

	public Camera() {
		super(ViewTypes.CAMERA);
	}
	protected Camera(String id,ViewTypes viewType, String icon, String draggable, String title) {
		super(id,viewType, icon, draggable, title);
	}
	public Camera(String id,String icon, String draggable, String title) {
		this(id,ViewTypes.CAMERA, icon, draggable, title);
	}
	@Override
	public void addProperties() {
		// TODO Auto-generated method stub
		
	}
}
