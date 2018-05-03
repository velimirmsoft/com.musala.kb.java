package com.musala.kb.solution.properties.test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.musala.kb.solution.properties.imp.EmployeesStatsPropContext;
import com.musala.kb.solution.properties.imp.ReadEmployeesFilePropImp;

class PropertiesSolutionTest {

	static String filePath = "res/db.txt";
	static String filePathXml = "res/db.xml";

	@Test
	void testPropertiesSolution() {

		// properties pattern solution
		EmployeesStatsPropContext empStatsPropContext = new EmployeesStatsPropContext();
		empStatsPropContext.setReadingEmployeesStrategy(new ReadEmployeesFilePropImp());
		empStatsPropContext.startReading(filePath);
		
		Assert.assertEquals("33 4.625 8.0 в о а", "" + empStatsPropContext.debugOutput);

	}

}
