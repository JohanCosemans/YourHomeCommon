package net.yourhome.common.net.model.viewproperties;

import net.yourhome.common.base.enums.ViewTypes;

public class TrackProgress extends View {
	public TrackProgress() {
		super(ViewTypes.TRACK_PROGRESS);
	}
	protected TrackProgress( String id,ViewTypes viewType, String icon, String draggable, String title) {
		super(id,viewType, icon, draggable, title);
	}
	public TrackProgress( String id,String icon, String draggable, String title) {
		this( id,ViewTypes.TRACK_PROGRESS, icon, draggable, title);
	}
	@Override
	public void addProperties() {
		// TODO Auto-generated method stub
		
	}

}
