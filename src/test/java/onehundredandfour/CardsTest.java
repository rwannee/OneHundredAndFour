package onehundredandfour;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import org.junit.Test;

public class CardsTest {
	
	@Test
	public void valuesTest() {
		Cards card = Cards.C55;
		assertEquals(55,card.getValue());
		assertEquals(7, card.getScore());
	}
	
	@Test
	public void cardIsPresentTest() {
		ArrayList<Cards> deck = new ArrayList<Cards>();
		for (Cards c : Cards.values()){
			deck.add(c);
		}
		assertEquals(true,deck.contains(Cards.C1));
	}

}