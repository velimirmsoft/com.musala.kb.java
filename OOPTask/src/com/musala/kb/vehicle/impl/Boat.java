package com.musala.kb.vehicle.impl;

import com.musala.kb.vehicle.HasPassengers;
import com.musala.kb.vehicle.Vehicle;
import com.musala.kb.vehicle.type.water.WaterVehicle;

public class Boat extends Vehicle implements WaterVehicle, HasPassengers {
	
	private int passengers = 8;
	
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
		System.out.println("Boat is moving!");
	}

	@Override
	public void floating() {
		System.out.println("Boat is floating!");
	}

	@Override
	public Boolean hasPassengers() {
		if(passengers != 0)
			return true;
		return false;
	}
	
	@Override
	public void setPassengers(int n) {
		this.passengers = n;	
	}
	
	
}
