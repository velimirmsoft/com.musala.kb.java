package com.musala.kb.generala.game;

public interface HandleRollsCombination {

	// handle the combinations of rolls -> player rolls
	// combinationPriviouslyChecked -> array mapping which combination were used by
	// the user as required in the task
	// returns points to be awarded to the player
	
	public int handleRollsCombinations(int[] rolls);

	public boolean isGenerala(int[] rolls);

	public boolean isFourOfAKind(int[] rolls);

	public boolean isStraight(int[] rolls);

	public boolean isFullHouse(int[] rolls);

	public boolean isTriple(int[] rolls);

	public boolean isDoublePair(int[] rolls);

	public boolean isPair(int[] rolls);

}
