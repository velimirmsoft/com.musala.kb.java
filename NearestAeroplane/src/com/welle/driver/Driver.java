package com.welle.driver;

public interface Driver {

	public void getInputAndStartLoop(long timePeriod);

	public void loopFetchAndCalculate(long timePeriod, Float myLatitude, Float myLongitude);

	public void stopFetchAndCalculate();

}
