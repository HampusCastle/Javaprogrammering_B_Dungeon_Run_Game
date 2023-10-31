package com.hampusborg.combat;

import java.util.Random;
import java.util.Scanner;

public abstract class Character implements ICombat {
    private Scanner sc = new Scanner(System.in);
    private int strength;
    protected int intelligence;
    private int agility;
    protected int baseDamage;
    private int health;
    private int experience;
    private int gold;
    private int level;
    private boolean hasDied = false;

    public Character(int strength, int intelligence, int agility, int damage, int castDamage, int health, int experience, int gold, int level) {
        this.strength = strength;
        this.intelligence = intelligence;
        this.agility = agility;
        this.baseDamage = damage;
        this.health = health;
        this.experience = experience;
        this.gold = gold;
        this.level = level;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getStrength() {
        return strength;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getAgility() {
        return agility;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public int getHealth() {
        return health;
    }

    public int getExperience() {
        return experience;
    }

    public int getGold() {
        return gold;
    }

    public int getLevel() {
        return level;
    }

    public void levelUp() {
        this.strength += 2;
        this.intelligence += 2;
        this.agility += 2;

    }

    public void act() throws InterruptedException {
        switch (sc.nextLine()) {

            case "1" -> attack();
            case "2" -> flee();
            case "3" -> getStatus();

        }
    }

    public int calculateDamage() {
        return this.baseDamage + (this.strength * 2 / 4 + 1);//baseDamage + (styrka * 2 / 4 + 1).
    }
    public boolean didFlee(){
        double fleeHigherThan = 50;
        double randomFactor = fleeHigherThan * 2;
        Random r = new Random();
        int fleeFactor = r.nextInt(1, (int) randomFactor + this.agility);
        return fleeFactor > fleeHigherThan;
    }
    public boolean didDodge() {
        double dodgeHigherThan = 50;
        double randomFactor = dodgeHigherThan * 1.5;
        Random r = new Random();
        int dodgeFactor = r.nextInt(1, (int) randomFactor + this.agility);
        return dodgeFactor > dodgeHigherThan;
    }

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health <= 0) {
            this.hasDied = true;
            System.out.println("Lost his life");
        }
    }
    public String getStatus() {
        return String.format("Status: [Base Damage: %d, Agility: %d, Health: %d, Intelligence: %d, Strength: %d, Experience: %d, Gold: %d, Level: %d]",
                this.baseDamage, this.agility, this.health, this.intelligence, this.strength, this.experience, this.gold, this.level);
    }

    public boolean isCriticalStrike() {
        double damageHigherThan = 50;
        double randomFactor = damageHigherThan * 1.5;
        Random r = new Random();
        int dodgeFactor = r.nextInt(1, (int) randomFactor + this.intelligence);
        return dodgeFactor > damageHigherThan;
    }
    public int attack() {
        return calculateDamage();
    }
    public boolean flee() throws InterruptedException {
        System.out.println("The player is trying to escape...");
        Thread.sleep(3000);
        return didFlee();
    }
}
