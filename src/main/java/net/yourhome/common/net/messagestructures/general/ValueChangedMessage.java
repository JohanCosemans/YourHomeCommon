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
 * THIS SOFTWARE IS PROVIDED BY THE NETBSD FOUNDATION, INC. AND CONTRIBUTORS
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
		this.type = MessageTypes.ValueChanged;
	}

	public ValueChangedMessage(JSONObject json) throws JSONException {
		super(json);
		this.value = json.getString("value");
		try {
			this.unit = json.getString("unit");
		} catch (JSONException e) {
		}
		this.valueType = ValueTypes.convert(json.getString("valueType"));
	}

	public ValueChangedMessage(JSONMessage message) throws JSONException {
		super(message);
		this.type = MessageTypes.ValueChanged;
	}

	@Override
	public JSONObject serialize() {
		JSONObject jsonObj = super.serialize();
		try {
			jsonObj.accumulate("value", this.value);
			jsonObj.accumulate("unit", this.unit);
			if (this.valueType != null) {
				jsonObj.accumulate("valueType", this.valueType.convert());
			}
		} catch (JSONException e) {
			JSONMessage.log.error("Exception occured: ", e);
		}
		return jsonObj;
	}
}
