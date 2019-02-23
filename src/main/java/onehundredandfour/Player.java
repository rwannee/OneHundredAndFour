package onehundredandfour;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Player class.
 */
public class Player {
	private final List<Card> hand;
	private final List<Card> score = new ArrayList<>();
	private Card cardOnTable;

	/**
	 * Player constructor.
	 * 
	 * @param hand the hand of cards the player will play with. 
	 * @return the player.
	 */
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

	/**
	 * setCardOnTable will place the provided card as the card on table for this player.
	 * 
	 * @param cardOnTable the card that will be 'played' as card on table.
	 */
	public void setCardOnTable(final Card cardOnTable) {
		this.cardOnTable = cardOnTable;
	}
	
	/**
	 * addToScore will add the provided card to the score of the player.
	 * 
	 * @param score the card that will be added to the players score.
	 */
	public void addToScore(Card score) {
		this.score.add(score);
	}

	/**
	 * playerPlaysCard will remove the card at given location from the players hand.
	 * 
	 * @param hand the players hand.
	 * @param location the location of the card that is being played.
	 * @return the card that is played.
	 */
	public static Card playerPlaysCard(List<Card> hand, int location) {
	Card card =  hand.remove(location);
	return card;
	}
	
	/**
	 * realPlayerPlaysCard will remove the card at given location from the players hand from user input.
	 * 
	 * @param reader the scanner required for user input.
	 * @return the card that is played.
	 */
	public Card realPlayerPlaysCard(Scanner reader) {
		
		int location = getLocation(reader); 
		this.setCardOnTable(this.getHand().get(location));
		
		Card card = (Cards) this.getHand().remove(location);
		return card;
		}

	/**
	 * getLocation will scan for user input for a location of card in the hand.
	 * 
	 * @param reader the scanner required for user input.
	 * @return the location of the card.
	 */
	private int getLocation(Scanner reader) {
		int location = 0;
		
			System.out.println("Enter the location of your card: ");
			location = reader.nextInt();
		return location;
	}
}
