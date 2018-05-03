package com.musala.kb.dice.rolling;

public class ContextDiceRolling {

	private DiceRolling dice;
	
	public void setDiceRollingImplementation(DiceRolling dice) {
		this.dice = dice;
	}
	
	public int rollTheDice() {
		return dice.rollDice();
	}
		
}
