package com.musala.kb.dice.rolling.test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.musala.kb.dice.rolling.DiceRoller;
import com.musala.kb.dice.rolling.DiceRolling_1;

class ContextDiceRollingTest {

	@Test	
	void testRollTheDice() {
		
		DiceRoller roll = new DiceRoller();
		roll.setDiceRollingImplementation(new DiceRolling_1());
		
		int r = roll.rollTheDice();
		Assert.assertTrue("returnedValue is in range.", (r >= 1 && r <= 6));
		
	}

}
