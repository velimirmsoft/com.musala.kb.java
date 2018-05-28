package com.welle.design.pattern.bridge;

public class TriangleShape extends Shape {

	public TriangleShape(Color c) {
		super(c);
	}

	@Override
	public void sayMyShapeAndColor() {
		System.out.println("Triangle.");
		color.applyColor();
	}

}