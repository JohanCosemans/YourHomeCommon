package net.yourhome.common.net.model.viewproperties;

import net.yourhome.common.base.enums.PropertyTypes;
import net.yourhome.common.base.enums.ViewTypes;

public class LineGraph extends View {
	
	public static String GRAPH_TITLE = "graphTitle";
	public static String MAXIMUM = "maximum";
	public static String MINIMUM = "minimum";
	
	public LineGraph() {
		super(ViewTypes.LINE_GRAPH);
	}
	protected LineGraph(String id,ViewTypes viewType, String icon, String draggable, String title) {
		super(id,viewType, icon, draggable, title);
	}
	
	public LineGraph(String id,String icon, String draggable, String title, String graphTitle, Double maximum, Double minimum) {
		this(id,ViewTypes.LINE_GRAPH, icon, draggable, title);

		this.setAttributeValue(GRAPH_TITLE, graphTitle);
		this.setAttributeValue(MAXIMUM, maximum+"");
		this.setAttributeValue(MINIMUM, minimum+"");
	}
	@Override
	public void addProperties() {

		this.properties.put(GRAPH_TITLE, new Property(PropertyTypes.STRING, GRAPH_TITLE, "Title", null));
		this.properties.put(MAXIMUM, new Property(PropertyTypes.DOUBLE, MAXIMUM, "Maximum", null));
		this.properties.put(MINIMUM, new Property(PropertyTypes.DOUBLE, MINIMUM, "Minimum", null));
		
	}

}
