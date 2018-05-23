package com.welle.design.pattern.strategy;

public class ZipCompresion implements CompressFile {

	@Override
	public void prepareFile() {
		System.out.println("Prepare compressing Zip ...");
	}

	@Override
	public void CompressFileAsap() {
		System.out.println("Compressing Zip ...");
	}

}
