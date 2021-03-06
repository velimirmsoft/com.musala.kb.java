package com.musala.kb.solution.strategy;

public interface ReadEmployeesFileStrategy {

	public void readFileAndStoreInMemory(String filePath);

	public int calculateAvgAge();

	public float calculateAvgServicesOfEmployees();

	public float calculateMaxLengthOfService();

	public String calculateMostCommonChars();

}
