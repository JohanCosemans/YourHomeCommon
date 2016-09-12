package net.yourhome.common.net.messagestructures.general;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import net.yourhome.common.base.enums.ControllerTypes;
import net.yourhome.common.base.enums.MessageTypes;
import net.yourhome.common.base.enums.MobileNotificationTypes;
import net.yourhome.common.net.messagestructures.JSONMessage;

public class ClientNotificationMessage extends JSONMessage {

	public MobileNotificationTypes notificationType;
	public String title;
	public String message;
	
	public String imagePath;
	public String videoPath;
	
	public String windowTitle;
	public String subtitle;
	public long startDate;
	public boolean cancel = false;
	
	public ClientNotificationMessage() {
		this.controlIdentifiers.setControllerIdentifier(ControllerTypes.GENERAL);
		this.type = MessageTypes.ClientNotification;
	}
	public ClientNotificationMessage(JSONObject jsonObject) throws JSONException {
		super(jsonObject);
	}
	public Map<String,String> getMessageMap() {
		Map<String,String> returnmap = new HashMap<String,String>();
		returnmap.put("title", title);
		returnmap.put("message", message);
		returnmap.put("imagePath", imagePath);
		returnmap.put("videoPath", videoPath);
		returnmap.put("windowTitle", windowTitle);
		returnmap.put("subtitle", subtitle);
		returnmap.put("startDate", startDate+"");
		returnmap.put("notificationType", notificationType.convert());
		returnmap.put("controllerIdentifier", controlIdentifiers.getControllerIdentifier().convert());
		returnmap.put("nodeIdentifier", controlIdentifiers.getNodeIdentifier());
		returnmap.put("valueIdentifier", controlIdentifiers.getValueIdentifier());
		returnmap.put("cancel", cancel?"true":"false");
		return returnmap;
	}
	
    public JSONObject serialize() {
    	JSONObject object = super.serialize();
    	try {
    		object.put("title", title);
    		object.put("message", message);
    		object.put("imagePath", imagePath);
    		object.put("videoPath", videoPath);
    		object.put("windowTitle", windowTitle);
    		object.put("subtitle", subtitle);
    		object.put("defaultDate", startDate);
			object.put("notificationType", notificationType.convert());
    		object.put("cancel", cancel);
		} catch (JSONException e) {
			log.error("Exception occured: ",e);
		}
    	return object;
    }
}
