package aber.ac.uk.tictactoe;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.Random;

public class GameController {
    TURN turn;
    private boolean gameStart = false;
    private int gameMode;
    private int[] gameState;

    private Bot bot1;
    private Bot bot2;
    public Label lblNo1;
    public Label lblNo2;
    public Label lblNo3;
    public Label lblNo4;
    public Label lblNo5;
    public Label lblNo6;
    public Label lblNo7;
    public Label lblNo8;
    public Label lblNo9;
    public Label lblTurn;
    public Button btnStart;

    private void reset(){
        lblNo1.setText("");
        lblNo2.setText("");
        lblNo3.setText("");
        lblNo4.setText("");
        lblNo5.setText("");
        lblNo6.setText("");
        lblNo7.setText("");
        lblNo8.setText("");
        lblNo9.setText("");
        gameState = new int[9];
        for (int i: gameState) {
            gameState[i] = 0;
        }
    }

    private void startGame(){
        reset();
        Random rand = new Random();
        int coin = rand.nextInt();
        if(coin%2 == 0){
            lblTurn.setText("Turn: X");
            turn = TURN.X;
        }
        else{
            lblTurn.setText("Turn: O");
            turn = TURN.O;
        }
        if(gameMode == 0){
            gameStart = true;
        }else if(gameMode == 1){
            gameStart = true;
            if(turn == TURN.O){
                    bot1.setGameState(gameState);
                    int nextMove = bot1.getNextMove();
                    for(int i =1; i < 11; i++){
                        if(i == nextMove && nextMove == 1){
                            onBox1Clicked();
                        } else if (i == nextMove && nextMove == 2) {
                            onBox2Clicked();
                        } else if (i == nextMove && nextMove == 3) {
                            onBox3Clicked();
                        }else if (i == nextMove && nextMove == 4) {
                            onBox4Clicked();
                        }else if (i == nextMove && nextMove == 5) {
                            onBox5Clicked();
                        }else if (i == nextMove && nextMove == 6) {
                            onBox6Clicked();
                        }else if (i == nextMove && nextMove == 7) {
                            onBox7Clicked();
                        }else if (i == nextMove && nextMove == 8) {
                            onBox8Clicked();
                        }else if (i == nextMove && nextMove == 9) {
                            onBox9Clicked();
                        }
                    }
            }
        }
        else if(gameMode == 2){
            gameStart = true;
            if(turn == TURN.O){
                bot1.setGameState(gameState);
                int nextMove = bot1.getNextMove();
                for(int i =1; i < 11; i++){
                    if(i == nextMove && nextMove == 1){
                        onBox1Clicked();
                    } else if (i == nextMove && nextMove == 2) {
                        onBox2Clicked();
                    } else if (i == nextMove && nextMove == 3) {
                        onBox3Clicked();
                    }else if (i == nextMove && nextMove == 4) {
                        onBox4Clicked();
                    }else if (i == nextMove && nextMove == 5) {
                        onBox5Clicked();
                    }else if (i == nextMove && nextMove == 6) {
                        onBox6Clicked();
                    }else if (i == nextMove && nextMove == 7) {
                        onBox7Clicked();
                    }else if (i == nextMove && nextMove == 8) {
                        onBox8Clicked();
                    }else if (i == nextMove && nextMove == 9) {
                        onBox9Clicked();
                    }
                }
            }
            if(turn == TURN.X){
                bot2.setGameState(gameState);
                int nextMove = bot2.getNextMove();
                for(int i =1; i < 10; i++){
                    if(i == nextMove && nextMove == 1){
                        onBox1Clicked();
                    } else if (i == nextMove && nextMove == 2) {
                        onBox2Clicked();
                    } else if (i == nextMove && nextMove == 3) {
                        onBox3Clicked();
                    }else if (i == nextMove && nextMove == 4) {
                        onBox4Clicked();
                    }else if (i == nextMove && nextMove == 5) {
                        onBox5Clicked();
                    }else if (i == nextMove && nextMove == 6) {
                        onBox6Clicked();
                    }else if (i == nextMove && nextMove == 7) {
                        onBox7Clicked();
                    }else if (i == nextMove && nextMove == 8) {
                        onBox8Clicked();
                    }else if (i == nextMove) {
                        onBox9Clicked();
                    }
                }
            }
        }

    }

    public void onStartButtonClick() {
        btnStart.setVisible(false);
        startGame();
    }

