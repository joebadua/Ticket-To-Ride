
import java.util.Random;
/**
 * This class implements Card to create a TrainCarCard for Ticket to Ride. Each train car card contains
 * a color that denotes its type
 */
public class TrainCarCard implements Card{

    private final String[] carTypes = {"Box", "Passenger", "Tanker", "Reefer",
                                        "Freight", "Hopper", "Coal", "Caboose", "Locomotives"};
    private static String[] colors = {"RED", "BLUE", "GREEN", "YELLOW", "BLACK"};
	private String color;
	private String carType;

    private Random random = new Random(System.currentTimeMillis());
    private int min = 1;
    private int max = carTypes.length;

    /**
	 * Constructs a train car card randomly. Only used for testing.
	 */
	public TrainCarCard() {
		this.color = colors[random.nextInt(max - min) + min];
		this.carType = carTypes[random.nextInt(max - min) + min];
	}

//	public TrainCarCard(String color){
//		this.color = color;
//		this.carType = "null";
//	}
	/**
	 * Constructs a train car card by string representing its color
	 * @param color string value of color
	 */
	public TrainCarCard(String color) {
	    this.color = color;
    }
	/**
	 * Returns the color of the train car card.
	 * @return string value of card color
	 */
	public String getColor() {
		return this.color;
	}
	/**
	 * Returns the type of the train car card.
	 * @return string value of car type
	 */
	public String getCarType() {
		return carType;
	}
	/**
	 * Returns a string representation of the card.
	 * @return string representation of the card
	 */
	@Override
	public String toString() {
		return "TrainCarCard: " + this.color;
	}
}
