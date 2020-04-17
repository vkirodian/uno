package com.rapps.games.uno;

import com.rapps.games.uno.pile.Deck;

public class UnoLauncher {

	public static void main(String[] args) {
		System.out.println("Starting Game");
		boolean winner = false;
		Players.onBoardPlayers();
		while (!winner) {
			Deck.prepareGame();
			System.out.println("***************Start Playing*****************");
			boolean play = true;
			while (play) {
				play = Play.play();
			}
			winner = Players.checkWinner(500);
			HumanPlayer.requestAction();
		}
	}

}
