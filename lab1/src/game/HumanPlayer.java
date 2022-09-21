package game;

public class HumanPlayer extends Player {
    
    public HumanPlayer(String userId){
        super(userId);
    }

    public int takePins(Board b){
        int amount = UserInterface.askForInt("How many pins do you take?", "|"+b.getNoPins()+"|");
        if (amount > 0 && amount < 3 && b.getNoPins()-amount>=0 ) {  //correct amount and not negative
            b.takePins(amount);
            return amount;
        } else if (amount == -2) { 
            return -2; //Close
        } else {
            return -1; //Restart choice
        }
    }

}
