/*
 * Copyright 2014-2024 hanyosh
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.gagu.core.exception;

import java.io.IOException;

/**
 * Subclass of {@link java.io.IOException} that properly handles a root cause,
 * exposing the root cause just like NestedChecked/RuntimeException does.
 *
 * <p>Proper root cause handling has not been added to standard IOException before
 * Java 6, which is why we need to do it ourselves for Java 5 compatibility purposes.
 *
 * <p>The similarity between this class and the NestedChecked/RuntimeException
 * class is unavoidable, as this class needs to derive from IOException.
 *
 * Author: yong.han
 * Date: 14-7-30
 * Time: 下午11:24
 *
 * @author hanyosh
 */
@SuppressWarnings("serial")
public class GaguIOException extends IOException {
	static {
		// Eagerly load the GaguExceptionUtils class to avoid classloader deadlock
		// issues on OSGi when calling getMessage().
		GaguExceptionUtils.class.getName();
	}


	/**
	 * Construct a {@code NestedIOException} with the specified detail message.
	 * @param msg the detail message
	 */
	public GaguIOException(String msg) {
		super(msg);
	}

	/**
	 * Construct a {@code NestedIOException} with the specified detail message
	 * and nested exception.
	 * @param msg the detail message
	 * @param cause the nested exception
	 */
	public GaguIOException(String msg, Throwable cause) {
		super(msg, cause);
	}


	/**
	 * Return the detail message, including the message from the nested exception
	 * if there is one.
	 */
	@Override
	public String getMessage() {
		return GaguExceptionUtils.buildMessage(super.getMessage(), getCause());
	}

}

























