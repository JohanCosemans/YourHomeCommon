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
package net.yourhome.common.net.model.viewproperties;

import net.yourhome.common.base.enums.PropertyTypes;
import net.yourhome.common.base.enums.ViewTypes;

public class SensorWithIndicator extends Sensor {
	public static String UP_IMAGE = "upImageSrc";
	public static String NEUTRAL_IMAGE = "neutralImageSrc";
	public static String DOWN_IMAGE = "downImageSrc";
	public static String COLOR = "color";
	public static String SIZE = "size";

	// Sensor
	public SensorWithIndicator() {
		super(ViewTypes.SENSOR_WITH_INDICATOR);
	}

	public SensorWithIndicator(String id, String icon, String draggable, String title, String upImageSrc, String neutralImageSrc, String downImageSrc, String color, Double size) {
		super(id, icon, draggable, title, color, size);

		this.setAttributeValue(SensorWithIndicator.UP_IMAGE, upImageSrc);
		this.setAttributeValue(SensorWithIndicator.NEUTRAL_IMAGE, neutralImageSrc);
		this.setAttributeValue(SensorWithIndicator.DOWN_IMAGE, downImageSrc);
	}

	@Override
	public void addProperties() {
		super.addProperties();
		this.properties.put(SensorWithIndicator.UP_IMAGE, new Property(PropertyTypes.IMAGE, SensorWithIndicator.UP_IMAGE, "Up image", null));
		this.properties.put(SensorWithIndicator.NEUTRAL_IMAGE, new Property(PropertyTypes.IMAGE, SensorWithIndicator.NEUTRAL_IMAGE, "Neutral image", null));
		this.properties.put(SensorWithIndicator.DOWN_IMAGE, new Property(PropertyTypes.IMAGE, SensorWithIndicator.DOWN_IMAGE, "Down image", null));
	}
}
