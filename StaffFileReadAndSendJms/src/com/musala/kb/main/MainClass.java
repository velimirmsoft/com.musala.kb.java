package com.musala.kb.main;

import com.musala.kb.read.xml.send.jms.imp.JmsReadAndSendDataImp;

public class MainClass {

	static String filePath = "res/db.txt";
	static String filePathXml = "res/db.xml";

	public static void main(String[] args) {

		// using - reading from xml file and jms
		JmsReadAndSendDataImp emplStats = new JmsReadAndSendDataImp();
		emplStats.readXmlFileAndStoreInMemory(filePathXml);
		emplStats.sendDataViaJMS();

	}

}
