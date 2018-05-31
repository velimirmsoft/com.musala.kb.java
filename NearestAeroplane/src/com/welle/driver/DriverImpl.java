package com.welle.driver;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import com.welle.calculator.AirborneDataImpl;
import com.welle.database.DatabaseManagerOracle;
import com.welle.database.MyDatabaseManager;
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
	private AirborneDataImpl calculator;
	private WriteFileToDisk writterToDisk;
	private DatabaseManagerOracle myDbManager;

	@Override
	public void getInputAndStartLoop(long timePeriod) {

		System.out.println("Welcome to my NeareastAirborne tracker ...");
		System.out.println("Enter your Latitude or Longitude or enter 'c' to use default coordinates ...");

		Const.TIME_INTERVAL = timePeriod;

		// init things
		fetcher = new FetchAirplaneDataImpl();
		calculator = new AirborneDataImpl();
		writterToDisk = new WriteAllAirplanesToDiskCVS();
		writterToDisk.setPath("C:\\velimir-avramovski-work\\java-things\\writeFilesHere\\");
		myDbManager = new MyDatabaseManager();
		myDbManager.connectToDB(Const.JBDC_TO_ORACLE_DB, Const.DB_USER, Const.DB_PASS);
		// myDbManager.clearFromDb(Const.DB_NAME);

		// init our plotter
		plotter = new PlotMyAirplaneData();
		plotter.initPlot();
		plotter.showPlot();

		Scanner sc = new Scanner(System.in);
		// String input = sc.nextLine();
		String input = "c"; // for faster testing :D
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
				writterToDisk.writeAllAirplanesToDisk("fetchedData_" + fetcher.returnTimeOfFetch(), fetcher.returnTimeOfFetch(), fetcher.returnPlanes());
				AirborneAirplane a = calculator.calculateNearesAirborne(fetcher.returnPlanes(), myLatitude, myLongitude);
				myDbManager.putToDb(a, Const.DB_NAME, fetcher.returnTimeOfFetch());
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
