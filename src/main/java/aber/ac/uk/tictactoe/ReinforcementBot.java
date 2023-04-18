package aber.ac.uk.tictactoe;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ReinforcementBot extends Bot{

    private final double Learning_Rate = 0.1;

    private int player;
    private final int reward = 3;
    private final int draw = 1;
    private final int penalty = -1;
    private int[] gameState;
    private List<State> QTable;
    private final List<State> actionHistory = new ArrayList<State>();
    private int[][] Q = new int[19683][9];

    public ReinforcementBot(int newPlayer){
        gameState = new int[9];
        player = newPlayer;
        load();
    }

    public int getNextMove() {
        //searchdatabase if state has been seen before, make move based on that, else make random move
        //save said move into a list, then use that list to update data after the game
        Random rand = new Random();
        int move = -1;
        int explore = rand.nextInt(0,100);
        if(explore%20 == 0){
            move = rand.nextInt(0,9);
            while (true){
                if(gameState[move] == 0){
                    State action = new State(gameState);
                    action.setMove(move);
                    actionHistory.add(action);
                    return move;
                }
                else{
                    move = rand.nextInt(0,9);
                }
            }
        }else{
            //make move based on the best one in the Q-Table
            for (State s:QTable) {
                if(s.getGameState() == gameState){
                    for(int i = 0; i < 9; i++){
                        int QValue = 0;
                        if(s.getQValues()[i] > QValue){
                            QValue = s.getQValues()[i];
                            move = i;
                        }
                    }
                    if(move >= 0){
                        State action = new State(gameState);
                        action.setMove(move);
                        actionHistory.add(action);
                        return move;
                    }
                }
            }
            move = rand.nextInt(0,9);
            while (true){
                if(gameState[move] == 0){
                    State action = new State(gameState);
                    action.setMove(move);
                    actionHistory.add(action);
                    return move;
                }
                else{
                    move = rand.nextInt(0,9);
                }
            }
        }
    }

    public void setGameState(int[] newState){
        System.arraycopy(newState, 0, gameState, 0, 9);
    }

    private void load(){
        //loads up what has been learnt from a text document with the format: State, Value for each Action (with an X if it's not a viable action)
        QTable = new ArrayList<State>();
    }

    public void update(int winner) {
        //takes all the moves made by the bot this game and sets their values based on the result of the game
        //Saves what has been learnt to the text document

        StringBuilder output = new StringBuilder();
        for (State s:actionHistory) {
            for (State qs: QTable) {
                if(s.getGameState() == qs.getGameState()){
                    for (int i = 0; i < 9; i++) {
                        qs.getQValues()[i] += s.getQValues()[i];
                    }
                }
            }
            output.append(Arrays.toString(s.getGameState()));
            output.append(" ");
            output.append(Arrays.toString(s.getQValues()));
            output.append("\n");
        }
        try{
            FileWriter writer = new FileWriter("test1.txt", true);
            writer.write(output.toString());
            writer.close();
        }
        catch (IOException e){
        }
    }
}
