package net.yourhome.common.net.model.viewproperties;

import net.yourhome.common.base.enums.ViewTypes;

public class Playlist extends View {

	public Playlist() {
		super(ViewTypes.PLAYLIST);
	}
	protected Playlist(String id,ViewTypes viewType, String icon, String draggable, String title) {
		super(id,viewType, icon, draggable, title);
	}
	public Playlist(String id,String icon, String draggable, String title) {
		this(id,ViewTypes.PLAYLIST, icon, draggable, title);
	}
	@Override
	public void addProperties() {
		// TODO Auto-generated method stub
		
	}

}
