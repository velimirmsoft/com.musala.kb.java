package com.musala.kb.generala.game.test;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.musala.kb.generala.game.imp.HandleRollsCombinationsImp;

class HandleRollsCombinationsTest {

	@Test
	void testHandleRollsCombinations() {

		HandleRollsCombinationsImp handleRolls = new HandleRollsCombinationsImp();

		int[] rolls1 = { 1, 1, 1, 1, 1 };
		Assert.assertEquals("Generala test passed!", 50, handleRolls.handleRollsCombinations(rolls1));

		int[] rolls2 = { 1, 1, 1, 1, 2 };
		Assert.assertEquals("FourOfAKind test passed!", 44, handleRolls.handleRollsCombinations(rolls2));

		int[] rolls3 = { 1, 2, 3, 4, 5 };
		Assert.assertEquals("Staight test passed!", 44, handleRolls.handleRollsCombinations(rolls3));

		int[] rolls4 = { 1, 1, 1, 2, 2 };
		Assert.assertEquals("FullHouse test passed!", 32, handleRolls.handleRollsCombinations(rolls4));

		int[] rolls5 = { 1, 1, 1, 4, 2 };
		Assert.assertEquals("Triple test passed!", 23, handleRolls.handleRollsCombinations(rolls5));

		int[] rolls6 = { 1, 1, 6, 2, 2 };
		Assert.assertEquals("DoublePair test passed!", 21, handleRolls.handleRollsCombinations(rolls6));

		int[] rolls7 = { 1, 1, 3, 5, 2 };
		Assert.assertEquals("Pair test passed!", 12, handleRolls.handleRollsCombinations(rolls7));

	}

}
