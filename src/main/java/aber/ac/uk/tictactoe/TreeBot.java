package aber.ac.uk.tictactoe;

public class TreeBot extends Bot{
    private final int[] gameState;
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
        return minMaxSearch(tree, 10, true).getMove();
    }

    private State minMaxSearch (State current, int depth, boolean maximizingPlayer){
            if(depth == 0 || current.isTerminal()){
                current.setValue(current.getValue() * depth);
                return current;
            }

            if(maximizingPlayer){
                State maxTemp = new State();
                maxTemp.setValue(-5000);
                State temp = new State();
                for (State child: current.getChildren()) {
                    temp.copy(minMaxSearch(child, depth - 1, false));
                    if(temp.getValue() > maxTemp.getValue()){
                        maxTemp.copy(temp);
                        maxTemp.setMove(child.getMove());
                    }
                }
                return maxTemp;
            }
            else{
                State minTemp = new State();
                minTemp.setValue(5000);
                State temp = new State();
                for (State child: current.getChildren()) {
                    temp.copy(minMaxSearch(child, depth - 1, true));
                    if(temp.getValue() < minTemp.getValue()){
                        minTemp.copy(temp);
                        minTemp.setMove(child.getMove());
                    }
                }
                return minTemp;
            }
    }

    
    private int utility(int[] newGameState){
        if(newGameState[0] == newGameState[1] && newGameState[1] == newGameState[2] && newGameState[0] == 1 || newGameState[3] == newGameState[4] && newGameState[4] == newGameState[5] && newGameState[3] == 1 ||
                newGameState[6] == newGameState[7] && newGameState[7] == newGameState[8] && newGameState[6] == 1 || newGameState[0] == newGameState[3] && newGameState[3] == newGameState[6] && newGameState[0] == 1 ||
                newGameState[1] == newGameState[4] && newGameState[4] == newGameState[7] && newGameState[1] == 1 || newGameState[2] == newGameState[5] && newGameState[5] == newGameState[8] && newGameState[2] == 1 ||
                newGameState[0] == newGameState[4] && newGameState[4] == newGameState[8] && newGameState[0] == 1|| newGameState[2] == newGameState[4] && newGameState[4] == newGameState[6] && newGameState[2] == 1){
            if(player == 1){
                return 1;
            }else if (player == 2){
                return -1;
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
        fillGameTree(root, player);
        return root;
    }

    private void fillGameTree(State parentState, int currentPlayer){
        for(int space : parentState.getAvailableSpaces()) {
            State childState = new State(parentState, space);
            parentState.getChildren().add(childState);
            childState.getGameState()[space] = currentPlayer;
            childState.checkTerminal();

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
        }
    }
}
