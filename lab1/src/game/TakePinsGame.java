package game;

import java.util.Random;

public class TakePinsGame {
    public static void main(String[] args) {
        //setup
        Board game = new Board();
        game.setUp(UserInterface.askForInt("Select start amount of pins", "|"+game.getNoPins()+"|"));
        Player[] players = new Player[] {new HumanPlayer("Jesper"),new ComputerPlayerTwo("COMPUTER [INSANE]")};

        //welcome message and randomise a starting player
        Random rand = new Random();
        int playerIndex = rand.nextInt(2);
        UserInterface.printMessage(players[(1-playerIndex)].getUserId() + " starts the game!!", "|"+game.getNoPins()+"|");
        
        //game phase
        while (game.getNoPins() > 0){
            playerIndex ^= 1;
            int returnedInt = -3;
            while(returnedInt == -3) {  // == -3 means retry
                returnedInt = players[playerIndex].takePins(game);
                if ((returnedInt) == -2) { // == -2 close program
                    System.exit(0); 
                }
            }
            UserInterface.printMessage(players[playerIndex].getUserId() + " took: " +returnedInt+" pins.", "|"+game.getNoPins()+"|");
        }

        //ending
        UserInterface.printMessage(players[playerIndex].getUserId() +" won!", "|"+game.getNoPins()+"|");
    }
}