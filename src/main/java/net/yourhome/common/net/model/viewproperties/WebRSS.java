package net.yourhome.common.net.model.viewproperties;

import net.yourhome.common.base.enums.PropertyTypes;
import net.yourhome.common.base.enums.ViewTypes;

public class WebRSS extends View {

	public static String URL = "url";
	public static String COLOR = "color";
	
	public WebRSS() {
		super(ViewTypes.WEB_RSS);
	}
	protected WebRSS( String id,ViewTypes viewType, String icon, String draggable, String title) {
		super(id,viewType, icon, draggable, title);
	}
	public WebRSS( String id,String icon, String draggable, String title, String url, String color) {
		this(id,ViewTypes.WEB_RSS, icon, draggable, title);
		this.setAttributeValue(URL, url);
		this.setAttributeValue(COLOR, color);
	}
	@Override
	public void addProperties() {
		this.properties.put(URL, new Property(PropertyTypes.STRING, URL, "Feed Url", null));
		this.properties.put(COLOR, new Property(PropertyTypes.COLOR, COLOR, "Text Color", null));
	}
}
