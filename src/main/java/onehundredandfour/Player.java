package onehundredandfour;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private final List<?> hand;
	private final List<Card> score = new ArrayList<>();
	private Card cardOnTable;

	public Player(final ArrayList<?> arrayList) {
		this.hand = arrayList;
	}

	public List<?> getHand() {
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
	
	public void addToScore(Card score) {
		this.score.add(score);
	}
}
