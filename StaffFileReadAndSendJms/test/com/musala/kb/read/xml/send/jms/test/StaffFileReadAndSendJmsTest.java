package com.musala.kb.read.xml.send.jms.test;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import com.musala.kb.main.MainClass;
import com.musala.kb.read.xml.send.jms.imp.JmsReadAndSendDataImp;

class StaffFileReadAndSendJmsTest {
	
	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Test
	void test() {

		JmsReadAndSendDataImp emplStats = new JmsReadAndSendDataImp();
		
		// pass xml
		int status = emplStats.readXmlFileAndStoreInMemory(MainClass.filePathXml);
		Assert.assertEquals(1, status);
		
		// fail xml
		status = emplStats.readXmlFileAndStoreInMemory("invalid/path");
		Assert.assertEquals(-1, status);
		
		exception.expect(javax.jms.JMSException.class);
		status = emplStats.sendDataViaJMS();
		// we expect this to fail since we have no ACTIVE server for the JMS - still a test :D
		Assert.assertEquals(-1, status);

	}
	
	public void testIndexOutOfBoundsException() {
		
	}
	
}
