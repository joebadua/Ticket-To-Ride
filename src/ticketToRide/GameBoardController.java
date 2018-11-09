import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Sphere;

/*
    Controller class for the GameBoard UI
 */
public class GameBoardController {

    private Player player1 = new Player("AQUA",Color.AQUA);
    private Player player2 = new Player("PINK",Color.PINK);
    private Player currentPlayer = player1;
    private GameBoard board = new GameBoard();
    private GameLogic gameLogic = new GameLogic();
    private String city1 = "";
    private String city2 = "";
    private StringBuilder builder = new StringBuilder();
    private boolean routeClaimed1 = false, routeClaimed2 = false, routeClaimed3 = false, routeClaimed4 = false;

    @FXML
    private Button SF;

    @FXML
    private Rectangle SFtoLA1;

    @FXML
    private Rectangle SFtoLA2;

    @FXML
    private Rectangle SFtoLA3;

    @FXML
    private Button LA;

    @FXML
    private Rectangle LAtoSD1;

    @FXML
    private Rectangle LAtoSD2;

    @FXML
    private Button SD;

    @FXML
    private Rectangle SDtoLV1;

    @FXML
    private Rectangle SDtoLV2;

    @FXML
    private Rectangle SDtoLV3;

    @FXML
    private Rectangle SDtoLV4;

    @FXML
    private Button LV;

    @FXML
    private Rectangle SFtoLV1;

    @FXML
    private Rectangle SFtoLV2;

    @FXML
    private Rectangle SFtoLV3;

    @FXML
    private Button route;

    @FXML
    private Button trainCard;

    @FXML
    private Button destinationCard;

    @FXML
    private Button quitButton;

    @FXML
    private Label player;

    @FXML
    private Sphere moon;

    @FXML
    private TextArea playerHand;

    /*
        Initializes the player's hands
        This method will automatically be invoked once JavaFX starts
     */
    public void initialize(){
        player1.addTCCard(new TrainCarCard("RED"));
        player1.addTCCard(new TrainCarCard("RED"));
        player1.addTCCard(new TrainCarCard("RED"));
        player1.addTCCard(new TrainCarCard("RED"));

        player2.addTCCard(new TrainCarCard("BLUE"));
        player2.addTCCard(new TrainCarCard("BLUE"));
        player2.addTCCard(new TrainCarCard("BLUE"));
        player2.addTCCard(new TrainCarCard("RED"));

        playerHand.clear();
        builder.setLength(0);
        for(int i = 0; i < player1.getTcHand().size(); i++) {
            builder.append(player1.getTcHand().get(i).getColor() + " ");
        }
        playerHand.setText(builder.toString());
        player.setText("Current Player:" + currentPlayer.getColor());
    }

