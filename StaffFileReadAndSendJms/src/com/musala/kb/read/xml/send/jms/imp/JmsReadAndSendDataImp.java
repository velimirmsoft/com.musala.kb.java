package com.musala.kb.read.xml.send.jms.imp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.musala.kb.read.xml.send.jms.JmsReadAndSendDataInterface;

public class JmsReadAndSendDataImp implements JmsReadAndSendDataInterface {

	private ArrayList<String> names = new ArrayList<String>();
	private ArrayList<String> ages = new ArrayList<String>();
	private ArrayList<String> lenOfServices = new ArrayList<String>();

	public JmsReadAndSendDataImp() {

	}

	@Override
	public void readXmlFileAndStoreInMemory(String filePath) {

		// read and fill from xml file here ...

		try {
			
			System.out.println("Reading XML file and storing in memory ...");

			File fXmlFile = new File(filePath);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			// System.out.println("Root element : " +
			// doc.getDocumentElement().getNodeName());

			NodeList nList = doc.getElementsByTagName("employee");

			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				// System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					// System.out.println("Staff id : " + eElement.getAttribute("id"));
					// System.out.println("name : " +
					// eElement.getElementsByTagName("name").item(0).getTextContent());
					// System.out.println("age : " +
					// eElement.getElementsByTagName("age").item(0).getTextContent());
					// System.out.println("lengthOfService : "+
					// eElement.getElementsByTagName("lengthOfService").item(0).getTextContent());

					names.add(eElement.getElementsByTagName("name").item(0).getTextContent());
					ages.add(eElement.getElementsByTagName("age").item(0).getTextContent());
					lenOfServices.add(eElement.getElementsByTagName("lengthOfService").item(0).getTextContent());

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void sendDataViaJMS() {

		Connection connection = null;

		try {
			
			System.out.println("About to send data via JMS ... ");

			Context ctx = new InitialContext();

			ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory("tcp://localhost:61616");

			connection = cf.createConnection();

			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			Destination destination = session.createQueue(JmsReadAndSendDataInterface.topicToListen);

			MessageProducer messageProducer = session.createProducer(destination);

			MapMessage message = session.createMapMessage();

			System.out.println("Messages to send = " + names.size());
			for(int i = 0; i < names.size(); i++) {
				
				System.out.println("toSend = " + names.get(i));
				
				message.setString("name", names.get(i));
				message.setString("age", ages.get(i));
				message.setString("lenOfService", lenOfServices.get(i));
				messageProducer.send(message);
				
			}
			
			// send end msg
			message.setString("end", "yes");
			messageProducer.send(message);
			
			System.out.println("Messages are sent ...");

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (JMSException e) {
					System.out.println(e);
				}
			}
			System.exit(0);
		}

	}

}
