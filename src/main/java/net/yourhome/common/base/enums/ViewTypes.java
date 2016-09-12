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

public enum ViewTypes implements EnumConverter<String, ViewTypes> {
	CLOCK_DIGITAL("clock_digital"), CLOCK_ANALOG("clock_analog"), COLOR_PICKER("color_picker"), TEXT("text"), WEB_LINK("web_link"), WEB_STATIC_HTML("web_static_html"), WEB_RSS("web_rss"), HEATING("heating"), IMAGE_BUTTON("image_button"), MULTI_STATE_BUTTON("multi_state_button"), IMAGE("image"), SHAPE("shape"), LINE_GRAPH("line_graph"), PLUS_MIN_VALUE("plus_min_value"), SENSOR("sensor"), SENSOR_WITH_INDICATOR("sensor_with_indicator"), SLIDER("slider"), CAMERA("camera"), TRACK_DISPLAY("track_display"), PLAYLIST("playlist"), PLAYLISTS("playlists"), ALBUM_IMAGE("album_image"), TRACK_PROGRESS("track_progress");

	private final String value;

	ViewTypes(String value) {
		this.value = value;
	}

	/* Reverse enum methods */
	private static ReverseEnumMap<String, ViewTypes> map = new ReverseEnumMap<String, ViewTypes>(ViewTypes.class);

	@Override
	public String convert() {
		return this.value;
	}

	public static ViewTypes convert(String val) {
		return ViewTypes.map.get(val);
	}

}
