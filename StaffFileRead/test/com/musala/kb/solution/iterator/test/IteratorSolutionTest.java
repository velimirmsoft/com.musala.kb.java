package com.musala.kb.solution.iterator.test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.musala.kb.solution.iterator.IteratorReadAndPrintFIle;

class IteratorSolutionTest {

	static String filePath = "res/db.txt";
	static String filePathXml = "res/db.xml";

	@Test
	void testIteratorSolution() {

		// iterator pattern solution
		IteratorReadAndPrintFIle iteratorReadAndPrintFile = new IteratorReadAndPrintFIle();
		String rData = iteratorReadAndPrintFile.readFileData(filePath);
		Assert.assertEquals("33 4.625 8.0 в о а", rData);

	}

}
