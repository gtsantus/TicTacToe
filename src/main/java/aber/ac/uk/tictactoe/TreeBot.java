package aber.ac.uk.tictactoe;


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
        int[] vm = maxValue(gameState);
        return vm[1];
    }

    private void minMaxSearch (){
        // calculate the move with the highest value, then return it
    }

    /*private int possibleMoves (List<Integer> currentMoves, int utility, int[] currentState){
        for (int i:currentState) {
            if(i == 0){
                currentMoves.add(i);
                if(isTerminal(currentState)){
                    //adjust utility
                }
            }
        }
    }
     */
    
    private int[] maxValue(int[] currentGameState){
        //input game state
        //output the move with the most utility (or least if player is = 2)
        int[] temp = new int[9];
        int[] vm = new int[2];
        System.arraycopy(currentGameState, 0, temp, 0, 9);

        if(isTerminal(temp)){
            vm[0] = vm[0] + utility(temp);
            return vm;
        }
        vm[0] = -1000;
        for(int i =0; i < 9; i++){
            if(temp[i] == 0){
                temp[i] = 2;
                int[] temp2 = minValue(temp);
                int[] vm2 = new int[2];
                temp[i] = 0;
                vm2[0] = temp2[0];
                vm2[1] = temp2[1];
                if(vm2[0] > vm[0]){
                    vm[0] = vm2[0];
                    vm[1] = i;
                }
            }
        }
        return vm;
    }

    private int[] minValue (int[] currentGameState){
        //currently doesn't work how I want it to. What I want it to do is fill out the game tree and calculate the utility of each state according to how many positive and
        //negative end states that state can lead to.

        int[] temp = new int[9];
        int[] vm = new int[2];
        System.arraycopy(currentGameState, 0, temp, 0, 9);

        if(isTerminal(temp)){
            vm[0] = vm[0] + utility(temp);
            return vm;
        }
        vm[0] = 1000;
        for(int i =0; i < 9; i++){
            if(temp[i] == 0){
                temp[i] = 1;
                int[] temp2 = maxValue(temp);
                int[] vm2 = new int[2];
                currentGameState[i] = 0;
                vm2[0] = temp2[0];
                vm2[1] = temp2[1];
                if(vm2[0] < vm[0]){
                    vm[0] = vm2[0];
                    vm[1] = i;
                }
            }
        }
        return vm;
    }

    private boolean isTerminal(int[] newGameState){
        return newGameState[0] == newGameState[1] && newGameState[1] == newGameState[2] && newGameState[0] != 0 || newGameState[3] == newGameState[4] && newGameState[4] == newGameState[5] && newGameState[3] != 0 ||
                newGameState[6] == newGameState[7] && newGameState[7] == newGameState[8] && newGameState[6] != 0 || newGameState[0] == newGameState[3] && newGameState[3] == newGameState[6] && newGameState[0] != 0 ||
                newGameState[1] == newGameState[4] && newGameState[4] == newGameState[7] && newGameState[1] != 0 || newGameState[2] == newGameState[5] && newGameState[5] == newGameState[8] && newGameState[2] != 0 ||
                newGameState[0] == newGameState[4] && newGameState[4] == newGameState[8] && newGameState[0] != 0|| newGameState[2] == newGameState[4] && newGameState[4] == newGameState[6] && newGameState[2] != 0;
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
}
