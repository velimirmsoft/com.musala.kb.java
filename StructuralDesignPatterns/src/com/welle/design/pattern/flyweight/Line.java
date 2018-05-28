package com.welle.design.pattern.flyweight;

import java.awt.Color;
import java.awt.Graphics;

public class Line implements Shape {

	// Notice that I have intensionally introduced delay in creating the Object of
	// concrete classes to make the point that flyweight pattern can be used for
	// Objects that takes a lot of time while instantiated.

	public Line() {
		System.out.println("Creating Line object");
		// adding time delay
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void draw(Graphics line, int x1, int y1, int x2, int y2, Color color) {
		line.setColor(color);
		line.drawLine(x1, y1, x2, y2);
	}

}