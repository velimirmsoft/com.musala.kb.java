package com.musala.kb.read.xml.send.jms;

public interface JmsReadAndSendDataInterface {
	
	public static String topicToListen = "listen.to.employees.data";

	public void readXmlFileAndStoreInMemory(String filePath);
	
	public void sendDataViaJMS();
	
}
