package net.yourhome.common.base.enums.zwave;

import net.yourhome.common.base.enums.EnumConverter;
import net.yourhome.common.base.enums.ReverseEnumMap;

public enum ZWaveCommandClassTypes  implements EnumConverter<Byte,ZWaveCommandClassTypes> {
    Basic((byte)0x20),
    ControllerReplication((byte)0x21),
    ApplicationStatus((byte)0x22),
    SwitchBinary((byte)0x25),
    SwitchMultilevel((byte)0x26),
    SwitchAll((byte)0x27),
    SwitchToggleBinary((byte)0x28),
    SwitchToggleMultilevel((byte)0x29),
    SceneActivation((byte)0x2B),
    SceneActuatorConf((byte)0x2C),
    SensorAlarm((byte)0x9C),
    SensorBinary((byte)0x30),
    SensorMultiLevel((byte)0x31),
    Meter((byte)0x32),
    MeterPulse((byte)0x35),
    ThermostatMode((byte)0x40),
    ThermostatOperatingState((byte)0x42),
    ThermostatSetpoint((byte)0x43),
    ThermostatFanMode((byte)0x44),
    ThermostatFanState((byte)0x45),
    ClimateControlSchedule((byte)0x46),
    BasicWindowCovering((byte)0x50),
    MultiInstance((byte)0x60),
    Configuration((byte)0x70),
    Alarm((byte)0x71),
    ManufacturerSpecific((byte)0x72),
    PowerLevel((byte)0x73),
    Protection((byte)0x75),
    Lock((byte)0x76),
    NodeNaming((byte)0x77),
    Battery((byte)0x80),
    Clock((byte)0x81),
    Hail((byte)0x82),
    WakeUp((byte)0x84),
    Association((byte)0x85),
    Version((byte)0x86),
    Indicator((byte)0x87),
    Proprietary((byte)0x88),
    Language((byte)0x89),
    MultiInstanceAssociation((byte)0x8e),
    MultiCmd((byte)0x8F),
    EnergyProduction((byte)0x90),
    ManufacturerProprietary((byte)0x91),
    AssociationCommandConfiguration((byte)0x9b),
    Mark((byte)0xEF),
    Unknown((byte)0);
    
    private final byte value;
    
    ZWaveCommandClassTypes(byte value) {
        this.value = (byte) value;
    }
    
	
	/* Reverse enum methods */
	private static ReverseEnumMap<Byte,ZWaveCommandClassTypes> map = new ReverseEnumMap<Byte,ZWaveCommandClassTypes>(ZWaveCommandClassTypes.class);
	

	public Byte convert() {
		return value;
	}
	
	public ZWaveCommandClassTypes convert(Byte val) {
		ZWaveCommandClassTypes returnValue = map.get(val);
		return returnValue==null?ZWaveCommandClassTypes.Unknown:returnValue;
	}

	public static ZWaveCommandClassTypes fromByte(Byte val) {
		ZWaveCommandClassTypes returnValue = map.get(val);
		return returnValue==null?ZWaveCommandClassTypes.Unknown:returnValue;
	}	
}
