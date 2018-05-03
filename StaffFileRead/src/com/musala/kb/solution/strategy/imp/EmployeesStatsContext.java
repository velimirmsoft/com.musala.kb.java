package com.musala.kb.solution.strategy.imp;

import com.musala.kb.solution.strategy.ReadEmployeesFileStrategy;

public class EmployeesStatsContext {
	
	public String debugOutput = "";

	private ReadEmployeesFileStrategy readEmployeesFiles;

	// this can be set at runtime by the application preferences
	public void setReadingEmployeesStragey(ReadEmployeesFileStrategy strategy) {
		this.readEmployeesFiles = strategy;
	}

	// use the strategy
	public void startReading(String filePath) {
		
		System.out.println("Strategy pattern solution ... \n");

		readEmployeesFiles.readFileAndStoreInMemory(filePath);
		
		int age = readEmployeesFiles.calculateAvgAge();
		float avgSes = readEmployeesFiles.calculateAvgServicesOfEmployees();
		float maxLen = readEmployeesFiles.calculateMaxLengthOfService();
		String mostComm = readEmployeesFiles.calculateMostCommonChars();
		
		debugOutput = age + " " + avgSes + " " + maxLen + " " + mostComm;

	}

}
