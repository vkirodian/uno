package com.rapps.games.uno.players;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Players {

	private static List<String> name = new ArrayList<>();
	private static Map<String, Integer> pointsMap = new HashMap<>();
	private static int currentIndex = 0;

	public static void onBoardPlayers() {
		System.out.println("Hard Coded Players Onboarding");
		name.add("Ace");
		name.add("Boss");
		name.add("Champion");
		name.add("You");

		pointsMap.put("Ace", 0);
		pointsMap.put("Boss", 0);
		pointsMap.put("Champion", 0);
		pointsMap.put("You", 0);
	}

	public static List<String> getPlayersList() {
		return name;
	}

	public static String currentPlayer() {
		if (currentIndex >= name.size()) {
			currentIndex = 0;
		}
		String n = name.get(currentIndex);
		System.out.println("Current Player : " + n);
		currentIndex++;
		return n;
	}

	public static void skipPlayer() {
		currentPlayer();
	}

	public static void reverse(String player) {
		Collections.reverse(name);
		int newIndex = name.indexOf(player);
		currentIndex = newIndex;
	}

	public static void addPoints(String player, int points) {
		int totalPoints = pointsMap.get(player) + points;
		pointsMap.put(player, totalPoints);
	}

	public static boolean checkWinner(int winningPoints) {
		boolean result = false;
		for (String player : pointsMap.keySet()) {
			System.out.println(player + "\t" + pointsMap.get(player));
			if(pointsMap.get(player) >= winningPoints) {
				result = true;
			}
		}
		return result;
	}
}
