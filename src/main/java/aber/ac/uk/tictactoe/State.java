package aber.ac.uk.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class State {
    private final int[] gameState;
    private int value;
    private int move;
    private boolean terminal;
    private final List<State> children;

    private final int[] QValues;


    public State (int[] newState){
        gameState = new int[9];
        QValues = new int [9];
        children = new ArrayList<>();
        System.arraycopy(newState, 0, gameState, 0, 9);
    }

    public State() {
        gameState = new int[9];
        children = new ArrayList<>();
        QValues = new int [9];
    }

    public State(State parent, int move){
        gameState = new int[9];
        children = new ArrayList<>();
        QValues = new int [9];
        this.move = move;
        System.arraycopy(parent.getGameState(), 0, gameState, 0, 9);
        checkTerminal();
    }

    public void setMove(int move) {
        this.move = move;
    }

    public List<State> getChildren() {
        return children;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setGameState(int[] newState){
        System.arraycopy(newState, 0, gameState, 0, 9);
    }

    public int[] getGameState() {
        return gameState;
    }

    public int getValue() {
        return value;
    }

    public int getMove() {
        return move;
    }

    public int[] getQValues() {return QValues;}

    public boolean isTerminal() {
        return terminal;
    }

    public void checkTerminal(){
         terminal = gameState[0] == gameState[1] && gameState[1] == gameState[2] && gameState[0] != 0 || gameState[3] == gameState[4] && gameState[4] == gameState[5] && gameState[3] != 0 ||
                gameState[6] == gameState[7] && gameState[7] == gameState[8] && gameState[6] != 0 || gameState[0] == gameState[3] && gameState[3] == gameState[6] && gameState[0] != 0 ||
                gameState[1] == gameState[4] && gameState[4] == gameState[7] && gameState[1] != 0 || gameState[2] == gameState[5] && gameState[5] == gameState[8] && gameState[2] != 0 ||
                gameState[0] == gameState[4] && gameState[4] == gameState[8] && gameState[0] != 0|| gameState[2] == gameState[4] && gameState[4] == gameState[6] && gameState[2] != 0 ||
                gameState[0] != 0 && gameState[1] != 0 && gameState[2] != 0 && gameState[3] != 0 && gameState[4] != 0 && gameState[5] != 0 && gameState[6] != 0 && gameState[7] != 0 && gameState[8] != 0;
    }

    public ArrayList<Integer> getAvailableSpaces(){
        ArrayList<Integer> available = new ArrayList<>();
        for(int i =0; i < 9; i++){
            if(gameState[i] == 0){
                available.add(i);
            }
        }
        return available;
    }

    public void copy(State target){
        value = target.getValue();
        move = target.getMove();
        System.arraycopy(gameState, 0, target.getGameState(), 0, 9);
        terminal = target.isTerminal();
        children.clear();
        children.addAll(target.getChildren());
    }
}
