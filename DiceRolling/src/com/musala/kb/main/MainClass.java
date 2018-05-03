package com.musala.kb.main;

import java.util.Scanner;

import com.musala.kb.dice.rolling.ContextDiceRolling;
import com.musala.kb.dice.rolling.DiceRolling_1;
import com.musala.kb.dice.rolling.DiceRolling_2;

public class MainClass {

	/*
	 * 
	 * Write a program that simulates rolling a pair of dice.
	 * 
	 * You can simulate rolling one die by choosing one of the integers 1, 2, 3, 4,
	 * 5, or 6 at random. The number you pick represents the number on the die after
	 * it is rolled. The expression
	 * 
	 * (int)(Math.random()*6) + 1
	 * 
	 * does the computation you need to select a random integer between 1 and 6. You
	 * can assign this value to a variable to represent one of the dice that are
	 * being rolled. Do this twice and add the results together to get the total
	 * roll. Your program should report the number showing on each die as well as
	 * the total roll. For example: The first die comes up 3 and the second die
	 * comes up 5 Your total roll is 8.
	 * 
	 * (Note: The word "dice" is a plural, as in "two dice." The singular is "die.")
	 * 
	 */

	public static void main(String[] args) {

		ContextDiceRolling contextDiceRolling_1 = new ContextDiceRolling();
		contextDiceRolling_1.setDiceRollingImplementation(new DiceRolling_1());

		ContextDiceRolling contextDiceRolling_2 = new ContextDiceRolling();
		contextDiceRolling_2.setDiceRollingImplementation(new DiceRolling_2());

		Scanner s = new Scanner(System.in);

		System.out.println("Rolling dices ... ");
		while ((s.nextLine()).equals("roll")) {
			int diceOne = contextDiceRolling_1.rollTheDice();
			int diceTwo = contextDiceRolling_2.rollTheDice();
			int total = diceTwo + diceOne;
			System.out.format(
					"The first die comes up %d and the second die comes up %d \r\n" + "Your total roll is %d \r\n",
					diceOne, diceTwo, total);
		}

		s.close();

	}

}
