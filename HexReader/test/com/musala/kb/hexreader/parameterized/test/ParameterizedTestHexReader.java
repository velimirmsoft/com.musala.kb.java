package com.musala.kb.hexreader.parameterized.test;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
// DOESNT WORK WITH THIS SHIT ... JUnit 5
// import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.musala.kb.hexreader.ContextHexReader;

@RunWith(Parameterized.class)
public class ParameterizedTestHexReader {

	private ContextHexReader hexReader;

	private String hex = "";
	private int expectedValue = 0;

	public ParameterizedTestHexReader(String hex, int expectedValue) {
		this.hex = hex;
		this.expectedValue = expectedValue;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> rollsToTest() {
		// creates list of parameters to test
		// hex to integer
		return Arrays.asList(new Object[][] { { "ffff", 65535 }, { "1111", 4369 }, { "123A", 4666 },
				{ "B2FC", 45820 }, { "CCXX", -1 }, { "0001", 1 } });
	}

	@Before
	public void initialize() {
		hexReader = new ContextHexReader();
		hexReader.setHexReaderInterfaceImpls(new com.musala.kb.hexreader.HexReader());
	}

	@Test
	public void testPrimeNumberChecker() {
		Assert.assertEquals(expectedValue, hexReader.startHexReading(hex));
	}

}
