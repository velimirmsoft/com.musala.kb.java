package com.musala.kb.solution.properties;

public class EmployeesStatsContext {

	public EmployeesStatsContext(String filePath) {
		
		System.out.println("Properties solution ... \n");
		
		ReadEmployeesFileImp readEmpFile = new ReadEmployeesFileImp();
		readEmpFile.readFileAndStoreInMemory(filePath);
		
		readEmpFile.calculateAvgAge();
		readEmpFile.calculateAvgServicesOfEmployees();
		readEmpFile.calculateMaxLengthOfService();
		readEmpFile.calculateMostCommonChars();
		
		readEmpFile.readPropertyFile();
		
	}
	
}
