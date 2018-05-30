package com.welle.driver;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import com.welle.calculator.CalcNearestAirborneImpl;
import com.welle.fetcher.FetchAirplaneDataImpl;
import com.welle.plot.data.PlotMyPlaneData;
import com.welle.unity.AirborneAirplane;

public class DriverImpl implements Driver {

	private Timer loopFetchTimer = null;
	private int loopCounter = 0;

	private PlotMyPlaneData plotter;

	@Override
	public void getInputAndStartLoop(long timePeriod) {

		System.out.println("Welcome to my NeareastAirborne tracker ...");
		System.out.println("Enter your Latitude or Longitude or enter 'c' to use default coordinates ...");

		// init our plotter
		plotter = new PlotMyPlaneData();
		plotter.initPlot();
		plotter.showPlot();

		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		if (input.equals("c")) {
			loopFetchAndCalculate(timePeriod, null, null);
		} else {
			double latitude = Double.parseDouble(input);
			double longitude = Double.parseDouble(sc.nextLine());
			loopFetchAndCalculate(timePeriod, latitude, longitude);
		}
		sc.close();

	}

	@Override
	public void loopFetchAndCalculate(long timePeriod, Double myLatitude, Double myLongitude) {
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				// fetchAndStoreAeroplaneData();
				FetchAirplaneDataImpl f = new FetchAirplaneDataImpl();
				f.fetchAndStoreAeroplaneData();
				CalcNearestAirborneImpl c = new CalcNearestAirborneImpl();
				AirborneAirplane a = null;
				if (myLatitude == null) {
					a = c.calculateNearesAirborne(f.returnPlanes(), 41.993952, 21.435601);
				} else {
					a = c.calculateNearesAirborne(f.returnPlanes(), myLatitude, myLongitude);
				}
				loopCounter++;
				plotter.addToMySeries(Double.valueOf(loopCounter), a.getGeodesicDistance(), a.getGeometricAltitude());
				plotter.updatePlot("" + a.getCallsign() + " - " + a.getICAO24_ID());
			}
		};
		loopFetchTimer = new Timer("looper");
		loopFetchTimer.scheduleAtFixedRate(timerTask, 0, timePeriod);
	}

	@Override
	public void stopFetchAndCalculate() {
		if (loopFetchTimer != null)
			loopFetchTimer.cancel();
	}

}
