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

public class PlusMinValue extends View {
	public static String STEP = "step";
	public static String COLOR = "color";
	public static String SIZE = "size";

	public PlusMinValue() {
		super(ViewTypes.PLUS_MIN_VALUE);
	}

	protected PlusMinValue(String id, ViewTypes viewType, String icon, String draggable, String title) {
		super(id, viewType, icon, draggable, title);
	}

	public PlusMinValue(String id, String icon, String draggable, String title) {
		this(id, ViewTypes.PLUS_MIN_VALUE, icon, draggable, title);
	}

	public PlusMinValue(String id, String icon, String draggable, String title, Double step, String color, int size) {
		this(id, ViewTypes.PLUS_MIN_VALUE, icon, draggable, title);
		this.setAttributeValue(PlusMinValue.STEP, step + "");
		this.setAttributeValue(PlusMinValue.COLOR, color);
		this.setAttributeValue(PlusMinValue.SIZE, size + "");
	}

	@Override
	public void addProperties() {
		this.properties.put(PlusMinValue.STEP, new Property(PropertyTypes.DOUBLE, PlusMinValue.STEP, "Step increase/decrease", null));
		this.properties.put(PlusMinValue.COLOR, new Property(PropertyTypes.COLOR, PlusMinValue.COLOR, "Color", null));
		this.properties.put(PlusMinValue.SIZE, new Property(PropertyTypes.DOUBLE, PlusMinValue.SIZE, "Size", null));
	}
}
