package com.welle.design.pattern.strategy;

public class RarCompresion implements CompressFile {

	@Override
	public void prepareFile() {
		System.out.println("Prepare compressing Rar ...");
	}

	@Override
	public void CompressFileAsap() {
		System.out.println("Compressing Rar ...");
	}

}
