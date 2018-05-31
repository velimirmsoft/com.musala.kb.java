package com.welle.driver;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import com.welle.calculator.CalcAirborneDataImpl;
import com.welle.fetcher.FetchAirplaneDataImpl;
import com.welle.plot.data.PlotMyAirplaneData;
import com.welle.settings.and.constants.Const;
import com.welle.unity.AirborneAirplane;

public class DriverImpl implements Driver {

	private Timer loopFetchTimer = null;
	private float loopCounter = 0;

	private PlotMyAirplaneData plotter;
	private FetchAirplaneDataImpl fetcher;
	private CalcAirborneDataImpl calculator;

	@Override
	public void getInputAndStartLoop(long timePeriod) {

		System.out.println("Welcome to my NeareastAirborne tracker ...");
		System.out.println("Enter your Latitude or Longitude or enter 'c' to use default coordinates ...");

		Const.timeInterval = timePeriod;

		// init things
		fetcher = new FetchAirplaneDataImpl();
		calculator = new CalcAirborneDataImpl();

		// init our plotter
		plotter = new PlotMyAirplaneData();
		plotter.initPlot();
		plotter.showPlot();

		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		if (input.equals("c")) {
			loopFetchAndCalculate(timePeriod, Const.DEF_LATITUDE, Const.DEF_LONGITUDE);
		} else {
			Float latitude = Float.parseFloat(input);
			Float longitude = Float.parseFloat(sc.nextLine());
			loopFetchAndCalculate(timePeriod, latitude, longitude);
		}
		sc.close();

	}

	@Override
	public void loopFetchAndCalculate(long timePeriod, Float myLatitude, Float myLongitude) {
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				fetcher.fetchAndStoreAeroplaneData();
				AirborneAirplane a = null;
				a = calculator.calculateNearesAirborne(fetcher.returnPlanes(), myLatitude, myLongitude);
				// update plots
				loopCounter++;
				plotter.addAndUpdatePlot(a.toString(), loopCounter, a.getGeodesicDistance(), a.getGeometricAltitude(), a.getSpeedOfAirplane(), fetcher.getLatForAllAirbornes(),
						fetcher.getLongForAllAirbornes());
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
