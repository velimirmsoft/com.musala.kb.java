package com.musala.kb.solution.xml.jms.imp;

import java.util.ArrayList;
import java.util.List;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.musala.kb.solution.general.MapUtilis;
import com.musala.kb.solution.xml.jms.ReceiveAndCalcEmployeesStatsInterface;

public class ReceiveAndCalcEmployeesStatsImp implements ReceiveAndCalcEmployeesStatsInterface {

	private int avgAgeOfEmployees = 0;
	private float avgServiceOfEmployees = 0;
	private float maxLengthOfService = 0;

	public static ArrayList<String> names = new ArrayList<String>();
	public static ArrayList<String> ages = new ArrayList<String>();
	public static ArrayList<String> lenOfServices = new ArrayList<String>();

	public ReceiveAndCalcEmployeesStatsImp() {

	}

	public void calcEveryThing() {
		calculateAvgAge();
		calculateAvgServicesOfEmployees();
		calculateMaxLengthOfService();
		calculateMostCommonChars();
	}

	public void receiveDataFromJMS() {

		// set up JMS listener ...
		try {

			System.out.println("Setting up listener for JMS data ...");

			// InitialContext ctx = new InitialContext();

			ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory("tcp://localhost:61616");

			Connection connection = cf.createConnection();

			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			Destination destination = session.createQueue(ReceiveAndCalcEmployeesStatsInterface.topicToListen);

			MessageConsumer consumer = session.createConsumer(destination);

			consumer.setMessageListener(new JMSMessageListener());
			connection.start();

			System.out.println("Listener is set ...");

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public void calculateAvgAge() {

		if (ages.isEmpty()) {
			try {
				throw new Exception("error!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {

			// avgAgeOfEmployees
			int sumAge = 0;
			for (String age : ages) {
				sumAge = sumAge + Integer.parseInt(age);
			}

			avgAgeOfEmployees = sumAge / (ages.size());
			System.out.println("avgAgeOfEmployees = " + avgAgeOfEmployees);

		}

	}

	@Override
	public void calculateAvgServicesOfEmployees() {

		if (lenOfServices.isEmpty()) {
			try {
				throw new Exception("error!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {

			// avgServiceOfEmployees
			float sumService = 0;
			for (String lenOfService : lenOfServices) {
				float c = Float.parseFloat(lenOfService);
				sumService = sumService + c;
			}

			avgServiceOfEmployees = sumService / (lenOfServices.size());
			System.out.println("avgServiceOfEmployees = " + avgServiceOfEmployees);

		}

	}

	@Override
	public void calculateMaxLengthOfService() {

		if (lenOfServices.isEmpty()) {
			try {
				throw new Exception("error!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {

			// maxLengthOfService
			for (String lenOfService : lenOfServices) {
				float c = Float.parseFloat(lenOfService);
				if (c > maxLengthOfService) {
					maxLengthOfService = c;
				}
			}

			System.out.println("maxLengthOfService = " + maxLengthOfService);

		}

	}

	@Override
	public void calculateMostCommonChars() {

		String oneLongName = "";
		for (String name : names) {
			oneLongName = oneLongName + name;
		}

		List<String> mapOfMostCommonChars = MapUtilis.countCharactersInString(oneLongName, false);
		System.out.println("Top 1 char = " + mapOfMostCommonChars.get(0));
		System.out.println("Top 2 char = " + mapOfMostCommonChars.get(1));
		System.out.println("Top 3 char = " + mapOfMostCommonChars.get(2));

	}

}