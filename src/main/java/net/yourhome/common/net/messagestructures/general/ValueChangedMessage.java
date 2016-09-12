package net.yourhome.common.net.messagestructures.general;

import org.json.JSONException;
import org.json.JSONObject;

import net.yourhome.common.base.enums.ControllerTypes;
import net.yourhome.common.base.enums.MessageTypes;
import net.yourhome.common.base.enums.ValueTypes;
import net.yourhome.common.net.messagestructures.JSONMessage;

public class ValueChangedMessage extends JSONMessage {
	
	public ValueTypes valueType;
	public String value;            
    public String unit;
    
	public ValueChangedMessage() {
		this.controlIdentifiers.setControllerIdentifier(ControllerTypes.GENERAL);
        type = MessageTypes.ValueChanged;
    }
	public ValueChangedMessage(JSONObject json) throws JSONException {
		super(json);
		value = json.getString("value");
		try {
			unit = json.getString("unit");
		}catch(JSONException e) {}
		valueType = ValueTypes.convert(json.getString("valueType"));
    }
	public ValueChangedMessage(JSONMessage message) throws JSONException {
		super(message);
        type = MessageTypes.ValueChanged;
    }
	
    public JSONObject serialize()
    {
    	JSONObject jsonObj = super.serialize();
    	try {
	    	jsonObj.accumulate("value", value);
	    	jsonObj.accumulate("unit", unit);
	    	if(valueType != null) {
	    		jsonObj.accumulate("valueType", valueType.convert());
	    	}
		} catch (JSONException e) {
			log.error("Exception occured: ",e);
		}
        return jsonObj;
    }
}
