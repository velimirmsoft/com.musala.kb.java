package com.musala.kb.dice.rolling;

import com.musala.kb.dice.rolling.DiceRollingInterface;

public class DiceRolling_1 implements DiceRollingInterface {

	@Override
	public int rollDice() {
		return (int) (Math.random()*6) + 1;
	}

}
