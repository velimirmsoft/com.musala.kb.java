package com.musala.kb.main;

import com.musala.kb.generala.game.GeneralaGame;

public class MainClass {

	/*
	 * 
	 * 
	 * Depending on your previous DiceRolling program write a program that
	 * represents Generala dice game. In that game each player rolls 5 dice at a
	 * time in one round. You have to evaluate whether these 5 dice are forming one
	 * or more combinations and calculate the player's score. The score is the sum
	 * of all the dice included in the picked combination plus the constant for the
	 * combination.
	 * 
	 * The combinations required to be implemented are:
	 * 
	 * Pair - when you have two equal dice (Example: 2,2,4,5,1) score constant is 10
	 * Double pair - is two different pairs (Example: 2,2,3,3,6) score constant is 15 
	 * Triple - three equal dice (Example - 3,3,3,2,5) score constant is 20 
	 * Full house - a triple and a pair (Exaplme: 3,3,3,2,2) score constant is 25
	 * Straight - a sequence of dice (possibilities: 1,2,3,4,5 or 2,3,4,5,6) score constant is 30 
	 * Four of a kind - four dice with equal number (Example - 4,4,4,4,2) score constant is 40 
	 * Generala - five dice with the same number (Example: 6,6,6,6,6) score constant is 50
	 * 
	 * Score calculation example: 3,3,3,4,5 - Triple - score is 3+3+3+20 = 29.
	 * 
	 * When a player rolls his dice, they can form more than one combination, in
	 * this case the one having the biggest score is picked.
	 * 
	 * A player can record score from each combination only once during a game. 
	 * For example: the dice
	 * numbers 3,3,4,2,4 form the following combinations a Pair with 16 points, a
	 * Pair with 18 points and a Double pair with 29 points, so the Double pair is
	 * picked and 29 points are added to the players score. If the player has used
	 * this combination previously the Pair with 18 is picked, and if the player has
	 * also used Pair he doesn't have a new combination to pick so he doesn't take
	 * points for that roll. Whenever a player scores Generala he automatically wins
	 * the game. If nobody scores Generala the winner is the one with the best
	 * score.
	 * 
	 * 
	 */

	public static void main(String[] args) {

		GeneralaGame game = SingeletonGeneralaGame.getInstanceOfGame();
		game.gameStageLogicAndFlow();
		
	}

}
