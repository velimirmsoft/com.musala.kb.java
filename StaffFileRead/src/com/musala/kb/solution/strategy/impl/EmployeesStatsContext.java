package com.musala.kb.solution.strategy.impl;

import com.musala.kb.solution.strategy.ReadEmployeesFileStrategy;

public class EmployeesStatsContext {

	private ReadEmployeesFileStrategy readEmployeesFiles;

	// this can be set at runtime by the application preferences
	public void setReadingEmployeesStragey(ReadEmployeesFileStrategy strategy) {
		this.readEmployeesFiles = strategy;
	}

	// use the strategy
	public void startReading(String filePath) {
		
		System.out.println("Strategy pattern solution ... \n");

		readEmployeesFiles.readFileAndStoreInMemory(filePath);
		readEmployeesFiles.calculateAvgAge();
		readEmployeesFiles.calculateAvgServicesOfEmployees();
		readEmployeesFiles.calculateMaxLengthOfService();
		readEmployeesFiles.calculateMostCommonChars();

	}

}
