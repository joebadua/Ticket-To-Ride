import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.HashMap;

public class GUIController {

    private Player player1 = new Player("AQUA", Color.AQUA);
    private Player player2 = new Player("PINK",Color.PINK);
    private Player currentPlayer = player1;
    private GameBoard board = new GameBoard();
    private GameLogic gameLogic = new GameLogic();
    private String city1 = "";
    private String city2 = "";
    private StringBuilder builder = new StringBuilder();
    private HashMap<String, RadioButton> destinations;

    @FXML
    private TextArea playerHand;

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
    private RadioButton Warren;

    @FXML
    private RadioButton Erie;

    @FXML
    private RadioButton Buffalo;

    @FXML
    private RadioButton OilCity;

    @FXML
    private RadioButton YoungsTown;

    @FXML
    private RadioButton Dubois;

    @FXML
    private RadioButton Pittsburg;

    @FXML
    private RadioButton Wheeling;

    @FXML
    private RadioButton MorganTown;

    @FXML
    private RadioButton Johstown;

    @FXML
    private RadioButton Altoona;

    @FXML
    private RadioButton Lewiston;

    @FXML
    private RadioButton Cumberland;

    @FXML
    private RadioButton Chambersburg;

    @FXML
    private RadioButton Harrisburg;

    @FXML
    private RadioButton Gettysburg;

    @FXML
    private RadioButton York;

    @FXML
    private RadioButton Baltimore;

    @FXML
    private RadioButton Lancaster;

    @FXML
    private RadioButton Reading;

    @FXML
    private RadioButton Philadelphia;

    @FXML
    private RadioButton Allentown;

    @FXML
    private RadioButton Stroudsburg;

    @FXML
    private RadioButton NewYork;

    @FXML
    private RadioButton AtlanticCity;

    @FXML
    private RadioButton Albany;

    @FXML
    private RadioButton Scranton;

    @FXML
    private RadioButton Williamsport;

    @FXML
    private RadioButton Towanda;

    @FXML
    private RadioButton Binghamton;

    @FXML
    private RadioButton Elmira;

    @FXML
    private RadioButton Syracuse;

    @FXML
    private RadioButton Rochester;

    @FXML
    private RadioButton Coudersport;

    @FXML
    private Rectangle ErieToYoungstownYellow1;

    @FXML
    private Rectangle ErieToYoungstownYellow2;

    @FXML
    private Rectangle ErieToYoungstownYellow3;

    @FXML
    private Rectangle ErieToYoungstownYellow4;

    @FXML
    private Rectangle ErieToYoungstownGreen1;

    @FXML
    private Rectangle ErieToYoungstownGreen2;

    @FXML
    private Rectangle ErieToYoungstownGreen3;

    @FXML
    private Rectangle ErieToYoungstownGreen4;

    @FXML
    private Rectangle CoudersportToWilliamsport1;

    @FXML
    private Rectangle CoudersportToWilliamsport2;

    @FXML
    private Rectangle CoudersportToWilliamsport3;

    @FXML
    private Rectangle CoudersportToWilliamsport4;

    @FXML
    private Rectangle BinghamtonToScranton1;

    @FXML
    private Rectangle BinghamtonToScranton2;

    @FXML
    private Rectangle BinghamtonToScranton3;

    @FXML
    private Rectangle AlbanyToNewYorkGreen1;

    @FXML
    private Rectangle AlbanyToNewYorkGreen2;

    @FXML
    private Rectangle AlbanyToNewYorkGreen3;

    @FXML
    private Rectangle AlbanyToNewYorkGreen4;

    @FXML
    private Rectangle AlbanyToNewYorkGreen5;

    @FXML
    private Rectangle AlbanyToNewYorkGreen6;

    @FXML
    private Rectangle AlbanyToNewYorkBlue1;

    @FXML
    private Rectangle AlbanyToNewYorkBlue2;

    @FXML
    private Rectangle AlbanyToNewYorkBlue3;

