package com.musala.kb.dice.rolling.test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.musala.kb.dice.rolling.ContextDiceRolling;
import com.musala.kb.dice.rolling.DiceRolling_1;

class ContextDiceRollingTest {

	@Test	
	void testRollTheDice() {
		
		ContextDiceRolling roll = new ContextDiceRolling();
		roll.setDiceRollingImplementation(new DiceRolling_1());
		
		int r = roll.rollTheDice();
		Assert.assertTrue("returnedValue is in range.", (r >= 1 && r <= 6));
		
	}

}
