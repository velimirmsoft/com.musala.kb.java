package com.welle.main;

import com.welle.driver.Driver;
import com.welle.driver.DriverImpl;

public class MainClass {

	public static void main(String[] args) {

		Driver d = new DriverImpl();
		d.getInputAndStartLoop(3000);

	}

}
