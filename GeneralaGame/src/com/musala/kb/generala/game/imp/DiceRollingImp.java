package com.musala.kb.generala.game.imp;

import com.musala.kb.generala.game.DiceRolling;

public class DiceRollingImp implements DiceRolling {

	@Override
	public int rollDice() {
		
		int rolled = (int) (Math.random()*6) + 1;
		
		return rolled;
	}

}
