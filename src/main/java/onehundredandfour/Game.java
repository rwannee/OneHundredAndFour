package onehundredandfour;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private final List<Player> players;
	private final ArrayList<?> deck;
	private final List<Card> row0 = new ArrayList<>();
	private final List<Card> row1 = new ArrayList<>();
	private final List<Card> row2 = new ArrayList<>();
	private final List<Card> row3 = new ArrayList<>();

	public Game(final List<Player> players, ArrayList<?> deck) {
		this.players = players;
		this.deck = deck;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public List<Card> getRow0() {
		return row0;
	}

	public List<Card> getRow1() {
		return row1;
	}

	public List<Card> getRow2() {
		return row2;
	}

	public List<Card> getRow3() {
		return row3;
	}
	
	public ArrayList<?> getDeck() {
		return deck;
	}
}