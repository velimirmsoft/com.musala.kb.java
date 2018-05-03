package com.musala.kb.solution.properties;

public interface ReadEmployeesFilePropInterface {

	public void readFileAndStoreInMemory(String filePath);
	
	public void readPropertyFile();
	
	public int calculateAvgAge();
	
	public float calculateAvgServicesOfEmployees();
	
	public float calculateMaxLengthOfService();
	
	public String calculateMostCommonChars();
	
}
