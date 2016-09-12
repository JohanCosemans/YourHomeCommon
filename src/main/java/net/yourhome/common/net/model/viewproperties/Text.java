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

import net.yourhome.common.base.enums.Alignments;
import net.yourhome.common.base.enums.PropertyTypes;
import net.yourhome.common.base.enums.ViewTypes;

public class Text extends View {

	public static String COLOR = "color";
	public static String SIZE = "size";
	public static String CONTENT = "content";
	public static String ALIGNMENT = "alignment";

	public Text() {
		super(ViewTypes.TEXT);
	}

	protected Text(String id, ViewTypes viewType, String icon, String draggable, String title) {
		super(id, viewType, icon, draggable, title);
	}

	public Text(String id, String icon, String draggable, String title, String color, Double size, String content, Alignments alignment) {
		this(id, ViewTypes.TEXT, icon, draggable, title);
		this.setAttributeValue(Text.CONTENT, content);
		this.setAttributeValue(Text.SIZE, size + "");
		this.setAttributeValue(Text.ALIGNMENT, alignment.convert());
		this.setAttributeValue(Text.COLOR, color);
	}

	@Override
	public void addProperties() {

		this.properties.put(Text.CONTENT, new Property(PropertyTypes.STRING, Text.CONTENT, "Content", null));
		this.properties.put(Text.SIZE, new Property(PropertyTypes.DOUBLE, Text.SIZE, "Size", null));
		this.properties.put(Text.ALIGNMENT, new Property(PropertyTypes.ALIGNMENT, Text.ALIGNMENT, "Alignment", null));
		this.properties.put(Text.COLOR, new Property(PropertyTypes.COLOR, Text.COLOR, "Color", null));

	}
}