    @FXML
    private Rectangle AlbanyToNewYorkBlue4;

    @FXML
    private Rectangle AlbanyToNewYorkBlue5;

    @FXML
    private Rectangle AlbanyToNewYorkBlue6;

    @FXML
    private Rectangle ReadingToAllentown1;

    @FXML
    private Rectangle ReadingToAllentown2;

    @FXML
    private Rectangle CumberlandToChambersburg1;

    @FXML
    private Rectangle CumberlandToChambersburg2;

    @FXML
    private Rectangle AltoonaToLewiston2;

    @FXML
    private Rectangle AltoonaToLewiston1;

    @FXML
    private Rectangle WheelingToPittsburg1;

    @FXML
    private Rectangle WheelingToPittsburg2;

    @FXML
    private Rectangle BuffaloToWarren1;

    @FXML
    private Rectangle BuffaloToWarren2;

    @FXML
    private Rectangle BuffaloToWarren3;

    @FXML
    private Rectangle BuffaloToWarren4;

    @FXML
    private Rectangle RochesterToElmira1;

    @FXML
    private Rectangle RochesterToElmira2;

    @FXML
    private Rectangle RochesterToElmira3;

    @FXML
    private Rectangle LancasterToPhillyGreen1;

    @FXML
    private Rectangle LancasterToPhilly2;

    @FXML
    private Rectangle LancasterToPhilly3;

    @FXML
    private Rectangle LancasterToPhilly4;

    @FXML
    private Rectangle BaltimoreToCumberland1;

    @FXML
    private Rectangle BaltimoreToCumberland2;

    @FXML
    private Rectangle BaltimoreToCumberland3;

    @FXML
    private Rectangle BaltimoreToCumberland4;

    @FXML
    private Rectangle BaltimoreToCumberland5;

    @FXML
    private Rectangle BaltimoreToCumberland6;

    @FXML
    private Rectangle BaltimoreToCumberland7;

    @FXML
    private Rectangle HarrisburgToChambersburg1;

    @FXML
    private Rectangle HarrisburgToChambersburg2;

    @FXML
    private Rectangle AltoonaToJohnstown;

    @FXML
    private Rectangle ErieToWarren1;

    @FXML
    private Rectangle ErieToWarren2;

    @FXML
    private Rectangle ErieToWarren3;

    @FXML
    private Rectangle RochesterToSyracuseBlue1;

    @FXML
    private Rectangle RochesterToSyracuseBlue2;

    @FXML
    private Rectangle RochesterToSyracuseBlue3;

    @FXML
    private Rectangle RochesterToSyracuseBlue4;

    @FXML
    private Rectangle ScrantonToAllentownBlue1;

    @FXML
    private Rectangle ScrantonToAllentownBlue2;

    @FXML
    private Rectangle ScrantonToAllentownBlue3;

    @FXML
    private Rectangle YoungstownToPittsburgBlue1;

    @FXML
    private Rectangle YoungstownToPittsburgBlue2;

    @FXML
    private Rectangle YoungstownToPittsburgBlue3;

    @FXML
    private Rectangle YoungstownToPittsburgBlue4;

    @FXML
    private Rectangle WheelingToMorgantown1;

    @FXML
    private Rectangle WheelingToMorgantown2;

    @FXML
    private Rectangle WheelingToMorgantown3;

    @FXML
    private Rectangle RochesterToSyracusePink1;

    @FXML
    private Rectangle RochesterToSyracusePink2;

    @FXML
    private Rectangle RochesterToSyracusePink3;

    @FXML
    private Rectangle RochesterToSyracusePink4;

    @FXML
    private Rectangle BinghamtonToAlbany1;

    @FXML
    private Rectangle BinghamtonToAlbany2;

    @FXML
    private Rectangle BinghamtonToAlbany3;

    @FXML
    private Rectangle BinghamtonToAlbany4;

    @FXML
    private Rectangle BinghamtonToAlbany5;

    @FXML
    private Rectangle BinghamtonToAlbany6;

