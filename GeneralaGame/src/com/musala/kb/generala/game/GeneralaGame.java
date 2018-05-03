package com.musala.kb.generala.game;

import java.util.Map;

public interface GeneralaGame {

	public static final int howMuchDiceToRoll = 5;

	// getter and setters 
	// getter and setters 
	// getter and setters 
	
	public int getPlayers();

	public void setPlayers(int players);

	public int getRounds();

	public void setRounds(int rounds);

	// I am using map within a map -> ID <Name, Score>
	public Map<Integer, Map<String, Integer>> getMapIdNameScore();

	public void setMapIdNameScore(Map<Integer, Map<String, Integer>> mapIdNameScore);
	
	// getter and setters 
	// getter and setters 
	// getter and setters 

	public boolean initPutPlayer(int id, String name, Map<Integer, Map<String, Integer>> playersTable);

	public boolean updatePlayerScore(int id, String playerName, int rolledTotal, Map<Integer, Map<String, Integer>> playersTable);

	public String getHighscorePlayer(Map<Integer, Map<String, Integer>> fromMapIdNameScore);

	// main method leading the game ...
	
	public int gameStageLogicAndFlow();

}
