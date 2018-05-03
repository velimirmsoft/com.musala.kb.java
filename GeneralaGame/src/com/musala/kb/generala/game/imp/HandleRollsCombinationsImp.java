package com.musala.kb.generala.game.imp;

import com.musala.kb.generala.game.HandleRollsCombination;

public class HandleRollsCombinationsImp implements HandleRollsCombination {

	public int[] combinationPriviouslyChecked = { 0, 0, 0, 0, 0, 0, 0 };
	private int sumOfSelectedCombination = 0;

	@Override
	public int handleRollsCombinations(int[] rolls) {

		int pointsToReturn = 0;
		sumOfSelectedCombination = 0;

		// combinationPriviouslyChecked -> 0s and 1s
		// 0 - pair
		// 1 - double pair
		// 2 - triple
		// 3 - full house
		// 4 - straight
		// 5 - four of a kind
		// 6 - generala

		// iterate though rolls and check for combinations start from the Generala ->
		// ... -> Pair
		// we start from the back couse they have priority in the combinations

		if (isGenerala(rolls)) {
			pointsToReturn = 50;
			System.out.println("Generala!");
		} else if ((combinationPriviouslyChecked[5] == 0) && isFourOfAKind(rolls)) {
			pointsToReturn = 40;
			combinationPriviouslyChecked[5] = 1;
			System.out.println("FourOfAKind!");
		} else if ((combinationPriviouslyChecked[4] == 0) && isStraight(rolls)) {
			pointsToReturn = 30;
			combinationPriviouslyChecked[4] = 1;
			System.out.println("Staight!");
		} else if ((combinationPriviouslyChecked[3] == 0) && isFullHouse(rolls)) {
			pointsToReturn = 25;
			combinationPriviouslyChecked[3] = 1;
			System.out.println("FullHouse!");
		} else if ((combinationPriviouslyChecked[2] == 0) && isTriple(rolls)) {
			pointsToReturn = 20;
			combinationPriviouslyChecked[2] = 1;
			System.out.println("Triple!");
		} else if ((combinationPriviouslyChecked[1] == 0) && isDoublePair(rolls)) {
			pointsToReturn = 15;
			combinationPriviouslyChecked[1] = 1;
			System.out.println("DoublePair!");
		} else if ((combinationPriviouslyChecked[0] == 0) && isPair(rolls)) {
			pointsToReturn = 10;
			combinationPriviouslyChecked[0] = 1;
			System.out.println("Pair!");
		}

		return sumOfSelectedCombination + pointsToReturn;
	}

	@Override
	public boolean isGenerala(int[] rolls) {
		int previousRoll = rolls[0];
		boolean isGenerala = false;
		for (int i = 0; i < rolls.length - 1; i++) {
			if (previousRoll == rolls[i + 1]) {
				isGenerala = true;
				previousRoll = rolls[i + 1];
			} else {
				isGenerala = false;
				break;
			}
		}
		return isGenerala;
	}

