package com.musala.kb.solution.properties.imp;

import com.musala.kb.solution.properties.ReadEmployeesFilePropInterface;

public class EmployeesStatsPropContext {
	
	public String debugOutput = "";

	private ReadEmployeesFilePropInterface readEmpFiles = null;

	// this can be set at runtime by the application preferences
	public void setReadingEmployeesStrategy(ReadEmployeesFilePropInterface readEmpFiles) {
		this.readEmpFiles = readEmpFiles;
	}

	// use the strategy
	public void startReading(String filePath) {

		System.out.println("Strategy pattern + Properties solution ... \n");

		readEmpFiles.readFileAndStoreInMemory(filePath);

		int age = readEmpFiles.calculateAvgAge();
		float avgSes = readEmpFiles.calculateAvgServicesOfEmployees();
		float maxLen = readEmpFiles.calculateMaxLengthOfService();
		String mostComm = readEmpFiles.calculateMostCommonChars();
		
		debugOutput = age + " " + avgSes + " " + maxLen + " " + mostComm;	

	}

}
