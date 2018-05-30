package com.welle.main;

import com.welle.driver.DriverImpl;

public class MainClass {

	public static void main(String[] args) {

		DriverImpl d = new DriverImpl();
		d.getInputAndStartLoop(10000);

	}

}
