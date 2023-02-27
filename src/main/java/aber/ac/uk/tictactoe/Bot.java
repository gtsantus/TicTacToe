package aber.ac.uk.tictactoe;

import java.util.Random;

public class Bot {
    private int[] gameState;

    public Bot(){
        gameState = new int[9];
        for (int i: gameState) {
            gameState[i] = 0;
        }
    }

    public int getNextMove(){
        return 0;
    }

    public void setGameState(int[] newState){
        gameState = newState;
    }
}
