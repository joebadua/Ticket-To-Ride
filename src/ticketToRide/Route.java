import java.util.Random;
/**
 * This class creates a Route object with a specific length and color.
 */
public class Route {
    private int routeLength;
    private String routeColor;
    private Random random = new Random(System.currentTimeMillis());
    private int min = 1;
    private int max = color.length;
    private static String[] color = {"RED", "BLUE", "GREEN", "YELLOW", "BLACK", "BLANK"};

    /**
     * Constructs a route of random length and color. Used only for a randomized board.
     * */
    public Route() {
        this.routeLength = random.nextInt(max-min) + min;
        this.routeColor = color[random.nextInt(color.length)];
    }
    /**
     * Constructs a route of set color and length.
     * @param routeColor - color of route
     * @param routeLength - length of route
     */
    public Route(String routeColor, int routeLength) {
        this.routeLength = routeLength;
        this.routeColor = routeColor ;
    }
    /**
     * Returns length of route.
     * @return integer length of route
     */
    public int getRouteLength() {
        return routeLength;
    }
    /**
     * Returns color of route.
     * @return string color of route
     */
    public String getRouteColor() {
        return routeColor;
    }
    /**
     * Returns a string represenation of the route
     * @return string represenation of route
     */
    @Override
    public String toString(){
        return "Length: " + this.routeLength + " " +  "Color: " + this.routeColor;
    }
}
