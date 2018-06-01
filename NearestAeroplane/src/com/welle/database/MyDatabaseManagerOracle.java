package com.welle.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.welle.unity.AirborneAirplane;

public class MyDatabaseManagerOracle implements DatabaseManager {

	private Connection con;

	@Override
	public void connectToDB(String dbDriver, String dbUser, String dbPass) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(dbDriver, dbUser, dbPass);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void putToDb(Object c, String dbName, Long timeS) {
		AirborneAirplane a = (AirborneAirplane) c;
		PreparedStatement ps;
		try {
			if (con != null) {
				ps = con.prepareStatement("insert into " + dbName + " values(?,?,?,?,?,?,?,?,?)");
				ps.setString(1, a.getICAO24_ID());
				ps.setString(2, a.getCountryOfOrigin());
				ps.setFloat(3, a.getGeometricAltitude());
				ps.setFloat(4, a.getLattitude());
				ps.setFloat(5, a.getLongitude());
				ps.setString(6, a.getCallsign());
				ps.setFloat(7, a.getSpeedOfAirplane());
				ps.setFloat(8, a.getGeodesicDistance());
				ps.setLong(9, timeS);
				int i = ps.executeUpdate();
				if (i > 0)
					System.out.println("Airplane logged in database ...");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Object> getAllFromDb() {
		return null;
	}

	@Override
	public void clearFromDb(String dbName) {
		PreparedStatement ps;
		if (con != null) {
			try {
				ps = con.prepareStatement("TRUNCATE table " + dbName);
				int i = ps.executeUpdate();
				if (i > 0)
					System.out.println("Database wiped ...");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
