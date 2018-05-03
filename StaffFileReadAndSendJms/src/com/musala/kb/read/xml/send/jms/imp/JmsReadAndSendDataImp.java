package com.musala.kb.read.xml.send.jms.imp;

import java.io.File;
import java.util.ArrayList;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.Session;
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
	public int readXmlFileAndStoreInMemory(String filePath) {

		// read and fill from xml file here ...

		int status = -1;

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

			// reading XML is done
			if (names.size() != 0 && ages.size() != 0 && lenOfServices.size() != 0) {
				status = 1;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return status;
		}

		return status;

	}

	@Override
	public int sendDataViaJMS() {

		Connection connection = null;

		int status = 0;
		
		try {

			System.out.println("About to send data via JMS ... ");

			// Context ctx = new InitialContext();

			ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory("tcp://localhost:61616");

			connection = cf.createConnection();

			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			Destination destination = session.createQueue(JmsReadAndSendDataInterface.topicToListen);

			MessageProducer messageProducer = session.createProducer(destination);

			MapMessage message = session.createMapMessage();

			System.out.println("Messages to send = " + names.size());
			for (int i = 0; i < names.size(); i++) {

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
			System.out.println("we got exception!");
			System.out.println(e);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (JMSException e) {
					System.out.println(e);
				}
			}
			status = -1;
			// this quits the problem - we dont want that for our tests
			// System.exit(0);
		}
		
		return status;

	}

}
