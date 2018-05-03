package com.musala.kb.generala.game.test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.musala.kb.generala.game.imp.DiceRollingImp;

class DiceRollingTest {

	@Test
	void testRollDice() {
		DiceRollingImp diceRollTest = new DiceRollingImp();
		// one for to test numerus of times
		for (int i = 0; i < 1000; i++) {
			// we got the format - msg, expected result, call the method we are testing
			int returnedValue = diceRollTest.rollDice();
			Assert.assertTrue("returnedValue is in range.", (returnedValue >= 1 && returnedValue <= 6));
		}
	}

}
