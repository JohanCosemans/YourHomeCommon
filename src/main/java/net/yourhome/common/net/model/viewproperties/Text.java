package net.yourhome.common.net.model.viewproperties;

import net.yourhome.common.base.enums.Alignments;
import net.yourhome.common.base.enums.PropertyTypes;
import net.yourhome.common.base.enums.ViewTypes;

public class Text extends View {

	public static String COLOR = "color";
	public static String SIZE = "size";
	public static String CONTENT = "content";
	public static String ALIGNMENT = "alignment";
	
	public Text() {
		super(ViewTypes.TEXT);
	}
	protected Text( String id,ViewTypes viewType, String icon, String draggable, String title) {
		super(id,viewType, icon, draggable, title);
	}
	public Text( String id,String icon, String draggable, String title, String color, Double size, String content, Alignments alignment) {
		this(id,ViewTypes.TEXT, icon, draggable, title);
		this.setAttributeValue(CONTENT, content);
		this.setAttributeValue(SIZE, size+"");
		this.setAttributeValue(ALIGNMENT, alignment.convert());
		this.setAttributeValue(COLOR, color);
	}
	@Override
	public void addProperties() {

		this.properties.put(CONTENT, new Property(PropertyTypes.STRING, CONTENT, "Content", null));
		this.properties.put(SIZE, new Property(PropertyTypes.DOUBLE, SIZE, "Size", null));
		this.properties.put(ALIGNMENT, new Property(PropertyTypes.ALIGNMENT, ALIGNMENT, "Alignment", null));
		this.properties.put(COLOR, new Property(PropertyTypes.COLOR, COLOR, "Color", null));
		
	}
}
