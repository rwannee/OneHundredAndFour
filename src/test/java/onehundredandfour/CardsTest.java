package onehundredandfour;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import org.junit.Test;

public class CardsTest {
	
@Test
public void test() {
	ArrayList<Cards> deck = new ArrayList<Cards>();
	for (Cards c : Cards.values()){
	deck.add(c);
	}
	assertEquals(true,deck.contains(Cards.C1));
	}

@Test
public void test2() {
	ArrayList<Cards> deck = new ArrayList<Cards>();
	for (Cards c : Cards.values()){
	deck.add(c);
	}
	GameHelper.shuffleDeck(deck, 5);
	
	for (Cards c : deck){
		System.out.println(c.getValue());	
	}
	assertEquals(104,deck.size());
	}

}