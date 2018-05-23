package com.welle.design.pattern.singleton;

// here we get the single instance of our class

public class GodSingletonInstance {

	private static GodSingletonInstance god = null;

	private GodSingletonInstance() {
		System.out.println("I am your god and saviour!");
	}

	public static GodSingletonInstance getSingleGodInstance() {
		if (god == null) {
			god = new GodSingletonInstance();
		}
		return god;
	}

	public void saveHumans() {
		System.out.println("You are saved!");
	}

}
