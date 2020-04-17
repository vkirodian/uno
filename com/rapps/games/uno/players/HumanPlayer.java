package com.rapps.games.uno.players;

import java.util.List;
import java.util.Scanner;

import com.rapps.games.uno.cards.Card;
import com.rapps.games.uno.cards.Color;
import com.rapps.games.uno.pile.Hand;

public class HumanPlayer {

	public static Card play(Card topCard) {
		System.out.println("You turn, select a card to play or press 0 to pass/draw.");
		List<Card> cards = Hand.getPlayersHand("You");
		int i = 1;
		for (Card card : cards) {
			System.out.println(i + " " + card);
			i++;
		}
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		if (input == 0) {
			return null;
		}
		input--;
		Card playedCard = cards.get(input);
		if (playedCard.getColor() == Color.WILD
				|| (topCard.getColor() == Color.WILD && topCard.getWildColor() == playedCard.getColor())
				|| topCard.getPoints().getPoints() == playedCard.getPoints().getPoints()
				|| (topCard.getColor() != Color.WILD && topCard.getColor() == playedCard.getColor())) {
			return playedCard;
		} else {
			System.out.println("(/) Invalid Card (/)");
			System.out.println("TOP CARD : " + topCard);
			return play(topCard);
		}

	}

	public static Color getWildColor() {
		System.out.println("Enter Wild Color");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		switch (input) {
		case "B":
			return Color.BLUE;
		case "G":
			return Color.GREEN;
		case "Y":
			return Color.YELLO;
		default:
			return Color.RED;
		}
	}

	public static void requestAction() {
		System.out.println("Press Enter to continue");
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
	}
}
