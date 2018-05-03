package com.musala.kb.oop.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.musala.kb.printer.logger.tester.Logger;
import com.musala.kb.printer.logger.tester.TestVehicles;
import com.musala.kb.vehicle.impl.Boat;
import com.musala.kb.vehicle.impl.Car;
import com.musala.kb.vehicle.impl.Motorcycle;
import com.musala.kb.vehicle.impl.Train;
import com.musala.kb.vehicle.impl.Truck;
import com.musala.kb.vehicle.impl.car.audi.Audi;

class OopTaskTest {

	private static final String OUTPUT_FILE = "res/output.txt";

	@Test
	public void testOopTask() {

		TestVehicles testVehicles = new TestVehicles();

		// init objects and wait for inited object respones ...

		Assert.assertEquals(" 6 v2000 120.0 SCANIA",
				testVehicles.setAndTestTruck(new Truck(), 6, "SCANIA", "v2000", 120));
		Assert.assertEquals(" 2 ex500 320.0 YAMAHA",
				testVehicles.setAndTestMotorcycle(new Motorcycle(), 2, "YAMAHA", "ex500", 320));
		Assert.assertEquals(" 4 55tka 160.0 YUGO", testVehicles.setAndTestCar(new Car(), 4, "YUGO", "55tka", 160));
		Assert.assertEquals(" 0 express 250.0 CHUCHU",
				testVehicles.setAndTestTrain(new Train(), 0, "CHUCHU", "express", 250));
		Assert.assertEquals(" 0 BoatX 100.0 seaMaster",
				testVehicles.setAndTestBoat(new Boat(), 0, "seaMaster", "BoatX", 100));
		Assert.assertEquals(" 4 p100 280.0 a4", testVehicles.setAndTestAudi(new Audi(), 4, "a4", "p100", 280));

	}

	@Test
	public void testOutputLoggerFile() {

		TestVehicles testVehicles = new TestVehicles();

		testVehicles.setAndTestTruck(new Truck(), 6, "SCANIA", "v2000", 120);
		testVehicles.setAndTestMotorcycle(new Motorcycle(), 2, "YAMAHA", "ex500", 320);
		testVehicles.setAndTestCar(new Car(), 4, "YUGO", "55tka", 160);
		testVehicles.setAndTestTrain(new Train(), 0, "CHUCHU", "express", 250);
		testVehicles.setAndTestBoat(new Boat(), 0, "seaMaster", "BoatX", 100);
		testVehicles.setAndTestAudi(new Audi(), 4, "4", "p100", 280);

		Logger log = new Logger();
		log.clearFile();
		log.writeDataToTextFile(testVehicles.getTruck());
		log.writeDataToTextFile(testVehicles.getMotorcycle());
		log.writeDataToTextFile(testVehicles.getCar());
		log.writeDataToTextFile(testVehicles.getTrain());
		log.writeDataToTextFile(testVehicles.getBoat());
		log.writeDataToTextFile(testVehicles.getAudi());

		String expectedOutput = "Truck\r\n" + 
				"v2000\r\n" + 
				"120.0\r\n" + 
				"SCANIA\r\n" + 
				"6\r\n" + 
				"-------------------------------------------\r\n" + 
				"Motorcycle\r\n" + 
				"ex500\r\n" + 
				"320.0\r\n" + 
				"YAMAHA\r\n" + 
				"2\r\n" + 
				"-------------------------------------------\r\n" + 
				"Car\r\n" + 
				"55tka\r\n" + 
				"160.0\r\n" + 
				"YUGO\r\n" + 
				"4\r\n" + 
				"-------------------------------------------\r\n" + 
				"Train\r\n" + 
				"express\r\n" + 
				"250.0\r\n" + 
				"CHUCHU\r\n" + 
				"0\r\n" + 
				"true\r\n" + 
				"-------------------------------------------\r\n" + 
				"Boat\r\n" + 
				"BoatX\r\n" + 
				"100.0\r\n" + 
				"seaMaster\r\n" + 
				"0\r\n" + 
				"true\r\n" + 
				"-------------------------------------------\r\n" + 
				"Audi\r\n" + 
				"p100\r\n" + 
				"280.0\r\n" + 
				"4\r\n" + 
				"4\r\n" + 
				"2010\r\n" + 
				"-------------------------------------------\r\n" + 
				"";

		String output = "";

		try (BufferedReader br = new BufferedReader(new FileReader(OUTPUT_FILE))) {
			String l = "";
			while ((l = br.readLine()) != null) {
				// System.out.println("l = " + l);
				output = output + l + "\r\n";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Assert.assertEquals(expectedOutput, output);

	}

}
