package com.welle.settings.and.constants;

public class Const {

	// 41.993957, 21.435536

	public static final String DB_NAME = "NEAREST_AIRPLANES";
	public static final String DB_USER = "WELLE";
	public static final String DB_PASS = "admin";
	public static final String JBDC_TO_ORACLE_DB = "jdbc:oracle:thin:@localhost:1521:xe";

	public static Long TIME_INTERVAL;

	public static final Float DEF_LONGITUDE = 21.435536f;
	public static final Float DEF_LATITUDE = 41.993957f;

	public static final String OPENSKY_AIRPLANES = "https://opensky-network.org/api/states/all";

	public static enum Position {
		NE, NW, SE, SW
	}

}
