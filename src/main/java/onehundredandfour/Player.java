package onehundredandfour;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

	public static Cards playerPlaysCard(List<?> hand, int location) {
	Cards card = (Cards) hand.remove(location);
	return card;
	}
	
	public Cards realPlayerPlaysCard(Scanner reader) {
		
		int location = getLocation(reader); 
		this.setCardOnTable((Card) this.getHand().get(location));
		
		Cards card = (Cards) this.getHand().remove(location);
		return card;
		}

	private int getLocation(Scanner reader) {
		int location = 0;
		
			System.out.println("Enter the location of your card: ");
			location = reader.nextInt();
		return location;
	}
}
