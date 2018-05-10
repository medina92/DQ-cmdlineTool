//  Dice.java
//  Purpose: Compute all dice rolls.
//********************************************************************
package Destiny;
import java.util.Random;

public class Dice {
    private int roll;
    private Random diceGenerator;

    public Dice() {
        diceGenerator = new Random();
    }

    public int rollD4() {
        roll = diceGenerator.nextInt(4) + 1;
        //System.out.println ("Rolling 1D4: " + roll);
        return roll;
    }

    public int rollD6() {
        roll = diceGenerator.nextInt(6) + 1;
        //System.out.println ("Rolling 1D6: " + roll);
        return roll;
    }

    public int rollD8() {
        roll = diceGenerator.nextInt(8) + 1;
        //System.out.println ("Rolling 1D8: " + roll);
        return roll;
    }

    public int rollD10() {
        roll = diceGenerator.nextInt(10) + 1;
        //System.out.println ("Rolling 1D10: " + roll);
        return roll;
    }

    public int rollD12() {
        roll = diceGenerator.nextInt(12) + 1;
        //System.out.println ("Rolling 1D12: " + roll); 
        return roll;
    }

    public int rollD20() {
        roll = diceGenerator.nextInt(20) + 1;
        //System.out.println ("Rolling 1D20: " + roll);
        return roll;
    }
}   

