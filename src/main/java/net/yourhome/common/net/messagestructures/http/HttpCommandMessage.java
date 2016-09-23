/*-
 * Copyright (c) 2016 Coteq, Johan Cosemans
 * All rights reserved.
 *
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY COTEQ AND CONTRIBUTORS
 * ``AS IS'' AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE FOUNDATION OR CONTRIBUTORS
 * BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package net.yourhome.common.net.messagestructures.http;

import org.json.JSONException;
import org.json.JSONObject;

import net.yourhome.common.base.enums.ControllerTypes;
import net.yourhome.common.base.enums.MessageTypes;
import net.yourhome.common.net.messagestructures.JSONMessage;
import net.yourhome.common.net.messagestructures.general.ProtectedJSONMessage;

public class HttpCommandMessage extends ProtectedJSONMessage {
	/*
	 * public String httpMethod; //get,post,delete,put public String
	 * messageType; //e.g. application/json public String messageBody; // e.g. {
	 * "command" : "value" } public String url; // e.g. www.google.be public
	 * String commandName; // e.g. XBMC Title public String commandDescription;
	 * // e.g. XBMC Title public int id; public int parentNodeId;
	 */
	public HttpCommand httpCommand;
	public String response;

	public HttpCommandMessage() {
		this.controlIdentifiers.setControllerIdentifier(ControllerTypes.HTTP); // HTTP
																				// command
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

	@Override
	public JSONObject serialize() {
		JSONObject object = super.serialize();
		try {
			object.put("httpMethod", this.httpCommand.getHttpMethod());
			object.put("messageType", this.httpCommand.getMessageType());
			object.put("messageBody", this.httpCommand.getMessageBody());
			object.put("url", this.httpCommand.getUrl());
			object.put("id", this.httpCommand.getId());
			object.put("description", this.httpCommand.getDescription());
			object.put("name", this.httpCommand.getName());
			object.put("parentNodeId", this.httpCommand.getParentNodeId());
		} catch (JSONException e) {
			JSONMessage.log.error("Exception occured: ", e);
		}
		return object;
	}
}
