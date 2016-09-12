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

package net.yourhome.common.base.enums;

public enum ValueTypes implements EnumConverter<String, ValueTypes> {
	SENSOR_GENERAL("sensor_general"), SENSOR_TEMPERATURE("sensor_temperature"), SENSOR_BINARY("sensor_binary"), SENSOR_HUMIDITY("sensor_humidity"), SENSOR_MOTION("sensor_motion"), SENSOR_LUMINOSITY("sensor_luminosity"), SENSOR_ALARM("sensor_alarm"), SWITCH_BINARY("switch_binary"), DIMMER("dimmer"), COLOR_BULB("color_bulb"), HEATING("heating"), GENERAL_COMMAND("general_command"), METER("meter"), TEXT("text"),
	// WEB_LINK("web_link"),
	WEB_STATIC_HTML("web_static_html"),
	// WEB_RSS("web_rss"),
	IP_CAMERA("ip_camera"), RADIO_STATION("radio_station"), SCENE_ACTIVATION("scene_activation"), WAIT("wait"), SYSTEM_COMMAND("system_command"), SEND_NOTIFICATION("send_notification"), SOUND_NOTIFICATION("sound_notification"), HTTP_COMMAND("http_command"), MUSIC_PLAY_PAUSE("music_play_pause"), MUSIC_RANDOM("music_random"), MUSIC_ACTION("music_action"), MUSIC_PLAYLIST("music_playlist"), MUSIC_PLAYLISTS("music_playlists"), MUSIC_PROGRESS("music_progress"), MUSIC_ALBUM_IMAGE("music_album_image"), MUSIC_TRACK_DISPLAY("music_track_display"),

	/* Trigger types */
	EVENT("event"), TIME_PERIOD("period"),

	// ...
	UNKNOWN("unknown");

	private final String value;

	ValueTypes(String value) {
		this.value = value;
	}

	/* Reverse enum methods */
	private static ReverseEnumMap<String, ValueTypes> map = new ReverseEnumMap<String, ValueTypes>(ValueTypes.class);

	@Override
	public String convert() {
		return this.value;
	}

	public static ValueTypes convert(String val) {
		ValueTypes valueType = ValueTypes.map.get(val);
		return valueType == null ? UNKNOWN : valueType;
	}

	@Override
	public String toString() {
		return this.value;
	}

	public String getValue() {
		return this.value;
	}

}
