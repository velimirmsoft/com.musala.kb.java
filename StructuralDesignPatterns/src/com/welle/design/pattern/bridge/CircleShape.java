package com.welle.design.pattern.bridge;

public class CircleShape extends Shape {

	public CircleShape(Color c) {
		super(c);
	}

	@Override
	public void sayMyShapeAndColor() {
		System.out.println("Circle.");
		color.applyColor();
	}

}
