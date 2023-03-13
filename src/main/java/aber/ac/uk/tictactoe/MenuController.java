package aber.ac.uk.tictactoe;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

    public Button btnBack;
    private int gameMode = 0;

    private Bot bot1;
    private Bot bot2;
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
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);
        GameController controller = fxmlLoader.getController();
        controller.setGameMode(gameMode);
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
        btnBack.setVisible(true);
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
        btnBack.setVisible(true);
    }

    public void onStartButtonClick() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MenuController.class.getResource("game-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);
        GameController controller = fxmlLoader.getController();
        if(gameMode == 1){
            controller.setGameMode(gameMode);
            controller.setBot1(bot1);
        }
        else if(gameMode == 2){
            controller.setGameMode(gameMode);
            controller.setBot1(bot1);
            controller.setBot2(bot2);
        }
        Stage stage = new Stage();
        stage.setTitle("Game");
        stage.setScene(scene);
        stage.show();
    }

    public void onReinforce1Click() {
        bot1 = new ReinforcementBot();
    }

    public void onTree1Click() {
        bot1 = new TreeBot(2);
    }

    public void onRandom1Click() {
        bot1 = new RandomBot();
    }

    public void onReinforce2Click() {
        bot2 = new ReinforcementBot();
    }

    public void onTree2Click() {
        bot2 = new TreeBot(1);
    }

    public void onRandom2Click() {
        bot2 = new RandomBot();
    }

    public void onBackButtonClick() {
        gameMode = 0;
        btnPvP.setVisible(true);
        btnPvB.setVisible(true);
        btnBvB.setVisible(true);
        btnRandom1.setVisible(false);
        btnReinforce1.setVisible(false);
        btnTree1.setVisible(false);
        lblPickABot1.setVisible(false);
        lblCurrentBot1.setVisible(false);
        btnRandom2.setVisible(false);
        btnReinforce2.setVisible(false);
        btnTree2.setVisible(false);
        lblPickABot2.setVisible(false);
        lblCurrentBot2.setVisible(false);
        btnStart.setVisible(false);
        btnBack.setVisible(false);
    }
}