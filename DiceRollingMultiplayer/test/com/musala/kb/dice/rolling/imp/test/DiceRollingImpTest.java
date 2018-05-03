package com.musala.kb.dice.rolling.imp.test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.musala.kb.dice.rolling.DiceRolling;
import com.musala.kb.dice.rolling.imp.DiceRollingImp;

class DiceRolling_1Test {

	@Test
	void testRollDice() {
		DiceRolling diceRollTest = new DiceRollingImp();
		// one for to test numerus of times
		for (int i = 0; i < 1000; i++) {
			// we got the format - msg, expected result, call the method we are testing
			int returnedValue = diceRollTest.rollDice();
			Assert.assertTrue("returnedValue is in range.", (returnedValue >= 1 && returnedValue <= 6));
		}
	}

}