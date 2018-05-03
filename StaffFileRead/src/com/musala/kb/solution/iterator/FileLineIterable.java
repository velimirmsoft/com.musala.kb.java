package com.musala.kb.solution.iterator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * The purpose of a <code>FileLineIterable</code> is to supply an iterator that
 * will return each line of a text file as a String. This can be used in
 * conjunction with the new (Java1.5) 'foreach' syntax.<BR>
 * Example:
 * 
 * <PRE>
 * for (String s : new FileLineIterable(filename))
 * 	System.out.println(s);
 * </PRE>
 *
 * @author Carey Brown
 */

public class FileLineIterable implements Iterable<String> {

	private File file;

	public FileLineIterable(String fileName) throws IOException {	
		
		this.file = new File(fileName);
		
		if (!file.exists())
			throw new FileNotFoundException("File does not exist: " + file.getPath());
		if (!file.isFile())
			throw new IOException("File is not of type 'file': " + file.getPath());
	}

	public FileLineIterator iterator() {
		try {
			return new FileLineIterator(file);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}