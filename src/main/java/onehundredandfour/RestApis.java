package onehundredandfour;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.ArrayList;
import java.util.List;

/**
 * Rest Api class
 *
 */
@RestController
public class RestApis {
	private static final String version = "0.0.1";
	List<Card> deck = GameHelper.createDeck();
	List<Player> players = new ArrayList<>();
	
	private static final String template = "Hello, the version of this application is: %s!";

	/**
	 * About service, showing the version of the app.
	 *
	 */
    @RequestMapping(value = "/about", method = GET)
    public String getVersion() {
        return new String(String.format(template, version));
    }
    
    /**
     * CreatePlayer, will create a player each call.
     * @throws Exception when exceeding the player limit
     *
     */
    @RequestMapping(value = "/createPlayer", method = GET)
    public Player createPlayer() throws Exception {
    GameHelper.shuffleDeck(deck);
    if(deck.size() >= 10) {
	List<Card> hand =  GameHelper.createHand(deck);
	Player player = new Player(hand);
	players.add(player); 
        return player;}
    else {throw new Exception("No cards left for a new player");}
    }
    
    /**
     * GetPlayers will return the list of players
     *
     */
    @RequestMapping(value = "/getPlayers", method = GET)
    public List<Player> getPlayers() {
        return players;
    }
    
    /**
     * startGame, will start a game with the currently created players and deck. 
     *
     */
    @RequestMapping(value = "/startGame", method = GET)
    public String startGame() {
    	new Game(players, deck);
		return "Game has been started!";
    }
	
}