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
package net.yourhome.common.base.enums.zwave;

import net.yourhome.common.base.enums.EnumConverter;
import net.yourhome.common.base.enums.ReverseEnumMap;

public enum ZWaveCommandClassTypes implements EnumConverter<Byte, ZWaveCommandClassTypes> {
	Basic(
			(byte) 0x20
	), ControllerReplication(
			(byte) 0x21
	), ApplicationStatus(
			(byte) 0x22
	), SwitchBinary(
			(byte) 0x25
	), SwitchMultilevel(
			(byte) 0x26
	), SwitchAll(
			(byte) 0x27
	), SwitchToggleBinary(
			(byte) 0x28
	), SwitchToggleMultilevel(
			(byte) 0x29
	), SceneActivation(
			(byte) 0x2B
	), SceneActuatorConf(
			(byte) 0x2C
	), SensorAlarm(
			(byte) 0x9C
	), SensorBinary(
			(byte) 0x30
	), SensorMultiLevel(
			(byte) 0x31
	), Meter(
			(byte) 0x32
	), MeterPulse(
			(byte) 0x35
	), ThermostatMode(
			(byte) 0x40
	), ThermostatOperatingState(
			(byte) 0x42
	), ThermostatSetpoint(
			(byte) 0x43
	), ThermostatFanMode(
			(byte) 0x44
	), ThermostatFanState(
			(byte) 0x45
	), ClimateControlSchedule(
			(byte) 0x46
	), BasicWindowCovering(
			(byte) 0x50
	), MultiInstance(
			(byte) 0x60
	), Configuration(
			(byte) 0x70
	), Alarm(
			(byte) 0x71
	), ManufacturerSpecific(
			(byte) 0x72
	), PowerLevel(
			(byte) 0x73
	), Protection(
			(byte) 0x75
	), Lock(
			(byte) 0x76
	), NodeNaming(
			(byte) 0x77
	), Battery(
			(byte) 0x80
	), Clock(
			(byte) 0x81
	), Hail(
			(byte) 0x82
	), WakeUp(
			(byte) 0x84
	), Association(
			(byte) 0x85
	), Version(
			(byte) 0x86
	), Indicator(
			(byte) 0x87
	), Proprietary(
			(byte) 0x88
	), Language(
			(byte) 0x89
	), MultiInstanceAssociation(
			(byte) 0x8e
	), MultiCmd(
			(byte) 0x8F
	), EnergyProduction(
			(byte) 0x90
	), ManufacturerProprietary(
			(byte) 0x91
	), AssociationCommandConfiguration(
			(byte) 0x9b
	), Mark(
			(byte) 0xEF
	), Unknown(
			(byte) 0
	);

	private final byte value;

	ZWaveCommandClassTypes(byte value) {
		this.value = value;
	}

	/* Reverse enum methods */
	private static ReverseEnumMap<Byte, ZWaveCommandClassTypes> map = new ReverseEnumMap<Byte, ZWaveCommandClassTypes>(
			ZWaveCommandClassTypes.class);

	@Override
	public Byte convert() {
		return this.value;
	}

	public ZWaveCommandClassTypes convert(Byte val) {
		ZWaveCommandClassTypes returnValue = ZWaveCommandClassTypes.map.get(val);
		return returnValue == null ? ZWaveCommandClassTypes.Unknown : returnValue;
	}

	public static ZWaveCommandClassTypes fromByte(Byte val) {
		ZWaveCommandClassTypes returnValue = ZWaveCommandClassTypes.map.get(val);
		return returnValue == null ? ZWaveCommandClassTypes.Unknown : returnValue;
	}
}
