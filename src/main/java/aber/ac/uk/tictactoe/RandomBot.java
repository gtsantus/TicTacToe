package aber.ac.uk.tictactoe;

import java.util.Random;

public class RandomBot extends Bot{

    private int[] gameState;

    public RandomBot(){
        gameState = new int[9];
    }

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
        System.arraycopy(newState, 0, gameState, 0, 9);
    }
}
