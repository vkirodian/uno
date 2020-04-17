package com.rapps.games.uno;

import java.util.List;

import com.rapps.games.uno.cards.Card;
import com.rapps.games.uno.cards.Color;
import com.rapps.games.uno.pile.Deck;
import com.rapps.games.uno.pile.DiscardPile;
import com.rapps.games.uno.pile.Hand;

public class Play {

	public static boolean play() {
		return playTurn(Players.currentPlayer());
	}

	private static boolean playTurn(String player) {
		Card topCard = checkTopOfDiscardPile();
		if (isAllowedToPlay(player, topCard)) {
			Card cardToPlay = player != "You" ? scanHighestCard(topCard, Hand.getPlayersHand(player))
					: HumanPlayer.play(topCard);
			if (cardToPlay == null) {
				System.out.println("No Cards to Play, Drawing Card");
				Hand.drawCard(player, Deck.getDeck().pop());
				cardToPlay = player != "You" ? scanHighestCard(topCard, Hand.getPlayersHand(player))
						: HumanPlayer.play(topCard);
				if (cardToPlay == null) {
					System.out.println("Passing Turn");
				}
			}
			if (cardToPlay != null) {
				// System.out.println("Throwing Card");
				if (cardToPlay.getColor() == Color.WILD) {
					cardToPlay.setWildColor(
							player != "You" ? Hand.checkHandForMaxColor(player) : HumanPlayer.getWildColor());
				}
				cardToPlay.setActive(true);
				DiscardPile.throwCard(cardToPlay);
				Hand.removeCard(player, cardToPlay);
			}
			if (isWinner(player)) {
				System.out.println("Winner is : " + player);
				calculatePoints(player);
				return false;
			}
		}
		return true;
	}

	public static Card checkTopOfDiscardPile() {
		return DiscardPile.getTopCard();
	}

	private static Card scanHighestCard(Card card, List<Card> cards) {
		// System.out.println("Scanning Highest Card");
		int highestPoint = 0;
		Card highestCard = null;
		Color color = card.getColor() != Color.WILD ? card.getColor() : card.getWildColor();
		int points = card.getPoints().getPoints();
		for (Card c : cards) {
			if (c.getColor() == Color.WILD) {
				highestCard = c;
				highestPoint = c.getPoints().getPoints();
				// System.out.println("Found Wild Card : " + c);
				break;
			}
			if (c.getPoints().getPoints() == points) {
				highestCard = c;
				highestPoint = c.getPoints().getPoints();
				// System.out.println("Found Card with Matching Points : " + c);
				break;
			}
		}
		if (highestCard == null || highestCard.getColor() != Color.WILD) {
			for (Card c : cards) {
				if (c.getColor() == color && c.getPoints().getPoints() >= highestPoint) {
					highestCard = c;
					highestPoint = c.getPoints().getPoints();
					// System.out.println("Found Card with Matching Color: " + c);
				}
			}
		}
		// System.out.println("Highest Card found : " + highestCard);
		return highestCard;
	}

	private static boolean isWinner(String player) {
		return (Hand.getPlayersHand(player).size() == 0);
	}

	private static boolean isAllowedToPlay(String player, Card topCard) {
		if (topCard.isActive()) {
			// System.out.println("Active card");
			int points = topCard.getPoints().getPoints();
			switch (points) {
			case 50:
				System.out.println("***Player Drawing 4***");
				if ("You".equals(player))
					HumanPlayer.requestAction();
				Hand.drawCard(player, Deck.getDeck().pop());
				Hand.drawCard(player, Deck.getDeck().pop());
				Hand.drawCard(player, Deck.getDeck().pop());
				Hand.drawCard(player, Deck.getDeck().pop());
				topCard.setActive(false);
				return false;
			case 40:
				// System.out.println("Wild Card");
				return true;
			case 25:
				System.out.println("***Player Drawing 2***");
				if ("You".equals(player))
					HumanPlayer.requestAction();
				Hand.drawCard(player, Deck.getDeck().pop());
				Hand.drawCard(player, Deck.getDeck().pop());
				topCard.setActive(false);
				return false;
			case 20:
				System.out.println("***Player Skipped***");
				if ("You".equals(player))
					HumanPlayer.requestAction();
				topCard.setActive(false);
				return false;
			case 15:
				System.out.println("***Player Reversed***");
				if ("You".equals(player))
					HumanPlayer.requestAction();
				Players.reverse(player);
				Players.currentPlayer();
				topCard.setActive(false);
				return false;
			}
		}
		return true;
	}

	public static void calculatePoints(String winningPlayer) {
		int points = 0;
		for (String player : Players.getPlayersList()) {
			points = points + Hand.getPointsAtHand(player);
		}
		System.out.println("Points Awarded");
		Players.addPoints(winningPlayer, points);
	}
}
