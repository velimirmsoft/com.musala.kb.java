package com.welle.design.pattern.strategy;

public class CompressStrategy {

	private CompressFile cFile;

	public void setStrategyForCompressing(CompressFile strategy) {
		this.cFile = strategy;
	}

	public CompressFile getStrategy() {
		return cFile;
	}

}
