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
package net.yourhome.common.net.model.binding;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONException;
import org.json.JSONObject;

import net.yourhome.common.base.enums.ControllerTypes;

public class ControlIdentifiers {

	private ControllerTypes controllerIdentifier;
	private String nodeIdentifier;
	private String valueIdentifier;

	public ControlIdentifiers() {
	}

	public ControlIdentifiers(JSONObject json) throws JSONException {
		this.controllerIdentifier = ControllerTypes.convert(json.get("controllerIdentifier").toString());
		try {
			this.nodeIdentifier = json.get("nodeIdentifier").toString();
		} catch (JSONException e) {
		}
		try {
			this.valueIdentifier = json.get("valueIdentifier").toString();
		} catch (JSONException e) {
		}
	}

	public ControlIdentifiers(ResultSet result) throws SQLException {
		this.controllerIdentifier = ControllerTypes.convert(result.getString("controller_identifier"));
		try {
			this.nodeIdentifier = result.getString("node_identifier");
		} catch (SQLException e) {
		}
		try {
			this.valueIdentifier = result.getString("value_identifier");
		} catch (SQLException e) {
		}
	}

	public ControlIdentifiers(String controllerIdentifier) {
		this.controllerIdentifier = ControllerTypes.convert(controllerIdentifier);
	}

	public ControlIdentifiers(String controllerIdentifier, String nodeIdentifier, String valueIdentifier) {
		this(controllerIdentifier);
		this.nodeIdentifier = nodeIdentifier;
		this.valueIdentifier = valueIdentifier;
	}

	public ControlIdentifiers(ControllerTypes controllerIdentifier, String nodeIdentifier, String valueIdentifier) {
		this.controllerIdentifier = controllerIdentifier;
		this.nodeIdentifier = nodeIdentifier;
		this.valueIdentifier = valueIdentifier;
	}

	public String getKey() {
		return this.controllerIdentifier.convert() + "/" + this.nodeIdentifier + "/" + this.valueIdentifier;
	}

	@Override
	public String toString() {
		return this.getKey();
	}

	public JSONObject serialize() {
		JSONObject jsonObj = new JSONObject();
		try {
			jsonObj.put("controllerIdentifier", this.controllerIdentifier.convert());
			jsonObj.put("nodeIdentifier", this.nodeIdentifier);
			jsonObj.put("valueIdentifier", this.valueIdentifier);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonObj;
	}

	/**
	 * @return the controllerIdentifier
	 */
	public ControllerTypes getControllerIdentifier() {
		return this.controllerIdentifier;
	}

	/**
	 * @param controllerIdentifier
	 *            the controllerIdentifier to set
	 */
	public void setControllerIdentifier(ControllerTypes controllerIdentifier) {
		this.controllerIdentifier = controllerIdentifier;
	}

	/**
	 * @return the nodeIdentifier
	 */
	public String getNodeIdentifier() {
		return this.nodeIdentifier;
	}

	/**
	 * @param nodeIdentifier
	 *            the nodeIdentifier to set
	 */
	public void setNodeIdentifier(String nodeIdentifier) {
		this.nodeIdentifier = nodeIdentifier;
	}

	/**
	 * @return the valueIdentifier
	 */
	public String getValueIdentifier() {
		return this.valueIdentifier;
	}

	/**
	 * @param valueIdentifier
	 *            the valueIdentifier to set
	 */
	public void setValueIdentifier(String valueIdentifier) {
		this.valueIdentifier = valueIdentifier;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof ControlIdentifiers) {
			if (this.controllerIdentifier != null && this.controllerIdentifier.equals(((ControlIdentifiers) o).getControllerIdentifier()) && this.nodeIdentifier != null && this.nodeIdentifier.equals(((ControlIdentifiers) o).getNodeIdentifier()) && this.valueIdentifier != null && this.valueIdentifier.equals(((ControlIdentifiers) o).getValueIdentifier())) {
				return true;
			}
		}
		return false;
	}

}
