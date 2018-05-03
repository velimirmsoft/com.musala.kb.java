package com.musala.kb.dice.rolling.imp.test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import com.musala.kb.dice.rolling.DiceRollingGameMultiplayer;
import com.musala.kb.dice.rolling.imp.DiceRollingGameMultiplayerImp;

class DiceRollingGameMultiplayerImpTest {

	@Test
	void testGetHighscorePlayer() {

		DiceRollingGameMultiplayer game = new DiceRollingGameMultiplayerImp();
		
		game.initPutPlayer(0, "welle");
		game.initPutPlayer(1, "zzzzz");
		game.initPutPlayer(2, "pffff");
		
		Assert.assertEquals(1, game.getHighscorePlayer());

	}

	@Test
	void testInitPutPlayer() {

		DiceRollingGameMultiplayer game = new DiceRollingGameMultiplayerImp();
		Assert.assertEquals(0, game.initPutPlayer(0, "welle"));

	}

	@Test
	void testUpdatePlayerScore() {

		DiceRollingGameMultiplayer game = new DiceRollingGameMultiplayerImp();
		
		game.initPutPlayer(0, "welle");
		game.initPutPlayer(1, "zzzzz");
		game.initPutPlayer(2, "pffff");
		
		Assert.assertEquals(100, game.updatePlayerScore(0, "welle", 100));

	}
	
	@Test
	void testGameStageLogicAndFlow() {
		
		DiceRollingGameMultiplayer game = new DiceRollingGameMultiplayerImp();
		
		String input = "2\n" + "1\n" + "2\n" + "welle\n" + "ivana\n" + "roll\n" + "roll\n" + "roll\n" + "roll";
	    InputStream in = new ByteArrayInputStream(input.getBytes());
	    System.setIn(in);
		
		game.gameStageLogicAndFlow(new Scanner(System.in));
		
	}

}
