/**
 * ESUP-Portail Helpdesk - Copyright (c) 2004-2008 ESUP-Portail consortium.
 */
package org.esupportail.commons.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.esupportail.commons.exceptions.ConfigException;


/**
 * Utilities for files.
 */
public class FileUtils {
	
	/**
	 * The size of the buffer used to read files.
	 */
	private static final int BUFFER_SIZE = 512;
	
	/**
	 * Constructor.
	 */
	private FileUtils() {
		throw new UnsupportedOperationException();
	}
	
    /**
     * @param path
     * @return the content of a file.
     * @throws ConfigException 
     */
    public static byte[] getFileContent(
    		final String path) throws ConfigException {
		try {
			InputStream is = FileUtils.class.getResourceAsStream(path); 
			if (is == null) {
				throw new ConfigException("could not read [" + path + "]");
			}
			ByteArrayOutputStream os = new ByteArrayOutputStream(2 * BUFFER_SIZE);
			byte[] buf = new byte[BUFFER_SIZE];
			int readBytes;
			while ((readBytes = is.read(buf)) > 0) {
			    os.write(buf, 0, readBytes);
			}
			byte[] result = os.toByteArray();
			is.close();
			os.close();
			return result;
		} catch (IOException e) {
			throw new ConfigException(e);
		}
    }

}
