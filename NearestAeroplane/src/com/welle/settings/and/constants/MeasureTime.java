package com.welle.settings.and.constants;

public class MeasureTime {

	private boolean isMeasuring = false;
	private long startTime;

	public void startMeasuring() {
		if (!isMeasuring) {
			startTime = System.currentTimeMillis();
			isMeasuring = true;
		}
	}

	public void stopMeasuring() {
		if (isMeasuring) {
			long stopTime = System.currentTimeMillis();
			System.out.println("final time in mS = " + (stopTime - startTime));
			isMeasuring = false;
		}
	}

}
