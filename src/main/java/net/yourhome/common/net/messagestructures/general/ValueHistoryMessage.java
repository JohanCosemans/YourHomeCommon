package net.yourhome.common.net.messagestructures.general;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import net.yourhome.common.base.enums.MessageTypes;
import net.yourhome.common.net.messagestructures.JSONMessage;

public class ValueHistoryMessage extends JSONMessage {
	public HistoryValues sensorValues = new HistoryValues();
	public String title;
	public int offset = 0;
	
	public ValueHistoryMessage() {
		super();
		this.type = MessageTypes.ValueHistory;
	}
	public ValueHistoryMessage(JSONMessage message) {
		super(message);
    }
	public ValueHistoryMessage(JSONObject jsonObject) throws JSONException {
		super(jsonObject);
		offset = jsonObject.getInt("offset");
        try {
            title = jsonObject.getString("title");
        }catch(JSONException e) {}
		
		// Parse values
		JSONObject valueObject = jsonObject.getJSONObject("Values");
		
		// Parse time
		JSONArray timeArray = valueObject.getJSONArray("time");
		for(int i=0;i<timeArray.length();i++) {
			sensorValues.time.add(timeArray.getInt(i));
		}
		
		// Parse value
		JSONArray valueArray = valueObject.getJSONArray("value");
		for(int i=0;i<valueArray.length();i++) {
			sensorValues.value.add(valueArray.getDouble(i));
		}
		
		try {
			sensorValues.valueUnit = valueObject.getString("valueUnit");
		}catch(JSONException e) {}
		
    }
	
	public JSONObject serialize() {
    	JSONObject object = super.serialize(); 

		try {
			JSONArray timeArray = new JSONArray(this.sensorValues.time);
			JSONArray valueArray = new JSONArray(this.sensorValues.value);
			JSONObject valuesObject = new JSONObject();
			valuesObject.put("time", timeArray);
			valuesObject.put("value", valueArray);
			valuesObject.put("valueUnit", this.sensorValues.valueUnit);
			object.put("title", this.title);
			object.put("Values", valuesObject);
			object.put("offset", offset);
		} catch (JSONException e) {
//			log.error("Exception occured: ",e);
		}
					
    	return object;
    }
	
}
