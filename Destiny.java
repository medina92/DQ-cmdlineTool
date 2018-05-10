//  Destiny.java
//  Purpose: Main block of program.
//********************************************************************
package Destiny;
import java.io.*;
import java.lang.*;
import java.util.*;

public class Destiny {
    public static void main(String[] args) {
        boolean gameState = true;
        char input;
        
        Dice dice = new Dice();
        Player player = new Player("Steve");
        Enemy enemy = new Enemy("fuckboy", 20, 0, 5, 12, 0);
        Scanner in = new Scanner(System.in);

        while(gameState) {                   
            System.out.print("what would you like to do? (c - combat) "
                    + "(b - backpack) (e - equipment) (q - quit): ");
            input = in.next().charAt(0);

            switch (input) {
                case 'q':
                    gameState = false;
                    break;
                case 'c':
                    clearScreen();
                    combat(player, enemy);
                    break;
                case 'b':
                    clearScreen();
                    addToBackpack(in, player);
                    break;
                default:
                    System.out.println("Invalid Input (y/n)");
                    break;
            }
        }
    }
    
    public static void addToBackpack(Scanner in, Player player) {
        int input, amt, boost, type;
        statItem item = new statItem();
        String mat, itemName;
        Boolean usingBackpack = true;
        while(usingBackpack) {
            System.out.print("\nWhat do you want to do with your "
                                         + "backpack? (a - add item) (p - add potion) "
                                         + "(v - view item's) (b - back to main menu) (r - remove item): ");
            input = in.next().charAt(0);
            switch (input) {
                case 'v':
                    player.displayBackpack();
                    break;
                case 'a':
                    if(!player.isBackpackFull()) {
                        System.out.print("\nType the name of the item: ");
                        in.nextLine();
                        mat = readString(in);
                        player.equipBackpack(mat);
                    } 
                    break;
                case 'p':
                    if(!player.isBackpackFull()) {
                        System.out.print("\nType the name of the potion: ");
                        in.nextLine();
                        itemName = readString(in);
                        System.out.print("\nWhat type of potion is it? (0 - heal) (1 - speed) "
                                         + "(2 - brawn) (3 - magic) (4 - armour): ");
                        type = readInt(in);
                        System.out.print("\nHow much does it boost the stat for?: ");
                        boost = readInt(in);
                        System.out.print("\nHow many?: ");
                        amt = readInt(in);
                        item.createPotion(type, itemName, boost, amt);
                        player.equipPotion(item);
                    }
                    break;
                case 'r':
                    
                    break;
                case 'b':
                    usingBackpack = false;
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }
    }
    
    public static void combat(Player player, Enemy enemy) {
        Scanner in = new Scanner(System.in);
        Boolean resolved = false;
        Boolean usingPotion = true;
        Boolean potionUsed = false;
        int round = 1;
        int potion;
        
        clearScreen();
        while(!resolved) {
            pause();
            System.out.println();
            player.getStats();
            System.out.println();
            enemy.getStats();
            System.out.println();
            System.out.println("Beginning round " + round + " of combat - \n");
            System.out.print("What would you like to do this round? (a - attack)"
                    + " (s - special abilities) (p - use a potion): ");
            pause();        
            
            switch(in.next().charAt(0)) {
                case 'a':
                    resolved = attack(player, enemy);
                    round++;
                    potionUsed = false;
                    player.resetAtrib();
                    enemy.resetAtrib();
                    break;
                case 'p':
                    if(!potionUsed) {
                        while(usingPotion) {
                            if(player.hasPotions()) {
                                System.out.println("What potion do you want to use? - ");
                                player.displayPotions();
                                System.out.print("-------: ");
                                potion = readInt(in);
                                usingPotion = player.usePotion(potion);
                            } else {
                                usingPotion = false;
                            }
                        }
                        usingPotion = true;
                    } else {
                        System.out.println("You've already used a potion this round!");
                    }
                    potionUsed = true;
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            } 
            //attackPhase = true;
            //clearScreen();
        }
        player.setHp(player.getMaxHp());
        enemy.setHp(enemy.getMaxHp());
    }
    
    public static Boolean attack(Player player, Enemy enemy) {
        int damage;
        int playerSpeed;
        int enemySpeed;
        Boolean attackPhase = true;
        
        while(attackPhase) {
            playerSpeed = player.getSpeedRoll();
            pause();
            enemySpeed = enemy.getSpeedRoll();

            if(playerSpeed > enemySpeed) {
                System.out.println(player.getName() + " acts this round!");
                pause();
                damage = player.getAttackRoll();
                damage -= enemy.getArmour();

                if(damage < 0)
                    damage = 0;

                System.out.println(player.getName() + " does " + damage +
                                   " damage to " + enemy.getName());

                enemy.subHp(damage);
                if(enemy.getHp() <= 0) {
                    System.out.println(enemy.getName() +
                                       " has been defeated!");
                    return true;
                }

                pause();
                attackPhase = false;
            } else if(playerSpeed == enemySpeed) { 
                System.out.print("\ntie! Re-rolling speed\n\n");
                pause();
            } else {
                System.out.println(enemy.getName() + " acts this round!");
                pause();

                damage = enemy.getAttackRoll();
                damage -= player.getArmour();

                if(damage < 0)
                    damage = 0;

                System.out.println(enemy.getName() + " does " + damage +
                                   " damage to " + player.getName());

                player.subHp(damage);
                if(player.getHp() <= 0) {
                    System.out.println(player.getName() +
                                       " has been defeated!");
                    return true;
                }

                pause();                  
                attackPhase = false;
            }
        }
        
        return false;
        
    }
    
    public static void pause() {
        try {
                Thread.sleep(1500);
        } catch(InterruptedException e) {
        }
    }
    
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    } 
    
    public static int readInt(Scanner in) {
        int temp = 0;
        Boolean readingInput = true;
        while(readingInput) {
            try {
                temp = Integer.parseInt(in.nextLine());
                readingInput = false;
            } catch(NumberFormatException e) {
                in.nextLine();
                System.out.print("Wring input! please input a number: ");
            }
        }
        return temp;
    }
    
    public static String readString(Scanner in) {
        String temp = null;
        Boolean readingInput = true;
        while(readingInput) {
            try {
                temp = in.nextLine();
                readingInput = false;
            } catch(NumberFormatException e) {
                in.nextLine();
                System.out.print("Wring input! please input a number: ");
            }
        }
        return temp;
    }
}
