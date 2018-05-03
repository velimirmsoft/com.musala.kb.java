package com.musala.kb.dice.rolling;

import com.musala.kb.dice.rolling.DiceRolling;

public class DiceRolling_2 implements DiceRolling {

	@Override
	public int rollDice() {
		
		int rolled = (int) (Math.random()*6) + 1;
		
		return rolled;
	}
	
}
