package aber.ac.uk.tictactoe;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TreeBot extends Bot{
    private int[] gameState;
    private final int player;

    public TreeBot(int newPlayer){
        gameState = new int[9];
        player = newPlayer;
    }

    public void setGameState(int[] newState){
        System.arraycopy(newState, 0, gameState, 0, 9);
    }

    public int getNextMove(){
        State tree = generateTree();
        //return minMaxSearch(tree, 10, true);
        return highestValue(tree);
    }

    private int highestValue(State current){
        int maxVal = -5000;
        int move = -1;
        for (State child: current.getChildren()) {
            if(child.getValue() > maxVal){
                move = child.getMove();
                maxVal = child.getValue();
            }
        }
        return move;
    }

    private int minMaxSearch (State current, int depth, boolean maximizingPlayer){
            int move = -1;
            if(depth == 0 || current.isTerminal()){
                return current.getValue() * depth;
            }

            if(maximizingPlayer){
                int maxEval = -100;
                int eval;
                for (State child: current.getChildren()) {
                    eval = minMaxSearch(child, depth - 1, false);
                    if(eval > maxEval){
                        maxEval = eval;
                        move = child.getMove();
                    }
                }
                return move;
            }
            else{
                int minEval = 100;
                int eval;
                for (State child: current.getChildren()) {
                    eval = minMaxSearch(child, depth - 1, true);
                    if(eval < minEval){
                        minEval = eval;
                        move = child.getMove();
                    }
                }
                return move;
            }
    }

    
    private int utility(int[] newGameState){
        if(newGameState[0] == newGameState[1] && newGameState[1] == newGameState[2] && newGameState[0] == 1 || newGameState[3] == newGameState[4] && newGameState[4] == newGameState[5] && newGameState[3] == 1 ||
                newGameState[6] == newGameState[7] && newGameState[7] == newGameState[8] && newGameState[6] == 1 || newGameState[0] == newGameState[3] && newGameState[3] == newGameState[6] && newGameState[0] == 1 ||
                newGameState[1] == newGameState[4] && newGameState[4] == newGameState[7] && newGameState[1] == 1 || newGameState[2] == newGameState[5] && newGameState[5] == newGameState[8] && newGameState[2] == 1 ||
                newGameState[0] == newGameState[4] && newGameState[4] == newGameState[8] && newGameState[0] == 1|| newGameState[2] == newGameState[4] && newGameState[4] == newGameState[6] && newGameState[2] == 1){
            if(player == 1){
                return -1;
            }else if (player == 2){
                return 1;
            }
        }
        else if(newGameState[0] == newGameState[1] && newGameState[1] == newGameState[2] && newGameState[0] == 2 || newGameState[3] == newGameState[4] && newGameState[4] == newGameState[5] && newGameState[3] == 2 ||
                newGameState[6] == newGameState[7] && newGameState[7] == newGameState[8] && newGameState[6] == 2 || newGameState[0] == newGameState[3] && newGameState[3] == newGameState[6] && newGameState[0] == 2 ||
                newGameState[1] == newGameState[4] && newGameState[4] == newGameState[7] && newGameState[1] == 2 || newGameState[2] == newGameState[5] && newGameState[5] == newGameState[8] && newGameState[2] == 2 ||
                newGameState[0] == newGameState[4] && newGameState[4] == newGameState[8] && newGameState[0] == 2|| newGameState[2] == newGameState[4] && newGameState[4] == newGameState[6] && newGameState[2] == 2){
            if(player == 2){
                return 1;
            }else if (player == 1){
                return -1;
            }
        }
        return 0;
    }

    private State generateTree(){
        State root = new State(gameState);
        fillGameTree(root, 2);
        return root;
    }

    private void fillGameTree(State parentState, int currentPlayer){
        for(int space : parentState.getAvailableSpaces()) {
            State childState = new State(parentState, space);
            parentState.getChildren().add(childState);
            childState.getGameState()[space] = currentPlayer;

            if(childState.isTerminal()){
                childState.setValue(utility(childState.getGameState()));
            }
            else{
                if(currentPlayer == 1){
                    fillGameTree(childState, 2);
                }else{
                    fillGameTree(childState, 1);
                }
            }
            parentState.setValue(parentState.getValue() + childState.getValue());
        }
    }
}
