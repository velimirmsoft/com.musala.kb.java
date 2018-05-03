package com.musala.kb.vehicle.impl;

import com.musala.kb.vehicle.HasPassengers;
import com.musala.kb.vehicle.Vehicle;
import com.musala.kb.vehicle.type.railway.RailWayVehicle;

public class Train extends Vehicle implements RailWayVehicle, HasPassengers {

	private int passengers = 128;

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
	
	@Override
	public void underground() {
		System.out.println("Train is underground!");
	}

	public void move() {
		System.out.println("Train is moving!");
	}

	@Override
	public Boolean hasPassengers() {
		if (passengers != 0)
			return true;
		return false;
	}

	@Override
	public void setPassengers(int n) {
		this.passengers = n;	
	}

}
