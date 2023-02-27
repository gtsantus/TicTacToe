package aber.ac.uk.tictactoe;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.Random;

public class GameController {
    TURN turn;
    private boolean gameStart = false;
    private boolean gameFinalState = false;
    private int gameMode;
    private int[] masterGameState;

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
    public Button btnNextMove;
    public Button btnEndGame;

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
        masterGameState = new int[9];
        for (int i: masterGameState) {
            masterGameState[i] = 0;
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
        gameStart = true;
        if(gameMode == 1){
            if(turn == TURN.O){
                bot1.setGameState(masterGameState);
                int nextMove = bot1.getNextMove();
                for(int i =0; i < 9; i++){
                    if(i == nextMove && nextMove == 0){
                        onBox1Clicked();
                    } else if (i == nextMove && nextMove == 1) {
                        onBox2Clicked();
                    } else if (i == nextMove && nextMove == 2) {
                        onBox3Clicked();
                    }else if (i == nextMove && nextMove == 3) {
                        onBox4Clicked();
                    }else if (i == nextMove && nextMove == 4) {
                        onBox5Clicked();
                    }else if (i == nextMove && nextMove == 5) {
                        onBox6Clicked();
                    }else if (i == nextMove && nextMove == 6) {
                        onBox7Clicked();
                    }else if (i == nextMove && nextMove == 7) {
                        onBox8Clicked();
                    }else if (i == nextMove && nextMove == 8) {
                        onBox9Clicked();
                    }
                }
            }
        }
    }

    public void onStartButtonClick() {
        btnStart.setVisible(false);
        if(gameMode ==  2){
            btnEndGame.setVisible(true);
            btnNextMove.setVisible(true);
        }
        startGame();
    }

    private void checkIfWon(){
            if (lblNo1.getText().equals(lblNo2.getText()) && lblNo2.getText().equals(lblNo3.getText()) && !lblNo1.getText().equals("") || lblNo4.getText().equals(lblNo5.getText()) && lblNo5.getText().equals(lblNo6.getText()) && !lblNo4.getText().equals("") ||
                    lblNo7.getText().equals(lblNo8.getText()) && lblNo8.getText().equals(lblNo9.getText()) && !lblNo7.getText().equals("") || lblNo1.getText().equals(lblNo4.getText()) && lblNo4.getText().equals(lblNo7.getText()) && !lblNo1.getText().equals("") ||
                    lblNo2.getText().equals(lblNo5.getText()) && lblNo5.getText().equals(lblNo8.getText()) && !lblNo2.getText().equals("") || lblNo3.getText().equals(lblNo6.getText()) && lblNo6.getText().equals(lblNo9.getText()) && !lblNo3.getText().equals("") ||
                    lblNo1.getText().equals(lblNo5.getText()) && lblNo5.getText().equals(lblNo9.getText()) && !lblNo1.getText().equals("") || lblNo3.getText().equals(lblNo5.getText()) && lblNo5.getText().equals(lblNo7.getText()) && !lblNo3.getText().equals("")) {
                        lblTurn.setText(turn.toString() + " wins!");
                        gameStart = false;
                        btnStart.setVisible(true);
                        btnEndGame.setVisible(false);
                        btnNextMove.setVisible(false);
            }else if (masterGameState[0] != 0 && masterGameState[1] != 0 && masterGameState[2] != 0 && masterGameState[3] != 0 && masterGameState[4] != 0 && masterGameState[5] != 0 && masterGameState[6] != 0 && masterGameState[7] != 0 && masterGameState[8] != 0){
                lblTurn.setText("Draw!");
                gameStart = false;
            }
            else{
                if(turn == TURN.X){
                    lblTurn.setText("Turn: O");
                    turn = TURN.O;
                    if(gameMode == 1){
                        bot1.setGameState(masterGameState);
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
                    }else if (gameMode == 2 && gameFinalState){
                        onNextMoveClick();
                    }
                }else{
                    lblTurn.setText("Turn: X");
                    turn = TURN.X;
                    if(gameMode == 2 && gameFinalState){
                        onNextMoveClick();
                    }
                }
            }
    }

