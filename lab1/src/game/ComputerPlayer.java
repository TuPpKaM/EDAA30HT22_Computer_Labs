package game;

import java.util.Random;

public class ComputerPlayer extends Player {

    public ComputerPlayer(String userId) {
        super(userId);
    }

    public int takePins(Board b){
        Random rand = new Random();
        int amount = (rand.nextInt(2))+1; //rand[0,1] + 1 = [1,2]
        if (b.getNoPins()-amount<0)  {
            b.takePins(b.getNoPins()); //Prevent pins from becoming negative
        } else {
            b.takePins(amount);
        }
        return amount;
    }
    
}
