package com.musala.kb.printer.logger.tester;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.musala.kb.vehicle.Vehicle;
import com.musala.kb.vehicle.impl.Boat;
import com.musala.kb.vehicle.impl.Car;
import com.musala.kb.vehicle.impl.Motorcycle;
import com.musala.kb.vehicle.impl.Train;
import com.musala.kb.vehicle.impl.Truck;
import com.musala.kb.vehicle.impl.car.audi.Audi;

public class Logger {

	private static final String OUTPUT_FILE = "res/output.txt";
	private String lineSep = System.lineSeparator();

	public void clearFile() {
		// clear file
		File tempFile = new File(OUTPUT_FILE);
		if (tempFile != null) {
			if (tempFile.exists()) {
				tempFile.delete();
			}
		}
		tempFile = null;
	}

	public void writeDataToTextFile(Vehicle v) {

		String toAppend = "";

		if (v instanceof Truck) {
			Truck t = (Truck) v;
			toAppend = "Truck";
			toAppend = toAppend + lineSep + t.getEngineType();
			toAppend = toAppend + lineSep + t.getMaxSpeed();
			toAppend = toAppend + lineSep + t.getModel();
			toAppend = toAppend + lineSep + t.getWheels();
			toAppend = toAppend + lineSep + "-------------------------------------------" + lineSep;
		}

		if (v instanceof Train) {
			Train t = (Train) v;
			toAppend = "Train";
			toAppend = toAppend + lineSep + t.getEngineType();
			toAppend = toAppend + lineSep + t.getMaxSpeed();
			toAppend = toAppend + lineSep + t.getModel();
			toAppend = toAppend + lineSep + t.getWheels();
			toAppend = toAppend + lineSep + t.hasPassengers();
			toAppend = toAppend + lineSep + "-------------------------------------------" + lineSep;
		}

		if (v instanceof Motorcycle) {
			Motorcycle t = (Motorcycle) v;
			toAppend = "Motorcycle";
			toAppend = toAppend + lineSep + t.getEngineType();
			toAppend = toAppend + lineSep + t.getMaxSpeed();
			toAppend = toAppend + lineSep + t.getModel();
			toAppend = toAppend + lineSep + t.getWheels();
			toAppend = toAppend + lineSep + "-------------------------------------------" + lineSep;
		}

		if (v instanceof Car) {
			Car t = (Car) v;
			toAppend = "Car";
			toAppend = toAppend + lineSep + t.getEngineType();
			toAppend = toAppend + lineSep + t.getMaxSpeed();
			toAppend = toAppend + lineSep + t.getModel();
			toAppend = toAppend + lineSep + t.getWheels();
			toAppend = toAppend + lineSep + "-------------------------------------------" + lineSep;
		}

		if (v instanceof Boat) {
			Boat t = (Boat) v;
			toAppend = "Boat";
			toAppend = toAppend + lineSep + t.getEngineType();
			toAppend = toAppend + lineSep + t.getMaxSpeed();
			toAppend = toAppend + lineSep + t.getModel();
			toAppend = toAppend + lineSep + t.getWheels();
			toAppend = toAppend + lineSep + t.hasPassengers();
			toAppend = toAppend + lineSep + "-------------------------------------------" + lineSep;
		}

		if (v instanceof Audi) {
			Audi t = (Audi) v;
			toAppend = "Audi";
			toAppend = toAppend + lineSep + t.getEngineType();
			toAppend = toAppend + lineSep + t.getMaxSpeed();
			toAppend = toAppend + lineSep + t.getModel();
			toAppend = toAppend + lineSep + t.getWheels();
			toAppend = toAppend + lineSep + t.getYear();
			toAppend = toAppend + lineSep + "-------------------------------------------" + lineSep;
		}

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE, true))) {
			bw.append(toAppend);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
