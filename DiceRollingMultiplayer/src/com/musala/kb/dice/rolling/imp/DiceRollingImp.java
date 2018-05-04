package com.musala.kb.dice.rolling.imp;

import com.musala.kb.dice.rolling.DiceRolling;

public class DiceRollingImp implements DiceRolling {

	@Override
	public int rollDice() {
		return (int) (Math.random()*6) + 1;
	}

}
