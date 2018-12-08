import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
    WILL BE THE MAIN FUNCTION FOR THE GAME
 */
public class TickeToRide extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/TicketToRide2.fxml"));
        Scene scene = new Scene(root);

        primaryStage.setTitle("Ticket-To-Ride");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
