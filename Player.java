/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Destiny;
import java.util.*;

/**
 *
 * @author danny
 */
public class Player extends Creature {
    private int money;  
    private List<statItem> potion = new ArrayList<>();
    
    //arrays store ability reference to grab from parsed xml
    private List<String> careerAbil = new ArrayList<>();
    private List<String> combatAbil = new ArrayList<>();
    private List<String> passAbil = new ArrayList<>();
    private List<String> modAbil = new ArrayList<>();
    private List<String> backpack = new ArrayList<>(5);
    private List<String> keywords = new ArrayList<>();
    
    //equipped items are stored as string to reference equipment parsed from xml
    private String head, cloak, gloves, mainHand, leftHand, chest, talisman, 
                   feet,necklace, ring1, ring2;
    
    public Player(String name) {
        super(name, 30, 0, 0, 0, 0);
        money = 20;
    }
    
    public void addMoney(int amt) {
        money += amt;
    }
    
    public void subMoney(int amt) {
        money -= amt;
    }
    
    public int getMoney() {
        return money;
    }
    
    public void equipItem(Equipment item) {
        
    }
    
    public void equipBackpack(String item) {
        if(backpack.size() >= 5) {
            System.out.println("Cannot hold anymore items!");
        } else {
            backpack.add(item);
        } 
    }
    
    public void equipPotion(statItem newPotion) {
        if(backpack.size() >= 5) {
            System.out.println("Cannot hold anymore items!");
        } else {
            backpack.add(newPotion.getName());
            this.potion.add(newPotion);
            System.out.println("You now have " + newPotion.getAmount() + 
                               "x " + newPotion.getName());
        }
    }
    
    public void removeBackpackItem(String item) {
        
    }
    
    public void displayBackpack() {
        if(!this.backpack.isEmpty()) {
            System.out.println("Your backpack contains - ");
            for(int i = 0; i < this.backpack.size(); i++) {
                System.out.println(this.backpack.get(i));
            }
            System.out.println();
        } else {
            System.out.println("You don't have any item's in your backpack!");
        }
    }
    
    public void displayPotions() {
        if(!this.potion.isEmpty()) {
            for(int i = 0; i < this.potion.size(); i++) {
                System.out.println(i + " - " + this.potion.get(i).getName());
            }
        } else {
            System.out.println("You don't have any potions!");
        }
    }
    
    public Boolean isBackpackFull() {
        if(this.backpack.size() >= 5) {
            System.out.println("Your backpack is full! Can't accept any more items. ");
            return true;
        } else {
            return false;
        }
    }
    
    public Boolean isBackpackEmpty() {
        if(backpack.size() <= 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public Boolean hasPotions() {
        if(this.potion.isEmpty()) {
            System.out.println("You do not have any stat affecting items!");
            return false;
        } else {
            return true;
        }
    }
    
    public Boolean usePotion(int potionIndex) {
        int maxHpOver;
        if((potionIndex < this.potion.size()) && (potionIndex >= 0)) {
            if(this.potion.get(potionIndex).isHealPotion()) {            
                if(this.getHp() == this.getMaxHp()) {
                    System.out.println("Your already at full health!");
                    return false;
                } else {
                    System.out.println("Using " + this.potion.get(potionIndex).getName() + " that heals for "+ this.potion.get(potionIndex).getHealBoost());
                    maxHpOver = this.getHp() + this.potion.get(potionIndex).getHealBoost();
                    
                    if(maxHpOver > this.getMaxHp()) {
                        this.setHp(this.getMaxHp());
                    } else {
                        this.addHp(this.potion.get(potionIndex).getHealBoost());
                    } 
                    
                    this.potion.get(potionIndex).subAmount();
                    if(this.potion.get(potionIndex).getAmount() <= 0) {
                        System.out.println("You are out of " + this.potion.get(potionIndex).getName());
                        this.potion.remove(potionIndex);
                    } else {
                        System.out.println("You have " + this.potion.get(potionIndex).getAmount() + "x uses of " + this.potion.get(potionIndex).getName() + " left!");
                    }
                    
                    return false;
                }    
            } else {             
                System.out.println("Using " + this.potion.get(potionIndex).getName() + " that boosts " 
                                   + this.potion.get(potionIndex).getPotionAtribType() + 
                                   " for "+ this.potion.get(potionIndex).getAtribBoost());

                switch (this.potion.get(potionIndex).getPotionAtribType()) {
                    case "Speed":
                        this.addSpeed(this.potion.get(potionIndex).getAtribBoost());
                        break;
                    case "Brawn":
                        this.addBrawn(this.potion.get(potionIndex).getAtribBoost());
                        break;
                    case "Magic":
                        this.addMagic(this.potion.get(potionIndex).getAtribBoost());                                
                        break;
                    case "Armour":
                        this.addArmour(this.potion.get(potionIndex).getAtribBoost());
                        break;
                    default:
                        break;
                }
                
                this.potion.get(potionIndex).subAmount();
                if(this.potion.get(potionIndex).getAmount() <= 0) {
                    System.out.println("You are out of " + this.potion.get(potionIndex).getName());
                    this.potion.remove(potionIndex);
                } else {
                    System.out.println("You have " + this.potion.get(potionIndex).getAmount() + "x uses of " + this.potion.get(potionIndex).getName() + " left!");
                }
            
                return false;
            }
        }
        System.out.println("Wrong input!");
        return true;
   } 
}
