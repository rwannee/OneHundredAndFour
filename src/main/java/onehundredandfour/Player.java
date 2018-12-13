package onehundredandfour;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private final List<Card> hand;
	private final List<Card> score = new ArrayList<>();
	private Card cardOnTable;

	public Player(final List<Card> hand) {
		this.hand = hand;
	}

	public List<Card> getHand() {
		return hand;
	}

	public List<Card> getScore() {
		return score;
	}

	public Card getCardOnTable() {
		return cardOnTable;
	}

	public void setCardOnTable(final Card cardOnTable) {
		this.cardOnTable = cardOnTable;
	}
}
