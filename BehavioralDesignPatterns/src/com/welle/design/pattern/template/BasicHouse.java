package com.welle.design.pattern.template;

public class BasicHouse extends BuildHouse {
	
	public BasicHouse() {
		super();
	}

	@Override
	public void buildWalls() {
		System.out.println("Building walls - basic house!");
	}

	@Override
	public void buildIndoor() {
		System.out.println("Building indoor - basic house!");	
	}

}
