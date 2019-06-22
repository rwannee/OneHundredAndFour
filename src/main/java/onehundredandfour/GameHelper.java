package onehundredandfour;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;


/**
 * GameHelper class
 *
 */
public class GameHelper {
	
	/**
	 * createDeck will create a deck of cards. 
	 *
	 * @return the created deck.
	 */
	public static List<Card> createDeck() {
		List<Card> deck = new ArrayList<Card>();
		for (Cards card : Cards.values()){
		deck.add(card);
		}
		return deck;
	}

	/**
	 * shuffleDeck will shuffle the provided deck of cards once.
	 * 
	 * @param deck the deck of cards that requires a shuffle.
	 * @return the shuffled deck.
	 */
	public static List<Card> shuffleDeck(List<Card> deck) {
		shuffleDeck(deck, 1);
		return deck;
	}

	/**
	 * shuffleDeck will shuffle the provided deck of cards a number of times.
	 * 
	 * @param deck the deck of cards that requires a shuffle.
	 * @param number the number of times the deck needs to be shuffled.
	 * @return the shuffled deck.
	 */
	public static List<Card> shuffleDeck(List<Card> deck, int number) {
		int i = 0;
		while (i < number) {
		Collections.shuffle(deck);
		i++;
		}
		return deck;
	}
	
	/**
	 * createHand will create a hand of 10 cards by removing them from the deck of cards that is provided.
	 * 
	 * @param deck is the deck of cards where the hand can be removed from.
	 * @return the hand that is created.
	 */
	public static List<Card> createHand(List<Card> deck) {
		List<Card> hand = new ArrayList<Card>();
		for (int i=0;i<10;i++) {
		Cards c = (Cards) deck.remove(0);
		hand.add(c);
		}
		return hand;
		}
	
	/**
	 * giveCard will return a card by removing them from the deck of cards that is provided.
	 * 
	 * @param deck is the deck of cards where the card can be removed from.
	 * @return the card that is extracted from the deck.
	 */
	public static Cards giveCard(List<Card> deck) {
		Cards card = (Cards) deck.remove(0);
		return card;
		}
	
	/**
	 * getPlayersCardsOnTable will check all players for the card on table.
	 * 
	 * @param players the list of players.
	 * @return the list of all cards that are on the table.
	 */
	public static List<Cards> getPlayersCardsOnTable(List<Player> players) {
		List<Cards> card = new ArrayList<>();
		for (Player player : players) {
			Cards cardOnTable = (Cards) player.getCardOnTable();
			if (cardOnTable != null) {
				card.add(cardOnTable);
			}
		}
		return card;
		}
	
	/**
	 * whoHasLowestCard will check the list of cards and return which card is lowest in value.
	 * 
	 * @param cardsOnTable is the list of cards.
	 * @return the card with the lowest value.
	 */
	public static Cards whoHasLowestCard(List<Cards> cardsOnTable) {
		List<Cards> cards = new ArrayList<Cards>(cardsOnTable);
		Cards lowestCard = cards
			      .stream()
			      .min(Comparator.comparing(Card::getValue))
			      .orElseThrow(NoSuchElementException::new);
		return lowestCard;
		
	}
	
	/**
	 * getPlayerWithLowestCardOnTable will return the player that has the lowest card on table.
	 * 
	 * @param players the list of players.
	 * @return the the player with lowest card on table.
	 * @throws NoSuchElementException when the comparison of card values cannot be executed.
	 */
	public static Player getPlayerWithLowestCardOnTable(List<Player> players) throws NoSuchElementException {
		List<Player> playersInGame = new ArrayList<Player>();
		Player playerWithLowestCard;
		for (Player player : players) {
			if (player.getCardOnTable() != null) {
				playersInGame.add(player);
			}
		}
		if (playersInGame.size() > 1) {
		playerWithLowestCard = playersInGame
			      .stream()
			      .min(Comparator.comparing( plyr -> plyr.getCardOnTable().getValue()))
			      .orElseThrow(NoSuchElementException::new);
		}else {playerWithLowestCard = playersInGame.get(0);}
		System.out.println(playerWithLowestCard.getId());
		return playerWithLowestCard;
		}
	
