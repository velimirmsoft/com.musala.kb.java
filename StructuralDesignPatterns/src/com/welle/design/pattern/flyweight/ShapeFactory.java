package com.welle.design.pattern.flyweight;

import java.util.HashMap;

public class ShapeFactory {

	// the idea is simple ->
	// when ever we need the object we just get it from our stored hashmap
	// instead of initing it again and wasting time 
	
	private static final HashMap<ShapeType, Shape> shapes = new HashMap<ShapeType, Shape>();

	public static Shape getShape(ShapeType type) {
		Shape shapeImpl = shapes.get(type);

		if (shapeImpl == null) {
			if (type.equals(ShapeType.OVAL_FILL)) {
				shapeImpl = new Oval(true);
			} else if (type.equals(ShapeType.OVAL_NOFILL)) {
				shapeImpl = new Oval(false);
			} else if (type.equals(ShapeType.LINE)) {
				shapeImpl = new Line();
			}
			shapes.put(type, shapeImpl);
		}
		return shapeImpl;
	}

	public static enum ShapeType {
		OVAL_FILL, OVAL_NOFILL, LINE;
	}

}
