package com.musala.kb.generala.game.parameterized.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
// DOESNT WORK WITH THIS SHIT ... JUnit 5
// import org.junit.jupiter.api.Test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.musala.kb.generala.game.imp.HandleRollsCombinationsImp;

// we are making parameterized JUnit test which means we set array of variables so our test
// swipes though them

@RunWith(Parameterized.class)
public class ParameterizedTestHandleRolls {

	private HandleRollsCombinationsImp handleRolls;
	private int[] rolls = new int[5];
	private int expectedReturn = 0;

	// Each parameter should be placed as an argument here Every time runner
	// triggers, it will pass the arguments
	// from parameters we defined in primeNumbers() method

	public ParameterizedTestHandleRolls(int[] rolls, int expectedReturn) {
		this.rolls = rolls;
		this.expectedReturn = expectedReturn;
	}

	@Parameterized.Parameters
	public static Collection<Object[]> rollsToTest() {
		// creates list of parameters to test
		// rolls, expectedValue
		return Arrays.asList(new Object[][] { { new int[] { 1, 1, 1, 1, 1 }, 50 }, { new int[] { 1, 1, 1, 1, 2 }, 44 },
				{ new int[] { 1, 2, 3, 4, 5 }, 44 }, { new int[] { 1, 1, 1, 2, 2 }, 32 },
				{ new int[] { 1, 1, 1, 4, 2 }, 23 }, { new int[] { 1, 1, 6, 2, 2 }, 21 },
				{ new int[] { 1, 1, 3, 5, 2 }, 12 } });
	}

	// init our test class
	@Before
	public void initialize() {
		handleRolls = new HandleRollsCombinationsImp();
	}

	// This test will run 5 times since we have 5 parameters defined
	@Test
	public void testPrimeNumberChecker() {
		System.out.println("roll array is : " + Arrays.toString(rolls));
		assertEquals(expectedReturn, handleRolls.handleRollsCombinations(rolls));
	}

}
