package com.musala.kb.solution.strategy;

public interface ReadEmployeesFileStrategy {

	public void readFileAndStoreInMemory(String filePath);
	
	public void calculateAvgAge();
	
	public void calculateAvgServicesOfEmployees();
	
	public void calculateMaxLengthOfService();
	
	public void calculateMostCommonChars();
	
}