	@Override
	public boolean isFourOfAKind(int[] rolls) {

		sumOfSelectedCombination = 0;

		boolean isFourOfAKind = false;

		// sort in one direction
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (rolls[i] < rolls[j]) {
					int temp = rolls[j];
					rolls[j] = rolls[i];
					rolls[i] = temp;
				}
			}
		}
		// System.out.println("Your sorted rolls : " + Arrays.toString(rolls));

		if (rolls[0] == rolls[1] && rolls[1] == rolls[2] && rolls[2] == rolls[3]) {
			isFourOfAKind = true;
			sumOfSelectedCombination = rolls[0] + rolls[1] + rolls[2] + rolls[3];
			return isFourOfAKind;
		} else {
			isFourOfAKind = false;
		}

		if (rolls[4] == rolls[3] && rolls[3] == rolls[2] && rolls[2] == rolls[1]) {
			isFourOfAKind = true;
			sumOfSelectedCombination = rolls[4] + rolls[3] + rolls[2] + rolls[1];
			return isFourOfAKind;
		} else {
			isFourOfAKind = false;
		}

		return isFourOfAKind;
	}

	@Override
	public boolean isStraight(int[] rolls) {
		boolean isStraight = false;

		sumOfSelectedCombination = 0;

		// sort in one direction
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (rolls[i] < rolls[j]) {
					int temp = rolls[j];
					rolls[j] = rolls[i];
					rolls[i] = temp;
				}
			}
		}
		// System.out.println("Your sorted rolls : " + Arrays.toString(rolls));

		int previousRoll = rolls[0];
		for (int i = 0; i < rolls.length - 1; i++) {
			if (previousRoll == rolls[i + 1] - 1) {
				isStraight = true;
				previousRoll = rolls[i + 1];
				sumOfSelectedCombination = sumOfSelectedCombination + previousRoll;
			} else {
				isStraight = false;
				break;
			}
		}
		return isStraight;
	}

	@Override
	public boolean isFullHouse(int[] rolls) {

		boolean isFullHouse = false;

		sumOfSelectedCombination = 0;

		// sort in one direction
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (rolls[i] < rolls[j]) {
					int temp = rolls[j];
					rolls[j] = rolls[i];
					rolls[i] = temp;
				}
			}
		}
		// System.out.println("Your sorted rolls : " + Arrays.toString(rolls));

		if ((rolls[0] == rolls[1] && rolls[1] == rolls[2]) && (rolls[3] == rolls[4])) {
			isFullHouse = true;
			sumOfSelectedCombination = rolls[0] + rolls[1] + rolls[2] + rolls[3] + rolls[4];
			return isFullHouse;
		} else {
			isFullHouse = false;
		}

		if ((rolls[4] == rolls[3] && rolls[3] == rolls[2]) && (rolls[1] == rolls[0])) {
			isFullHouse = true;
			sumOfSelectedCombination = rolls[4] + rolls[3] + rolls[2] + rolls[1] + rolls[0];
			return isFullHouse;
		} else {
			isFullHouse = false;
		}

		return isFullHouse;
	}

	@Override
	public boolean isTriple(int[] rolls) {

		sumOfSelectedCombination = 0;

		boolean isTriple = false;

		// sort in one direction
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (rolls[i] < rolls[j]) {
					int temp = rolls[j];
					rolls[j] = rolls[i];
					rolls[i] = temp;
				}
			}
		}
		// System.out.println("Your sorted rolls : " + Arrays.toString(rolls));

		// try with if statements since we have static 5 dice rolls

		if (rolls[0] == rolls[1] && rolls[1] == rolls[2]) {
			isTriple = true;
			sumOfSelectedCombination = rolls[0] + rolls[1] + rolls[2];
			return isTriple;
		} else {
			isTriple = false;
		}

		if (rolls[4] == rolls[3] && rolls[3] == rolls[2]) {
			isTriple = true;
			sumOfSelectedCombination = rolls[4] + rolls[3] + rolls[2];
			return isTriple;
		} else {
			isTriple = false;
		}

		if (rolls[1] == rolls[2] && rolls[2] == rolls[3]) {
			isTriple = true;
			sumOfSelectedCombination = rolls[1] + rolls[2] + rolls[3];
			return isTriple;
		} else {
			isTriple = false;
		}

		return isTriple;
	}

	@Override
	public boolean isDoublePair(int[] rolls) {

		sumOfSelectedCombination = 0;

		boolean isDoublePair = false;

		// sort in one direction
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (rolls[i] < rolls[j]) {
					int temp = rolls[j];
					rolls[j] = rolls[i];
					rolls[i] = temp;
				}
			}
		}
		// System.out.println("Your sorted rolls : " + Arrays.toString(rolls));

		// try with if statements since we have static 5 dice rolls

		if (rolls[0] == rolls[1] && rolls[2] == rolls[3]) {
			isDoublePair = true;
			sumOfSelectedCombination = rolls[0] + rolls[1] + rolls[2] + rolls[3];
			return isDoublePair;
		} else {
			isDoublePair = false;
		}

		if (rolls[0] == rolls[1] && rolls[3] == rolls[4]) {
			isDoublePair = true;
			sumOfSelectedCombination = rolls[0] + rolls[1] + rolls[3] + rolls[4];
			return isDoublePair;
		} else {
			isDoublePair = false;
		}

		if (rolls[1] == rolls[2] && rolls[3] == rolls[4]) {
			isDoublePair = true;
			sumOfSelectedCombination = rolls[1] + rolls[2] + rolls[3] + rolls[4];
			return isDoublePair;
		} else {
			isDoublePair = false;
		}

		return isDoublePair;
	}

	@Override
	public boolean isPair(int[] rolls) {

		sumOfSelectedCombination = 0;

		boolean isPair = false;

		// sort in one direction
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (rolls[i] < rolls[j]) {
					int temp = rolls[j];
					rolls[j] = rolls[i];
					rolls[i] = temp;
				}
			}
		}
		// System.out.println("Your sorted rolls : " + Arrays.toString(rolls));

		if (rolls[0] == rolls[1]) {
			isPair = true;
			sumOfSelectedCombination = rolls[0] + rolls[1];
			return isPair;
		} else {
			isPair = false;
		}

		if (rolls[1] == rolls[2]) {
			isPair = true;
			sumOfSelectedCombination = rolls[1] + rolls[2];
			return isPair;
		} else {
			isPair = false;
		}

		if (rolls[2] == rolls[3]) {
			isPair = true;
			sumOfSelectedCombination = rolls[2] + rolls[3];
			return isPair;
		} else {
			isPair = false;
		}

		if (rolls[4] == rolls[3]) {
			isPair = true;
			sumOfSelectedCombination = rolls[3] + rolls[4];
			return isPair;
		} else {
			isPair = false;
		}

		return isPair;
	}

}
