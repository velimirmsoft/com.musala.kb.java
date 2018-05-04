package com.musala.kb.dice.rolling;

import java.util.Map;
import java.util.Scanner;

public interface DiceRollingGameMultiplayer {

	public int getPlayers();
	public void setPlayers(int players);

	public int getRounds();
	public void setRounds(int rounds);

	public int getHowMuchDicesToRoll();
	public void setHowMuchDicesToRoll(int howMuchDicesToRoll);

	// I am using map within a map -> ID <Name, Score>
	public Map<Integer, Map<String, Integer>> getMapNameAndScore();
	public void setMapNameAndScore(Map<Integer, Map<String, Integer>> mapNameAndScore);

	public int initPutPlayer(int id, String name);
	public int updatePlayerScore(int id, String playerName, int rolledTotal);
	public int getHighscorePlayer();

	public void gameStageLogicAndFlow(Scanner s);

}
