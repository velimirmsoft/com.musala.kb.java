package com.musala.kb.solution.general.test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.musala.kb.solution.general.ReadAndPrintFile;

class GeneralSolutionTest {

	static String filePath = "res/db.txt";
	static String filePathXml = "res/db.xml";

	@Test
	void testGeneralSolution() {

		// general solution ...
		ReadAndPrintFile readAndPrintFile = new ReadAndPrintFile();
		
		int res = readAndPrintFile.readFileData(filePath);
		Assert.assertEquals(1, res);
		
		String rData = readAndPrintFile.calculateThings();
		Assert.assertEquals("33 4.625 8.0 в о а", rData);

	}

}
