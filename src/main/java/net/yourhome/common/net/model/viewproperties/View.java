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

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.yourhome.common.base.enums.ValueTypes;
import net.yourhome.common.base.enums.ViewTypes;

public abstract class View {
	protected String id;
	protected ViewTypes type;
	protected String icon;
	protected String draggable;
	protected String title;
	protected Map<String, Property> properties;
	private List<ValueTypes> allowed = new ArrayList<ValueTypes>();

	public View() {
		this.properties = new LinkedHashMap<String, Property>();
		this.addProperties();
	}

	public View(ViewTypes type) {
		this();
		this.type = type;
	}

	public View(String id, ViewTypes type, String icon, String draggable, String title) {
		this();
		this.type = type;
		this.icon = icon;
		this.draggable = draggable;
		this.title = title;
		this.id = id;

		/*
		 * byte[] bytesOfMessage; try { bytesOfMessage =
		 * (this.type+this.icon+this.draggable+this.title).getBytes("UTF-8");
		 * MessageDigest md = MessageDigest.getInstance("MD5"); id = new
		 * BigInteger(1,md.digest(bytesOfMessage)).toString(16); } catch
		 * (UnsupportedEncodingException e) { e.printStackTrace(); } catch
		 * (NoSuchAlgorithmException e) { e.printStackTrace(); }
		 */
	}

	public abstract void addProperties();

	/**
	 * @return the id
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the allowed
	 */
	public List<String> getAllowed() {
		List<String> allowedList = new ArrayList<String>();
		for (ValueTypes v : this.allowed) {
			allowedList.add(v.convert());
		}
		return allowedList;
	}

	public View addAllowed(ValueTypes[] valueTypes) {
		for (ValueTypes type : valueTypes) {
			this.allowed.add(type);
		}
		return this;
	}

	protected void setAttributeValue(String key, String value) {
		this.properties.get(key).setValue(value);
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return this.type.convert();
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = ViewTypes.convert(type);
	}

	/**
	 * @return the icon
	 */
	public String getIcon() {
		return this.icon;
	}

	/**
	 * @param icon
	 *            the icon to set
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

	/**
	 * @return the draggable
	 */
	public String getDraggable() {
		return this.draggable;
	}

	/**
	 * @param draggable
	 *            the draggable to set
	 */
	public void setDraggable(String draggable) {
		this.draggable = draggable;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the properties
	 */
	public Collection<Property> getProperties() {
		return this.properties.values();
	}

	/**
	 * @param properties
	 *            the properties to set
	 */
	public void setProperties(Collection<Property> properties) {
		for (Property p : properties) {
			this.properties.put(p.getKey(), p);
		}
	}

	public void setProperty(Property property) {
		this.properties.put(property.getKey(), property);
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(ViewTypes type) {
		this.type = type;
	}

}
