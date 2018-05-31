package com.welle.database;

import java.util.ArrayList;

public interface DatabaseManagerOracle {

	public void connectToDB(String dbDriver, String dbUser, String dbPass);

	public void putToDb(Object c, String dbName, Long timeS);

	public ArrayList<?> getAllFromDb();

	public void clearFromDb(String dbName);

}
