package com.musala.kb.main;

import com.musala.kb.solution.general.ReadAndPrintFile;
import com.musala.kb.solution.iterator.IteratorReadAndPrintFIle;
import com.musala.kb.solution.properties.imp.EmployeesStatsPropContext;
import com.musala.kb.solution.properties.imp.ReadEmployeesFilePropImp;
import com.musala.kb.solution.strategy.imp.EmployeesStatsContext;
import com.musala.kb.solution.strategy.imp.ReadEmployeesFileImp;
import com.musala.kb.solution.xml.jms.imp.ReceiveAndCalcEmployeesStatsImp;
import com.musala.kb.solution.xml.jms.imp.XmlAndJmsEmployeesStatsContext;

public class MainClass {

	static String filePath = "res/db.txt";
	static String filePathXml = "res/db.xml";

	public static void main(String[] args) {

		// general solution ...
		ReadAndPrintFile readAndPrintFile = new ReadAndPrintFile();
		readAndPrintFile.readFileData(filePath);
		readAndPrintFile.calculateThings();
		// general solution ...
		System.out.println("------------------------------------------");

		// iterator pattern solution
		IteratorReadAndPrintFIle iteratorReadAndPrintFile = new IteratorReadAndPrintFIle();
		iteratorReadAndPrintFile.readFileData(filePath);
		// iteratorReadAndPrintFile.calculateThings();
		// general solution ...
		System.out.println("------------------------------------------");

		// strategy pattern - modules: context, interface and interface implementation
		EmployeesStatsContext empStatsContext = new EmployeesStatsContext();
		empStatsContext.setReadingEmployeesStragey(new ReadEmployeesFileImp());
		empStatsContext.startReading(filePath);
		System.out.println("------------------------------------------");

		// using property file + strategy pattern
		EmployeesStatsPropContext empStatsPropContext = new EmployeesStatsPropContext();
		empStatsPropContext.setReadingEmployeesStrategy(new ReadEmployeesFilePropImp());
		empStatsPropContext.startReading(filePath);
		System.out.println("------------------------------------------");

		// using - reading from xml file and jms
		XmlAndJmsEmployeesStatsContext emplStats = new XmlAndJmsEmployeesStatsContext();
		emplStats.setReceiveDataXmlStrategy(new ReceiveAndCalcEmployeesStatsImp());
		emplStats.startReceivingAndCalcStats(filePathXml);
		System.out.println("------------------------------------------");

	}

}
