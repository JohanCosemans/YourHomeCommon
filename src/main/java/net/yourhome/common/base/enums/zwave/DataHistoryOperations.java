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

public enum DataHistoryOperations implements EnumConverter<Integer, DataHistoryOperations> {
	NO_OPERATION(0), DELTA(1), AVERAGE(2), MIN(3), MAX(4);

	private final Integer value;

	DataHistoryOperations(int value) {
		this.value = value;
	}

	/* Reverse enum methods */
	private static ReverseEnumMap<Integer, DataHistoryOperations> map = new ReverseEnumMap<Integer, DataHistoryOperations>(DataHistoryOperations.class);

	@Override
	public Integer convert() {
		return this.value;
	}

	public DataHistoryOperations convert(Integer val) {
		return DataHistoryOperations.map.get(val);
	}

	public static DataHistoryOperations fromInt(Integer val) {
		return DataHistoryOperations.map.get(val);
	}
}