	/**
	 * checkPlayerCardAgainstRows will validate the card of the player against the existing rows in the game.
	 * 
	 * @param player the player for which the card needs to be validated.
	 * @param game the game for which the card is validated for.
	 * @return boolean on whether the card was successfully added to the game.
	 */
	public static boolean checkPlayerCardAgainstRows(Player player, Game game) {
		List<Card> after = new ArrayList<>();

		if (player.getCardOnTable().getValue() > game.getRow0().get(game.getRow0().size()-1).getValue()) {
		after.add(0, game.getRow0().get(game.getRow0().size()-1));	
		}
		if (player.getCardOnTable().getValue() > game.getRow1().get(game.getRow1().size()-1).getValue()) {
			if (after.isEmpty()) {
				after.add(0, game.getRow1().get(game.getRow1().size()-1));	
			}else if (game.getRow1().get(game.getRow1().size()-1).getValue() > after.get(0).getValue()) {
				after.add(0, game.getRow1().get(game.getRow1().size()-1));	
			}
		}
		if (player.getCardOnTable().getValue() > game.getRow2().get(game.getRow2().size()-1).getValue()) {
			if (after.isEmpty()) {
				after.add(0, game.getRow2().get(game.getRow2().size()-1));
			}else if(game.getRow2().get(game.getRow2().size()-1).getValue() > after.get(0).getValue()) {
				after.add(0, game.getRow2().get(game.getRow2().size()-1));
			}
		}
		if (player.getCardOnTable().getValue() > game.getRow3().get(game.getRow3().size()-1).getValue()) {
			if (after.isEmpty()){
				after.add(0, game.getRow3().get(game.getRow3().size()-1));	
			}else if (game.getRow3().get(game.getRow3().size()-1).getValue() > after.get(0).getValue()) {
				after.add(0, game.getRow3().get(game.getRow3().size()-1));	
			}
		}
		if (!after.isEmpty()) {
			rowChecker(player, after, game.getRow0());
			rowChecker(player, after, game.getRow1());
			rowChecker(player, after, game.getRow2());
			rowChecker(player, after, game.getRow3());
			return true;
		}else
		{	int number = (int) (Math.random()*4);
			System.out.println("Card is lower than last cards in all rows. \r\nrow " + number + " is traded for your card.");
		try {
			tradeCardForRow(player, getRow(number, game));
		} catch (Exception e) {
			System.out.println("problemo");
			e.printStackTrace();
		}
			return false;
		}
	}
	
	/**
	 * tradeCardForRow will replace the cards of a row for the players card and add the replaced cards to the players score.
	 * 
	 * @param player is the player that played the card.
	 * @param row is the row which is being replaced.
	 */
	public static void tradeCardForRow(Player player, List<Card> row) {
		for (Card x : row) {
		player.addToScore(x);
		}
		row.clear();
		
		row.add(player.getCardOnTable());
		player.removeCardOnTable();
	}
	
	/**
	 * rowChecker will validate if the card will fit in the row or that the row needs to be traded for the card.
	 * 
	 * @param player is the player that played the card.
	 * @param after is the card where the players card needs to be added behind.
	 * @param row the row that is validated on its length and if after is present in the row.
	 */
	public static void rowChecker(Player player, List<Card> after, List<Card> row) {
		if(after.get(0).equals(row.get(row.size() -1))) {
			if (row.size() < 5) {
				row.add(player.getCardOnTable());
				player.removeCardOnTable();
			}else {
				tradeCardForRow(player, row);
				System.out.println("Row is taken");
			}
		}
	}
	
	/**
	 * getRow will return the requested row based on the provided number and game.
	 * 
	 * @param number is the row number of the requested row.
	 * @param game is the game for which the row is requested.
	 * @return the row.
	 * @throws Exception upon error.
	 */
	public static List<Card> getRow(int number, Game game) throws Exception {
		if(number == 0) {
			return game.getRow0();
		}else if (number == 1){
			return game.getRow1();	
		}
		else if (number == 2){
			return game.getRow2();	
		}else if (number == 3){
			return game.getRow3();	
		}else {
		throw new Exception();
		}
	}
	
}