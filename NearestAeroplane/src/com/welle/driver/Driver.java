package com.welle.driver;

public interface Driver {

	public void getInputAndStartLoop(long timePeriod);

	public void loopFetchAndCalculate(long timePeriod, Double myLatitude, Double myLongitude);

	public void stopFetchAndCalculate();

}
