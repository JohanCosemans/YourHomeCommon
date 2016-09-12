package net.yourhome.common.net.model.viewproperties;

import net.yourhome.common.base.enums.PropertyTypes;
import net.yourhome.common.base.enums.ViewTypes;

public class WebLink extends View {

	public static String URL = "url";
	
	public WebLink() {
		super(ViewTypes.WEB_LINK);
	}
	protected WebLink( String id,ViewTypes viewType, String icon, String draggable, String title) {
		super(id,viewType, icon, draggable, title);
	}
	public WebLink( String id,String icon, String draggable, String title, String url) {
		this(id,ViewTypes.WEB_LINK, icon, draggable, title);
		this.setAttributeValue(URL, url);
	}
	@Override
	public void addProperties() {
		this.properties.put(URL, new Property(PropertyTypes.STRING, URL, "Url", null));
	}
}
