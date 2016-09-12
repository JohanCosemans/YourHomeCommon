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
		this.offset = jsonObject.getInt("offset");
		try {
			this.title = jsonObject.getString("title");
		} catch (JSONException e) {
		}

		// Parse values
		JSONObject valueObject = jsonObject.getJSONObject("Values");

		// Parse time
		JSONArray timeArray = valueObject.getJSONArray("time");
		for (int i = 0; i < timeArray.length(); i++) {
			this.sensorValues.time.add(timeArray.getInt(i));
		}

		// Parse value
		JSONArray valueArray = valueObject.getJSONArray("value");
		for (int i = 0; i < valueArray.length(); i++) {
			this.sensorValues.value.add(valueArray.getDouble(i));
		}

		try {
			this.sensorValues.valueUnit = valueObject.getString("valueUnit");
		} catch (JSONException e) {
		}

	}

	@Override
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
			object.put("offset", this.offset);
		} catch (JSONException e) {
			// log.error("Exception occured: ",e);
		}

		return object;
	}

}
