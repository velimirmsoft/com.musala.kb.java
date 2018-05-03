package com.musala.kb.solution.xml.jms.test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.musala.kb.solution.xml.jms.imp.ReceiveAndCalcEmployeesStatsImp;
import com.musala.kb.solution.xml.jms.imp.XmlAndJmsEmployeesStatsContext;

class XMLJmsSolutionTest {

	static String filePath = "res/db.txt";
	static String filePathXml = "res/db.xml";

	@Test
	void testIteratorSolution() {

		// using - reading from xml file and jms
		XmlAndJmsEmployeesStatsContext emplStats = new XmlAndJmsEmployeesStatsContext();
		emplStats.setReceiveDataXmlStrategy(new ReceiveAndCalcEmployeesStatsImp());
		emplStats.startReceivingAndCalcStats(filePathXml);

		// JMS service is not started, we expect this to return -1 status
		// the rest of the code is the same as in previous examples I find it not effective to write tests for the
		// same things over and over again ...
		Assert.assertEquals(-1, emplStats.status);

	}

}
