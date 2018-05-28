package com.welle.design.pattern.bridge;

public class GreenColor implements Color {

	@Override
	public void applyColor() {
		System.out.println("Green!");
	}

}
