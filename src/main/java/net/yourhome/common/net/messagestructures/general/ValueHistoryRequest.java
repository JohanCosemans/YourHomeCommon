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
package net.yourhome.common.net.messagestructures.general;

import org.json.JSONException;
import org.json.JSONObject;

import net.yourhome.common.base.enums.MessageTypes;
import net.yourhome.common.base.enums.zwave.DataHistoryOperations;
import net.yourhome.common.base.enums.zwave.DataHistoryPeriodTypes;
import net.yourhome.common.net.messagestructures.JSONMessage;

public class ValueHistoryRequest extends JSONMessage {

	public int historyAmount = 10;
	public int offset = 0;
	public DataHistoryPeriodTypes periodType;
	public DataHistoryOperations operation;

	public ValueHistoryRequest() {
		super();
		this.type = MessageTypes.ValueHistoryRequest;
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

	@Override
	public JSONObject serialize() {
		JSONObject jsonObj = super.serialize();
		try {
			jsonObj.accumulate("historyAmount", this.historyAmount);
			jsonObj.accumulate("offset", this.offset);
			jsonObj.accumulate("periodType", this.periodType.convert());
			jsonObj.accumulate("operation", this.operation.convert());
		} catch (JSONException e) {
			JSONMessage.log.error("Exception occured: ", e);
		}

		return jsonObj;
	}
}
