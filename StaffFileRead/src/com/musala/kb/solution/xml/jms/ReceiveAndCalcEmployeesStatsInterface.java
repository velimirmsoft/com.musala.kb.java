package com.musala.kb.solution.xml.jms;

public interface ReceiveAndCalcEmployeesStatsInterface {
	
	public static String topicToListen = "listen.to.employees.data";

	public void receiveDataFromJMS();
	
	public void calculateAvgAge();
	
	public void calculateAvgServicesOfEmployees();
	
	public void calculateMaxLengthOfService();
	
	public void calculateMostCommonChars();
	
}
