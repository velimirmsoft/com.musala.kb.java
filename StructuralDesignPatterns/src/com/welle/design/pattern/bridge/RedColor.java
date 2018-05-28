package com.welle.design.pattern.bridge;

public class RedColor implements Color {

	@Override
	public void applyColor() {
		System.out.println("Red!");
	}

}
