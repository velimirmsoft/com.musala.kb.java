package com.musala.kb.generala.game.test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.musala.kb.generala.game.imp.GeneralaGameImp;

class GeneralaGameTest {

	@Test
	void testInitPutPlayer() {
		GeneralaGameImp game = new GeneralaGameImp();

		// create test user and map
		Map<Integer, Map<String, Integer>> testMap = new HashMap<Integer, Map<String, Integer>>();

		Map<String, Integer> player_1 = new HashMap<String, Integer>();
		player_1.put("player_1", 50);
		testMap.put(0, player_1);

		Map<String, Integer> player_2 = new HashMap<String, Integer>();
		player_2.put("player_2", 55);
		testMap.put(1, player_2);

		Assert.assertTrue("Should init player in DB.", game.initPutPlayer(0, "testUser", testMap));
		Assert.assertTrue("Should fail and return FALSE.", !(game.initPutPlayer(-1, "testUser", testMap)));
		Assert.assertTrue("Should fail and return FALSE.",
				!(game.initPutPlayer(5, "testUserrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr", testMap)));
	}

	@Test
	void testUpdatePlayerScore() {
		GeneralaGameImp game = new GeneralaGameImp();

		// create test user and map
		Map<Integer, Map<String, Integer>> testMap = new HashMap<Integer, Map<String, Integer>>();

		Assert.assertTrue("invalid parametars fail",
				!(game.updatePlayerScore(0, "testUserrrrrrrrrrrrrrrrrrrrrrrrrr", 20, testMap)));

		// should fail, there is no user 'testUser'
		Assert.assertTrue("Cool, this should pass.", !(game.updatePlayerScore(0, "testUser", 20, testMap)));

		Map<String, Integer> player_1 = new HashMap<String, Integer>();
		player_1.put("player_1", 50);
		testMap.put(0, player_1);

		Map<String, Integer> player_2 = new HashMap<String, Integer>();
		player_2.put("player_2", 55);
		testMap.put(1, player_2);

		Assert.assertTrue("Cool, this should pass.", (game.updatePlayerScore(1, "player_2", 20, testMap)));

	}

	@Test
	void testGetHighscorePlayer() {
		GeneralaGameImp game = new GeneralaGameImp();

		// create test user and map
		Map<Integer, Map<String, Integer>> testMap = new HashMap<Integer, Map<String, Integer>>();

		Map<String, Integer> player_1 = new HashMap<String, Integer>();
		player_1.put("player_1", 50);
		testMap.put(0, player_1);

		Map<String, Integer> player_2 = new HashMap<String, Integer>();
		player_2.put("player_2", 55);
		testMap.put(1, player_2);

		Map<String, Integer> player_3 = new HashMap<String, Integer>();
		player_3.put("player_3", 155);
		testMap.put(2, player_3);

		Map<String, Integer> player_4 = new HashMap<String, Integer>();
		player_4.put("player_4", 5);
		testMap.put(3, player_4);

		Assert.assertEquals("2*{player_3=155}", game.getHighscorePlayer(testMap));
	}

	@Test
	void testInputNumberOfPlayers() {

		GeneralaGameImp game = new GeneralaGameImp();

		String input = "3";
		InputStream in = new ByteArrayInputStream(input.getBytes());
		Assert.assertEquals(1, game.inputNumberOfPlayers(new Scanner(in)));

		input = "-4";
		in = new ByteArrayInputStream(input.getBytes());
		System.setIn(in);

		Assert.assertEquals(-1, game.inputNumberOfPlayers(new Scanner(System.in)));

	}

}
