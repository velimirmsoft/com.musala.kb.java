package com.musala.kb.dice.rolling;

public class DiceRoller {

	private DiceRollingInterface dice;
	
	public void setDiceRollingImplementation(DiceRollingInterface dice) {
		this.dice = dice;
	}
	
	public int rollTheDice() {
		return dice.rollDice();
	}
		
}
