package com.welle.settings;

public class FilesAndPaths {

	private String fileToRead = "res/moby10b.txt";

	public String returnFileToRead() {
		return fileToRead;
	}
	
	public void setFileToRead(String filePath) {
		fileToRead = filePath;
	}

}
