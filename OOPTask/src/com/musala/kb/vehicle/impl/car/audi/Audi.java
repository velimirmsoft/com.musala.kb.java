package com.musala.kb.vehicle.impl.car.audi;

import com.musala.kb.vehicle.impl.Car;

public class Audi extends Car {

	private String year = "2010";

	@Override
	public int getWheels() {
		// TODO Auto-generated method stub
		return super.getWheels();
	}

	@Override
	public String getModel() {
		// TODO Auto-generated method stub
		return super.getModel();
	}

	@Override
	public String getEngineType() {
		// TODO Auto-generated method stub
		return super.getEngineType();
	}

	@Override
	public double getMaxSpeed() {
		// TODO Auto-generated method stub
		return super.getMaxSpeed();
	}

	@Override
	public void setWheels(int wheels) {
		// TODO Auto-generated method stub
		super.setWheels(wheels);
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		super.move();
	}
	
	public String getYear() {
		return year;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
	public void printYearOfTheAudi() {
		System.out.println("year = " + year);
	}
	
}
