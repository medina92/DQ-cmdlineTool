/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Destiny;

/**
 *
 * @author danny
 */
public class Equipment {
    private String equipType;
    private int speedMod;
    private int brawnMod;
    private int magicMod;
    private int armourMod;
    private String specialAbil;
    
    public Equipment() {
        equipType = null;
        speedMod = 0;
        brawnMod = 0;
        magicMod = 0;
        armourMod = 0;
        specialAbil = null;
    }
    
    public Equipment(String equipType, int speedMod, int brawnMod, int magicMod, int armourMod, String specialAbil) {
        this.equipType = equipType;
        this.speedMod = speedMod;
        this.brawnMod = brawnMod;
        this.magicMod = magicMod;
        this.armourMod = armourMod;
        this.specialAbil = specialAbil;
    }
    
    public String getEquipType() {
        return equipType;
    }
    
    public int getSpeedMod() {
        return speedMod;
    }
    
    public int getBrawnMod() {
        return brawnMod;
    }
    
    public int getMagicMod() {
        return magicMod;
    }
    
    public int getArmourMod() {
        return armourMod;
    }
    
    public String getSpecialAbil() {
        return specialAbil;
    }
}
