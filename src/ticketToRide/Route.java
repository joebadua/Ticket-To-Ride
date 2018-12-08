import java.util.Random;
/**
 * This class creates a Route object with a specific length and color.
 */
public class Route {
    private int routeLength;
    private String routeColor1;
    private String routeColor2;
    private Random random = new Random(System.currentTimeMillis());
    private int min = 1;
    private int max = color.length;
    private static String[] color = {"RED", "BLUE", "GREEN", "YELLOW", "BLACK", "BLANK"};

    /**
     * Constructs a route of random length and color. Used only for a randomized board.
     * */
    public Route() {
        this.routeLength = random.nextInt(max-min) + min;
        this.routeColor1 = color[random.nextInt(color.length)];
        this.routeColor2 = color[random.nextInt(color.length)];
    }
    /**
     * Constructs a route of set color and length.
     * @param routeColor1 - color of route
     * @param routeLength - length of route
     */
    public Route(String routeColor1, int routeLength) {
        this.routeLength = routeLength;
        this.routeColor1 = routeColor1;
        this.routeColor2 = null;
    }

    public Route(String routeColor1, String routeColor2, int routeLength) {
        this.routeLength = routeLength;
        this.routeColor1 = routeColor1;
        this.routeColor2 = routeColor2;
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
    public String getRouteColor1() {
        return routeColor1;
    }

    public String getRouteColor2() {
        return routeColor2;
    }
    /**
     * Returns a string representation of the route
     * @return string representation of route
     */
    @Override
    public String toString(){
        return "Length: " + this.routeLength + " " +  "Color(s): " + this.routeColor1 + "," + this.routeColor2;
    }
}
