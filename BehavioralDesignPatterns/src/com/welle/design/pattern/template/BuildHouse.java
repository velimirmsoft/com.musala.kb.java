package com.welle.design.pattern.template;

// here we define abstract class on how our template - algorithm will follow

public abstract class BuildHouse {

	// final so subclasses can't override it - this is the template
	// and all shell FOLLOW to implement our algorithm
	public final void buildHouse() {
		buildFondation();
		buildPillars();
		buildWalls();
		buildRoof();
		buildIndoor();
		System.out.println("House is build.");
	}

	public void buildRoof() {
		System.out.println("Building roof.");
	}

	public void buildPillars() {
		System.out.println("Building pillars.");
	}

	// this is default method
	private void buildFondation() {
		System.out.println("Building foundation.");
	}

	// this ones will be implemented by our subclasses
	public abstract void buildWalls();

	public abstract void buildIndoor();

}
