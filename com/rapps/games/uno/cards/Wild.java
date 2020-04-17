package com.rapps.games.uno.cards;

public enum Wild implements Points {

	WILD1(40), WILD2(40), WILD3(40), WILD4(40), DRAWFOUR1(50), DRAWFOUR2(50), DRAWFOUR3(50), DRAWFOUR4(50);

	int points;

	private Wild(int points) {
		this.points = points;
	}

	@Override
	public int getPoints() {
		return points;
	}
}
