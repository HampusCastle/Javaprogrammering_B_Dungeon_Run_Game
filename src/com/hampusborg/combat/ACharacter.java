package com.hampusborg.combat;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static jdk.internal.org.jline.utils.Status.getStatus;

public abstract class ACharacter implements ICombat {
    protected Scanner sc = new Scanner(System.in);

    protected int strength;
    protected int agility;
    protected int baseDamage;
    protected int health;
    protected int level;
    protected int intelligence;
    protected static boolean hasDied = false;
    protected String name;
    protected int damage;
    protected int experience;
    protected int gold;

    public ACharacter(String name, int strength, int agility, int baseDamage, int health, int level, int intelligence, int damage, int experience) {
        this.strength = strength;
        this.agility = agility;
        this.baseDamage = baseDamage;
        this.health = health;
        this.level = level;
        this.intelligence = intelligence;
        this.name = name;
        this.damage = damage;
        this.experience = experience;
        this.gold = gold;
    }

    public boolean isCriticalStrike() {
        double damageHigherThan = 50;
        double randomFactor = damageHigherThan * 1.5;
        Random r = new Random();
        int dodgeFactor = r.nextInt(1, (int) randomFactor + this.intelligence);
        return dodgeFactor > damageHigherThan;
    }

    public boolean didFlee() {
        double fleeHigherThan = 50;
        double randomFactor = fleeHigherThan * 2;
        Random r = new Random();
        int fleeFactor = r.nextInt(1, (int) randomFactor + this.agility);
        return fleeFactor > fleeHigherThan;
    }

    public int calculateDamage() {
        return this.baseDamage + (this.strength * 2 / 4 + 1);
    }

    public boolean didDodge() {
        double dodgeHigherThan = 50;
        double randomFactor = dodgeHigherThan * 1.5;
        Random r = new Random();
        int dodgeFactor = r.nextInt(1, (int) randomFactor + this.agility);
        return dodgeFactor > dodgeHigherThan;
    }
    public boolean takenDamage(int calculateDamage) {
        this.health -= this.calculateDamage();
        if (this.health <= 0) {
            this.hasDied = true;
            System.out.println("Lost his life");
        }
        return true;
    }
    @Override
    public String getStatus() {
            return String.format("Status: [Name: %s, Base Damage: %d, Agility: %d, Health: %d, Intelligence: %d, Strength: %d, Experience: %d, Gold: %d, Level: %d]",
                    this.name, this.baseDamage, this.agility, this.health, this.intelligence, this.strength, this.experience, this.gold, this.level);
        }
    }