    public void onBox1Clicked(){
        if(gameStart && lblNo1.getText().equals("")){
            lblNo1.setText(turn.toString());
            if(turn == TURN.X){
                masterGameState[0] = 1;
            }
            else{
                masterGameState[0] = 2;
            }
            checkIfWon();
        }
    }

    public void onBox2Clicked(){
        if(gameStart && lblNo2.getText().equals("")){
            lblNo2.setText(turn.toString());
            if(turn == TURN.X){
                masterGameState[1] = 1;
            }
            else{
                masterGameState[1] = 2;
            }
            checkIfWon();
        }
    }

    public void onBox3Clicked(){
        if(gameStart && lblNo3.getText().equals("")){
            lblNo3.setText(turn.toString());
            if(turn == TURN.X){
                masterGameState[2] = 1;
            }
            else{
                masterGameState[2] = 2;
            }
            checkIfWon();
        }
    }

    public void onBox4Clicked(){
        if(gameStart && lblNo4.getText().equals("")){
            lblNo4.setText(turn.toString());
            if(turn == TURN.X){
                masterGameState[3] = 1;
            }
            else{
                masterGameState[3] = 2;
            }
            checkIfWon();
        }
    }

    public void onBox5Clicked(){
        if(gameStart && lblNo5.getText().equals("")){
            lblNo5.setText(turn.toString());
            if(turn == TURN.X){
                masterGameState[4] = 1;
            }
            else{
                masterGameState[4] = 2;
            }
            checkIfWon();
        }
    }

    public void onBox6Clicked(){
        if(gameStart && lblNo6.getText().equals("")){
            lblNo6.setText(turn.toString());
            if(turn == TURN.X){
                masterGameState[5] = 1;
            }
            else{
                masterGameState[5] = 2;
            }
            checkIfWon();
        }
    }

    public void onBox7Clicked(){
        if(gameStart && lblNo7.getText().equals("")){
            lblNo7.setText(turn.toString());
            if(turn == TURN.X){
                masterGameState[6] = 1;
            }
            else{
                masterGameState[6] = 2;
            }
            checkIfWon();
        }
    }

    public void onBox8Clicked(){
        if(gameStart && lblNo8.getText().equals("")){
            lblNo8.setText(turn.toString());
            if(turn == TURN.X){
                masterGameState[7] = 1;
            }
            else{
                masterGameState[7] = 2;
            }
            checkIfWon();
        }
    }

    public void onBox9Clicked(){
        if(gameStart && lblNo9.getText().equals("")){
            lblNo9.setText(turn.toString());
            if(turn == TURN.X){
                masterGameState[8] = 1;
            }
            else{
                masterGameState[8] = 2;
            }
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

    public void onNextMoveClick() {
        if(turn == TURN.X){
            if(gameMode == 1 || gameMode == 2){
                bot1.setGameState(masterGameState);
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
        }else {
            if (gameMode == 2) {
                bot2.setGameState(masterGameState);
                int nextMove = bot2.getNextMove();
                for (int i = 1; i < 11; i++) {
                    if (i == nextMove && nextMove == 1) {
                        onBox1Clicked();
                    } else if (i == nextMove && nextMove == 2) {
                        onBox2Clicked();
                    } else if (i == nextMove && nextMove == 3) {
                        onBox3Clicked();
                    } else if (i == nextMove && nextMove == 4) {
                        onBox4Clicked();
                    } else if (i == nextMove && nextMove == 5) {
                        onBox5Clicked();
                    } else if (i == nextMove && nextMove == 6) {
                        onBox6Clicked();
                    } else if (i == nextMove && nextMove == 7) {
                        onBox7Clicked();
                    } else if (i == nextMove && nextMove == 8) {
                        onBox8Clicked();
                    } else if (i == nextMove && nextMove == 9) {
                        onBox9Clicked();
                    }
                }
            }
        }
    }

    public void onEndGameClick() {
        gameFinalState = true;
        onNextMoveClick();
    }
}
