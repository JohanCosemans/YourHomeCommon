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

public class LineGraph extends View {

	public static String GRAPH_TITLE = "graphTitle";
	public static String MAXIMUM = "maximum";
	public static String MINIMUM = "minimum";

	public LineGraph() {
		super(ViewTypes.LINE_GRAPH);
	}

	protected LineGraph(String id, ViewTypes viewType, String icon, String draggable, String title) {
		super(id, viewType, icon, draggable, title);
	}

	public LineGraph(String id, String icon, String draggable, String title, String graphTitle, Double maximum, Double minimum) {
		this(id, ViewTypes.LINE_GRAPH, icon, draggable, title);

		this.setAttributeValue(LineGraph.GRAPH_TITLE, graphTitle);
		this.setAttributeValue(LineGraph.MAXIMUM, maximum + "");
		this.setAttributeValue(LineGraph.MINIMUM, minimum + "");
	}

	@Override
	public void addProperties() {

		this.properties.put(LineGraph.GRAPH_TITLE, new Property(PropertyTypes.STRING, LineGraph.GRAPH_TITLE, "Title", null));
		this.properties.put(LineGraph.MAXIMUM, new Property(PropertyTypes.DOUBLE, LineGraph.MAXIMUM, "Maximum", null));
		this.properties.put(LineGraph.MINIMUM, new Property(PropertyTypes.DOUBLE, LineGraph.MINIMUM, "Minimum", null));

	}

}
