package onehundredandfour;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class GameHelperTest {

	@Test
	public void createDeckTest() {
		ArrayList<?> deck = GameHelper.createDeck();
		for (Cards c : Cards.values()){
			Assert.assertTrue(deck.contains(c));
		}
	}
	
	@Test
	public void shuffleOnceImpactTest() {
		ArrayList<Cards> deck = new ArrayList<Cards>();
		for (Cards c : Cards.values()){
			deck.add(c);
		}
		GameHelper.shuffleDeck(deck);
	
		for (Cards c : Cards.values()){
			Assert.assertTrue(deck.contains(c));
		}
		assertEquals(104,deck.size());
	}
	
	@Test
	public void shuffleMultipleImpactTest() {
		ArrayList<Cards> deck = new ArrayList<Cards>();
		for (Cards c : Cards.values()){
			deck.add(c);
		}
		GameHelper.shuffleDeck(deck, 5);
	
		for (Cards c : Cards.values()){
			Assert.assertTrue(deck.contains(c));
		}
		assertEquals(104,deck.size());
	}
	
	@Test
	public void createHandTest() {
		ArrayList<?> deck = GameHelper.createDeck();
		ArrayList<?> hand = GameHelper.createHand(deck);
		assertEquals(10,hand.size());
		assertEquals(Cards.C1, hand.get(0));
	}
	
	@Test
	public void giveCardTest() {
		ArrayList<?> deck = GameHelper.createDeck();
		Cards card = GameHelper.giveCard(deck);
		assertEquals(Cards.C1, card);
	}
	
	@Test
	public void getPlayersCardsOnTableAndLowestCardTest() {
		//Deck and hands created
		ArrayList<?> deck = GameHelper.createDeck();
		ArrayList<?> hand1 = GameHelper.createHand(deck);
		ArrayList<?> hand2 = GameHelper.createHand(deck);
		
		//Players created and added to list of players
		List<Player> players = new ArrayList<>();
		Player one = new Player(hand1);
		Player two = new Player(hand2);
		players.add(one);
		players.add(two);
		
		//Cards are set to table
		one.setCardOnTable((Card) one.getHand().get(0));
		two.setCardOnTable((Card) two.getHand().get(0)); 
		
		//method getPlayersCardsOnTable is tested
		List<Card> result = new ArrayList<Card>();
		result = GameHelper.getPlayersCardsOnTable(players);
		assertEquals(one.getCardOnTable(), result.get(0));
		assertEquals(two.getCardOnTable(), result.get(1));
		
		//method whoHasLowestCard is tested
		Card lowestCard = GameHelper.whoHasLowestCard(result);
		assertEquals(Cards.C1, lowestCard);
		
		//method getPlayerWithLowestCardOnTable is tested
		Player lowestPlayer = GameHelper.getPlayerWithLowestCardOnTable(players);
		assertEquals(one, lowestPlayer);
	}
	
	@Test
	public void checkPlayerCardAgainstRowsPositiveTest() {
		//Deck and hands created
		ArrayList<?> deck = GameHelper.createDeck();
		Card C1 = (Card) GameHelper.giveCard(deck);
		ArrayList<?> hand1 = GameHelper.createHand(deck);
		ArrayList<?> hand2 = GameHelper.createHand(deck);
		
		//Players created and added to list of players
		List<Player> players = new ArrayList<>();
		Player one = new Player(hand1);
		Player two = new Player(hand2);
		players.add(one);
		players.add(two);
		
		Game game = new Game(players, deck);
		game.getRow0().add(C1);
		game.getRow1().add(GameHelper.giveCard(deck));
		game.getRow2().add(GameHelper.giveCard(deck));
		game.getRow3().add(GameHelper.giveCard(deck));
		
		//Cards are set to table
		one.setCardOnTable((Card) one.getHand().get(0));
		two.setCardOnTable((Card) two.getHand().get(0)); 
		
		//method getPlayerWithLowestCardOnTable is tested
		Player lowestPlayer = GameHelper.getPlayerWithLowestCardOnTable(players);
		boolean result = GameHelper.checkPlayerCardAgainstRows(lowestPlayer, game);
		assertTrue(result);
		assertEquals(2, game.getRow0().size());
		assertEquals(Cards.C2, game.getRow0().get(game.getRow0().size()-1));
		assertNull(lowestPlayer.getCardOnTable());
		
	}
	
	@Test
	public void checkPlayerCardAgainstRowsNegativeTest() {
		//Deck and hands created
		ArrayList<?> deck = GameHelper.createDeck();
		ArrayList<?> hand1 = GameHelper.createHand(deck);
		ArrayList<?> hand2 = GameHelper.createHand(deck);
		
		//Players created and added to list of players
		List<Player> players = new ArrayList<>();
		Player one = new Player(hand1);
		Player two = new Player(hand2);
		players.add(one);
		players.add(two);
		
		Game game = new Game(players, deck);
		game.getRow0().add(GameHelper.giveCard(deck));
		game.getRow1().add(GameHelper.giveCard(deck));
		game.getRow2().add(GameHelper.giveCard(deck));
		game.getRow3().add(GameHelper.giveCard(deck));
		
		//Cards are set to table
		one.setCardOnTable((Card) one.getHand().get(0));
		two.setCardOnTable((Card) two.getHand().get(0)); 
		
		//method getPlayerWithLowestCardOnTable is tested
		Player lowestPlayer = GameHelper.getPlayerWithLowestCardOnTable(players);
		boolean result = GameHelper.checkPlayerCardAgainstRows(lowestPlayer, game);
		assertFalse(result);
		assertEquals(1, game.getRow0().size());
		assertEquals(1, game.getRow1().size());
		assertEquals(1, game.getRow2().size());
		assertEquals(1, game.getRow3().size());
		assertEquals(1, lowestPlayer.getScore().size());
		assertNull(lowestPlayer.getCardOnTable());
	}
	
	@Test
	public void tradeCardForRowTest() {
		ArrayList<?> deck = GameHelper.createDeck();
		List<Card> row = new ArrayList<>();
		row.add((Card) deck.get(54));
		deck.remove(54);
		ArrayList<?> hand1 = GameHelper.createHand(deck);
		
		Player one = new Player(hand1);
		one.setCardOnTable((Card) one.getHand().get(0));
		GameHelper.tradeCardForRow(one, row);	
		
		assertNull(one.getCardOnTable());
		assertEquals(true, one.getScore().contains(Cards.C55));
		assertEquals(Cards.C1, row.get(0));
		assertEquals(1,row.size());
	}
	
	@Test
	public void getRowTest() throws Exception {
		ArrayList<?> deck = GameHelper.createDeck();
		
		Game game = new Game(null, deck);
		game.getRow0().add(GameHelper.giveCard(deck));
		game.getRow1().add(GameHelper.giveCard(deck));
		game.getRow2().add(GameHelper.giveCard(deck));
		game.getRow3().add(GameHelper.giveCard(deck));
		
		List<Card> result = GameHelper.getRow(0, game);
		assertEquals(game.getRow0(), result);
		result = GameHelper.getRow(1, game);
		assertEquals(game.getRow1(), result);
		result = GameHelper.getRow(2, game);
		assertEquals(game.getRow2(), result);
		result = GameHelper.getRow(3, game);
		assertEquals(game.getRow3(), result);
	}
	
	@Test(expected=Exception.class)
	public void getRowExceptionTest() throws Exception {
		ArrayList<?> deck = GameHelper.createDeck();
		
		Game game = new Game(null, deck);
		game.getRow0().add(GameHelper.giveCard(deck));
		game.getRow1().add(GameHelper.giveCard(deck));
		game.getRow2().add(GameHelper.giveCard(deck));
		game.getRow3().add(GameHelper.giveCard(deck));
		
		List<Card> result = GameHelper.getRow(4, game);
		assertEquals(game.getRow0(), result);
	}
}