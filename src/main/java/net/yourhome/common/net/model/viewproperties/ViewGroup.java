package net.yourhome.common.net.model.viewproperties;

import java.util.ArrayList;
import java.util.List;

public class ViewGroup {
	
	private String title;
	private List<View> objects = new ArrayList<View>();
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the objects
	 */
	public List<View> getObjects() {
		return objects;
	}
	/**
	 * @param objects the objects to set
	 */
	public void setObjects(List<View> objects) {
		this.objects = objects;
	}
	
	public void addView(View v) {
		this.objects.add(v);
	}
	
	
	
}
