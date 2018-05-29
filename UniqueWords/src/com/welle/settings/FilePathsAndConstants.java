package com.welle.settings;

public class FilePathsAndConstants {

	public static enum OrderType {
		ASC, DESC
	}

	public static enum WhichImplementation {
		LIST, MAP
	}

	private String fileToRead = "res/moby10b.txt";

	public String returnFileToRead() {
		return fileToRead;
	}

	public void setFileToRead(String filePath) {
		fileToRead = filePath;
	}

}
