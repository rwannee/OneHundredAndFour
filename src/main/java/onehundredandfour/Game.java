package onehundredandfour;

import java.util.ArrayList;
import java.util.List;

/**
 * Game class.
 */
public class Game {
	private final List<Player> players;
	private final List<Card> deck;
	private final List<Card> row0 = new ArrayList<>();
	private final List<Card> row1 = new ArrayList<>();
	private final List<Card> row2 = new ArrayList<>();
	private final List<Card> row3 = new ArrayList<>();

	/**
	 * Game constructor.
	 * @param players the list of players joining the game.
	 * @param deck the deck of cards the game will be played with.
	 * @return the game.
	 */
	public Game(final List<Player> players, List<Card> deck) {
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
	
	public List<Card> getDeck() {
		return deck;
	}
}