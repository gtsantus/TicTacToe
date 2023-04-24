package aber.ac.uk.tictactoe;

public class Bot {
    private final int[] gameState;

    public Bot(){
        gameState = new int[9];
    }

    public int getNextMove(){
        return 0;
    }

    public void setGameState(int[] newState){
        System.arraycopy(newState, 0, gameState, 0, 9);
    }

    public void update(int winner) {
    }

    public void load(){

    }
}
