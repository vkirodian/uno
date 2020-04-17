package com.rapps.games.uno.pile;

import java.util.Collections;
import java.util.Stack;

import com.rapps.games.uno.Players;
import com.rapps.games.uno.cards.Card;
import com.rapps.games.uno.cards.Color;
import com.rapps.games.uno.cards.Numbers;
import com.rapps.games.uno.cards.Special;
import com.rapps.games.uno.cards.Wild;
import com.rapps.games.uno.cards.ZeroNumbers;

public class Deck {

	private static Stack<Card> deck = new Stack<Card>();

	public static void prepareGame() {
		distribute(shuffleDeck(prepareDeck()));
		drawFirstCard();
	}

	private static Stack<Card> prepareDeck() {
		System.out.println("Preparing Deck");
		for (Color c : Color.values()) {

			if (Color.WILD != c) {
				for (ZeroNumbers z : ZeroNumbers.values()) {
					deck.push(new Card(c, z));
				}

				for (Numbers n : Numbers.values()) {
					deck.push(new Card(c, n));
				}

				for (Special s : Special.values()) {
					deck.push(new Card(c, s));
				}
			} else {
				for (Wild w : Wild.values()) {
					deck.push(new Card(c, w));
				}
			}
		}
		// check(deck);
		return deck;
	}

	private static Stack<Card> shuffleDeck(Stack<Card> deck) {
		System.out.println("Shuffling Deck");
		Collections.shuffle(deck);
		// check(deck);
		return deck;
	}

	private static void distribute(Stack<Card> deck) {
		Hand.initilizeHand();
		System.out.println("Distributing Cards");
		int count = 7 * Players.getPlayersList().size();
		for (int i = 0; i < count; i++)
			Hand.drawCard(Players.currentPlayer(), deck.pop());
	}

	public static void drawFirstCard() {
		Card firstCard = deck.pop();
		firstCard.setActive(true);
		if (firstCard.getColor() == Color.WILD) {
			firstCard.setWildColor(Color.RED);
		}
		DiscardPile.throwCard(firstCard);
	}

	public static Stack<Card> getDeck() {
		if (deck.size() == 0) {
			System.out.println("Main Deck empty");
		}
		return deck;
	}

	private static void check(Stack<Card> deck) {
		System.out.println("Checking cards");
		for (Card c : deck) {
			System.out.println(c);
		}
	}
}
