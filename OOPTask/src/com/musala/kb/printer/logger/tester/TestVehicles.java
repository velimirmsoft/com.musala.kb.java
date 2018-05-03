package com.musala.kb.printer.logger.tester;

import static com.musala.kb.printer.logger.tester.Print.*;

import com.musala.kb.vehicle.Vehicle;
import com.musala.kb.vehicle.impl.Boat;
import com.musala.kb.vehicle.impl.Car;
import com.musala.kb.vehicle.impl.Motorcycle;
import com.musala.kb.vehicle.impl.Train;
import com.musala.kb.vehicle.impl.Truck;
import com.musala.kb.vehicle.impl.car.audi.Audi;

public class TestVehicles {

	private Truck truck;
	private Motorcycle motorcycle;
	private Car car;
	private Train train;
	private Boat boat;
	private Audi audi;

	public TestVehicles() {

	}

	public String setAndTestTruck(Vehicle v, int wheels, String model, String engineType, double maxSpeed) {

		this.truck = (Truck) v;
		truck.setWheels(wheels);
		truck.setEngineType(engineType);
		truck.setMaxSpeed(maxSpeed);
		truck.setModel(model);

		System.out.println("printVehicleData ...");

		mPrint(truck.getWheels());
		mPrint(truck.getEngineType());
		mPrint(truck.getMaxSpeed());
		mPrint(truck.getModel());

		truck.move();

		System.out.println("-----------------------------------------");
		
		return getAllPrintedText();

	}
	
	public Truck getTruck() {
		return truck;
	}

	public String setAndTestMotorcycle(Vehicle v, int wheels, String model, String engineType, double maxSpeed) {

		this.motorcycle = (Motorcycle) v;
		motorcycle.setWheels(wheels);
		motorcycle.setEngineType(engineType);
		motorcycle.setMaxSpeed(maxSpeed);
		motorcycle.setModel(model);

		System.out.println("printVehicleData ...");

		mPrint(motorcycle.getWheels());
		mPrint(motorcycle.getEngineType());
		mPrint(motorcycle.getMaxSpeed());
		mPrint(motorcycle.getModel());

		motorcycle.move();

		System.out.println("-----------------------------------------");
		
		return getAllPrintedText();

	}
	
	public Motorcycle getMotorcycle() {
		return motorcycle;
	}
	
	public String setAndTestCar(Vehicle v, int wheels, String model, String engineType, double maxSpeed) {

		this.car = (Car) v;
		car.setWheels(wheels);
		car.setEngineType(engineType);
		car.setMaxSpeed(maxSpeed);
		car.setModel(model);

		System.out.println("printVehicleData ...");

		mPrint(car.getWheels());
		mPrint(car.getEngineType());
		mPrint(car.getMaxSpeed());
		mPrint(car.getModel());

		car.move();

		System.out.println("-----------------------------------------");

		return getAllPrintedText();
		
	}
	
	public Car getCar() {
		return car;
	}
	
	public String setAndTestTrain(Vehicle v, int wheels, String model, String engineType, double maxSpeed) {

		this.train = (Train) v;
		train.setWheels(wheels);
		train.setEngineType(engineType);
		train.setMaxSpeed(maxSpeed);
		train.setModel(model);

		System.out.println("printVehicleData ...");

		mPrint(train.getWheels());
		mPrint(train.getEngineType());
		mPrint(train.getMaxSpeed());
		mPrint(train.getModel());

		train.setPassengers(150);
		train.hasPassengers();
		train.move();
		train.underground();

		System.out.println("-----------------------------------------");

		return getAllPrintedText();
		
	}
	
	public Train getTrain() {
		return train;
	}
	
	public String setAndTestBoat(Vehicle v, int wheels, String model, String engineType, double maxSpeed) {

		this.boat = (Boat) v;
		boat.setWheels(wheels);
		boat.setEngineType(engineType);
		boat.setMaxSpeed(maxSpeed);
		boat.setModel(model);

		System.out.println("printVehicleData ...");

		mPrint(boat.getWheels());
		mPrint(boat.getEngineType());
		mPrint(boat.getMaxSpeed());
		mPrint(boat.getModel());

		boat.setPassengers(6);
		boat.hasPassengers();
		boat.move();
		boat.floating();

		System.out.println("-----------------------------------------");
		
		return getAllPrintedText();

	}
	
	public Boat getBoat() {
		return boat;
	}
	
	public String setAndTestAudi(Vehicle v, int wheels, String model, String engineType, double maxSpeed) {

		this.audi = (Audi) v;
		audi.setWheels(wheels);
		audi.setEngineType(engineType);
		audi.setMaxSpeed(maxSpeed);
		audi.setModel(model);

		System.out.println("printVehicleData ...");

		mPrint(audi.getWheels());
		mPrint(audi.getEngineType());
		mPrint(audi.getMaxSpeed());
		mPrint(audi.getModel());

		audi.printYearOfTheAudi();
		audi.move();

		System.out.println("-----------------------------------------");
		
		return getAllPrintedText();

	}
	
	public Audi getAudi() {
		return audi;
	}

}
