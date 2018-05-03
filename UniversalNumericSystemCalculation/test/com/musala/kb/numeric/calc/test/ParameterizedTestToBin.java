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
import com.musala.kb.numeric.calc.imp.DecToBinAndBinToDec;

@RunWith(Parameterized.class)
public class ParameterizedTestToBin {

	private ContextNumericSystems convertor;

	private String input = "";
	private String expectedValue = "";

	public ParameterizedTestToBin(String input, String expectedValue) {
		this.input = input;
		this.expectedValue = expectedValue;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> rollsToTest() {
		// creates list of parameters to test
		// hex to integer
		return Arrays.asList(new Object[][] { { "7", "111" }, { "1", "1" }, { "0", "0" }, { "0001", "1" },  { "zxc", "-1" } });
	}

	@Before
	public void initialize() {
		convertor = new ContextNumericSystems();
		convertor.setUnvInterfaceNumCalc(new DecToBinAndBinToDec());
	}

	@Test
	public void testPrimeNumberChecker() {
		Assert.assertEquals(expectedValue, convertor.fromDecimal(input));
	}

}
