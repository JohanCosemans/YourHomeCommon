package net.yourhome.common.net.model.viewproperties;

import net.yourhome.common.base.enums.PropertyTypes;
import net.yourhome.common.base.enums.ViewTypes;

public class WebStaticHtml extends View {

	public static String CONTENT = "content";
	
	public WebStaticHtml() {
		super(ViewTypes.WEB_STATIC_HTML);
	}
	protected WebStaticHtml( String id,ViewTypes viewType, String icon, String draggable, String title) {
		super(id,viewType, icon, draggable, title);
	}
	public WebStaticHtml( String id,String icon, String draggable, String title, String content) {
		this(id,ViewTypes.WEB_STATIC_HTML, icon, draggable, title);
		this.setAttributeValue(CONTENT, content);
	}
	@Override
	public void addProperties() {
		this.properties.put(CONTENT, new Property(PropertyTypes.STRING, CONTENT, "Direct HTML input", null));
	}
}
