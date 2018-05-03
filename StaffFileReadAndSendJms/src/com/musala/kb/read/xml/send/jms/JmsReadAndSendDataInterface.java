package com.musala.kb.read.xml.send.jms;

public interface JmsReadAndSendDataInterface {
	
	public static String topicToListen = "listen.to.employees.data";

	public int readXmlFileAndStoreInMemory(String filePath);
	
	public int sendDataViaJMS();
	
}
