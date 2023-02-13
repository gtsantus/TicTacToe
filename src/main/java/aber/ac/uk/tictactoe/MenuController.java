package aber.ac.uk.tictactoe;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

    public Button btnPvP;
    public Button btnBvB;
    public Button btnPvB;

    public void onPvPButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MenuController.class.getResource("game-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);
        Stage stage = new Stage();
        stage.setTitle("Game");
        stage.setScene(scene);
        stage.show();
    }

    public void onPvBButtonClick() {
        btnPvP.setVisible(false);
        btnBvB.setVisible(false);
    }

    public void onBvBButtonClick() {
        btnPvP.setVisible(false);
        btnPvB.setVisible(false);
    }
}