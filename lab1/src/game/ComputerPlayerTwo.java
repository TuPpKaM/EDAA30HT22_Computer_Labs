package game;

public class ComputerPlayerTwo extends Player {

    public ComputerPlayerTwo(String userId) {
        super(userId);
    }

    public int takePins(Board b){
        int amount = 2;
        if (b.getNoPins()-amount<=0)  {
            amount = b.getNoPins();
            b.takePins(amount); 
        } else if(b.getNoPins()==5) {
            b.takePins(amount);
        }else {
            amount = 1;
            b.takePins(amount);
        }
        return amount;
    }
    
}
