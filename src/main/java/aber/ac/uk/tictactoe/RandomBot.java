package aber.ac.uk.tictactoe;

import java.util.Random;

public class RandomBot extends Bot{

    private int[] gameState;

    public int getNextMove(){
        Random rand = new Random();
        int move = rand.nextInt(0,9);
        while (true){
            if(gameState[move] == 0){
                return move;
            }
            else{
                move = rand.nextInt(0,9);
            }
        }
    }

    public void setGameState(int[] newState){
        gameState = newState;
    }
}