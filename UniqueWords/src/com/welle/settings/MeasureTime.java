package com.welle.settings;

public class MeasureTime {

	public static long startTime;

	public static void startMeasuring() {
		startTime = System.currentTimeMillis();
	}

	public static void stopMeasuring() {
		long stopTime = System.currentTimeMillis();
		System.out.println("final time in mS = " + (stopTime - startTime));
	}

}
