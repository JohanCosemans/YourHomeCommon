package net.yourhome.common.net.messagestructures.general;

import java.util.ArrayList;
import java.util.List;


public class HistoryValues {
	public List<Integer> time;
	public List<Double> value;
	public String valueUnit;
	
	public HistoryValues() {
		time = new ArrayList<Integer>();
		value = new ArrayList<Double>();
	}
	
	

}