    @FXML
    private Rectangle OilCityToDubois1;

    @FXML
    private Rectangle OilCityToDubois2;

    @FXML
    private Rectangle OilCityToDubois3;

    @FXML
    private Rectangle HarrisburgToReading1;

    @FXML
    private Rectangle HarrisburgToReading2;

    @FXML
    private Rectangle YorkToLancaster;

    @FXML
    private Rectangle PittsburgToMorgantown1;

    @FXML
    private Rectangle PittsburgToMorgantown2;

    @FXML
    private Rectangle PittsburgToMorgantown3;

    @FXML
    private Rectangle JohnstownToAltoona;

    @FXML
    private Rectangle ReadingToLancaster;

    @FXML
    private Rectangle HarrisburgToGettysburg1;

    @FXML
    private Rectangle HarrisburgToGettysburg2;

    @FXML
    private Rectangle WilliamsportToLewiston1;

    @FXML
    private Rectangle WilliamsportToLewiston2;

    @FXML
    private Rectangle WilliamsportToLewiston3;

    @FXML
    private Rectangle ScrantonToStroudsburg1;

    @FXML
    private Rectangle ScrantonToStroudsburg2;

    @FXML
    private Rectangle SyracusToBinghamton1;

    @FXML
    private Rectangle SyracusToBinghamton2;

    @FXML
    private Rectangle ElmiraToTowanda1;

    @FXML
    private Rectangle ElmiraToTowanda2;

    public void initialize(){
        destinations = new HashMap<>();
/*        destinations.put(Warren.getId(), Warren);
        destinations.put(Dubois.getId(), Dubois);
        destinations.put(Pittsburg.getId(), Pittsburg);
        destinations.put(Lancaster.getId(), Lancaster);
        destinations.put(OilCity.getId(), OilCity);
        destinations.put(Scranton.getId(), Scranton);
        destinations.put(Williamsport.getId(), Williamsport);
        destinations.put(Philadelphia.getId(), Philadelphia);
        destinations.put(Baltimore.getId(), Baltimore);
        destinations.put(Gettysburg.getId(), Gettysburg);
        destinations.put(Wheeling.getId(), Wheeling);
        destinations.put(MorganTown.getId(), MorganTown);
        destinations.put(Towanda.getId(), Towanda);
        destinations.put(Elmira.getId(), Elmira);
        destinations.put(Erie.getId(), Erie);
        destinations.put(YoungsTown.getId(), YoungsTown);
        destinations.put(York.getId(), York);
        destinations.put(Lewiston.getId(), Lewiston);
        destinations.put(Albany.getId(), Albany);
        destinations.put(Altoona.getId(), Altoona);
        destinations.put(Syracuse.getId(), Syracuse);
        destinations.put(Buffalo.getId(), Buffalo);
        destinations.put(Stroudsburg.getId(), Stroudsburg);
        destinations.put(Reading.getId(), Reading);
        destinations.put(Chambersburg.getId(), Chambersburg);
        destinations.put(Johstown.getId(), Johstown);
        destinations.put(Rochester.getId(), Rochester);
        destinations.put(Coudersport.getId(), Coudersport);
        destinations.put(Harrisburg.getId(), Harrisburg);
        destinations.put(AtlanticCity.getId(), AtlanticCity);
        destinations.put(Allentown.getId(), Allentown);
        destinations.put(Cumberland.getId(), Cumberland);*/

    }
    @FXML
    void buttonPressed(ActionEvent event) {

    }

    @FXML
    void pressed(ActionEvent event) {
        RadioButton button = (RadioButton)event.getSource();
        if ( city1.isEmpty() || city2.isEmpty() ) {
            if ( city1.isEmpty() ) {
               city1 = button.getId();
               System.out.println(city1);
            } else {
                city2 = button.getId();
                System.out.println(city2);
            }
        } else {
            for(String key : destinations.keySet()) {
                System.out.println(key);
            }
        }
    }

}
