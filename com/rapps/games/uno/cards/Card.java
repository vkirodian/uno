package com.rapps.games.uno.cards;

public class Card {

	private Color color;
	private Points points;
	private Color wildColor;
	private boolean isActive;

	public Card(Color color, Points points) {
		super();
		this.color = color;
		this.points = points;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Points getPoints() {
		return points;
	}

	public void setPoints(Points points) {
		this.points = points;
	}

	public Color getWildColor() {
		return wildColor;
	}

	public void setWildColor(Color wildColor) {
		this.wildColor = wildColor;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return color + "\t" + points;
	}

}
