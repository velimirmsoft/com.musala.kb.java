package com.welle.design.pattern.composite;

import java.util.ArrayList;

public class Drawing implements Shape {

	private ArrayList<Shape> shapes = new ArrayList<Shape>();

	@Override
	public void draw(String color) {
		for (Shape s : shapes) {
			s.draw(color);
		}
	}

	public void addShape(Shape s) {
		shapes.add(s);
	}

	public void removeShape(Shape s) {
		shapes.remove(s);
	}

}
