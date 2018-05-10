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
public class Enemy extends Creature {
   private List<String> abilities = new ArrayList<String>();
    
    public Enemy(String name, int hp, int speed, int brawn, int magic, int armour) {
        super(name, hp, speed, brawn, magic, armour);
    }    
}
