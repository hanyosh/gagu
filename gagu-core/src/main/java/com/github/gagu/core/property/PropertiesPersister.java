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

package com.github.gagu.core.property;

import java.io.*;
import java.util.Properties;

/**
 * Strategy interface for persisting {@code java.util.Properties},
 * allowing for pluggable parsing strategies.
 *
 * <p>The default implementation is DefaultPropertiesPersister,
 * providing the native parsing of {@code java.util.Properties},
 * but allowing for reading from any Reader and writing to any Writer
 * (which allows to specify an encoding for a properties file).
 *
 * <p>This interface also supports properties XML files,
 * through the {@code loadFromXml} and {@code storeToXml} methods.
 * The default implementations delegate to JDK 1.5's corresponding methods.
 *
 * Author: yong.han
 * Date: 14-7-31
 * Time: 下午11:23
 *
 * @author hanyosh
 */
public interface PropertiesPersister {
	/**
	 * Load properties from the given InputStream into the given
	 * Properties object.
	 * @param props the Properties object to load into
	 * @param is the InputStream to load from
	 * @throws java.io.IOException in case of I/O errors
	 * @see java.util.Properties#load
	 */
	void load(Properties props, InputStream is) throws IOException;

	/**
	 * Load properties from the given Reader into the given
	 * Properties object.
	 * @param props the Properties object to load into
	 * @param reader the Reader to load from
	 * @throws IOException in case of I/O errors
	 */
	void load(Properties props, Reader reader) throws IOException;


	/**
	 * Write the contents of the given Properties object to the
	 * given OutputStream.
	 * @param props the Properties object to store
	 * @param os the OutputStream to write to
	 * @param header the description of the property list
	 * @throws IOException in case of I/O errors
	 * @see java.util.Properties#store
	 */
	void store(Properties props, OutputStream os, String header) throws IOException;

	/**
	 * Write the contents of the given Properties object to the
	 * given Writer.
	 * @param props the Properties object to store
	 * @param writer the Writer to write to
	 * @param header the description of the property list
	 * @throws IOException in case of I/O errors
	 */
	void store(Properties props, Writer writer, String header) throws IOException;


	/**
	 * Load properties from the given XML InputStream into the
	 * given Properties object.
	 * @param props the Properties object to load into
	 * @param is the InputStream to load from
	 * @throws IOException in case of I/O errors
	 * @see java.util.Properties#loadFromXML(java.io.InputStream)
	 */
	void loadFromXml(Properties props, InputStream is) throws IOException;

	/**
	 * Write the contents of the given Properties object to the
	 * given XML OutputStream.
	 * @param props the Properties object to store
	 * @param os the OutputStream to write to
	 * @param header the description of the property list
	 * @throws IOException in case of I/O errors
	 * @see java.util.Properties#storeToXML(java.io.OutputStream, String)
	 */
	void storeToXml(Properties props, OutputStream os, String header) throws IOException;

	/**
	 * Write the contents of the given Properties object to the
	 * given XML OutputStream.
	 * @param props the Properties object to store
	 * @param os the OutputStream to write to
	 * @param encoding the encoding to use
	 * @param header the description of the property list
	 * @throws IOException in case of I/O errors
	 * @see java.util.Properties#storeToXML(java.io.OutputStream, String, String)
	 */
	void storeToXml(Properties props, OutputStream os, String header, String encoding) throws IOException;
}
