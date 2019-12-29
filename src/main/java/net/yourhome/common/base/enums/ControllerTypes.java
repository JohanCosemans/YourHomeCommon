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
package net.yourhome.common.base.enums;

public enum ControllerTypes implements EnumConverter<String, ControllerTypes> {
	SPOTIFY("spotify"), ZWAVE("zwave"), RADIO("radio"), HTTP("http"), GENERAL("general"), IPCAMERA("ipcamera"), THERMOSTAT("thermostat"), PHILIPS_HUE("philips_hue"), UNKNOWN("unknown"), DEMO("demo"),IKEA("IKEA");

	private final String value;

	ControllerTypes(String value) {
		this.value = value;
	}

	/* Reverse enum methods */
	private static ReverseEnumMap<String, ControllerTypes> map = new ReverseEnumMap<String, ControllerTypes>(ControllerTypes.class);

	@Override
	public String convert() {
		return this.value;
	}

	public static ControllerTypes convert(String val) {
		return ControllerTypes.map.get(val);
	}

	public String getValue() {
		return this.value;
	}

}
