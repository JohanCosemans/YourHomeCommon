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
package net.yourhome.common.net.messagestructures.zwave;

import java.math.BigInteger;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Element;

import net.yourhome.common.base.enums.zwave.ZWaveCommandClassTypes;

public class ZWaveValue {

	private ZWaveCommandClassTypes commandClass;
	private short nodeId;
	private BigInteger valueId;
	private long homeId;
	private short instance;

	public ZWaveValue() {

	}

	public ZWaveValue(Element commandElement) {
		try {
			this.setValueId(BigInteger.valueOf(Long.parseLong(commandElement.getAttribute("valueId"))));
		} catch (Exception e) {
		}
		try {
			this.setHomeId(Long.parseLong(commandElement.getAttribute("homeId")));
		} catch (Exception e) {
		}
		try {
			this.setInstance((short) Integer.parseInt(commandElement.getAttribute("instance")));
		} catch (Exception e) {
		}
		try {
			if (commandElement.getAttribute("nodeId").contains("x")) {
				this.setNodeId((short) Integer.parseInt(commandElement.getAttribute("nodeId")));
			} else {
				this.setNodeId((short) Integer.parseInt(commandElement.getAttribute("nodeId")));
			}
		} catch (Exception e) {
		}
	}

	public ZWaveValue(JSONObject jsonObject) throws JSONException {
		try {
			this.setValueId(BigInteger.valueOf(jsonObject.getLong("valueId")));
		} catch (Exception e) {
		}
		try {
			this.setHomeId(jsonObject.getLong("homeId"));
		} catch (Exception e) {
		}
		try {
			this.setInstance((short) jsonObject.getInt("instance"));
		} catch (Exception e) {
		}
		try {
			this.setNodeId((short) jsonObject.getInt("nodeId"));
		} catch (Exception e) {
		}
		try {
			this.commandClass = ZWaveCommandClassTypes.fromByte((byte) jsonObject.getInt("commandClass"));
		} catch (Exception e) {
		}
	}

	public ZWaveValue(short commandClass, short nodeId, BigInteger valueId, long homeId, short instance) {
		this.commandClass = ZWaveCommandClassTypes.fromByte((byte) commandClass);
		this.nodeId = nodeId;
		this.valueId = valueId;
		this.homeId = homeId;
		this.instance = instance;
	}

	// Expected format: ZV_V122437650_I1_N7_C49_H21827453
	public ZWaveValue(String controlId) {
		if (controlId != null) {
			String[] splittedString = controlId.split("_");
			this.valueId = BigInteger.valueOf(Long.parseLong(splittedString[1].substring(1)));
			this.instance = Short.parseShort(splittedString[2].substring(1));
			this.nodeId = Short.parseShort(splittedString[3].substring(1));
			this.commandClass = ZWaveCommandClassTypes.fromByte(Byte.valueOf(splittedString[4].substring(1)));
			this.homeId = Long.parseLong(splittedString[5].substring(1));
		}
	}

	public JSONObject toJSON() {
		JSONObject jsonRep = new JSONObject();
		try {
			jsonRep.put("commandClass", this.commandClass);
			jsonRep.put("nodeId", this.nodeId);
			jsonRep.put("valueId", this.valueId);
			jsonRep.put("homeId", this.homeId);
			jsonRep.put("instance", this.instance);

		} catch (JSONException e) {
			e.printStackTrace();
		}
		return jsonRep;
	}

	public String toControlId() {
		// Expected format: ZV_V122437650_I1_N7_C49_H21827453
		// System.out.println("ZV_V"+this.valueId+"_I"+this.instance+"_N"+this.nodeId+"_C"+this.commandClass.convert()+"_H"+this.homeId);
		return "ZV_V" + this.valueId + "_I" + this.instance + "_N" + this.nodeId + "_C" + this.commandClass.convert() + "_H" + this.homeId;
	}

	/**
	 * @return the commandClass
	 */
	public ZWaveCommandClassTypes getCommandClass() {
		return this.commandClass;
	}

	/**
	 * @param commandClass
	 *            the commandClass to set
	 */
	public void setCommandClass(ZWaveCommandClassTypes commandClass) {
		this.commandClass = commandClass;
	}

	/**
	 * @return the nodeId
	 */
	public short getNodeId() {
		return this.nodeId;
	}

	/**
	 * @param nodeId
	 *            the nodeId to set
	 */
	public void setNodeId(short nodeId) {
		this.nodeId = nodeId;
	}

	/**
	 * @return the valueId
	 */
	public BigInteger getValueId() {
		return this.valueId;
	}

	/**
	 * @param valueId
	 *            the valueId to set
	 */
	public void setValueId(BigInteger valueId) {
		this.valueId = valueId;
	}

	/**
	 * @return the homeId
	 */
	public long getHomeId() {
		return this.homeId;
	}

	/**
	 * @param homeId
	 *            the homeId to set
	 */
	public void setHomeId(long homeId) {
		this.homeId = homeId;
	}

	/**
	 * @return the instance
	 */
	public short getInstance() {
		return this.instance;
	}

	/**
	 * @param instance
	 *            the instance to set
	 */
	public void setInstance(short instance) {
		this.instance = instance;
	}

}
