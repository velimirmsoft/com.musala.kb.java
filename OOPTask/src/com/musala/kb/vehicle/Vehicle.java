package com.musala.kb.vehicle;

public abstract class Vehicle {

	private int wheels = -1;
	private String model = "-";
	private String engineType = "-";
	private double maxSpeed = 0.0;
	
	public int getWheels() {
		return wheels;
	};
	
	public String getModel() {
		return model;
	}
	
	public String getEngineType() {
		return engineType;
	}
	
	public double getMaxSpeed() {
		return maxSpeed;
	}
	
	public void setWheels(int wheels) {
		this.wheels = wheels;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}
	
	public void setMaxSpeed(double maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
}
