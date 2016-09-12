package net.yourhome.common.net.messagestructures.general;

import org.json.JSONException;
import org.json.JSONObject;

import net.yourhome.common.base.enums.MessageTypes;
import net.yourhome.common.base.enums.zwave.DataHistoryOperations;
import net.yourhome.common.base.enums.zwave.DataHistoryPeriodTypes;
import net.yourhome.common.net.messagestructures.JSONMessage;

public class ValueHistoryRequest extends JSONMessage {

	public int historyAmount = 10;
	public int offset=0;
	public DataHistoryPeriodTypes periodType;
	public DataHistoryOperations operation;
	
	public ValueHistoryRequest() {
		super();
		type = MessageTypes.ValueHistoryRequest;
	}
	public ValueHistoryRequest(JSONMessage jsonMessage) throws JSONException {
		super(jsonMessage);
	}
	public ValueHistoryRequest(JSONObject jsonObject) throws JSONException {
		super(jsonObject);
		this.periodType = DataHistoryPeriodTypes.fromInt(jsonObject.getInt("periodType"));
		this.operation = DataHistoryOperations.fromInt(jsonObject.getInt("operation"));
		this.historyAmount = jsonObject.getInt("historyAmount");
		this.offset = jsonObject.getInt("offset");
	}
	 public JSONObject serialize()
	    {
	    	JSONObject jsonObj = super.serialize();
			try {
				jsonObj.accumulate("historyAmount", historyAmount);
				jsonObj.accumulate("offset", offset);
				jsonObj.accumulate("periodType", periodType.convert());
				jsonObj.accumulate("operation", operation.convert());
			} catch (JSONException e) {
				log.error("Exception occured: ",e);
			}
	    	
	        return jsonObj;
	    }
}
