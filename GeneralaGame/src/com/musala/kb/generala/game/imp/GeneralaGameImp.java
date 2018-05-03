package com.musala.kb.generala.game.imp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.musala.kb.generala.game.GeneralaGame;
import com.musala.kb.ultils.MapUtilis;

public class GeneralaGameImp implements GeneralaGame {

	// variables

	private int players = 0;
	private int rounds = 0;
	// list of objects that are handling rolls of players
	private ArrayList<HandleRollsCombinationsImp> playersObjects = new ArrayList<HandleRollsCombinationsImp>();

	// I am using map within a map -> ID <Name, Score>
	private Map<Integer, Map<String, Integer>> mapIdNameScore = new HashMap<Integer, Map<String, Integer>>();

	// getter and setters
	// getter and setters
	// getter and setters

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
	public Map<Integer, Map<String, Integer>> getMapIdNameScore() {
		return mapIdNameScore;
	}

	@Override
	public void setMapIdNameScore(Map<Integer, Map<String, Integer>> mapNameAndScore) {
		this.mapIdNameScore = mapNameAndScore;
	}

	// getter and setters
	// getter and setters
	// getter and setters

	@Override
	public boolean initPutPlayer(int id, String name, Map<Integer, Map<String, Integer>> playersTable) {
		if (id < 0 || name.length() > 20) {
			return false;
		} else {
			Map<String, Integer> data = new HashMap<String, Integer>();
			data.put("" + name, 0);
			playersTable.put(id, data);
			setMapIdNameScore(playersTable);
			// return status of the update player status
			return (playersTable.get(id) != null);
		}
	}

	@Override
	public boolean updatePlayerScore(int id, String playerName, int rolledTotal,
			Map<Integer, Map<String, Integer>> playersTable) {
		if (id < 0 || playerName.length() > 20 || rolledTotal < 0) {
			return false;
		} else {
			Map<String, Integer> previousdata = playersTable.get(id);
			Map<String, Integer> dataNew = new HashMap<String, Integer>();
			if (previousdata == null) {
				return false;
			}
			dataNew.put("" + playerName, previousdata.get(playerName) + rolledTotal);
			playersTable.put(id, dataNew);
			setMapIdNameScore(playersTable);
			return (previousdata.get(playerName) + rolledTotal == dataNew.get(playerName));
		}
	}

	@Override
	public String getHighscorePlayer(Map<Integer, Map<String, Integer>> playersTable) {
		Map<Integer, Map<String, Integer>> rMap = MapUtilis.sortByValueOfInnerMap(playersTable);
		return "" + rMap.keySet().toArray()[0] + "*" + rMap.values().toArray()[0];
	}

	@Override
	public int gameStageLogicAndFlow() {

		Scanner s = null;

		try {

			s = new Scanner(System.in);
			String input = "";

			System.out.println("----------------------------------------");
			System.out.println("Welcome to GeneralaGame ...");
			System.out.println("----------------------------------------");
			System.out.println("");

			// input number of players
			inputNumberOfPlayers(s);

			// enter players names
			System.out.println("Enter the PLAYERs names ... ");
			for (int i = 0; i < getPlayers(); i++) {
				System.out.println("Player : " + (i + 1));
				input = s.nextLine();
				initPutPlayer((i + 1), input, getMapIdNameScore());
				// add object for the the player
				playersObjects.add(new HandleRollsCombinationsImp());
			}

			// input rounds
			System.out.println("Enter the rounds : ");
			input = s.nextLine();
			if (input.matches("[0-9]+")) {
				setRounds(Integer.parseInt(input));
			} else {
				return -1;
			}

			// PLAY THE GAME

			System.out.println("");
			System.out.println("----------------------------------------");
			System.out.println("GAME STARTS ... ");
			System.out.println("----------------------------------------");
			System.out.println("----------------------------------------");
			System.out.println("----------------------------------------");

			// dice to roll
			DiceRollingImp diceRoll = new DiceRollingImp();

			boolean generalaDetected = false;
			int generalaPlayerId = 0;
			for (int i = 0; i < getRounds(); i++) {
				System.out.println("");
				System.out.println("Round : " + (i + 1) + " ... ");

				for (int k = 0; k < getPlayers(); k++) {

					// every player has ID, and it stays the same as putted in the map
					Map<Integer, Map<String, Integer>> playersTable = getMapIdNameScore();
					Map<String, Integer> player = playersTable.get((k + 1));
					String playerName = player.keySet().iterator().next();

					System.out.println("");
					System.out.println("Player : " + (k + 1) + ". " + playerName + " -> rolling your dice ... ");

					// here we roll 5 dice for each player in a round
					int[] rolledArray = new int[5];
					int combinationConstantToAdd = 0;
					for (int j = 0; j < howMuchDiceToRoll; j++) {
						int roll = diceRoll.rollDice();
						rolledArray[j] = roll;
					}

					System.out.println("Your rolls : " + Arrays.toString(rolledArray));
					HandleRollsCombinationsImp playerCombos = playersObjects.get((k));
					combinationConstantToAdd = playerCombos.handleRollsCombinations(rolledArray);

					// if generala - end the game
					if (combinationConstantToAdd == 50) {
						generalaDetected = true;
						generalaPlayerId = (k + 1);
						break;
					}

					System.out.println("TotalRolled in this round = " + (combinationConstantToAdd) + ".");

					// update the player score in the map score board
					updatePlayerScore((k + 1), player.keySet().iterator().next(), (combinationConstantToAdd),
							getMapIdNameScore());

				}

				if (generalaDetected) {
					break;
				}

			}

			if (!generalaDetected) {
				// get winner
				System.out.println("");
				System.out.println("----------------------------------------");
				System.out.println(getHighscorePlayer(getMapIdNameScore()));
				System.out.println("----------------------------------------");
			} else {
				// update the player score in the map score board
				System.out.println("PLAYER WITH ID = " + generalaPlayerId + " scored GENERALA - game over!");
			}

			return 1;

		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			s.close();
		}

	}

	public int inputNumberOfPlayers(Scanner s) {
		// input number of players
		System.out.println("Enter the number of players : ");
		String input = s.nextLine();
		if (input.matches("[0-9]+")) {
			setPlayers(Integer.parseInt(input));
		} else {
			return -1;
		}
		return 1;
	}

}
