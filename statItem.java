/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Destiny;
import java.util.Scanner;

/**
 *
 * @author danny
 */
public class statItem {
    private String name;
    //private potionType type;
    private int amount;
    private int healBoost;
    private int speedBoost;
    private int brawnBoost;
    private int magicBoost;
    private int armourBoost;
    //private Scanner in = new Scanner(System.in);
    
    public statItem() {
        this.name = null;
        this.healBoost = this.speedBoost = this.brawnBoost = this.magicBoost = this.armourBoost = 0;
        this.amount = 0;
    }
    
    public void createPotion(int type, String name, int boost, int amount) {
        this.amount = amount;
        this.name = name;
        switch(type) {
            case 0: 
                this.healBoost = boost;
                break;
            case 1:
                this.speedBoost = boost;
                break;
            case 2:
                this.brawnBoost = boost;
                break;
            case 3:
                this.magicBoost = boost;
                break;
            case 4:
                this.armourBoost = boost;
                break;
            default:
                System.out.println("Incorrect input! pass correct type");
        }
    }
    
    public String getName () {
        return this.name;
    }
    
    public int getHealBoost() { 
        return this.healBoost;
    }
    
    public int getAtribBoost() {
        if(this.speedBoost !=0) {
            return this.speedBoost;
        } else if(this.brawnBoost != 0) {
            return this.brawnBoost;
        } else if(this.magicBoost != 0) {
            return this.magicBoost;
        } else if(this.armourBoost != 0) {
            return this.armourBoost;
        } else {
            return 0;
        }
    }
    
    public int getAmount() {
        return this.amount;
    }
    
    public void subAmount() {
        this.amount -= 1;
    }
   
    public Boolean isHealPotion() {
        if(this.healBoost > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public String getPotionAtribType() {
        if(this.speedBoost !=0) {
            return "Speed";
        } else if(this.brawnBoost != 0) {
            return "Brawn";
        } else if(this.magicBoost != 0) {
            return "Magic";
        } else if(this.armourBoost != 0) {
            return "Armour";
        } 
        return "No Atrib Type Set!";
    }
    /*public enum potionType {
        health,
        speed,
        brawn,
        magic,
        armour
    }*/
}
