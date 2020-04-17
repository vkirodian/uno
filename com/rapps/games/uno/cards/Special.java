package com.rapps.games.uno.cards;

public enum Special implements Points {

	DRAWTWO1(25), DRAWTWO2(25), REVERSE1(15), REVERSE2(15), SKIP1(20), SKIP2(20);

	int points;

	private Special(int points) {
		this.points = points;
	}

	@Override
	public int getPoints() {
		return points;
	}
}
