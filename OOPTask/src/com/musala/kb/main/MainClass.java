package com.musala.kb.main;

import com.musala.kb.printer.logger.tester.Logger;
import com.musala.kb.printer.logger.tester.TestVehicles;
import com.musala.kb.vehicle.impl.Boat;
import com.musala.kb.vehicle.impl.Car;
import com.musala.kb.vehicle.impl.Motorcycle;
import com.musala.kb.vehicle.impl.Train;
import com.musala.kb.vehicle.impl.Truck;
import com.musala.kb.vehicle.impl.car.audi.Audi;

public class MainClass {

	public static void main(String[] args) {

		TestVehicles testVehicles = new TestVehicles();

		// prints to console
		
		testVehicles.setAndTestTruck(new Truck(), 6, "SCANIA", "v2000", 120);
		testVehicles.setAndTestMotorcycle(new Motorcycle(), 2, "YAMAHA", "ex500", 320);
		testVehicles.setAndTestCar(new Car(), 4, "YUGO", "55tka", 160);
		testVehicles.setAndTestTrain(new Train(), 0, "CHUCHU", "express", 250);
		testVehicles.setAndTestBoat(new Boat(), 0, "seaMaster", "BoatX", 100);
		testVehicles.setAndTestAudi(new Audi(), 4, "4", "p100", 280);

		// writes to file
		
		Logger log = new Logger();
		log.clearFile();
		log.writeDataToTextFile(testVehicles.getTruck());
		log.writeDataToTextFile(testVehicles.getMotorcycle());
		log.writeDataToTextFile(testVehicles.getCar());
		log.writeDataToTextFile(testVehicles.getTrain());
		log.writeDataToTextFile(testVehicles.getBoat());
		log.writeDataToTextFile(testVehicles.getAudi());

	}

}
