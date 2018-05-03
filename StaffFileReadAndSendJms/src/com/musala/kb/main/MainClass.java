package com.musala.kb.main;

import com.musala.kb.read.xml.send.jms.imp.JmsReadAndSendDataImp;

public class MainClass {

	public static String filePath = "res/db.txt";
	public static String filePathXml = "res/db.xml";

	public static void main(String[] args) {

		// using - reading from xml file and jms
		JmsReadAndSendDataImp emplStats = new JmsReadAndSendDataImp();
		emplStats.readXmlFileAndStoreInMemory(filePathXml);
		emplStats.sendDataViaJMS();

	}

}
