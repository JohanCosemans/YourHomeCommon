package net.yourhome.common.net.messagestructures.http;

import org.json.JSONException;
import org.json.JSONObject;

import net.yourhome.common.base.enums.ControllerTypes;
import net.yourhome.common.base.enums.MessageTypes;
import net.yourhome.common.net.messagestructures.JSONMessage;

public class HttpCommandMessage extends JSONMessage {
	/*public String httpMethod;	//get,post,delete,put
	public String messageType; //e.g. application/json
	public String messageBody; // e.g. { "command" : "value" }
	public String url;			// e.g. www.google.be		
	public String commandName; // e.g. XBMC Title 
	public String commandDescription; // e.g. XBMC Title 
	public int id;
	public int parentNodeId;*/
	public HttpCommand httpCommand;
	public String response;

	
	public HttpCommandMessage() {
		this.controlIdentifiers.setControllerIdentifier(ControllerTypes.HTTP); // HTTP command
		this.type = MessageTypes.HttpCommand;
		this.httpCommand = new HttpCommand();
	}
	public HttpCommandMessage(JSONObject json) throws JSONException {
		this();
		this.httpCommand = new HttpCommand(json);
	}
	public HttpCommandMessage(HttpCommand httpCommand) {
		this();
		this.httpCommand = httpCommand;
	}
	public HttpCommandMessage(JSONMessage message) throws JSONException {
		super(message);
    }
    public JSONObject serialize() {
    	JSONObject object = super.serialize();
    	try {
			object.put("httpMethod", httpCommand.getHttpMethod());
	    	object.put("messageType",this.httpCommand.getMessageType());
	    	object.put("messageBody",this.httpCommand.getMessageBody());
	    	object.put("url",this.httpCommand.getUrl());
	    	object.put("id",httpCommand.getId());	    	
	    	object.put("description",this.httpCommand.getDescription());
	    	object.put("name",httpCommand.getName());	    	
	    	object.put("parentNodeId",httpCommand.getParentNodeId());
		} catch (JSONException e) {
			log.error("Exception occured: ",e);
		}
    	return object;
    }
}
