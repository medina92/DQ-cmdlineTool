//  Player.java
//  Purpose: Conatains all information and actions pertaining to the player
//********************************************************************
package Destiny;

public class Creature {
    private String name;
    private int maxHp;
    private int hp;
    private int baseSpeed;
    private int modSpeed;
    private int baseBrawn;
    private int modBrawn;
    private int baseMagic;
    private int modMagic;
    private int baseArmour;
    private int modArmour;
    private Dice roll = new Dice();
    
    public Creature(String name, int maxHp, int speed, int brawn, int magic, int armour) {
        this.name = name;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.modSpeed = this.baseSpeed = speed;
        this.modBrawn = this.baseBrawn = brawn;
        this.modMagic = this.baseMagic = magic;
        this.modArmour = this.baseArmour = armour;
    }
    
    public void setName(String newName) {
        name += newName;
    }

    public void addMaxHp(int amt) {
        maxHp += amt;
    }
    
    public void addHp(int amt) {
        hp += amt;
    }

    public void addSpeed(int amt) {
        this.modSpeed += amt;
    }

    public void addBrawn(int amt) {
        this.modBrawn += amt;
    }

    public void addMagic(int amt) {
        this.modMagic += amt;
    }

    public void addArmour(int amt) {
        this.modArmour += amt;
    }
    
    public void subMaxHp(int amt) {
        maxHp -= amt;
    }
    
    public void subHp(int amt) {
        hp -= amt;
    }

    public void subSpeed(int amt) {
        this.modSpeed -= amt;
    }

    public void subBrawn(int amt) {
        this.modBrawn -= amt;
    }

    public void subMagic(int amt) {
        this.modMagic -= amt;
    }

    public void subArmour(int amt) {
        this.modArmour -= amt;
    }
    
    public void setHp(int amt) {
        hp = amt;
    }
    
    public String getName() {
        return name;
    }
    
    public int getMaxHp() {
        return maxHp;
    }
    
    public int getHp() {
        return hp;
    }

    public int getSpeed() {
        return this.modSpeed;
    }

    public int getBrawn() {
        return this.modBrawn;
    }

    public int getMagic() {
        return this.modMagic;
    }

    public int getArmour() {
        return this.modArmour;
    }
    
    public void resetAtrib() {
        this.modSpeed = this.baseSpeed;
        this.modBrawn = this.baseBrawn;
        this.modMagic = this.baseMagic;
        this.modArmour = this.baseArmour;
    }
    
    public int getD6Roll() {
        return roll.rollD6();
    }
    
    public int getSpeedRoll() {
        int result = this.modSpeed + roll.rollD6() + roll.rollD6();
        System.out.println(name + "'s speed is " + result);
        return result;
    }
    
    public int getAttackRoll() {
        int result = 0;
        if(this.modBrawn > this.modMagic) {
            result = this.modBrawn + roll.rollD6();
        } else {
            result = this.modMagic + roll.rollD6();
        }
        return result;
    }
    
    public void getStats() {
        System.out.println("\n" + name + "'s Stats -" );
        System.out.println("Hp: " + getHp());
        System.out.println("Speed: " + getSpeed());
        System.out.println("Brawn: " + getBrawn());
        System.out.println("Magic: " + getMagic());
        System.out.println("Armour: " + getArmour());
    }
}
