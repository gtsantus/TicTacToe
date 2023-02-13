package aber.ac.uk.tictactoe;

import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.util.Random;

public class GameController {
    TURN turn;
    boolean gameStart = false;

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
            }
            else{
                if(turn == TURN.X){
                    lblTurn.setText("Turn: O");
                    turn = TURN.O;
                }else{
                    lblTurn.setText("Turn: X");
                    turn = TURN.X;
                }
            }
    }

    public void onBox1Clicked(){
        if(gameStart && lblNo1.getText().equals("")){
            lblNo1.setText(turn.toString());
            checkIfWon();
        }
    }

    public void onBox2Clicked(){
        if(gameStart && lblNo2.getText().equals("")){
            lblNo2.setText(turn.toString());
            checkIfWon();
        }
    }

    public void onBox3Clicked(){
        if(gameStart && lblNo3.getText().equals("")){
            lblNo3.setText(turn.toString());
            checkIfWon();
        }
    }

    public void onBox4Clicked(){
        if(gameStart && lblNo4.getText().equals("")){
            lblNo4.setText(turn.toString());
            checkIfWon();
        }
    }

    public void onBox5Clicked(){
        if(gameStart && lblNo5.getText().equals("")){
            lblNo5.setText(turn.toString());
            checkIfWon();
        }
    }

    public void onBox6Clicked(){
        if(gameStart && lblNo6.getText().equals("")){
            lblNo6.setText(turn.toString());
            checkIfWon();
        }
    }

    public void onBox7Clicked(){
        if(gameStart && lblNo7.getText().equals("")){
            lblNo7.setText(turn.toString());
            checkIfWon();
        }
    }

    public void onBox8Clicked(){
        if(gameStart && lblNo8.getText().equals("")){
            lblNo8.setText(turn.toString());
            checkIfWon();
        }
    }

    public void onBox9Clicked(){
        if(gameStart && lblNo9.getText().equals("")){
            lblNo9.setText(turn.toString());
            checkIfWon();
        }
    }

}
