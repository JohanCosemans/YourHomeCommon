package net.yourhome.common.net.model.viewproperties;

import net.yourhome.common.base.enums.ViewTypes;

public class Playlists extends ImageButton {
	public Playlists() {
		super(ViewTypes.PLAYLISTS);
	}
	protected Playlists(String id,ViewTypes viewType, String icon, String draggable, String title) {
		super(id,viewType, icon, draggable, title);
	}
	public Playlists(String id,String icon, String draggable, String title, String imageSrc) {
		this(id,ViewTypes.PLAYLISTS, icon, draggable, title);
	}
	public Playlists(String id,String image, String title) {
		this(id,image, image, title, image);
		this.setAttributeValue("imageSrc", image);
	}


}
