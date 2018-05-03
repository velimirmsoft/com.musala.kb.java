package com.musala.kb.solution.strategy.test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.musala.kb.solution.strategy.imp.EmployeesStatsContext;
import com.musala.kb.solution.strategy.imp.ReadEmployeesFileImp;

class StrategySolutionTest {

	static String filePath = "res/db.txt";
	static String filePathXml = "res/db.xml";

	@Test
	void testStrategySolution() {

		// strategy pattern solution
		EmployeesStatsContext empStatsContext = new EmployeesStatsContext();
		empStatsContext.setReadingEmployeesStragey(new ReadEmployeesFileImp());
		empStatsContext.startReading(filePath);
		
		Assert.assertEquals("33 4.625 8.0 в о а", empStatsContext.debugOutput);

	}

}
