package aber.ac.uk.tictactoe;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ReinforcementBot extends Bot{

    private final int player;
    private int[] gameState;
    private List<State> QTable;
    private final List<State> actionHistory = new ArrayList<State>();

    public ReinforcementBot(int newPlayer){
        gameState = new int[9];
        player = newPlayer;
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
                    }
                    else{
                        move = rand.nextInt(0,9);
                        State action = new State(gameState);
                        action.setMove(move);
                        actionHistory.add(action);
                    }
                    return move;
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

    public void load(){
        //loads up what has been learnt from a text document with the format: State, Value for each Action
        QTable = new ArrayList<State>();
        State temp = new State();
        try{
            File database = new File("test1.txt");
            Scanner myReader = new Scanner(database);
            while (myReader.hasNextLine()){
                String data = myReader.nextLine();
                temp = new State();

                temp.getGameState()[0] = data.toCharArray()[1] - 48;
                temp.getGameState()[1] = data.toCharArray()[4] - 48;
                temp.getGameState()[2] = data.toCharArray()[7] - 48;
                temp.getGameState()[3] = data.toCharArray()[10] - 48;
                temp.getGameState()[4] = data.toCharArray()[13] - 48;
                temp.getGameState()[5] = data.toCharArray()[16] - 48;
                temp.getGameState()[6] = data.toCharArray()[19] - 48;
                temp.getGameState()[7] = data.toCharArray()[22] - 48;
                temp.getGameState()[8] = data.toCharArray()[25] - 48;

                String QData = data.substring(29, data.length() - 1);
                String[] tempValues = QData.split(", ");
                for(int i = 0; i < 9; i++){
                    temp.getQValues()[i] = Integer.parseInt(tempValues[i]);
                }

                QTable.add(temp);
            }
            myReader.close();
        }catch(FileNotFoundException e){
            //cry
        }
        if(QTable.isEmpty()){
            QTable.add(temp);
        }
    }

    public void update(int winner) {
        //takes all the moves made by the bot this game and sets their values based on the result of the game
        //Saves what has been learnt to the text document
        StringBuilder output = new StringBuilder();
        StringBuilder data = new StringBuilder();

        for (State s:actionHistory) {
            if(winner == 0){
                int draw = 1;
                s.getQValues()[s.getMove()] = draw;
            }else if(winner == player){
                int reward = 3;
                s.getQValues()[s.getMove()] = reward;
            }
            else{
                int penalty = -1;
                s.getQValues()[s.getMove()] = penalty;
            }
        }

        for (State s:actionHistory) {
            for (State state : QTable) {
                if (Arrays.equals(s.getGameState(), state.getGameState())) {
                    for (int i = 0; i < 9; i++) {
                        state.getQValues()[i] += s.getQValues()[i];
                    }
                    s.setValue(1000);
                }
            }
            if(!(s.getValue() == 1000)){
                QTable.add(s);
            }
        }

        for (State s:QTable) {
            output.append(Arrays.toString(s.getGameState()));
            output.append(" ");
            output.append(Arrays.toString(s.getQValues()));
            output.append("\n");
        }

        if(winner == 0){
            data.append("Result: draw, ");
        }else if(winner == player){
            data.append("Result: win,  ");
        }
        else{
            data.append("Result: lose, ");
        }

        data.append("Number of states in QTable: ");
        data.append(QTable.size());
        data.append("\n");
        try{
            FileWriter writer = new FileWriter("test1.txt");
            writer.write(output.toString());
            writer.close();
            QTable.clear();
        }
        catch (IOException ignored){
        }
        try{
            FileWriter writer = new FileWriter("data1.txt", true);
            writer.write(data.toString());
            writer.close();
        }
        catch (IOException ignored){
        }
    }
}
