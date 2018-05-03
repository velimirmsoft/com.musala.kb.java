package com.musala.kb.vehicle.impl;

import com.musala.kb.vehicle.Vehicle;

public class Motorcycle extends Vehicle {

	@Override
	public int getWheels() {
		return super.getWheels();
	}

	@Override
	public String getModel() {
		return super.getModel();
	}

	@Override
	public String getEngineType() {
		return super.getEngineType();
	}

	@Override
	public double getMaxSpeed() {
		return super.getMaxSpeed();
	}

	@Override
	public void setWheels(int wheels) {
		super.setWheels(wheels);
	}
	
	public void move() {
		System.out.println("Motorcycle is moving!");
	}
	
}
