package net.yourhome.common.net.model.viewproperties;

import net.yourhome.common.base.enums.ViewTypes;

public class AlbumImage extends View {
	public AlbumImage() {
		super(ViewTypes.ALBUM_IMAGE);
	}
	protected AlbumImage(String id,ViewTypes viewType, String icon, String draggable, String title) {
		super( id, viewType, icon, draggable, title);
	}
	public AlbumImage(String id,String icon, String draggable, String title) {
		this(id,ViewTypes.ALBUM_IMAGE, icon, draggable, title);
	}
	@Override
	public void addProperties() {
		
	}
}
