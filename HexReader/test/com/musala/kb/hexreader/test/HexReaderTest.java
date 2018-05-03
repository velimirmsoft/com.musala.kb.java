package com.musala.kb.hexreader.test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.musala.kb.hexreader.ContextHexReader;
import com.musala.kb.hexreader.HexReader;

class HexReaderTest {

	@Test
	void testHexReader() {

		ContextHexReader chr = new ContextHexReader();
		chr.setHexReaderInterfaceImpls(new HexReader());
		
		String input = "ffff";
		InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
		Scanner s = new Scanner(System.in);
		
		Assert.assertEquals(65535, chr.startHexReading(s.nextLine()));
		s.close();
		
	}

}
