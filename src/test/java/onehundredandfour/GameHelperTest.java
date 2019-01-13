package onehundredandfour;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

public class GameHelperTest {

	@Test
	public void getDeckTest() {
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
}