    /*
        The buttonPressed will handle all the logic and events happening in the GUI.
        This ranges from showing the current player, clearing the board for the next player's turn,
            showing the hand of the current player.
        This method will also invoke GameLogic methods such as switching current players, checking if a move is valid,
            drawing cards etc.
     */
    @FXML
    void buttonPressed(ActionEvent event) {
        Button pressed = (Button) event.getSource();

        /*
            Check if one the one of the buttons is pressed first!
            If one of the destinations were pressed, we proceed with assuming that the player will claim a route.
         */
        if (pressed.equals(SF) || pressed.equals(LA) || pressed.equals(SD) || pressed.equals(LV)) {
        /*
            Check if one of the city variables is still empty so the player can choose the second destination.
            Doing this to prevent the player from continually spamming the buttons and overriding the data stored already
            This is also is a fail safe so that in the even that the player "accidentally" presses a button after
            choosing two destinations already, nothing will happen.
         */
            if (city1.isEmpty() || city2.isEmpty()) {
                if ( pressed.equals(SF) && (!city1.equals("SF") && !city2.equals("SF")) ) {
                    SF.setStyle("-fx-background-color: #7CFC00");
                    if (city1.isEmpty()) {
                        city1 = SF.getText();
                    } else {
                        city2 = SF.getText();
                    }
                } else if ( pressed.equals(LA) && (!city1.equals("LA") && !city2.equals("LA")) ) {
                    LA.setStyle("-fx-background-color: #7CFC00");
                    if (city1.isEmpty()) {
                        city1 = LA.getText();
                    } else {
                        city2 = LA.getText();
                    }
                } else if ( pressed.equals(SD) && (!city1.equals("SD") && !city2.equals("SD")) ) {
                    SD.setStyle("-fx-background-color: #7CFC00");
                    if (city1.isEmpty()) {
                        city1 = SD.getText();
                    } else {
                        city2 = SD.getText();
                    }
                } else if ( pressed.equals(LV) && (!city1.equals("LV") && !city2.equals("LV")) ) {
                    LV.setStyle("-fx-background-color: #7CFC00");
                    if (city1.isEmpty()) {
                        city1 = LV.getText();
                    } else {
                        city2 = LV.getText();
                    }
                }
                System.out.println(city1);
                System.out.println(city2);
            }
        }

        /*
            We a boolean flag for each route to prevent the claimed route to be claimed by the other player.
            This will ensure that a route claimed by a player won't be overridden by the other player
         */
        if (pressed.equals(route)) {
            if (gameLogic.isValidMove(currentPlayer, board, city1, city2)) {

                gameLogic.discPlayerHand(currentPlayer, board, city1, city2);
                if ((city1.equals("SF") && city2.equals("LA")) || ((city1.equals("LA") && city2.equals("SF")))) {
                    if (!routeClaimed1) {
                        routeClaimed1 = true;
                        SFtoLA1.setFill(currentPlayer.getPlayerColor());
                        SFtoLA2.setFill(currentPlayer.getPlayerColor());
                        SFtoLA3.setFill(currentPlayer.getPlayerColor());
                    }
                } else if ((city1.equals("SF") && city2.equals("LV")) || ((city1.equals("LV") && city2.equals("SF")))) {
                    if (!routeClaimed2) {
                        routeClaimed2 = true;
                        SFtoLV1.setFill(currentPlayer.getPlayerColor());
                        SFtoLV2.setFill(currentPlayer.getPlayerColor());
                        SFtoLV3.setFill(currentPlayer.getPlayerColor());
                    }
                } else if ((city1.equals("SD") && city2.equals("LA")) || ((city1.equals("LA") && city2.equals("SD")))) {
                    if (!routeClaimed3) {
                        routeClaimed3 = true;
                        LAtoSD1.setFill(currentPlayer.getPlayerColor());
                        LAtoSD2.setFill(currentPlayer.getPlayerColor());
                    }
                } else if ((city1.equals("SD") && city2.equals("LV")) || ((city1.equals("LV") && city2.equals("SD")))) {
                    if (!routeClaimed4) {
                        routeClaimed4 = true;
                        SDtoLV1.setFill(currentPlayer.getPlayerColor());
                        SDtoLV2.setFill(currentPlayer.getPlayerColor());
                        SDtoLV3.setFill(currentPlayer.getPlayerColor());
                        SDtoLV4.setFill(currentPlayer.getPlayerColor());
                    }
                }

                //Clear the formatting after claiming a route for the next player's turn
                city1 = "";
                city2 = "";
                SF.setStyle(null);
                LA.setStyle(null);
                SD.setStyle(null);
                LV.setStyle(null);

                //After claiming a route, we switch players now
                currentPlayer = gameLogic.getCurrentPlayer(currentPlayer, player1, player2);
                //Showing the hand of the current player after the previous player had drawn a card
                playerHand.clear();
                builder.setLength(0);
                for(int i = 0; i < currentPlayer.getTcHand().size(); i++) {
                    builder.append(currentPlayer.getTcHand().get(i).getColor() + " ");
                }
                playerHand.setText(builder.toString());
                player.setText("Current Player:" + currentPlayer.getColor());

            } else {
                System.out.println("NOT A VALID MOVE");
                //Clear the formatting after claiming a route for the next player's turn
                city1 = "";
                city2 = "";
                SF.setStyle(null);
                LA.setStyle(null);
                SD.setStyle(null);
                LV.setStyle(null);
            }
        }

        if (pressed.equals(trainCard)) {
            currentPlayer.addTCCard(board.getTCCard());

            //After drawing a card, we switch players now
            currentPlayer = gameLogic.getCurrentPlayer(currentPlayer, player1, player2);

            //Showing the hand of the current player after the previous player had drawn a card
            playerHand.clear();
            builder.setLength(0);
            for(int i = 0; i < currentPlayer.getTcHand().size(); i++) {
                builder.append(currentPlayer.getTcHand().get(i).getColor() + " ");
            }
            playerHand.setText(builder.toString());
            player.setText("Current Player:" + currentPlayer.getColor());
        }

        if (pressed.equals(destinationCard)) {
            currentPlayer.addTCCard(board.getDCCard());

            //After drawing a card, we switch players now
            currentPlayer = gameLogic.getCurrentPlayer(currentPlayer, player1, player2);

            //Showing the hand of the current player after the previous player had drawn a card
            playerHand.clear();
            builder.setLength(0);
            for(int i = 0; i < currentPlayer.getTcHand().size(); i++) {
                builder.append(currentPlayer.getTcHand().get(i).getColor() + " ");
            }
            playerHand.setText(builder.toString());
            player.setText("Current Player:" + currentPlayer.getColor());
        }

       //Application will close if the users choose to quit the game
       if (pressed.equals(quitButton)) {
           Platform.exit();
       }
    }

}

