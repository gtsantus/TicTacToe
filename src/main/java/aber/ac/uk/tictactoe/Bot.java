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
        Random rand = new Random();
        int move = rand.nextInt(1,10);
        while (true){
            if(gameState[move-1] == 0){
                return move;
            }
            else{
                move = rand.nextInt(1,10);
            }
        }
    }

    public void setGameState(int[] newState){
        gameState = newState;
    }
}
