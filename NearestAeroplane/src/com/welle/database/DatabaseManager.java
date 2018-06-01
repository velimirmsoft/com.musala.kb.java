package com.welle.database;

import java.util.ArrayList;

public interface DatabaseManager {

	public void connectToDB(String dbDriver, String dbUser, String dbPass);

	public void putToDb(Object c, String dbName, Long timeS);

	public ArrayList<Object> getAllFromDb();

	public void clearFromDb(String dbName);

}
