package com.musala.kb.numeric.calc.test;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.Before;
// DOESNT WORK WITH THIS SHIT ... JUnit 5
// import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.musala.kb.numeric.calc.imp.ContextNumericSystems;
import com.musala.kb.numeric.calc.imp.DecToOctalAndOctalToDec;

@RunWith(Parameterized.class)
public class ParameterizedTestOctaToBin {

	private ContextNumericSystems convertor;

	private String input = "";
	private String expectedValue = "";

	public ParameterizedTestOctaToBin(String input, String expectedValue) {
		this.input = input;
		this.expectedValue = expectedValue;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> rollsToTest() {
		// creates list of parameters to test
		// hex to integer
		return Arrays.asList(new Object[][] { { "7", "7" }, { "1", "1" }, { "16", "20" }, { "66", "102" }, { "asd", "-1" } });
	}

	@Before
	public void initialize() {
		convertor = new ContextNumericSystems();
		convertor.setUnvInterfaceNumCalc(new DecToOctalAndOctalToDec());
	}

	@Test
	public void testPrimeNumberChecker() {
		Assert.assertEquals(expectedValue, convertor.fromDecimal(input));
	}

}
