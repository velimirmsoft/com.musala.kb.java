package com.musala.kb.dice.rolling.imp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.musala.kb.dice.rolling.DiceRollingGameMultiplayer;
import com.musala.kb.ultils.MapUtilis;

public class DiceRollingGameMultiplayerImp implements DiceRollingGameMultiplayer {

	/*
	 * Part II
	 * 
	 * Modify the DiceRolling program so that now it simulates dice rolling game
	 * between a number of players.
	 * 
	 * Each game will have a number of rounds and each player will be throwing a
	 * number of dice. Players will also have names. The user enters all the
	 * information (number of players, rounds, dice and names of the players)
	 * through the console
	 * 
	 * Add a method which returns the player with the highest score after the game
	 * has finished
	 * 
	 */

	private int players = 0;
	private int rounds = 0;
	// I am using map within a map -> ID <Name, Score>
	private Map<Integer, Map<String, Integer>> mapNameAndScore = new HashMap<Integer, Map<String, Integer>>();
	private int howMuchDicesToRoll = 0;

	@Override
	public int getPlayers() {
		return players;
	}

	@Override
	public void setPlayers(int players) {
		this.players = players;
	}

	@Override
	public int getRounds() {
		return rounds;
	}

	@Override
	public void setRounds(int rounds) {
		this.rounds = rounds;
	}

	@Override
	public int getHowMuchDicesToRoll() {
		return howMuchDicesToRoll;
	}

	@Override
	public void setHowMuchDicesToRoll(int howMuchDicesToRoll) {
		this.howMuchDicesToRoll = howMuchDicesToRoll;
	}

	@Override
	public Map<Integer, Map<String, Integer>> getMapNameAndScore() {
		return mapNameAndScore;
	}

	@Override
	public void setMapNameAndScore(Map<Integer, Map<String, Integer>> mapNameAndScore) {
		this.mapNameAndScore = mapNameAndScore;
	}

	@Override
	public int getHighscorePlayer() {
		Map<Integer, Map<String, Integer>> rMap = MapUtilis.sortByValue(mapNameAndScore);
		System.out.println("");
		System.out.println("----------------------------------------");
		System.out.println("Highscore ID = " + rMap.keySet().toArray()[0]);
		System.out.println("Highscore value = " + rMap.values().toArray()[0]);
		System.out.println("----------------------------------------");
		return 1;
	}

	@Override
	public int initPutPlayer(int id, String name) {
		Map<Integer, Map<String, Integer>> playersTable = getMapNameAndScore();
		Map<String, Integer> data = new HashMap<String, Integer>();
		data.put("" + name, 0);
		playersTable.put(id, data);
		setMapNameAndScore(playersTable);
		return playersTable.get(id).get(name);
	}

	@Override
	public int updatePlayerScore(int id, String playerName, int rolledTotal) {
		Map<Integer, Map<String, Integer>> playersTable = getMapNameAndScore();
		Map<String, Integer> previousdata = playersTable.get(id);
		Map<String, Integer> data = new HashMap<String, Integer>();
		data.put("" + playerName, previousdata.get(playerName) + rolledTotal);
		playersTable.put(id, data);
		return playersTable.get(id).get(playerName);
	}

	@Override
	public int gameStageLogicAndFlow(Scanner s) {

		s = null;
		
		try {
			
			s = new Scanner(System.in);

			System.out.println("----------------------------------------");
			System.out.println("Welcome to DiceRollingMultiplayer ...");
			System.out.println("----------------------------------------");
			System.out.println("");
			
			// input number of players
			System.out.println("Enter the number of players : ");
			String input = s.nextLine();
			System.out.println("" + input);
			if (input.matches("[0-9]+")) {
				setPlayers(Integer.parseInt(input));
			} else {
				s.close();
				return -1;
			}

			// input rounds
			System.out.println("Enter the rounds : ");
			input = s.nextLine();
			System.out.println("" + input);
			if (input.matches("[0-9]+")) {
				setRounds(Integer.parseInt(input));
			} else {
				s.close();
				return -1;
			}

			// input dices to roll
			System.out.println("Enter the number dice to roll per player : ");
			input = s.nextLine();
			System.out.println("" + input);
			if (input.matches("[0-9]+")) {
				setHowMuchDicesToRoll(Integer.parseInt(input));
			} else {
				s.close();
				return -1;
			}

			// enter players names
			System.out.println("Enter the PLAYERs names ... ");
			for (int i = 0; i < getPlayers(); i++) {
				System.out.println("Player : " + (i + 1));
				input = s.nextLine();
				System.out.println("" + input);
				initPutPlayer((i + 1), input);
			}

			// PLAY THE GAME

			System.out.println("");
			System.out.println("----------------------------------------");
			System.out.println("GAME STARTS ... ");
			System.out.println("----------------------------------------");
			System.out.println("----------------------------------------");
			System.out.println("----------------------------------------");

			DiceRollingImp diceRoll = new DiceRollingImp();
			for (int i = 0; i < getRounds(); i++) {
				System.out.println("");
				System.out.println("Round : " + (i + 1) + " ... ");

				for (int k = 0; k < getPlayers(); k++) {

					Map<Integer, Map<String, Integer>> playersTable = getMapNameAndScore();
					Map<String, Integer> player = playersTable.get((k + 1));
					String playerName = player.keySet().iterator().next();

					System.out.println("");
					System.out.println(
							"Player : " + (k + 1) + ". " + playerName + " -> roll your dice -> type 'roll' ... ");

					int totalRolledForPlayer = 0;
					for (int j = 0; j < getHowMuchDicesToRoll(); j++) {
						input = s.nextLine();
						if ((input.equals("roll"))) {
							int roll = diceRoll.rollDice();
							totalRolledForPlayer = totalRolledForPlayer + roll;
							System.out.println("Roll number : " + (j + 1) + " and you rolled = " + roll + ".");
						}
					}
					System.out.println("TotalRolled in this round = " + totalRolledForPlayer + ".");
					updatePlayerScore((k + 1), player.keySet().iterator().next(), totalRolledForPlayer);

				}
			}

			// get winner
			getHighscorePlayer();

			s.close();

			return 1;

		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			s.close();
		}

	}

}
