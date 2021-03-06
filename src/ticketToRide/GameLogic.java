import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;

// Vast majority of functionality is going to go here. All rules for turns and all of game setup
public class GameLogic {

	private final int MAX_SCORE = 15;
	private final int MIN_CAR_COUNT = 2;
	private Player player1, player2;
	private GameBoard board;
	private Deck discardPile = new Deck();
	List<TrainCarCard> discards = new ArrayList<>();

	public GameLogic() {
		board = new GameBoard();
		// For this assignment, we are leaving the max at 2 players
		player1 = new Player("");
		player2 = new Player("");
	}

	public boolean gameOver() {
		if (player1.getScore() == MAX_SCORE || player2.getScore() == MAX_SCORE)
			return true;
		else if (player1.getCarCount() <= MIN_CAR_COUNT || player2.getCarCount() <= MIN_CAR_COUNT)
			return true;
		else if (player1.getTcHand().isEmpty() || player2.getTcHand().isEmpty())
			return true;

		return false;
	}

	/*
	 	playGame goes through the process of playing an entire game
		 until GameOver() returns false
	 */
	public void playGame() {
		Scanner scanner = new Scanner(System.in);

		/*
			Note to self: Find way to eliminate repeating code
		 */
		while(!gameOver()) {

			// add a function here that displays the routes from GameBoard

			// PLAYER 1
			System.out.println("----" +  player1.getColor() + "----");
			System.out.println("Press 1 to Draw 2 Cards");
			System.out.println("Press 2 to Claim a Route");
			System.out.println("Press 3 to Draw Destination Cards from the board");
			int input1 = scanner.nextInt();

			if(input1 == 1) {
				for(int i = 0; i < 2; i++)
					player1.addTCCard(board.getTCCard());
			}
			else if(input1 == 2) {
				System.out.println("Which route would you like to take?");

				// add something here that would allow player to input route they want
				// also, put isValidMovein here
			}
			else if(input1 == 3) { player1.addDCCard(board.getDCCard()); }


			// PLAYER 2
			System.out.println("----" +  player2.getColor() + "----");
			System.out.println("Press 1 to Draw 2 Cards");
			System.out.println("Press 2 to Claim a Route");
			System.out.println("Press 3 to Draw Destination Cards from the board");
			int input2 = scanner.nextInt();

			if(input2 == 1) {
				for(int i = 0; i < 2; i++)
					player1.addTCCard(board.getTCCard());
			}
			else if(input2 == 2) {
				System.out.println("Which route would you like to take?");

				// add something here that would allow player to input route they want
				// also, put isValidMovein here

			}
			else if(input2 == 3) { player2.addDCCard(board.getDCCard()); }
		}

	}

    /*
    	isValidMove tests a Player's cards against the board for:
  	 	1) The correct color of TrainCarCards for a route
    	2) The correct amount of TrainCarCards for a route
    	This will be used in playGame()
     */
	public boolean isValidMove(Player player, GameBoard routes, String city1, String city2) {

		int color1= 0;
		int color2= 0;
		Route route = routes.getRoute(city1, city2);

		List<TrainCarCard> player_hand = player.getTcHand();

		if ( route.getRouteColor2() != null ) {
			for (int i = 0; i < player_hand.size(); i++) {
				if (player_hand.get(i).getColor().equals(route.getRouteColor1())) {
					color1++;
					if (color1 == route.getRouteLength()) {
						return true;
					}
				} else if (player_hand.get(i).getColor().equals(route.getRouteColor2())) {
					color2++;
					if (color2 == route.getRouteLength()) {
						return true;
					}
				}
			}
		} else {
			for (int i = 0; i < player_hand.size(); i++) {
				if (player_hand.get(i).getColor().equals(route.getRouteColor1())) {
					color1++;
					if (color1 == route.getRouteLength()) {
						return true;
					}
				}
			}
		}
		return false;
    }

	public void discardPlayerHand(Player player, GameBoard routes, String city1, String city2) {
		Route route = routes.getRoute(city1, city2);
		List<TrainCarCard> player_hand = player.getTcHand();
		int removedCards = 0;

		for(Iterator<TrainCarCard> i = player_hand.iterator(); i.hasNext(); ) {
			TrainCarCard a = i.next();
			if( a.getColor().equals(route.getRouteColor1()) && removedCards < route.getRouteLength() ) {
				removedCards++;
				i.remove();
			} else if ( a.getColor().equals(route.getRouteColor2()) && removedCards < route.getRouteLength() ) {
				removedCards++;
				i.remove();
			}
		}
	}

    public Player getCurrentPlayer(Player currentPlayer, Player p1, Player p2) {
	    //Returns the next player that will take a turn
	    if (currentPlayer == p1) {
	        currentPlayer = p2;
        } else {
	        currentPlayer = p1;
        }
		return  currentPlayer;
	}

	public void addToDiscardPile(Player player, GameBoard routes, String city1, String city2){
	    Route route = routes.getRoute(city1,city2);

	}


}
