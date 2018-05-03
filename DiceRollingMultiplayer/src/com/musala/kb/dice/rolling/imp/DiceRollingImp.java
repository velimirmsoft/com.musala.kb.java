package com.musala.kb.dice.rolling.imp;

import com.musala.kb.dice.rolling.DiceRolling;

public class DiceRollingImp implements DiceRolling {

	@Override
	public int rollDice() {
		
		int rolled = (int) (Math.random()*6) + 1;
		
		return rolled;
	}

}
