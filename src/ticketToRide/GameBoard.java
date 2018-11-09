import java.util.*;

/**
 * The class GameBoard holds all of the information needed for the board of a game of Ticket to Ride. It holds the
 * Deck objects of each card type and a list of the routes contained therein.
 */
public class GameBoard {
	
	//private LinkedList<Card> tcHand;
	private Deck tcDeck;
	private Deck dcDeck;
	//private LinkedList<Player> players;
    private HashMap<List<String>, Route> destinations;
    /**
     * Constructs a game board for Ticket to ride. Initializes routes in destinations map. Initializes and
     * fills card decks.
     */
    public GameBoard() {
        /*
            Using an array for the keys/destinations since the routes are bi-directional.
            It's the same route regardless which end you start in.
         */
        destinations = new HashMap<>();

        destinations.put(new ArrayList<>(Arrays.asList("LA", "SF")), new Route("BLUE", 3));
        destinations.put(new ArrayList<>(Arrays.asList("LA", "SD")), new Route("BLACK", 2));
        destinations.put(new ArrayList<>(Arrays.asList("SF", "LV")), new Route("BLANK", 3));
        destinations.put(new ArrayList<>(Arrays.asList("SD", "LV")), new Route("RED", 4));

        // Build decks for game
        tcDeck = new Deck("trainCarGUI.txt", 0);
        dcDeck = new Deck("destCardGUI.txt", 1);

    }
    /**
     * Returns route based on cities passed through as parameters from GUI mouse clicks. Checks to ensure cities
     * create a route occurs elsewhere.
     * @param city1 - first city chosen
     * @param city2 - second city chosen
     * @return route that connects cities
     */
    public Route getRoute(String city1, String city2) {
        ArrayList<String> cities = getKey(city1, city2);
        Route foundRoute;
        if (cities == null || cities.isEmpty()) {
            foundRoute = null;
        } else {
            foundRoute = new Route(destinations.get(cities).getRouteColor(), destinations.get(cities).getRouteLength());
        }
        return foundRoute;
    }
    /**
     * A helper function to ensure that cities can be clicked in any order and will still return
     * the proper route if deemed valid
     * @param c1 - first city chosen
     * @param c2 - second city chosen
     * @return list of cities in route
     */
    private ArrayList getKey(String c1, String c2){
        Set keySet = destinations.keySet();

        for(Iterator itr = keySet.iterator(); itr.hasNext();){
            ArrayList<String> keys = (ArrayList<String>) itr.next();
            if(keys.contains(c1) && keys.contains(c2)){
                return keys;
            }
        }
        return null;
    }
    /**
     * Returns card retrieved from draw function in Deck class
     * @return train car card from draw function
     */
    public Card getTCCard() {
        return tcDeck.draw();
    }
    /**
     * Returns card retrieved from draw function in Deck class
     * @return destination card from draw function
     */
    public Card getDCCard() {
        return dcDeck.draw();
    }
}