    private void checkIfWon(){
            if (lblNo1.getText().equals(lblNo2.getText()) && lblNo2.getText().equals(lblNo3.getText()) && !lblNo1.getText().equals("") || lblNo4.getText().equals(lblNo5.getText()) && lblNo5.getText().equals(lblNo6.getText()) && !lblNo4.getText().equals("") ||
                    lblNo7.getText().equals(lblNo8.getText()) && lblNo8.getText().equals(lblNo9.getText()) && !lblNo7.getText().equals("") || lblNo1.getText().equals(lblNo4.getText()) && lblNo4.getText().equals(lblNo7.getText()) && !lblNo1.getText().equals("") ||
                    lblNo2.getText().equals(lblNo5.getText()) && lblNo5.getText().equals(lblNo8.getText()) && !lblNo2.getText().equals("") || lblNo3.getText().equals(lblNo6.getText()) && lblNo6.getText().equals(lblNo9.getText()) && !lblNo3.getText().equals("") ||
                    lblNo1.getText().equals(lblNo5.getText()) && lblNo5.getText().equals(lblNo9.getText()) && !lblNo1.getText().equals("") || lblNo3.getText().equals(lblNo5.getText()) && lblNo5.getText().equals(lblNo7.getText()) && !lblNo3.getText().equals("")) {
                        lblTurn.setText(turn.toString() + " wins!");
                        gameStart = false;
            }else if (gameState[0] != 0 && gameState[1] != 0 && gameState[2] != 0 && gameState[3] != 0 && gameState[4] != 0 && gameState[5] != 0 && gameState[6] != 0 && gameState[7] != 0 && gameState[8] != 0){
                lblTurn.setText("Draw!");
                gameStart = false;
            }
            else{
                if(turn == TURN.X){
                    lblTurn.setText("Turn: O");
                    turn = TURN.O;
                    if(gameMode == 1 || gameMode == 2){
                        bot1.setGameState(gameState);
                        int nextMove = bot1.getNextMove();
                        for(int i =1; i < 11; i++){
                            if(i == nextMove && nextMove == 1){
                                onBox1Clicked();
                            } else if (i == nextMove && nextMove == 2) {
                                onBox2Clicked();
                            } else if (i == nextMove && nextMove == 3) {
                                onBox3Clicked();
                            }else if (i == nextMove && nextMove == 4) {
                                onBox4Clicked();
                            }else if (i == nextMove && nextMove == 5) {
                                onBox5Clicked();
                            }else if (i == nextMove && nextMove == 6) {
                                onBox6Clicked();
                            }else if (i == nextMove && nextMove == 7) {
                                onBox7Clicked();
                            }else if (i == nextMove && nextMove == 8) {
                                onBox8Clicked();
                            }else if (i == nextMove && nextMove == 9) {
                                onBox9Clicked();
                            }
                        }
                    }
                }else{
                    lblTurn.setText("Turn: X");
                    turn = TURN.X;
                    if(gameMode == 2){
                        bot2.setGameState(gameState);
                        int nextMove = bot2.getNextMove();
                        for(int i =1; i < 11; i++){
                            if(i == nextMove && nextMove == 1){
                                onBox1Clicked();
                            } else if (i == nextMove && nextMove == 2) {
                                onBox2Clicked();
                            } else if (i == nextMove && nextMove == 3) {
                                onBox3Clicked();
                            }else if (i == nextMove && nextMove == 4) {
                                onBox4Clicked();
                            }else if (i == nextMove && nextMove == 5) {
                                onBox5Clicked();
                            }else if (i == nextMove && nextMove == 6) {
                                onBox6Clicked();
                            }else if (i == nextMove && nextMove == 7) {
                                onBox7Clicked();
                            }else if (i == nextMove && nextMove == 8) {
                                onBox8Clicked();
                            }else if (i == nextMove && nextMove == 9) {
                                onBox9Clicked();
                            }
                        }
                    }
                }
            }
    }

    public void onBox1Clicked(){
        if(gameStart && lblNo1.getText().equals("")){
            lblNo1.setText(turn.toString());
            gameState[0] = 1;
            checkIfWon();
        }
    }

    public void onBox2Clicked(){
        if(gameStart && lblNo2.getText().equals("")){
            lblNo2.setText(turn.toString());
            gameState[1] = 1;
            checkIfWon();
        }
    }

    public void onBox3Clicked(){
        if(gameStart && lblNo3.getText().equals("")){
            lblNo3.setText(turn.toString());
            gameState[2] = 1;
            checkIfWon();
        }
    }

    public void onBox4Clicked(){
        if(gameStart && lblNo4.getText().equals("")){
            lblNo4.setText(turn.toString());
            gameState[3] = 1;
            checkIfWon();
        }
    }

    public void onBox5Clicked(){
        if(gameStart && lblNo5.getText().equals("")){
            lblNo5.setText(turn.toString());
            gameState[4] = 1;
            checkIfWon();
        }
    }

    public void onBox6Clicked(){
        if(gameStart && lblNo6.getText().equals("")){
            lblNo6.setText(turn.toString());
            gameState[5] = 1;
            checkIfWon();
        }
    }

    public void onBox7Clicked(){
        if(gameStart && lblNo7.getText().equals("")){
            lblNo7.setText(turn.toString());
            gameState[6] = 1;
            checkIfWon();
        }
    }

    public void onBox8Clicked(){
        if(gameStart && lblNo8.getText().equals("")){
            lblNo8.setText(turn.toString());
            gameState[7] = 1;
            checkIfWon();
        }
    }

    public void onBox9Clicked(){
        if(gameStart && lblNo9.getText().equals("")){
            lblNo9.setText(turn.toString());
            gameState[8] = 1;
            checkIfWon();
        }
    }

    public void setGameMode(int gm){
        gameMode = gm;
    }

    public void setBot1(Bot bot){
        bot1 = bot;
    }

    public void setBot2(Bot bot){
        bot2 = bot;
    }

}
