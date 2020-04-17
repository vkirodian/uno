package com.rapps.games.uno.pile;

import java.util.Stack;

import com.rapps.games.uno.cards.Card;

public class DiscardPile {

	private static Stack<Card> discardPile = new Stack<Card>();

	public static void throwCard(Card card) {
		discardPile.push(card);
		//System.out.println("TOP CARD : " + card);
	}

	public static Card getTopCard() {
		Card card = discardPile.peek();
		System.out.println("TOP CARD : " + card);// + ", Active : " + card.isActive());
		if (card.getWildColor() != null) {
			System.out.println(" Wild Color : " + card.getWildColor());
		}
		return card;
	}

}
