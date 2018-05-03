package com.musala.kb.solution.xml.jms.imp;

import com.musala.kb.solution.xml.jms.ReceiveAndCalcEmployeesStatsInterface;

public class XmlAndJmsEmployeesStatsContext {

	private ReceiveAndCalcEmployeesStatsInterface readEmployeesFileStrategy;

	// this can be set at runtime by the application preferences
	public void setReceiveDataXmlStrategy(ReceiveAndCalcEmployeesStatsInterface readEmployeesFileStrategy) {
		this.readEmployeesFileStrategy = readEmployeesFileStrategy;
	}

	// use the strategy
	public void startReceivingAndCalcStats(String filePath) {

		System.out.println("XML and JMS solution ... \n");

		// set listener to topic to get data via JMS
		readEmployeesFileStrategy.receiveDataFromJMS();

	}

}
