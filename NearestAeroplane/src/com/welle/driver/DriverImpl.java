package com.welle.driver;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import com.welle.calculator.AirborneCalculator;
import com.welle.database.DatabaseManager;
import com.welle.database.MyDatabaseManagerOracle;
import com.welle.fetcher.FetchAirplaneData;
import com.welle.fetcher.FetchAirplaneDataImpl;
import com.welle.plot.data.PlotMyAirplaneData;
import com.welle.plot.data.PlotMyData;
import com.welle.settings.and.constants.Const;
import com.welle.unity.AirborneAirplane;
import com.welle.write.csv.WriteAllAirplanesToDiskCVS;
import com.welle.write.csv.WriteFileToDisk;

public class DriverImpl implements Driver {

	private Timer loopFetchTimer = null;
	private float loopCounter = 0;

	private PlotMyData plotter;
	private FetchAirplaneData fetcher;
	private AirborneCalculator calculator;
	private WriteFileToDisk writterToDisk;
	private DatabaseManager myDbManager;

	@Override
	public void getInputAndStartLoop(long timePeriod) {

		if (timePeriod < 10000) {
			timePeriod = 10000;
			System.out.println("This program works best for 'time intervals' larger then 10 secs ...");
			System.out.println("timePeriod set to 10 secs ...");
		}

		System.out.println("Welcome to my NeareastAirborne tracker ...");
		System.out.println("Enter your Latitude or Longitude or enter 'c' to use default coordinates ...");

		Const.TIME_INTERVAL = timePeriod;

		// init things
		fetcher = new FetchAirplaneDataImpl();
		calculator = new AirborneCalculator();
		plotter = new PlotMyAirplaneData();
		plotter.initPlot();
		plotter.showPlot();
		writterToDisk = new WriteAllAirplanesToDiskCVS();
		writterToDisk.setPath("C:\\velimir-avramovski-work\\java-things\\writeFilesHere\\");
		myDbManager = new MyDatabaseManagerOracle();
		myDbManager.connectToDB(Const.JBDC_TO_ORACLE_DB, Const.DB_USER, Const.DB_PASS);

		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		// String input = "c"; // for faster testing :D
		if (input.equals("c")) {
			loopFetchAndCalculate(timePeriod, Const.DEF_LATITUDE, Const.DEF_LONGITUDE);
		} else {
			loopFetchAndCalculate(timePeriod, Float.parseFloat(input), Float.parseFloat(sc.nextLine()));
		}
		sc.close();

	}

	@Override
	public void loopFetchAndCalculate(long timePeriod, Float myLatitude, Float myLongitude) {
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				loopCounter++;
				fetcher.fetchAndStoreAeroplaneData();
				AirborneAirplane a = calculator.calculateNearesAirborne(fetcher.returnPlanes(), myLatitude, myLongitude);
				plotter.addAndUpdatePlot(a.toString(), loopCounter, a.getGeodesicDistance(), a.getGeometricAltitude(), a.getSpeedOfAirplane(), fetcher.getLatForAllAirbornes(),
						fetcher.getLongForAllAirbornes());
				writterToDisk.writeAirplanesDataToDisk("fetchedData_" + fetcher.returnTimeOfFetch(), fetcher.returnTimeOfFetch(), fetcher.returnPlanes());
				myDbManager.putToDb(a, Const.DB_NAME, fetcher.returnTimeOfFetch());
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
