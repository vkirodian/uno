package com.rapps.games.uno.cards;

public enum ZeroNumbers implements Points {

	ZERO(0), ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9);

	int points;

	private ZeroNumbers(int points) {
		this.points = points;
	}

	@Override
	public int getPoints() {
		return points;
	}
}
