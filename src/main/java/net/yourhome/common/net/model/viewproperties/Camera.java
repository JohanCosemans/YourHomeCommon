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
package net.yourhome.common.net.model.viewproperties;

import net.yourhome.common.base.enums.PropertyTypes;
import net.yourhome.common.base.enums.ViewTypes;

public class Camera extends View {

	public static String LIVE_STREAM = "live_stream";
	public static String SHOW_REFRESH_BUTTON = "show_refresh_button";
	public static String REFRESH_DELAY_S = "refresh_delay_s";

	public Camera() {
		super(ViewTypes.CAMERA);
	}

	protected Camera(String id, ViewTypes viewType, String icon, String draggable, String title) {
		super(id, viewType, icon, draggable, title);
	}

	public Camera(String id, String icon, String draggable, String title) {
		this(id, ViewTypes.CAMERA, icon, draggable, title);
	}

	@Override
	public void addProperties() {
		this.properties.put(Camera.LIVE_STREAM, new Property(PropertyTypes.BOOLEAN, Camera.LIVE_STREAM, "Live Stream (instead of snapshot)", null));
		this.properties.put(Camera.REFRESH_DELAY_S, new Property(PropertyTypes.DOUBLE, Camera.REFRESH_DELAY_S, "Refresh Delay (seconds)", 600.0));
		this.properties.put(Camera.SHOW_REFRESH_BUTTON, new Property(PropertyTypes.BOOLEAN, Camera.SHOW_REFRESH_BUTTON, "Show Refresh icon", true));

	}

}
