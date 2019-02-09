package onehundredandfour;
import java.util.Scanner;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class GameTest {
	Scanner reader = new Scanner(System.in);

	@Test
	public void GameplayTest() {
		ArrayList<Player> players = new ArrayList<>();
		ArrayList<?> deck = GameHelper.createDeck();
		GameHelper.shuffleDeck(deck);
		
		Player p1 = new Player(GameHelper.createHand(deck));
		Player p2 = new Player(GameHelper.createHand(deck));
		players.add(p1);
		players.add(p2);
		Game game = new Game(players, deck);
		assertEquals(2, game.getPlayers().size());
		
		System.out.println("P1 cards");
		for (int i=0;i < p1.getHand().size();i++) {
			System.out.println(p1.getHand().get(i));
			}

		assertEquals(104, game.getDeck().size() + p1.getHand().size() + p2.getHand().size());
		
		game.getRow0().add(GameHelper.giveCard(deck));
		game.getRow1().add(GameHelper.giveCard(deck));
		game.getRow2().add(GameHelper.giveCard(deck));
		game.getRow3().add(GameHelper.giveCard(deck));
		printRows(game);
		
		int i = 0;
		while(i < 10) {
		executeRound(game);
		i++;
		}
		calculateAndPrintScore(game);
		reader.close();
	}

	private void executeRound(Game game) {	
		playersSetCardOnTable(game.getPlayers());
		while(!GameHelper.getPlayersCardsOnTable(game.getPlayers()).isEmpty()) {
		System.out.println("Lowest Card is: "+ GameHelper.whoHasLowestCard(GameHelper.getPlayersCardsOnTable(game.getPlayers())));
		GameHelper.checkPlayerCardAgainstRows(GameHelper.getPlayerWithLowestCardOnTable(game.getPlayers()),game);
		printRows(game);
		}
		System.out.println("Round is over!");
	}
	private void playersSetCardOnTable(List<Player> players) {	
		for (Player player : players) {
		
	//To test the user input, uncomment this section of the test.		
	//		if (player.equals(players.get(0))) {
	//			players.get(0).realPlayerPlaysCard(reader);
	//		}else {
		player.setCardOnTable(Player.playerPlaysCard(player.getHand(), 0));
	//	}
		}
		
	}

	private void printRows(Game game) {
		System.out.println("Row 0 contains: "+ game.getRow0());
		System.out.println("Row 1 contains: "+ game.getRow1());
		System.out.println("Row 2 contains: "+ game.getRow2());
		System.out.println("Row 3 contains: "+ game.getRow3());
	}
	
	private void calculateAndPrintScore(Game game) {
		int totalScore = 0;
		for(Player p : game.getPlayers()) {
		totalScore = 0;
		for (Card c : p.getScore()) {
			totalScore = totalScore + c.getScore();
		}
		System.out.println("Player's score is: " + totalScore);
		}
	}

}