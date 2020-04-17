package com.rapps.games.uno.pile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rapps.games.uno.Players;
import com.rapps.games.uno.cards.Card;
import com.rapps.games.uno.cards.Color;

public class Hand {

	private static Map<String, List<Card>> hand = null;

	public static void initilizeHand() {
		System.out.println("Initilizing Hand");
		hand = new HashMap<>();
		List<String> names = Players.getPlayersList();
		for (String name : names) {
			hand.put(name, new ArrayList<Card>());
		}
	}

	public static void drawCard(String player, Card card) {
		List<Card> cards = hand.get(player);
		cards.add(card);
		// System.out.println("Hand : " + hand.get(player));
		hand.put(player, cards);
	}

	public static List<Card> getPlayersHand(String player) {
		// System.out.println("Hand : " + hand.get(player));
		return hand.get(player);
	}

	public static void removeCard(String player, Card card) {
		List<Card> cards = hand.get(player);
		cards.remove(card);
		// System.out.println("Hand : " + hand.get(player));
		hand.put(player, cards);
	}

	public static Color checkHandForMaxColor(String player) {
		for (Card card : hand.get(player)) {
			if (card.getColor() != Color.WILD) {
				return card.getColor();
			}
		}
		return Color.RED;
	}

	public static int getPointsAtHand(String player) {
		int total = 0;
		for (Card card : hand.get(player)) {
			total = total + card.getPoints().getPoints();
		}
		return total;
	}
}
