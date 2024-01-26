package Disciplines;

import java.util.Random;

public class Diceroll {

    private int diceResult;
    Random rand = new Random();
    public Diceroll(){
        this.diceResult = rand.nextInt(6);
    }

    public int getDiceResult() {
        return diceResult;
    }
}
