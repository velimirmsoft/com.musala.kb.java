package com.musala.kb.main;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;

import org.apache.activemq.ActiveMQConnectionFactory;

public class MessageSender {
	
	public static void main(String[] args) {
		
		Connection connection = null;

		try {

			Context ctx = new InitialContext();

			ActiveMQConnectionFactory cf = new ActiveMQConnectionFactory("tcp://localhost:61616");

			connection = cf.createConnection();

			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

			Destination destination = session.createQueue("test.prog.queue");

			MessageProducer messageProducer = session.createProducer(destination);

			MapMessage message = session.createMapMessage();

			message.setString("Name", "Tim");
			message.setString("Role", "Developer");
			message.setDouble("Salary", 850000);

			messageProducer.send(message);

			System.out.println("Message is sent ...");

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
