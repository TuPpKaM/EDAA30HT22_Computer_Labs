package game;

public class Board {
    private int noPins;

    public Board() {
        noPins = 0;
    }

    public void setUp(int amount){
        noPins = amount;
    }

    public void takePins(int amount){
        noPins = noPins - amount;
    }

    public int getNoPins(){
        return noPins;
    }
}
