package aber.ac.uk.tictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

    private int gameMode = 0;

    private Bot bot1;
    public Button btnPvP;
    public Button btnBvB;
    public Button btnPvB;
    public Button btnRandom2;
    public Button btnTree2;
    public Button btnReinforce2;
    public Label lblPickABot2;
    public Label lblCurrentBot2;
    public Button btnRandom1;
    public Button btnTree1;
    public Button btnReinforce1;
    public Label lblPickABot1;
    public Button btnStart;
    public Label lblCurrentBot1;

    public void onPvPButtonClick() throws IOException {
        gameMode = 0;
        FXMLLoader fxmlLoader = new FXMLLoader(MenuController.class.getResource("game-view.fxml"));
        GameController controller = fxmlLoader.getController();
        controller.setGameMode(gameMode);
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);
        Stage stage = new Stage();
        stage.setTitle("Game");
        stage.setScene(scene);
        stage.show();
    }

    public void onPvBButtonClick() {
        gameMode = 1;
        btnPvP.setVisible(false);
        btnBvB.setVisible(false);
        btnRandom1.setVisible(true);
        btnReinforce1.setVisible(true);
        btnTree1.setVisible(true);
        btnStart.setVisible(true);
        lblPickABot1.setVisible(true);
        lblCurrentBot1.setVisible(true);

    }

    public void onBvBButtonClick() {
        gameMode = 2;
        btnPvP.setVisible(false);
        btnPvB.setVisible(false);
        btnRandom1.setVisible(true);
        btnReinforce1.setVisible(true);
        btnTree1.setVisible(true);
        lblPickABot1.setVisible(true);
        lblCurrentBot1.setVisible(true);
        btnRandom2.setVisible(true);
        btnReinforce2.setVisible(true);
        btnTree2.setVisible(true);
        lblPickABot2.setVisible(true);
        lblCurrentBot2.setVisible(true);
        btnStart.setVisible(true);
    }

    public void onStartButtonClick(ActionEvent actionEvent) throws IOException {
        if(gameMode == 1){
            FXMLLoader fxmlLoader = new FXMLLoader(MenuController.class.getResource("game-view.fxml"));
            GameController controller = fxmlLoader.getController();
            controller.setGameMode(gameMode);
            controller.setBot1(bot1);
            Scene scene = new Scene(fxmlLoader.load(), 700, 500);
            Stage stage = new Stage();
            stage.setTitle("Game");
            stage.setScene(scene);
            stage.show();
        }
    }

    public void onReinforce1Click(ActionEvent actionEvent) {
    }

    public void onTree1Click(ActionEvent actionEvent) {
    }

    public void onRandom1Click(ActionEvent actionEvent) {
        bot1 = new Bot();
    }

    public void onReinforce2Click(ActionEvent actionEvent) {
    }

    public void onTree2Click(ActionEvent actionEvent) {
    }

    public void onRandom2Click(ActionEvent actionEvent) {
        bot1 = new Bot();
    }
}