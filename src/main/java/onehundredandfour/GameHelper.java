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
	
	public static Card whoHasLowestCard(List<Card> cardsOnTable) {
		ArrayList<Card> cards = new ArrayList<>();
		for (Card c : cardsOnTable) {
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
	
	public static boolean checkPlayerCardAgainstRows(Player pCard, Game game) {
		List<Card> after = new ArrayList<>();

		if (pCard.getCardOnTable().getValue() > game.getRow0().get(game.getRow0().size()-1).getValue()) {
		after.add(0, game.getRow0().get(game.getRow0().size()-1));	
		}
		if (pCard.getCardOnTable().getValue() > game.getRow1().get(game.getRow1().size()-1).getValue()) {
			if (after.isEmpty()) {
				after.add(0, game.getRow1().get(game.getRow1().size()-1));	
			}else if (game.getRow1().get(game.getRow1().size()-1).getValue() > after.get(0).getValue()) {
				after.add(0, game.getRow1().get(game.getRow1().size()-1));	
			}
		}
		if (pCard.getCardOnTable().getValue() > game.getRow2().get(game.getRow2().size()-1).getValue()) {
			if (after.isEmpty()) {
				after.add(0, game.getRow2().get(game.getRow2().size()-1));
			}else if(game.getRow2().get(game.getRow2().size()-1).getValue() > after.get(0).getValue()) {
				after.add(0, game.getRow2().get(game.getRow2().size()-1));
			}
		}
		if (pCard.getCardOnTable().getValue() > game.getRow3().get(game.getRow3().size()-1).getValue()) {
			if (after.isEmpty()){
				after.add(0, game.getRow3().get(game.getRow3().size()-1));	
			}else if (game.getRow3().get(game.getRow3().size()-1).getValue() > after.get(0).getValue()) {
				after.add(0, game.getRow3().get(game.getRow3().size()-1));	
			}
		}
		if (!after.isEmpty()) {
			rowChecker(pCard, after, game.getRow0());
			rowChecker(pCard, after, game.getRow1());
			rowChecker(pCard, after, game.getRow2());
			rowChecker(pCard, after, game.getRow3());
			return true;
		}else
		{	int number = (int) (Math.random()*4);
			System.out.println("Card is lower than last cards in all rows. \r\nrow " + number + " is traded for your card.");
		try {
			tradeCardForRow(pCard, getRow(number, game));
		} catch (Exception e) {
			System.out.println("problemo");
			e.printStackTrace();
		}
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
	
	public static void rowChecker(Player pCard, List<Card> after, List<Card> row) {
		if(after.get(0).equals(row.get(row.size() -1))) {
			if (row.size() < 5) {
				row.add(pCard.getCardOnTable());
				pCard.setCardOnTable(null);
			}else {
				tradeCardForRow(pCard, row);
				System.out.println("Row is taken");
			}
		}
	}
	
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