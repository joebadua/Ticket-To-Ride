/**
 * This class implements Card to create a Destination Card for Ticket to Ride. This Card holds a
 * destination and origin city, and a point value. If the route is completed at the end of the game
 * by the player who holds the card, the points are awarded to the player
 */
public class DestCard implements Card{
	
	private final String dest;
	private final String origin;
	private final int value;

	/**
	 * Constructs empty DestCard
	 */
	public DestCard() {
		this.dest = "null";
		this.origin = "null";
		this.value = 0;
	}
	/**
	 * Constructs a card containing a destination city, origin city, and point value
	 * @param String dest - destination city
	 * @param String origin - origin city
	 * @param int value - point value of card
	 */
	public DestCard(String dest, String origin, int value) {
		this.dest = dest;
		this.origin = origin;
		this.value = value;
	}

	/**
	 * Returns the destination city of the card.
	 * @return city name
	 */
	public String getDest() {
		return this.dest;
	}
	/**
	 * Returns the origin city of the card.
	 * @return city name
	 */
	public String getOrigin() {
		return this.origin;
	}
	/**
	 * Returns the value of the card.
	 * @return integer point value
	 */
	public int getValue() {
		return this.value;
	}
	/**
	 * Returns a string representation of this card.
	 * @return String representation of this card.
	 */
	public String toString() {
		return "Destination Card: destination = " + this.dest + " origin = " + this.origin + "value = " + this.value;
	}
}
