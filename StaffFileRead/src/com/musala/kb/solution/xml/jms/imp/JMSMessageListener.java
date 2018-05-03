package com.musala.kb.solution.xml.jms.imp;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

public class JMSMessageListener implements MessageListener {

	public void onMessage(Message message) {

		System.out.println("Some message is received!");

		if (message instanceof MapMessage) {
			MapMessage mapMessage = (MapMessage) message;

			try {

				String name = mapMessage.getString("name");
				System.out.println("name : " + name);
				ReceiveAndCalcEmployeesStatsImp.names.add(name);

				String age = mapMessage.getString("age");
				System.out.println("age : " + age);
				ReceiveAndCalcEmployeesStatsImp.ages.add(age);

				String service = mapMessage.getString("lenOfService");
				System.out.println("service : " + service);
				ReceiveAndCalcEmployeesStatsImp.lenOfServices.add(service);

				// try end tag
				String endTag = mapMessage.getString("end");
				if (endTag != null) {
					if (endTag.equals("yes")) {
						System.out.println("------------------------------------------");
						System.out.println("");
						ReceiveAndCalcEmployeesStatsImp rc = new ReceiveAndCalcEmployeesStatsImp();
						rc.calcEveryThing();
					}
				}

			} catch (JMSException e) {
				throw new RuntimeException(e);
			}
		} else {
			System.out.println("Invalid Message Received");
		}

	}
}