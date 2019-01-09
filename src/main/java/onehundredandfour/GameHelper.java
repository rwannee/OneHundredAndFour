package onehundredandfour;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameHelper {
	
	public static ArrayList<?> createDeck() {
		ArrayList<Cards> deck = new ArrayList<Cards>();
		for (Cards c : Cards.values()){
		deck.add(c);
		}
		return deck;
	}

	public static ArrayList<?> shuffleDeck(ArrayList<?> deck) {
		shuffleDeck(deck, 1);
		return deck;
	}

	public static ArrayList<?> shuffleDeck(ArrayList<?> deck, int number) {
		int i = 0;
		while (i < number) {
		Collections.shuffle(deck);
		i++;
		}
		return deck;
	}
	
	public static ArrayList<?> createHand(ArrayList<?> deck) {
		ArrayList<Cards> hand = new ArrayList<Cards>();
		for (int i=0;i<10;i++) {
		Cards c = (Cards) deck.remove(0);
		hand.add(c);
		}
		return hand;
		}

	public static Cards giveCard(ArrayList<?> deck) {
		Cards card = (Cards) deck.remove(0);
		return card;
		}
	
	public static Cards playerPlaysCard(List<?> hand, int location) {
		Cards card = (Cards) hand.remove(location);
		return card;
		}
	
	public static List<Card> getPlayersCardsOnTable(List<Player> players) {
		List<Card> card = new ArrayList<>();
		for (Player player : players) {
			Card c = player.getCardOnTable();
			if (c != null) {
				card.add(c);
			}
		}
		return card;
		}
	
	public static Card whoHasLowestCard(List<Card> p1) {
		ArrayList<Card> cards = new ArrayList<>();
		for (Card c : p1) {
			cards.add(c);
		}
		Card min = cards.get(0);
        for (Card i : cards){
            min = min.getValue() < i.getValue() ? min : i;
        }
		return min;
		
	}
	
	public static Player getPlayerWithLowestCardOnTable(List<Player> players) {
		List<Player> p = new ArrayList<>();
		for (Player player : players) {
			Card c = player.getCardOnTable();
			if (c != null) {
				p.add(player);
			}
		}
		Player min = p.get(0);
        for (Player i : p){
            min = min.getCardOnTable().getValue() < i.getCardOnTable().getValue() ? min : i;
        }
		return min;
		}
	
//	public static boolean checkCardAgainstRows(Card card, Game game) {
//		List<Card> after = new ArrayList<>();
//
//		if (card.getValue() > game.getRow0().get(game.getRow0().size()-1).getValue()) {
//		after.add(0, game.getRow0().get(game.getRow0().size()-1));	
//		game.getRow0().add(card);
//		}
//		if (card.getValue() > game.getRow1().get(game.getRow1().size()-1).getValue()) {
//			if (after.isEmpty()) {
//				after.add(game.getRow1().get(game.getRow1().size()-1));	
//			}else if (game.getRow1().get(game.getRow1().size()-1).getValue() > after.get(0).getValue()) {
//				game.getRow0().remove(card);
//				game.getRow1().add(card);
//			}
//		}
//		if (card.getValue() > game.getRow2().get(game.getRow2().size()-1).getValue()) {
//			if (after.isEmpty()) {
//				after.add(game.getRow2().get(game.getRow2().size()-1));
//			}else if(game.getRow2().get(game.getRow2().size()-1).getValue() > after.get(0).getValue()) {
//				game.getRow0().remove(card);
//				game.getRow1().remove(card);
//				game.getRow2().add(card);
//			}
//		}
//		if (card.getValue() > game.getRow3().get(game.getRow3().size()-1).getValue()) {
//			if (after.isEmpty()){
//				after.add(game.getRow3().get(game.getRow3().size()-1));	
//			}else if (game.getRow3().get(game.getRow3().size()-1).getValue() > after.get(0).getValue()) {
//				game.getRow0().remove(card);
//				game.getRow1().remove(card);
//				game.getRow2().remove(card);
//				game.getRow3().add(card);
//			}
//		}
//		if (!after.isEmpty()) {
//			return true;
//		}else
//		{	System.out.println("Card is lower than last cards in all rows. \r\nPlease pick a row.");
//			return false;
//		}
//	}
	
	public static boolean checkPlayerCardAgainstRows(Player pCard, Game game) {
		List<Card> after = new ArrayList<>();

		if (pCard.getCardOnTable().getValue() > game.getRow0().get(game.getRow0().size()-1).getValue()) {
		after.add(0, game.getRow0().get(game.getRow0().size()-1));	
		game.getRow0().add(pCard.getCardOnTable());
		}
		if (pCard.getCardOnTable().getValue() > game.getRow1().get(game.getRow1().size()-1).getValue()) {
			if (after.isEmpty()) {
				after.add(0, game.getRow1().get(game.getRow1().size()-1));	
				game.getRow1().add(pCard.getCardOnTable());
			}else if (game.getRow1().get(game.getRow1().size()-1).getValue() > after.get(0).getValue()) {
				after.add(0, game.getRow1().get(game.getRow1().size()-1));	
				game.getRow0().remove(pCard.getCardOnTable());
				game.getRow1().add(pCard.getCardOnTable());
			}
		}
		if (pCard.getCardOnTable().getValue() > game.getRow2().get(game.getRow2().size()-1).getValue()) {
			if (after.isEmpty()) {
				after.add(0, game.getRow2().get(game.getRow2().size()-1));
				game.getRow2().add(pCard.getCardOnTable());
			}else if(game.getRow2().get(game.getRow2().size()-1).getValue() > after.get(0).getValue()) {
				after.add(0, game.getRow2().get(game.getRow2().size()-1));
				game.getRow0().remove(pCard.getCardOnTable());
				game.getRow1().remove(pCard.getCardOnTable());
				game.getRow2().add(pCard.getCardOnTable());
			}
		}
		if (pCard.getCardOnTable().getValue() > game.getRow3().get(game.getRow3().size()-1).getValue()) {
			if (after.isEmpty()){
				after.add(0, game.getRow3().get(game.getRow3().size()-1));	
				game.getRow3().add(pCard.getCardOnTable());
			}else if (game.getRow3().get(game.getRow3().size()-1).getValue() > after.get(0).getValue()) {
				after.add(0, game.getRow3().get(game.getRow3().size()-1));	
				game.getRow0().remove(pCard.getCardOnTable());
				game.getRow1().remove(pCard.getCardOnTable());
				game.getRow2().remove(pCard.getCardOnTable());
				game.getRow3().add(pCard.getCardOnTable());
			}
		}
		if (!after.isEmpty()) {
			pCard.setCardOnTable(null);
			return true;
		}else
		{	System.out.println("Card is lower than last cards in all rows. \r\nrow0 is traded for your card.");
		tradeCardForRow(pCard, game.getRow0());
			return false;
		}
	}
	
	public static void tradeCardForRow(Player pCard, List<Card> row) {
		for (Card x : row) {
		pCard.addToScore(x);
		}
		row.clear();
		
		row.add(pCard.getCardOnTable());
		pCard.setCardOnTable(null);
	}
	
}